declare module '@apiverve/seoscraper' {
  export interface seoscraperOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface seoscraperResponse {
    status: string;
    error: string | null;
    data: SEODataScraperData;
    code?: number;
  }


  interface SEODataScraperData {
      requestURL:               string;
      url:                      string;
      canonical:                string;
      lang:                     string;
      charset:                  string;
      title:                    string;
      image:                    string;
      favicons:                 Favicon[];
      author:                   string;
      description:              string;
      keywords:                 string;
      source:                   string;
      price:                    string;
      priceCurrency:            string;
      availability:             string;
      robots:                   string;
      jsonld:                   Jsonld[];
      ogURL:                    string;
      ogLocale:                 string;
      ogLocaleAlternate:        string;
      ogTitle:                  string;
      ogType:                   string;
      ogDescription:            string;
      ogDeterminer:             string;
      ogSiteName:               string;
      ogImage:                  string;
      ogImageSecureURL:         string;
      ogImageType:              string;
      ogImageWidth:             string;
      ogImageHeight:            string;
      twitterTitle:             string;
      twitterDescription:       string;
      twitterImage:             string;
      twitterImageAlt:          string;
      twitterCard:              string;
      twitterSite:              string;
      twitterSiteID:            string;
      twitterURL:               string;
      twitterAccountID:         string;
      twitterCreator:           string;
      twitterCreatorID:         string;
      twitterPlayer:            string;
      twitterPlayerWidth:       string;
      twitterPlayerHeight:      string;
      twitterPlayerStream:      string;
      twitterAppNameIphone:     string;
      twitterAppIDIphone:       string;
      twitterAppURLIphone:      string;
      twitterAppNameIpad:       string;
      twitterAppIDIpad:         string;
      twitterAppURLIpad:        string;
      twitterAppNameGoogleplay: string;
      twitterAppIDGoogleplay:   string;
      twitterAppURLGoogleplay:  string;
      headings:                 Heading[];
      imgTags:                  ImgTag[];
      responseBody:             string;
      viewport:                 string;
      xUACompatible:            string;
      the360SiteVerification:   string;
      fbAppID:                  string;
      msvalidate01:             string;
      referrer:                 string;
      yKey:                     string;
      googleSiteVerification:   string;
      googleAdsenseAccount:     string;
      yandexVerification:       string;
  }
  
  interface Favicon {
      rel:  string;
      href: string;
  }
  
  interface Heading {
      level: Level;
      text:  string;
  }
  
  enum Level {
      H2 = "h2",
      H3 = "h3",
      H4 = "h4",
  }
  
  interface ImgTag {
      src: string;
      alt: string;
  }
  
  interface Jsonld {
      context:    string;
      type:       string;
      id:         string;
      url:        string;
      author:     Author;
      isPartOf:   IsPartOf;
      inLanguage: string;
      sameAs:     string[];
  }
  
  interface Author {
      type:             string;
      id:               string;
      url:              string;
      logo:             string;
      description:      string;
      founder:          Founder;
      foundingDate:     Date;
      foundingLocation: string;
      name:             string;
      legalName:        string;
      contactPoint:     ContactPoint;
  }
  
  interface ContactPoint {
      type:              string;
      availableLanguage: AvailableLanguage[];
      contactOption:     string;
      contactType:       string;
      telephone:         string;
  }
  
  interface AvailableLanguage {
      type:          string;
      name:          string;
      alternateName: string;
  }
  
  interface Founder {
      type: string;
      id:   string;
      name: string;
  }
  
  interface IsPartOf {
      type:            string;
      id:              string;
      url:             string;
      potentialAction: PotentialAction;
  }
  
  interface PotentialAction {
      type:       string;
      target:     string;
      queryInput: string;
  }

  export default class seoscraperWrapper {
    constructor(options: seoscraperOptions);

    execute(callback: (error: any, data: seoscraperResponse | null) => void): Promise<seoscraperResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: seoscraperResponse | null) => void): Promise<seoscraperResponse>;
    execute(query?: Record<string, any>): Promise<seoscraperResponse>;
  }
}
