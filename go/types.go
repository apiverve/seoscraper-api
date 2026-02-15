// Package seoscraper provides a Go client for the SEO Data Scraper API.
//
// For more information, visit: https://apiverve.com/marketplace/seoscraper?utm_source=go&utm_medium=readme
package seoscraper

import (
	"fmt"
	"reflect"
	"regexp"
	"strings"
)

// ValidationRule defines validation constraints for a parameter.
type ValidationRule struct {
	Type      string
	Required  bool
	Min       *float64
	Max       *float64
	MinLength *int
	MaxLength *int
	Format    string
	Enum      []string
}

// ValidationError represents a parameter validation error.
type ValidationError struct {
	Errors []string
}

func (e *ValidationError) Error() string {
	return "Validation failed: " + strings.Join(e.Errors, "; ")
}

// Helper functions for pointers
func float64Ptr(v float64) *float64 { return &v }
func intPtr(v int) *int             { return &v }

// Format validation patterns
var formatPatterns = map[string]*regexp.Regexp{
	"email":    regexp.MustCompile(`^[^\s@]+@[^\s@]+\.[^\s@]+$`),
	"url":      regexp.MustCompile(`^https?://.+`),
	"ip":       regexp.MustCompile(`^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$|^([0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$`),
	"date":     regexp.MustCompile(`^\d{4}-\d{2}-\d{2}$`),
	"hexColor": regexp.MustCompile(`^#?([0-9a-fA-F]{3}|[0-9a-fA-F]{6})$`),
}

// Request contains the parameters for the SEO Data Scraper API.
//
// Parameters:
//   - url (required): string - The URL of the web page to scrape SEO data from [format: url]
type Request struct {
	Url string `json:"url"` // Required
}

// ToQueryParams converts the request struct to a map of query parameters.
// Only non-zero values are included.
func (r *Request) ToQueryParams() map[string]string {
	params := make(map[string]string)
	if r == nil {
		return params
	}

	v := reflect.ValueOf(*r)
	t := v.Type()

	for i := 0; i < v.NumField(); i++ {
		field := v.Field(i)
		fieldType := t.Field(i)

		// Get the json tag for the field name
		jsonTag := fieldType.Tag.Get("json")
		if jsonTag == "" {
			continue
		}
		// Handle tags like `json:"name,omitempty"`
		jsonName := strings.Split(jsonTag, ",")[0]
		if jsonName == "-" {
			continue
		}

		// Skip zero values
		if field.IsZero() {
			continue
		}

		// Convert to string
		params[jsonName] = fmt.Sprintf("%v", field.Interface())
	}

	return params
}

