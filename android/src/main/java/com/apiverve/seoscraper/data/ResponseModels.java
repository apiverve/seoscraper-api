// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     SEODataScraperData data = Converter.fromJsonString(jsonString);

package com.apiverve.seoscraper.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static SEODataScraperData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(SEODataScraperData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(SEODataScraperData.class);
        writer = mapper.writerFor(SEODataScraperData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// SEODataScraperData.java

package com.apiverve.seoscraper.data;

import com.fasterxml.jackson.annotation.*;

public class SEODataScraperData {
    private String requestURL;
    private String url;
    private String canonical;
    private String lang;
    private String charset;
    private String title;
    private String image;
    private Favicon[] favicons;
    private String author;
    private String description;
    private String keywords;
    private String source;
    private String price;
    private String priceCurrency;
    private String availability;
    private String robots;
    private Jsonld[] jsonld;
    private String ogURL;
    private String ogLocale;
    private String ogLocaleAlternate;
    private String ogTitle;
    private String ogType;
    private String ogDescription;
    private String ogDeterminer;
    private String ogSiteName;
    private String ogImage;
    private String ogImageSecureURL;
    private String ogImageType;
    private String ogImageWidth;
    private String ogImageHeight;
    private String twitterTitle;
    private String twitterDescription;
    private String twitterImage;
    private String twitterImageAlt;
    private String twitterCard;
    private String twitterSite;
    private String twitterSiteID;
    private String twitterURL;
    private String twitterAccountID;
    private String twitterCreator;
    private String twitterCreatorID;
    private String twitterPlayer;
    private String twitterPlayerWidth;
    private String twitterPlayerHeight;
    private String twitterPlayerStream;
    private String twitterAppNameIphone;
    private String twitterAppIDIphone;
    private String twitterAppURLIphone;
    private String twitterAppNameIpad;
    private String twitterAppIDIpad;
    private String twitterAppURLIpad;
    private String twitterAppNameGoogleplay;
    private String twitterAppIDGoogleplay;
    private String twitterAppURLGoogleplay;
    private Heading[] headings;
    private ImgTag[] imgTags;
    private String responseBody;
    private String viewport;
    private String xUACompatible;
    private String the360SiteVerification;
    private String fbAppID;
    private String msvalidate01;
    private String referrer;
    private String yKey;
    private String googleSiteVerification;
    private String googleAdsenseAccount;
    private String yandexVerification;

    @JsonProperty("requestUrl")
    public String getRequestURL() { return requestURL; }
    @JsonProperty("requestUrl")
    public void setRequestURL(String value) { this.requestURL = value; }

    @JsonProperty("url")
    public String getURL() { return url; }
    @JsonProperty("url")
    public void setURL(String value) { this.url = value; }

    @JsonProperty("canonical")
    public String getCanonical() { return canonical; }
    @JsonProperty("canonical")
    public void setCanonical(String value) { this.canonical = value; }

    @JsonProperty("lang")
    public String getLang() { return lang; }
    @JsonProperty("lang")
    public void setLang(String value) { this.lang = value; }

    @JsonProperty("charset")
    public String getCharset() { return charset; }
    @JsonProperty("charset")
    public void setCharset(String value) { this.charset = value; }

    @JsonProperty("title")
    public String getTitle() { return title; }
    @JsonProperty("title")
    public void setTitle(String value) { this.title = value; }

    @JsonProperty("image")
    public String getImage() { return image; }
    @JsonProperty("image")
    public void setImage(String value) { this.image = value; }

    @JsonProperty("favicons")
    public Favicon[] getFavicons() { return favicons; }
    @JsonProperty("favicons")
    public void setFavicons(Favicon[] value) { this.favicons = value; }

    @JsonProperty("author")
    public String getAuthor() { return author; }
    @JsonProperty("author")
    public void setAuthor(String value) { this.author = value; }

    @JsonProperty("description")
    public String getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(String value) { this.description = value; }

    @JsonProperty("keywords")
    public String getKeywords() { return keywords; }
    @JsonProperty("keywords")
    public void setKeywords(String value) { this.keywords = value; }

    @JsonProperty("source")
    public String getSource() { return source; }
    @JsonProperty("source")
    public void setSource(String value) { this.source = value; }

    @JsonProperty("price")
    public String getPrice() { return price; }
    @JsonProperty("price")
    public void setPrice(String value) { this.price = value; }

    @JsonProperty("priceCurrency")
    public String getPriceCurrency() { return priceCurrency; }
    @JsonProperty("priceCurrency")
    public void setPriceCurrency(String value) { this.priceCurrency = value; }

    @JsonProperty("availability")
    public String getAvailability() { return availability; }
    @JsonProperty("availability")
    public void setAvailability(String value) { this.availability = value; }

    @JsonProperty("robots")
    public String getRobots() { return robots; }
    @JsonProperty("robots")
    public void setRobots(String value) { this.robots = value; }

    @JsonProperty("jsonld")
    public Jsonld[] getJsonld() { return jsonld; }
    @JsonProperty("jsonld")
    public void setJsonld(Jsonld[] value) { this.jsonld = value; }

    @JsonProperty("og:url")
    public String getOgURL() { return ogURL; }
    @JsonProperty("og:url")
    public void setOgURL(String value) { this.ogURL = value; }

    @JsonProperty("og:locale")
    public String getOgLocale() { return ogLocale; }
    @JsonProperty("og:locale")
    public void setOgLocale(String value) { this.ogLocale = value; }

    @JsonProperty("og:locale:alternate")
    public String getOgLocaleAlternate() { return ogLocaleAlternate; }
    @JsonProperty("og:locale:alternate")
    public void setOgLocaleAlternate(String value) { this.ogLocaleAlternate = value; }

    @JsonProperty("og:title")
    public String getOgTitle() { return ogTitle; }
    @JsonProperty("og:title")
    public void setOgTitle(String value) { this.ogTitle = value; }

    @JsonProperty("og:type")
    public String getOgType() { return ogType; }
    @JsonProperty("og:type")
    public void setOgType(String value) { this.ogType = value; }

    @JsonProperty("og:description")
    public String getOgDescription() { return ogDescription; }
    @JsonProperty("og:description")
    public void setOgDescription(String value) { this.ogDescription = value; }

    @JsonProperty("og:determiner")
    public String getOgDeterminer() { return ogDeterminer; }
    @JsonProperty("og:determiner")
    public void setOgDeterminer(String value) { this.ogDeterminer = value; }

    @JsonProperty("og:site_name")
    public String getOgSiteName() { return ogSiteName; }
    @JsonProperty("og:site_name")
    public void setOgSiteName(String value) { this.ogSiteName = value; }

    @JsonProperty("og:image")
    public String getOgImage() { return ogImage; }
    @JsonProperty("og:image")
    public void setOgImage(String value) { this.ogImage = value; }

    @JsonProperty("og:image:secure_url")
    public String getOgImageSecureURL() { return ogImageSecureURL; }
    @JsonProperty("og:image:secure_url")
    public void setOgImageSecureURL(String value) { this.ogImageSecureURL = value; }

    @JsonProperty("og:image:type")
    public String getOgImageType() { return ogImageType; }
    @JsonProperty("og:image:type")
    public void setOgImageType(String value) { this.ogImageType = value; }

    @JsonProperty("og:image:width")
    public String getOgImageWidth() { return ogImageWidth; }
    @JsonProperty("og:image:width")
    public void setOgImageWidth(String value) { this.ogImageWidth = value; }

    @JsonProperty("og:image:height")
    public String getOgImageHeight() { return ogImageHeight; }
    @JsonProperty("og:image:height")
    public void setOgImageHeight(String value) { this.ogImageHeight = value; }

    @JsonProperty("twitter:title")
    public String getTwitterTitle() { return twitterTitle; }
    @JsonProperty("twitter:title")
    public void setTwitterTitle(String value) { this.twitterTitle = value; }

    @JsonProperty("twitter:description")
    public String getTwitterDescription() { return twitterDescription; }
    @JsonProperty("twitter:description")
    public void setTwitterDescription(String value) { this.twitterDescription = value; }

    @JsonProperty("twitter:image")
    public String getTwitterImage() { return twitterImage; }
    @JsonProperty("twitter:image")
    public void setTwitterImage(String value) { this.twitterImage = value; }

    @JsonProperty("twitter:image:alt")
    public String getTwitterImageAlt() { return twitterImageAlt; }
    @JsonProperty("twitter:image:alt")
    public void setTwitterImageAlt(String value) { this.twitterImageAlt = value; }

    @JsonProperty("twitter:card")
    public String getTwitterCard() { return twitterCard; }
    @JsonProperty("twitter:card")
    public void setTwitterCard(String value) { this.twitterCard = value; }

    @JsonProperty("twitter:site")
    public String getTwitterSite() { return twitterSite; }
    @JsonProperty("twitter:site")
    public void setTwitterSite(String value) { this.twitterSite = value; }

    @JsonProperty("twitter:site:id")
    public String getTwitterSiteID() { return twitterSiteID; }
    @JsonProperty("twitter:site:id")
    public void setTwitterSiteID(String value) { this.twitterSiteID = value; }

    @JsonProperty("twitter:url")
    public String getTwitterURL() { return twitterURL; }
    @JsonProperty("twitter:url")
    public void setTwitterURL(String value) { this.twitterURL = value; }

    @JsonProperty("twitter:account_id")
    public String getTwitterAccountID() { return twitterAccountID; }
    @JsonProperty("twitter:account_id")
    public void setTwitterAccountID(String value) { this.twitterAccountID = value; }

    @JsonProperty("twitter:creator")
    public String getTwitterCreator() { return twitterCreator; }
    @JsonProperty("twitter:creator")
    public void setTwitterCreator(String value) { this.twitterCreator = value; }

    @JsonProperty("twitter:creator:id")
    public String getTwitterCreatorID() { return twitterCreatorID; }
    @JsonProperty("twitter:creator:id")
    public void setTwitterCreatorID(String value) { this.twitterCreatorID = value; }

    @JsonProperty("twitter:player")
    public String getTwitterPlayer() { return twitterPlayer; }
    @JsonProperty("twitter:player")
    public void setTwitterPlayer(String value) { this.twitterPlayer = value; }

    @JsonProperty("twitter:player:width")
    public String getTwitterPlayerWidth() { return twitterPlayerWidth; }
    @JsonProperty("twitter:player:width")
    public void setTwitterPlayerWidth(String value) { this.twitterPlayerWidth = value; }

    @JsonProperty("twitter:player:height")
    public String getTwitterPlayerHeight() { return twitterPlayerHeight; }
    @JsonProperty("twitter:player:height")
    public void setTwitterPlayerHeight(String value) { this.twitterPlayerHeight = value; }

    @JsonProperty("twitter:player:stream")
    public String getTwitterPlayerStream() { return twitterPlayerStream; }
    @JsonProperty("twitter:player:stream")
    public void setTwitterPlayerStream(String value) { this.twitterPlayerStream = value; }

    @JsonProperty("twitter:app:name:iphone")
    public String getTwitterAppNameIphone() { return twitterAppNameIphone; }
    @JsonProperty("twitter:app:name:iphone")
    public void setTwitterAppNameIphone(String value) { this.twitterAppNameIphone = value; }

    @JsonProperty("twitter:app:id:iphone")
    public String getTwitterAppIDIphone() { return twitterAppIDIphone; }
    @JsonProperty("twitter:app:id:iphone")
    public void setTwitterAppIDIphone(String value) { this.twitterAppIDIphone = value; }

    @JsonProperty("twitter:app:url:iphone")
    public String getTwitterAppURLIphone() { return twitterAppURLIphone; }
    @JsonProperty("twitter:app:url:iphone")
    public void setTwitterAppURLIphone(String value) { this.twitterAppURLIphone = value; }

    @JsonProperty("twitter:app:name:ipad")
    public String getTwitterAppNameIpad() { return twitterAppNameIpad; }
    @JsonProperty("twitter:app:name:ipad")
    public void setTwitterAppNameIpad(String value) { this.twitterAppNameIpad = value; }

    @JsonProperty("twitter:app:id:ipad")
    public String getTwitterAppIDIpad() { return twitterAppIDIpad; }
    @JsonProperty("twitter:app:id:ipad")
    public void setTwitterAppIDIpad(String value) { this.twitterAppIDIpad = value; }

    @JsonProperty("twitter:app:url:ipad")
    public String getTwitterAppURLIpad() { return twitterAppURLIpad; }
    @JsonProperty("twitter:app:url:ipad")
    public void setTwitterAppURLIpad(String value) { this.twitterAppURLIpad = value; }

    @JsonProperty("twitter:app:name:googleplay")
    public String getTwitterAppNameGoogleplay() { return twitterAppNameGoogleplay; }
    @JsonProperty("twitter:app:name:googleplay")
    public void setTwitterAppNameGoogleplay(String value) { this.twitterAppNameGoogleplay = value; }

    @JsonProperty("twitter:app:id:googleplay")
    public String getTwitterAppIDGoogleplay() { return twitterAppIDGoogleplay; }
    @JsonProperty("twitter:app:id:googleplay")
    public void setTwitterAppIDGoogleplay(String value) { this.twitterAppIDGoogleplay = value; }

    @JsonProperty("twitter:app:url:googleplay")
    public String getTwitterAppURLGoogleplay() { return twitterAppURLGoogleplay; }
    @JsonProperty("twitter:app:url:googleplay")
    public void setTwitterAppURLGoogleplay(String value) { this.twitterAppURLGoogleplay = value; }

    @JsonProperty("headings")
    public Heading[] getHeadings() { return headings; }
    @JsonProperty("headings")
    public void setHeadings(Heading[] value) { this.headings = value; }

    @JsonProperty("imgTags")
    public ImgTag[] getImgTags() { return imgTags; }
    @JsonProperty("imgTags")
    public void setImgTags(ImgTag[] value) { this.imgTags = value; }

    @JsonProperty("responseBody")
    public String getResponseBody() { return responseBody; }
    @JsonProperty("responseBody")
    public void setResponseBody(String value) { this.responseBody = value; }

    @JsonProperty("viewport")
    public String getViewport() { return viewport; }
    @JsonProperty("viewport")
    public void setViewport(String value) { this.viewport = value; }

    @JsonProperty("X-UA-Compatible")
    public String getXUACompatible() { return xUACompatible; }
    @JsonProperty("X-UA-Compatible")
    public void setXUACompatible(String value) { this.xUACompatible = value; }

    @JsonProperty("360-site-verification")
    public String getThe360SiteVerification() { return the360SiteVerification; }
    @JsonProperty("360-site-verification")
    public void setThe360SiteVerification(String value) { this.the360SiteVerification = value; }

    @JsonProperty("fb:app_id")
    public String getFbAppID() { return fbAppID; }
    @JsonProperty("fb:app_id")
    public void setFbAppID(String value) { this.fbAppID = value; }

    @JsonProperty("msvalidate.01")
    public String getMsvalidate01() { return msvalidate01; }
    @JsonProperty("msvalidate.01")
    public void setMsvalidate01(String value) { this.msvalidate01 = value; }

    @JsonProperty("referrer")
    public String getReferrer() { return referrer; }
    @JsonProperty("referrer")
    public void setReferrer(String value) { this.referrer = value; }

    @JsonProperty("y_key")
    public String getYKey() { return yKey; }
    @JsonProperty("y_key")
    public void setYKey(String value) { this.yKey = value; }

    @JsonProperty("google-site-verification")
    public String getGoogleSiteVerification() { return googleSiteVerification; }
    @JsonProperty("google-site-verification")
    public void setGoogleSiteVerification(String value) { this.googleSiteVerification = value; }

    @JsonProperty("google-adsense-account")
    public String getGoogleAdsenseAccount() { return googleAdsenseAccount; }
    @JsonProperty("google-adsense-account")
    public void setGoogleAdsenseAccount(String value) { this.googleAdsenseAccount = value; }

    @JsonProperty("yandex-verification")
    public String getYandexVerification() { return yandexVerification; }
    @JsonProperty("yandex-verification")
    public void setYandexVerification(String value) { this.yandexVerification = value; }
}

// Favicon.java

package com.apiverve.seoscraper.data;

import com.fasterxml.jackson.annotation.*;

public class Favicon {
    private String rel;
    private String href;

    @JsonProperty("rel")
    public String getRel() { return rel; }
    @JsonProperty("rel")
    public void setRel(String value) { this.rel = value; }

    @JsonProperty("href")
    public String getHref() { return href; }
    @JsonProperty("href")
    public void setHref(String value) { this.href = value; }
}

// Heading.java

package com.apiverve.seoscraper.data;

import com.fasterxml.jackson.annotation.*;

public class Heading {
    private Level level;
    private String text;

    @JsonProperty("level")
    public Level getLevel() { return level; }
    @JsonProperty("level")
    public void setLevel(Level value) { this.level = value; }

    @JsonProperty("text")
    public String getText() { return text; }
    @JsonProperty("text")
    public void setText(String value) { this.text = value; }
}

// Level.java

package com.apiverve.seoscraper.data;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Level {
    H2, H3, H4;

    @JsonValue
    public String toValue() {
        switch (this) {
            case H2: return "h2";
            case H3: return "h3";
            case H4: return "h4";
        }
        return null;
    }

    @JsonCreator
    public static Level forValue(String value) throws IOException {
        if (value.equals("h2")) return H2;
        if (value.equals("h3")) return H3;
        if (value.equals("h4")) return H4;
        throw new IOException("Cannot deserialize Level");
    }
}

// ImgTag.java

package com.apiverve.seoscraper.data;

import com.fasterxml.jackson.annotation.*;

public class ImgTag {
    private String src;
    private String alt;

    @JsonProperty("src")
    public String getSrc() { return src; }
    @JsonProperty("src")
    public void setSrc(String value) { this.src = value; }

    @JsonProperty("alt")
    public String getAlt() { return alt; }
    @JsonProperty("alt")
    public void setAlt(String value) { this.alt = value; }
}

// Jsonld.java

package com.apiverve.seoscraper.data;

import com.fasterxml.jackson.annotation.*;

public class Jsonld {
    private String context;
    private String type;
    private String id;
    private String url;
    private Author author;
    private IsPartOf isPartOf;
    private String inLanguage;
    private String[] sameAs;

    @JsonProperty("@context")
    public String getContext() { return context; }
    @JsonProperty("@context")
    public void setContext(String value) { this.context = value; }

    @JsonProperty("@type")
    public String getType() { return type; }
    @JsonProperty("@type")
    public void setType(String value) { this.type = value; }

    @JsonProperty("@id")
    public String getID() { return id; }
    @JsonProperty("@id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("url")
    public String getURL() { return url; }
    @JsonProperty("url")
    public void setURL(String value) { this.url = value; }

    @JsonProperty("author")
    public Author getAuthor() { return author; }
    @JsonProperty("author")
    public void setAuthor(Author value) { this.author = value; }

    @JsonProperty("isPartOf")
    public IsPartOf getIsPartOf() { return isPartOf; }
    @JsonProperty("isPartOf")
    public void setIsPartOf(IsPartOf value) { this.isPartOf = value; }

    @JsonProperty("inLanguage")
    public String getInLanguage() { return inLanguage; }
    @JsonProperty("inLanguage")
    public void setInLanguage(String value) { this.inLanguage = value; }

    @JsonProperty("sameAs")
    public String[] getSameAs() { return sameAs; }
    @JsonProperty("sameAs")
    public void setSameAs(String[] value) { this.sameAs = value; }
}

// Author.java

package com.apiverve.seoscraper.data;

import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;

public class Author {
    private String type;
    private String id;
    private String url;
    private String logo;
    private String description;
    private Founder founder;
    private LocalDate foundingDate;
    private String foundingLocation;
    private String name;
    private String legalName;
    private ContactPoint contactPoint;

    @JsonProperty("@type")
    public String getType() { return type; }
    @JsonProperty("@type")
    public void setType(String value) { this.type = value; }

    @JsonProperty("@id")
    public String getID() { return id; }
    @JsonProperty("@id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("url")
    public String getURL() { return url; }
    @JsonProperty("url")
    public void setURL(String value) { this.url = value; }

    @JsonProperty("logo")
    public String getLogo() { return logo; }
    @JsonProperty("logo")
    public void setLogo(String value) { this.logo = value; }

    @JsonProperty("description")
    public String getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(String value) { this.description = value; }

    @JsonProperty("founder")
    public Founder getFounder() { return founder; }
    @JsonProperty("founder")
    public void setFounder(Founder value) { this.founder = value; }

    @JsonProperty("foundingDate")
    public LocalDate getFoundingDate() { return foundingDate; }
    @JsonProperty("foundingDate")
    public void setFoundingDate(LocalDate value) { this.foundingDate = value; }

    @JsonProperty("foundingLocation")
    public String getFoundingLocation() { return foundingLocation; }
    @JsonProperty("foundingLocation")
    public void setFoundingLocation(String value) { this.foundingLocation = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("legalName")
    public String getLegalName() { return legalName; }
    @JsonProperty("legalName")
    public void setLegalName(String value) { this.legalName = value; }

    @JsonProperty("contactPoint")
    public ContactPoint getContactPoint() { return contactPoint; }
    @JsonProperty("contactPoint")
    public void setContactPoint(ContactPoint value) { this.contactPoint = value; }
}

// ContactPoint.java

package com.apiverve.seoscraper.data;

import com.fasterxml.jackson.annotation.*;

public class ContactPoint {
    private String type;
    private AvailableLanguage[] availableLanguage;
    private String contactOption;
    private String contactType;
    private String telephone;

    @JsonProperty("@type")
    public String getType() { return type; }
    @JsonProperty("@type")
    public void setType(String value) { this.type = value; }

    @JsonProperty("availableLanguage")
    public AvailableLanguage[] getAvailableLanguage() { return availableLanguage; }
    @JsonProperty("availableLanguage")
    public void setAvailableLanguage(AvailableLanguage[] value) { this.availableLanguage = value; }

    @JsonProperty("contactOption")
    public String getContactOption() { return contactOption; }
    @JsonProperty("contactOption")
    public void setContactOption(String value) { this.contactOption = value; }

    @JsonProperty("contactType")
    public String getContactType() { return contactType; }
    @JsonProperty("contactType")
    public void setContactType(String value) { this.contactType = value; }

    @JsonProperty("telephone")
    public String getTelephone() { return telephone; }
    @JsonProperty("telephone")
    public void setTelephone(String value) { this.telephone = value; }
}

// AvailableLanguage.java

package com.apiverve.seoscraper.data;

import com.fasterxml.jackson.annotation.*;

public class AvailableLanguage {
    private String type;
    private String name;
    private String alternateName;

    @JsonProperty("@type")
    public String getType() { return type; }
    @JsonProperty("@type")
    public void setType(String value) { this.type = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("alternateName")
    public String getAlternateName() { return alternateName; }
    @JsonProperty("alternateName")
    public void setAlternateName(String value) { this.alternateName = value; }
}

// Founder.java

package com.apiverve.seoscraper.data;

import com.fasterxml.jackson.annotation.*;

public class Founder {
    private String type;
    private String id;
    private String name;

    @JsonProperty("@type")
    public String getType() { return type; }
    @JsonProperty("@type")
    public void setType(String value) { this.type = value; }

    @JsonProperty("@id")
    public String getID() { return id; }
    @JsonProperty("@id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }
}

// IsPartOf.java

package com.apiverve.seoscraper.data;

import com.fasterxml.jackson.annotation.*;

public class IsPartOf {
    private String type;
    private String id;
    private String url;
    private PotentialAction potentialAction;

    @JsonProperty("@type")
    public String getType() { return type; }
    @JsonProperty("@type")
    public void setType(String value) { this.type = value; }

    @JsonProperty("@id")
    public String getID() { return id; }
    @JsonProperty("@id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("url")
    public String getURL() { return url; }
    @JsonProperty("url")
    public void setURL(String value) { this.url = value; }

    @JsonProperty("potentialAction")
    public PotentialAction getPotentialAction() { return potentialAction; }
    @JsonProperty("potentialAction")
    public void setPotentialAction(PotentialAction value) { this.potentialAction = value; }
}

// PotentialAction.java

package com.apiverve.seoscraper.data;

import com.fasterxml.jackson.annotation.*;

public class PotentialAction {
    private String type;
    private String target;
    private String queryInput;

    @JsonProperty("@type")
    public String getType() { return type; }
    @JsonProperty("@type")
    public void setType(String value) { this.type = value; }

    @JsonProperty("target")
    public String getTarget() { return target; }
    @JsonProperty("target")
    public void setTarget(String value) { this.target = value; }

    @JsonProperty("query-input")
    public String getQueryInput() { return queryInput; }
    @JsonProperty("query-input")
    public void setQueryInput(String value) { this.queryInput = value; }
}