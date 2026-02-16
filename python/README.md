SEO Data Scraper API
============

SEO Scraper is a simple tool for scraping SEO data. It returns the meta title, meta description, and more.

![Build Status](https://img.shields.io/badge/build-passing-green)
![Code Climate](https://img.shields.io/badge/maintainability-B-purple)
![Prod Ready](https://img.shields.io/badge/production-ready-blue)

This is a Python API Wrapper for the [SEO Data Scraper API](https://apiverve.com/marketplace/seoscraper?utm_source=pypi&utm_medium=readme)

---

## Installation

Using `pip`:

```bash
pip install apiverve-seodatascraper
```

Using `pip3`:

```bash
pip3 install apiverve-seodatascraper
```

---

## Configuration

Before using the seoscraper API client, you have to setup your account and obtain your API Key.
You can get it by signing up at [https://apiverve.com](https://apiverve.com?utm_source=pypi&utm_medium=readme)

---

## Quick Start

Here's a simple example to get you started quickly:

```python
from apiverve_seodatascraper.apiClient import SeoscraperAPIClient

# Initialize the client with your APIVerve API key
api = SeoscraperAPIClient("[YOUR_API_KEY]")

query = { "url": "https://apiverve.com" }

try:
    # Make the API call
    result = api.execute(query)

    # Print the result
    print(result)
except Exception as e:
    print(f"Error: {e}")
```

---

## Usage

The SEO Data Scraper API documentation is found here: [https://docs.apiverve.com/ref/seoscraper](https://docs.apiverve.com/ref/seoscraper?utm_source=pypi&utm_medium=readme).
You can find parameters, example responses, and status codes documented here.

### Setup

```python
# Import the client module
from apiverve_seodatascraper.apiClient import SeoscraperAPIClient

# Initialize the client with your APIVerve API key
api = SeoscraperAPIClient("[YOUR_API_KEY]")
```

---

## Perform Request

Using the API client, you can perform requests to the API.

###### Define Query

```python
query = { "url": "https://apiverve.com" }
```

###### Simple Request

```python
# Make a request to the API
result = api.execute(query)

# Print the result
print(result)
```

###### Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "requestUrl": "https://ebay.com",
    "url": "https://www.ebay.com/",
    "canonical": "https://www.ebay.com",
    "lang": "en",
    "charset": "utf-8",
    "title": "Electronics, Cars, Fashion, Collectibles & More | eBay",
    "image": "",
    "favicons": [
      {
        "rel": "icon",
        "href": "https://pages.ebay.com/favicon.ico"
      }
    ],
    "author": "",
    "description": "Buy & sell electronics, cars, clothes, collectibles & more on eBay, the world's online marketplace. Top brands, low prices & free shipping on many items.",
    "keywords": "",
    "source": "",
    "price": "",
    "priceCurrency": "",
    "availability": "",
    "robots": "",
    "jsonld": [
      {
        "@context": "https://schema.org",
        "@type": "WebPage",
        "@id": "https://www.ebay.com/#webpage",
        "url": "https://www.ebay.com",
        "author": {
          "@type": "Corporation",
          "@id": "https://www.ebay.com/#corporation",
          "url": "https://www.ebay.com",
          "logo": "https://ir.ebaystatic.com/rs/v/fxxj3ttftm5ltcqnto1o4baovyl.png",
          "description": "eBay Inc. is an American multinational e-commerce corporation based in San Jose, California, that facilitates consumer-to-consumer and business-to-consumer sales through its website. eBay was founded by Pierre Omidyar in the autumn of 1995, and became a notable success story of the dot-com bubble. eBay is a multibillion-dollar business with operations in about 30 countries, as of 2011. The company manages the eBay website, an online auction and shopping website in which people and businesses buy and sell a wide variety of goods and services worldwide. The website is free to use for buyers, but sellers are charged fees for listing items after a limited number of free listings, and again when those items are sold.",
          "founder": {
            "@type": "Person",
            "@id": "https://www.ebay.com/#founder",
            "name": "Pierre Omidyar"
          },
          "foundingDate": "1995-09-03",
          "foundingLocation": "San Jose, CA",
          "name": "eBay",
          "legalName": "eBay Inc.",
          "contactPoint": {
            "@type": "ContactPoint",
            "availableLanguage": [
              {
                "@type": "Language",
                "name": "English",
                "alternateName": "en"
              },
              {
                "@type": "Language",
                "name": "Spanish",
                "alternateName": "es"
              }
            ],
            "contactOption": "TollFree",
            "contactType": "Customer Service",
            "telephone": "+1-866-961-9253"
          }
        },
        "isPartOf": {
          "@type": "WebSite",
          "@id": "https://www.ebay.com/#website",
          "url": "https://www.ebay.com",
          "potentialAction": {
            "@type": "SearchAction",
            "target": "https://www.ebay.com/sch/i.html?_nkw={srch_str}&ssPageName=GSTL",
            "query-input": "required name=srch_str"
          }
        },
        "inLanguage": "EN",
        "sameAs": [
          "https://www.facebook.com/ebay/",
          "https://www.pinterest.com/ebay/",
          "https://twitter.com/eBay",
          "https://www.linkedin.com/company/ebay/",
          "https://www.youtube.com/ebay",
          "https://www.instagram.com/ebay/"
        ]
      }
    ],
    "og:url": "https://www.ebay.com",
    "og:locale": "",
    "og:locale:alternate": "",
    "og:title": "Electronics, Cars, Fashion, Collectibles & More | eBay",
    "og:type": "website",
    "og:description": "Buy & sell electronics, cars, clothes, collectibles & more on eBay, the world's online marketplace. Top brands, low prices & free shipping on many items.",
    "og:determiner": "",
    "og:site_name": "eBay",
    "og:image": "https://ir.ebaystatic.com/cr/v/c1/ebay-logo-1-1200x630-margin.png",
    "og:image:secure_url": "",
    "og:image:type": "",
    "og:image:width": "",
    "og:image:height": "",
    "twitter:title": "Electronics, Cars, Fashion, Collectibles & More | eBay",
    "twitter:description": "Buy & sell electronics, cars, clothes, collectibles & more on eBay, the world's online marketplace. Top brands, low prices & free shipping on many items.",
    "twitter:image": "https://ir.ebaystatic.com/cr/v/c1/ebay-logo-1-1200x1200-margin.png",
    "twitter:image:alt": "",
    "twitter:card": "summary",
    "twitter:site": "@eBay",
    "twitter:site:id": "",
    "twitter:url": "",
    "twitter:account_id": "",
    "twitter:creator": "",
    "twitter:creator:id": "",
    "twitter:player": "",
    "twitter:player:width": "",
    "twitter:player:height": "",
    "twitter:player:stream": "",
    "twitter:app:name:iphone": "",
    "twitter:app:id:iphone": "",
    "twitter:app:url:iphone": "",
    "twitter:app:name:ipad": "",
    "twitter:app:id:ipad": "",
    "twitter:app:url:ipad": "",
    "twitter:app:name:googleplay": "",
    "twitter:app:id:googleplay": "",
    "twitter:app:url:googleplay": "",
    "headings": [
      {
        "level": "h4",
        "text": "Parts & Accessories"
      },
      {
        "level": "h4",
        "text": "Vehicles"
      },
      {
        "level": "h4",
        "text": "Top Categories"
      },
      {
        "level": "h4",
        "text": "Additional Categories"
      },
      {
        "level": "h4",
        "text": "Top Categories"
      },
      {
        "level": "h4",
        "text": "Featured"
      },
      {
        "level": "h4",
        "text": "Top Categories"
      },
      {
        "level": "h4",
        "text": "Additional Categories"
      },
      {
        "level": "h4",
        "text": "Top Categories"
      },
      {
        "level": "h4",
        "text": "Additional Categories"
      },
      {
        "level": "h4",
        "text": "Top Categories"
      },
      {
        "level": "h4",
        "text": "Featured"
      },
      {
        "level": "h4",
        "text": "Top Categories"
      },
      {
        "level": "h4",
        "text": "Popular Topics"
      },
      {
        "level": "h4",
        "text": "Top Categories"
      },
      {
        "level": "h4",
        "text": "Additional Categories"
      },
      {
        "level": "h4",
        "text": "Top Categories"
      },
      {
        "level": "h4",
        "text": "Top Brands"
      },
      {
        "level": "h4",
        "text": "Shop eBay Refurbished Electronics"
      },
      {
        "level": "h4",
        "text": "Shop eBay Refurbished Home"
      },
      {
        "level": "h2",
        "text": "Games you love. Cards you covet."
      },
      {
        "level": "h2",
        "text": "Trending in Sneakers"
      },
      {
        "level": "h3",
        "text": "Nike Kobe 6 Protro Sail All-Star FQ3546-100 Ship Now"
      },
      {
        "level": "h3",
        "text": "Size 13 - Air Jordan 1 Retro OG High Black Toe Reimagined"
      },
      {
        "level": "h3",
        "text": "Nike Zoom Kobe 6 Protro 'All-Star 2.0' MENS FQ3546-100 IN HANDS SHIPS NOW"
      },
      {
        "level": "h3",
        "text": "Nike Kobe 6 Protro 'Sail' All Star  FQ3546-100 Size 8 - 13 BRAND NEW"
      },
      {
        "level": "h3",
        "text": "Size 11 - Air Jordan 1 Retro OG Low Black Toe"
      },
      {
        "level": "h3",
        "text": "Nike Zoom Kobe 6 Protro 'All-Star 2.0' PREORDER SHIPS 02/13"
      },
      {
        "level": "h3",
        "text": "NIKE KOBE 6 PROTRO SAIL ALL STAR (FQ3546-100)"
      },
      {
        "level": "h3",
        "text": "Air Jordan 1 Retro High OG Black Toe Reimagined DZ5485-106"
      },
      {
        "level": "h3",
        "text": "Size 9 Nike Zoom Kobe 6 Protro All Star 2.0 FQ3546-100 Brand New SHIPS FAST"
      },
      {
        "level": "h3",
        "text": "Nike Kobe 6 Protro Sail All-Star FQ3546-100 Ship Now  **IN HAND SHIP NOW**"
      },
      {
        "level": "h2",
        "text": "Trending in Watches"
      },
      {
        "level": "h3",
        "text": "Rolex Submariner Mens 40mm Date 16610 SS Vintage Running Automatic Wrist Watch"
      },
      {
        "level": "h3",
        "text": "Cartier Santos Carree Ref: 2961 18K Yellow Gold / S. Steel 29mm Automatic Watch"
      },
      {
        "level": "h3",
        "text": "Omega Speedmaster 145022 71 ST  Chronograph Vintage Pilots Watch 1039 516"
      },
      {
        "level": "h3",
        "text": "Cartier Tank Must XL Automatic Wristwatch WSTA0040 w/Spare Straps, Box & Papers"
      },
      {
        "level": "h3",
        "text": "Factory Service Breitling Superocean Heritage II Chronograph 18K SS Wrist Watch"
      },
      {
        "level": "h3",
        "text": "Rolex Oyster Perpetual Day-Date Ref. 1803 Champagne Dial 36mm #W150325-1"
      },
      {
        "level": "h3",
        "text": "Patek Philippe 3543 Gubelin Roman Dial Vintage 18k Gold Box and Papers 1969"
      },
      {
        "level": "h3",
        "text": "Rolex OP Datejust Thunderbird Men's 36mm 16263 Two-Tone Wristwatch #W145913-1"
      },
      {
        "level": "h3",
        "text": "Grand Seiko Hi-Beat 36000 80 Hours SLGH021 \"Genbi Valley\" Watch 2024 LE 1/1000"
      },
      {
        "level": "h3",
        "text": "ROLEX MENS EXPLORER II 16570 GMT DATE 40MM STAINLESS STEEL BLACK Box And papers"
      },
      {
        "level": "h2",
        "text": "Score these trending kicks"
      },
      {
        "level": "h3",
        "text": "Travis Scott x Jordan 1 Low Velvet Brown"
      },
      {
        "level": "h3",
        "text": "Nike Air Diamond Turf 49ers 2025"
      },
      {
        "level": "h3",
        "text": "Jordan 5 Retro OG Metallic Reimagined"
      },
      {
        "level": "h3",
        "text": "Jordan 3 Retro Black Cat 2025"
      },
      {
        "level": "h3",
        "text": "Jordan 1 High Black Toe Reimagined"
      },
      {
        "level": "h3",
        "text": "Nike Zoom Kobe 5 Protro Year of the Mamba"
      },
      {
        "level": "h3",
        "text": "Jordan 3 Retro Black Cement 2024"
      },
      {
        "level": "h2",
        "text": "Trending in Refurbished"
      },
      {
        "level": "h3",
        "text": "Soundcore Life Q20 Wireless Over-Ear Headphones ANC Bluetooth Headset|Refurbish"
      },
      {
        "level": "h3",
        "text": "Lenovo Thinkpad T14 G1 14\" FHD Intel Core i5 10310U 16GB RAM 512GB SSD W11P"
      },
      {
        "level": "h3",
        "text": "HP TP01-3016 Desktop Intel i5-12400 Intel UHD 730 12GB DDR4 RAM 256GB SSD W11H"
      },
      {
        "level": "h3",
        "text": "JBL Partybox 110 Portable Bluetooth Party Speaker w/ 160W Powerful Sound, Black"
      },
      {
        "level": "h3",
        "text": "Lenovo Yoga 7 2-In-1 14IML9 14\" Touch Ultra 5 125U 16GB 1TB Win11P FPR CAM 2Y"
      },
      {
        "level": "h3",
        "text": "JBL Tune 710BT, Wireless Over-Ear Headphones"
      },
      {
        "level": "h3",
        "text": "Soundcore Boom 2 Outdoor Speaker LED Portable Subwoofer BassUp 2.0 IPX7|Refurb"
      },
      {
        "level": "h3",
        "text": "Shark Upright Vacuum LA481HGN Rotator Lift-Away ADV Upright Hair Pro Brushroll"
      },
      {
        "level": "h3",
        "text": "HP ENVY TE01-4000 Desktop Intel Core i5-13400 1.8 GHz 8GB DDR4 256GB SSD W11H"
      },
      {
        "level": "h3",
        "text": "Reconditioned Olympus E-M10 Mark IV Mirrorless Camera w/ 14-42mm EZ Lens (Black)"
      },
      {
        "level": "h2",
        "text": "eBay Live"
      },
      {
        "level": "h2",
        "text": "Conquer cold weather"
      },
      {
        "level": "h3",
        "text": "Snow Blowers"
      },
      {
        "level": "h3",
        "text": "Cozy Bedding"
      },
      {
        "level": "h3",
        "text": "Generators"
      },
      {
        "level": "h3",
        "text": "Men’s Coats"
      },
      {
        "level": "h3",
        "text": "Women’s Coats"
      },
      {
        "level": "h3",
        "text": "Tires"
      },
      {
        "level": "h3",
        "text": "Thermostats"
      },
      {
        "level": "h2",
        "text": "Today's Deals"
      },
      {
        "level": "h3",
        "text": "Samsung Galaxy S21 5G SM-G991U1 128GB Unlocked Excellent"
      },
      {
        "level": "h3",
        "text": "Nintendo Switch Lite 32GB + Screen Protector 🛡️ + FREE 2-DAY Shipping ✈️"
      },
      {
        "level": "h3",
        "text": "EcoFlow Solar Generator RIVER 2 Pro 768Wh+110W Solar Panel Certified Refurbished"
      },
      {
        "level": "h3",
        "text": "Rachel Koen Diamond Love Chain Bracelet 18K White Gold 0.12cttw"
      },
      {
        "level": "h3",
        "text": "JBL Bar 1300X 1170W 11.1.4-Ch Soundbar w/ Detachable Surround Speakers"
      },
      {
        "level": "h3",
        "text": "Clore JNC770 Green 1700 Peak Amp Premium 12 Volt Jump Starter SOLJNC770G New!"
      },
      {
        "level": "h3",
        "text": "Shark ZU100 Rotator Vacuum Cleaner for Pet Hair, Navy (Certified Refurbished)"
      },
      {
        "level": "h3",
        "text": "Google Pixel 7 5G 128GB (Factory Unlocked) - Excellent"
      },
      {
        "level": "h2",
        "text": "Today's Deals"
      },
      {
        "level": "h3",
        "text": "Samsung Galaxy S21 5G SM-G991U1 128GB Unlocked Excellent"
      },
      {
        "level": "h3",
        "text": "Nintendo Switch Lite 32GB + Screen Protector 🛡️ + FREE 2-DAY Shipping ✈️"
      },
      {
        "level": "h3",
        "text": "EcoFlow Solar Generator RIVER 2 Pro 768Wh+110W Solar Panel Certified Refurbished"
      },
      {
        "level": "h3",
        "text": "Rachel Koen Diamond Love Chain Bracelet 18K White Gold 0.12cttw"
      },
      {
        "level": "h3",
        "text": "JBL Bar 1300X 1170W 11.1.4-Ch Soundbar w/ Detachable Surround Speakers"
      },
      {
        "level": "h3",
        "text": "Clore JNC770 Green 1700 Peak Amp Premium 12 Volt Jump Starter SOLJNC770G New!"
      },
      {
        "level": "h3",
        "text": "Shark ZU100 Rotator Vacuum Cleaner for Pet Hair, Navy (Certified Refurbished)"
      },
      {
        "level": "h3",
        "text": "Google Pixel 7 5G 128GB (Factory Unlocked) - Excellent"
      }
    ],
    "imgTags": [
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": ""
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": ""
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Sealed boxes"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Singles"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Sealed packs"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Sealed boxes"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Singles"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Sealed packs"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Motors"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Electronics"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Refurbished finds"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Motors"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Electronics"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Refurbished finds"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Nike Kobe 6 Protro Sail All-Star FQ3546-100 Ship Now"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Size 13 - Air Jordan 1 Retro OG High Black Toe Reimagined"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Nike Zoom Kobe 6 Protro 'All-Star 2.0' MENS FQ3546-100 IN HANDS SHIPS NOW"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Nike Kobe 6 Protro 'Sail' All Star  FQ3546-100 Size 8 - 13 BRAND NEW"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Size 11 - Air Jordan 1 Retro OG Low Black Toe"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Nike Zoom Kobe 6 Protro 'All-Star 2.0' PREORDER SHIPS 02/13"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "NIKE KOBE 6 PROTRO SAIL ALL STAR (FQ3546-100)"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Air Jordan 1 Retro High OG Black Toe Reimagined DZ5485-106"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Size 9 Nike Zoom Kobe 6 Protro All Star 2.0 FQ3546-100 Brand New SHIPS FAST"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Nike Kobe 6 Protro Sail All-Star FQ3546-100 Ship Now  **IN HAND SHIP NOW**"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Rolex Submariner Mens 40mm Date 16610 SS Vintage Running Automatic Wrist Watch"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Cartier Santos Carree Ref: 2961 18K Yellow Gold / S. Steel 29mm Automatic Watch"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Omega Speedmaster 145022 71 ST  Chronograph Vintage Pilots Watch 1039 516"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Cartier Tank Must XL Automatic Wristwatch WSTA0040 w/Spare Straps, Box & Papers"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Factory Service Breitling Superocean Heritage II Chronograph 18K SS Wrist Watch"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Rolex Oyster Perpetual Day-Date Ref. 1803 Champagne Dial 36mm #W150325-1"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Patek Philippe 3543 Gubelin Roman Dial Vintage 18k Gold Box and Papers 1969"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Rolex OP Datejust Thunderbird Men's 36mm 16263 Two-Tone Wristwatch #W145913-1"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Grand Seiko Hi-Beat 36000 80 Hours SLGH021 \"Genbi Valley\" Watch 2024 LE 1/1000"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "ROLEX MENS EXPLORER II 16570 GMT DATE 40MM STAINLESS STEEL BLACK Box And papers"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": ""
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": ""
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": ""
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": ""
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": ""
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": ""
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": ""
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Soundcore Life Q20 Wireless Over-Ear Headphones ANC Bluetooth Headset|Refurbish"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Lenovo Thinkpad T14 G1 14\" FHD Intel Core i5 10310U 16GB RAM 512GB SSD W11P"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "HP TP01-3016 Desktop Intel i5-12400 Intel UHD 730 12GB DDR4 RAM 256GB SSD W11H"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "JBL Partybox 110 Portable Bluetooth Party Speaker w/ 160W Powerful Sound, Black"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Lenovo Yoga 7 2-In-1 14IML9 14\" Touch Ultra 5 125U 16GB 1TB Win11P FPR CAM 2Y"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "JBL Tune 710BT, Wireless Over-Ear Headphones"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Soundcore Boom 2 Outdoor Speaker LED Portable Subwoofer BassUp 2.0 IPX7|Refurb"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Shark Upright Vacuum LA481HGN Rotator Lift-Away ADV Upright Hair Pro Brushroll"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "HP ENVY TE01-4000 Desktop Intel Core i5-13400 1.8 GHz 8GB DDR4 256GB SSD W11H"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Reconditioned Olympus E-M10 Mark IV Mirrorless Camera w/ 14-42mm EZ Lens (Black)"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": ""
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": ""
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": ""
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": ""
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": ""
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": ""
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": ""
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": ""
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": ""
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Samsung Galaxy S21 5G SM-G991U1 128GB Unlocked Excellent"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Nintendo Switch Lite 32GB + Screen Protector 🛡️ + FREE 2-DAY Shipping ✈️"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "EcoFlow Solar Generator RIVER 2 Pro 768Wh+110W Solar Panel Certified Refurbished"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Rachel Koen Diamond Love Chain Bracelet 18K White Gold 0.12cttw"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "JBL Bar 1300X 1170W 11.1.4-Ch Soundbar w/ Detachable Surround Speakers"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Clore JNC770 Green 1700 Peak Amp Premium 12 Volt Jump Starter SOLJNC770G New!"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Shark ZU100 Rotator Vacuum Cleaner for Pet Hair, Navy (Certified Refurbished)"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Google Pixel 7 5G 128GB (Factory Unlocked) - Excellent"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Samsung Galaxy S21 5G SM-G991U1 128GB Unlocked Excellent"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Nintendo Switch Lite 32GB + Screen Protector 🛡️ + FREE 2-DAY Shipping ✈️"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "EcoFlow Solar Generator RIVER 2 Pro 768Wh+110W Solar Panel Certified Refurbished"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Rachel Koen Diamond Love Chain Bracelet 18K White Gold 0.12cttw"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "JBL Bar 1300X 1170W 11.1.4-Ch Soundbar w/ Detachable Surround Speakers"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Clore JNC770 Green 1700 Peak Amp Premium 12 Volt Jump Starter SOLJNC770G New!"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Shark ZU100 Rotator Vacuum Cleaner for Pet Hair, Navy (Certified Refurbished)"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": "Google Pixel 7 5G 128GB (Factory Unlocked) - Excellent"
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": ""
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": ""
      },
      {
        "src": "https://ir.ebaystatic.com/pictures/aw/pics/s_1x2.gif",
        "alt": ""
      }
    ],
    "responseBody": "",
    "viewport": "width=device-width, initial-scale=1, user-scalable=yes, minimum-scale=1",
    "X-UA-Compatible": "IE=edge",
    "360-site-verification": "5f0e3731bf6d3fc8b2f58b1a585a788f",
    "fb:app_id": "102628213125203",
    "msvalidate.01": "34E98E6F27109BE1A9DCF19658EEEE33",
    "referrer": "unsafe-url",
    "y_key": "acf32e2a69cbc2b0",
    "google-site-verification": "8kHr3jd3Z43q1ovwo0KVgo_NZKIEMjthBxti8m8fYTg",
    "google-adsense-account": "sites-7757056108965234",
    "yandex-verification": "6e11485a66d91eff"
  }
}
```

---

## Error Handling

The API client provides comprehensive error handling through the `SeoscraperAPIClientError` exception. Here are some examples:

### Basic Error Handling

```python
from apiverve_seodatascraper.apiClient import SeoscraperAPIClient, SeoscraperAPIClientError

api = SeoscraperAPIClient("[YOUR_API_KEY]")

query = { "url": "https://apiverve.com" }

try:
    result = api.execute(query)
    print("Success!")
    print(result)
except SeoscraperAPIClientError as e:
    print(f"API Error: {e.message}")
    if e.status_code:
        print(f"Status Code: {e.status_code}")
    if e.response:
        print(f"Response: {e.response}")
```

### Handling Specific Error Types

```python
from apiverve_seodatascraper.apiClient import SeoscraperAPIClient, SeoscraperAPIClientError

api = SeoscraperAPIClient("[YOUR_API_KEY]")

query = { "url": "https://apiverve.com" }

try:
    result = api.execute(query)

    # Check for successful response
    if result.get('status') == 'success':
        print("Request successful!")
        print(result.get('data'))
    else:
        print(f"API returned an error: {result.get('error')}")

except SeoscraperAPIClientError as e:
    # Handle API client errors
    if e.status_code == 401:
        print("Unauthorized: Invalid API key")
    elif e.status_code == 429:
        print("Rate limit exceeded")
    elif e.status_code >= 500:
        print("Server error - please try again later")
    else:
        print(f"API error: {e.message}")
except Exception as e:
    # Handle unexpected errors
    print(f"Unexpected error: {str(e)}")
```

### Using Context Manager (Recommended)

The client supports the context manager protocol for automatic resource cleanup:

```python
from apiverve_seodatascraper.apiClient import SeoscraperAPIClient, SeoscraperAPIClientError

query = { "url": "https://apiverve.com" }

# Using context manager ensures proper cleanup
with SeoscraperAPIClient("[YOUR_API_KEY]") as api:
    try:
        result = api.execute(query)
        print(result)
    except SeoscraperAPIClientError as e:
        print(f"Error: {e.message}")
# Session is automatically closed here
```

---

## Advanced Features

### Debug Mode

Enable debug logging to see detailed request and response information:

```python
from apiverve_seodatascraper.apiClient import SeoscraperAPIClient

# Enable debug mode
api = SeoscraperAPIClient("[YOUR_API_KEY]", debug=True)

query = { "url": "https://apiverve.com" }

# Debug information will be printed to console
result = api.execute(query)
```

### Manual Session Management

If you need to manually manage the session lifecycle:

```python
from apiverve_seodatascraper.apiClient import SeoscraperAPIClient

api = SeoscraperAPIClient("[YOUR_API_KEY]")

query = { "url": "https://apiverve.com" }

try:
    result = api.execute(query)
    print(result)
finally:
    # Manually close the session when done
    api.close()
```

---

## Customer Support

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact?utm_source=pypi&utm_medium=readme).

---

## Updates
Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms?utm_source=pypi&utm_medium=readme) and all legal documents and agreements.

---

## License
Licensed under the The MIT License (MIT)

Copyright (&copy;) 2026 APIVerve, and EvlarSoft LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