// Validate checks the request parameters against validation rules.
// Returns a ValidationError if validation fails, nil otherwise.
func (r *Request) Validate() error {
	rules := map[string]ValidationRule{
		"url": {Type: "string", Required: true, Format: "url"},
	}

	if len(rules) == 0 {
		return nil
	}

	var errors []string
	v := reflect.ValueOf(*r)
	t := v.Type()

	for i := 0; i < v.NumField(); i++ {
		field := v.Field(i)
		fieldType := t.Field(i)

		jsonTag := fieldType.Tag.Get("json")
		if jsonTag == "" {
			continue
		}
		jsonName := strings.Split(jsonTag, ",")[0]

		rule, exists := rules[jsonName]
		if !exists {
			continue
		}

		// Check required
		if rule.Required && field.IsZero() {
			errors = append(errors, fmt.Sprintf("Required parameter [%s] is missing", jsonName))
			continue
		}

		if field.IsZero() {
			continue
		}

		// Type-specific validation
		switch rule.Type {
		case "integer", "number":
			var numVal float64
			switch field.Kind() {
			case reflect.Int, reflect.Int64:
				numVal = float64(field.Int())
			case reflect.Float64:
				numVal = field.Float()
			}
			if rule.Min != nil && numVal < *rule.Min {
				errors = append(errors, fmt.Sprintf("Parameter [%s] must be at least %v", jsonName, *rule.Min))
			}
			if rule.Max != nil && numVal > *rule.Max {
				errors = append(errors, fmt.Sprintf("Parameter [%s] must be at most %v", jsonName, *rule.Max))
			}

		case "string":
			strVal := field.String()
			if rule.MinLength != nil && len(strVal) < *rule.MinLength {
				errors = append(errors, fmt.Sprintf("Parameter [%s] must be at least %d characters", jsonName, *rule.MinLength))
			}
			if rule.MaxLength != nil && len(strVal) > *rule.MaxLength {
				errors = append(errors, fmt.Sprintf("Parameter [%s] must be at most %d characters", jsonName, *rule.MaxLength))
			}
			if rule.Format != "" {
				if pattern, ok := formatPatterns[rule.Format]; ok {
					if !pattern.MatchString(strVal) {
						errors = append(errors, fmt.Sprintf("Parameter [%s] must be a valid %s", jsonName, rule.Format))
					}
				}
			}
		}

		// Enum validation
		if len(rule.Enum) > 0 {
			strVal := fmt.Sprintf("%v", field.Interface())
			found := false
			for _, enumVal := range rule.Enum {
				if strVal == enumVal {
					found = true
					break
				}
			}
			if !found {
				errors = append(errors, fmt.Sprintf("Parameter [%s] must be one of: %s", jsonName, strings.Join(rule.Enum, ", ")))
			}
		}
	}

	if len(errors) > 0 {
		return &ValidationError{Errors: errors}
	}
	return nil
}

// ResponseData contains the data returned by the SEO Data Scraper API.
type ResponseData struct {
	RequestUrl string `json:"requestUrl"`
	Url string `json:"url"`
	Canonical string `json:"canonical"`
	Lang string `json:"lang"`
	Charset string `json:"charset"`
	Title string `json:"title"`
	Image string `json:"image"`
	Favicons []FaviconsItem `json:"favicons"`
	Author string `json:"author"`
	Description string `json:"description"`
	Keywords string `json:"keywords"`
	Source string `json:"source"`
	Price string `json:"price"`
	PriceCurrency string `json:"priceCurrency"`
	Availability string `json:"availability"`
	Robots string `json:"robots"`
	Jsonld []JsonldItem `json:"jsonld"`
	Og:url string `json:"og:url"`
	Og:locale string `json:"og:locale"`
	Og:locale:alternate string `json:"og:locale:alternate"`
	Og:title string `json:"og:title"`
	Og:type string `json:"og:type"`
	Og:description string `json:"og:description"`
	Og:determiner string `json:"og:determiner"`
	Og:siteName string `json:"og:site_name"`
	Og:image string `json:"og:image"`
	Og:image:secureUrl string `json:"og:image:secure_url"`
	Og:image:type string `json:"og:image:type"`
	Og:image:width string `json:"og:image:width"`
	Og:image:height string `json:"og:image:height"`
	Twitter:title string `json:"twitter:title"`
	Twitter:description string `json:"twitter:description"`
	Twitter:image string `json:"twitter:image"`
	Twitter:image:alt string `json:"twitter:image:alt"`
	Twitter:card string `json:"twitter:card"`
	Twitter:site string `json:"twitter:site"`
	Twitter:site:id string `json:"twitter:site:id"`
	Twitter:url string `json:"twitter:url"`
	Twitter:accountId string `json:"twitter:account_id"`
	Twitter:creator string `json:"twitter:creator"`
	Twitter:creator:id string `json:"twitter:creator:id"`
	Twitter:player string `json:"twitter:player"`
	Twitter:player:width string `json:"twitter:player:width"`
	Twitter:player:height string `json:"twitter:player:height"`
	Twitter:player:stream string `json:"twitter:player:stream"`
	Twitter:app:name:iphone string `json:"twitter:app:name:iphone"`
	Twitter:app:id:iphone string `json:"twitter:app:id:iphone"`
	Twitter:app:url:iphone string `json:"twitter:app:url:iphone"`
	Twitter:app:name:ipad string `json:"twitter:app:name:ipad"`
	Twitter:app:id:ipad string `json:"twitter:app:id:ipad"`
	Twitter:app:url:ipad string `json:"twitter:app:url:ipad"`
	Twitter:app:name:googleplay string `json:"twitter:app:name:googleplay"`
	Twitter:app:id:googleplay string `json:"twitter:app:id:googleplay"`
	Twitter:app:url:googleplay string `json:"twitter:app:url:googleplay"`
	Headings []HeadingsItem `json:"headings"`
	ImgTags []ImgTagsItem `json:"imgTags"`
	ResponseBody string `json:"responseBody"`
	Viewport string `json:"viewport"`
	X-UA-Compatible string `json:"X-UA-Compatible"`
	360-site-verification string `json:"360-site-verification"`
	Fb:appId string `json:"fb:app_id"`
	Msvalidate.01 string `json:"msvalidate.01"`
	Referrer string `json:"referrer"`
	YKey string `json:"y_key"`
	Google-site-verification string `json:"google-site-verification"`
	Google-adsense-account string `json:"google-adsense-account"`
	Yandex-verification string `json:"yandex-verification"`
}

// FaviconsItem represents an item in the Favicons array.
type FaviconsItem struct {
	Rel string `json:"rel"`
	Href string `json:"href"`
}

// JsonldItem represents an item in the Jsonld array.
type JsonldItem struct {
	@context string `json:"@context"`
	@type string `json:"@type"`
	@id string `json:"@id"`
	Url string `json:"url"`
	Author AuthorData `json:"author"`
	IsPartOf IsPartOfData `json:"isPartOf"`
	InLanguage string `json:"inLanguage"`
	SameAs []string `json:"sameAs"`
}

// AuthorData represents the author object.
type AuthorData struct {
	@type string `json:"@type"`
	@id string `json:"@id"`
	Url string `json:"url"`
	Logo string `json:"logo"`
	Description string `json:"description"`
	Founder FounderData `json:"founder"`
	FoundingDate string `json:"foundingDate"`
	FoundingLocation string `json:"foundingLocation"`
	Name string `json:"name"`
	LegalName string `json:"legalName"`
	ContactPoint ContactPointData `json:"contactPoint"`
}

// FounderData represents the founder object.
type FounderData struct {
	@type string `json:"@type"`
	@id string `json:"@id"`
	Name string `json:"name"`
}

// ContactPointData represents the contactPoint object.
type ContactPointData struct {
	@type string `json:"@type"`
	AvailableLanguage []AvailableLanguageItem `json:"availableLanguage"`
	ContactOption string `json:"contactOption"`
	ContactType string `json:"contactType"`
	Telephone string `json:"telephone"`
}

// AvailableLanguageItem represents an item in the AvailableLanguage array.
type AvailableLanguageItem struct {
	@type string `json:"@type"`
	Name string `json:"name"`
	AlternateName string `json:"alternateName"`
}

// IsPartOfData represents the isPartOf object.
type IsPartOfData struct {
	@type string `json:"@type"`
	@id string `json:"@id"`
	Url string `json:"url"`
	PotentialAction PotentialActionData `json:"potentialAction"`
}

// PotentialActionData represents the potentialAction object.
type PotentialActionData struct {
	@type string `json:"@type"`
	Target string `json:"target"`
	Query-input string `json:"query-input"`
}

// HeadingsItem represents an item in the Headings array.
type HeadingsItem struct {
	Level string `json:"level"`
	Text string `json:"text"`
}

// ImgTagsItem represents an item in the ImgTags array.
type ImgTagsItem struct {
	Src string `json:"src"`
	Alt string `json:"alt"`
}
