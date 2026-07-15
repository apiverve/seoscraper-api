# SEO Data Scraper API

SEO Scraper is a simple tool for scraping SEO data. It returns the meta title, meta description, and more.

![Build Status](https://img.shields.io/badge/build-passing-green)
![Code Climate](https://img.shields.io/badge/maintainability-B-purple)
![Prod Ready](https://img.shields.io/badge/production-ready-blue)
[![npm version](https://img.shields.io/npm/v/@apiverve/seoscraper.svg)](https://www.npmjs.com/package/@apiverve/seoscraper)

This is a Javascript Wrapper for the [SEO Data Scraper API](https://apiverve.com/marketplace/seoscraper?utm_source=npm&utm_medium=readme)

---

## Installation

Using npm:
```shell
npm install @apiverve/seoscraper
```

Using yarn:
```shell
yarn add @apiverve/seoscraper
```

---

## Configuration

Before using the SEO Data Scraper API client, you have to setup your account and obtain your API Key.
You can get it by signing up at [https://apiverve.com](https://apiverve.com?utm_source=npm&utm_medium=readme)

---

## Quick Start

[Get started with the Quick Start Guide](https://docs.apiverve.com/quickstart?utm_source=npm&utm_medium=readme)

The SEO Data Scraper API documentation is found here: [https://docs.apiverve.com/ref/seoscraper](https://docs.apiverve.com/ref/seoscraper?utm_source=npm&utm_medium=readme).
You can find parameters, example responses, and status codes documented here.

### Setup

```javascript
const seoscraperAPI = require('@apiverve/seoscraper');
const api = new seoscraperAPI({
    api_key: '[YOUR_API_KEY]'
});
```

---

## Usage

---

### Perform Request

Using the API is simple. All you have to do is make a request. The API will return a response with the data you requested.

```javascript
var query = {
  "url": "https://apiverve.com"
};

api.execute(query, function (error, data) {
    if (error) {
        return console.error(error);
    } else {
        console.log(data);
    }
});
```

---

### Using Promises

You can also use promises to make requests. The API returns a promise that you can use to handle the response.

```javascript
var query = {
  "url": "https://apiverve.com"
};

api.execute(query)
    .then(data => {
        console.log(data);
    })
    .catch(error => {
        console.error(error);
    });
```

---

### Using Async/Await

You can also use async/await to make requests. The API returns a promise that you can use to handle the response.

```javascript
async function makeRequest() {
    var query = {
  "url": "https://apiverve.com"
};

    try {
        const data = await api.execute(query);
        console.log(data);
    } catch (error) {
        console.error(error);
    }
}
```

---

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "requestUrl": "https://apiverve.com",
    "url": "https://apiverve.com/",
    "canonical": "https://apiverve.com",
    "lang": "en",
    "charset": "utf-8",
    "title": "APIVerve - Fast, Scalable, and Reliable APIs",
    "image": "",
    "favicons": [
      {
        "rel": "icon",
        "type": "image/x-icon",
        "href": "/images/favicon.ico"
      },
      {
        "rel": "icon",
        "type": "image/png",
        "href": "/images/favicon.png"
      },
      {
        "rel": "apple-touch-icon",
        "href": "/images/favicon.png"
      }
    ],
    "author": "APIVerve",
    "description": "APIVerve offers fast, scalable, and reliable APIs for developers. Access data enrichment, validation, and integration services with enterprise-grade performance.",
    "keywords": "API, developer tools, data enrichment, API integration, scalable APIs, reliable APIs",
    "source": "",
    "price": "",
    "priceCurrency": "",
    "availability": "",
    "robots": "index, follow",
    "jsonld": [
      {
        "@context": "https://schema.org",
        "@type": "Organization",
        "name": "APIVerve",
        "url": "https://apiverve.com",
        "logo": "https://apiverve.com/images/favicon.png",
        "sameAs": [
          "https://www.facebook.com/apiverve",
          "https://www.twitter.com/apivervehq",
          "https://www.linkedin.com/company/apiverve",
          "https://github.com/apiverve",
          "https://www.instagram.com/apiverve"
        ]
      },
      {
        "@context": "https://schema.org",
        "@type": "WebSite",
        "url": "https://apiverve.com",
        "potentialAction": {
          "@type": "SearchAction",
          "target": {
            "@type": "EntryPoint",
            "urlTemplate": "https://apiverve.com/marketplace?search={search_term_string}"
          },
          "query-input": "required name=search_term_string"
        }
      }
    ],
    "og:url": "https://apiverve.com",
    "og:locale": "",
    "og:locale:alternate": "",
    "og:title": "APIVerve - Fast, Scalable, and Reliable APIs",
    "og:type": "website",
    "og:description": "APIVerve offers fast, scalable, and reliable APIs for developers. Access data enrichment, validation, and integration services with enterprise-grade performance.",
    "og:determiner": "",
    "og:site_name": "APIVerve",
    "og:image": "https://apiverve.com/images/posterImage.png",
    "og:image:secure_url": "",
    "og:image:type": "",
    "og:image:width": "1200",
    "og:image:height": "630",
    "twitter:title": "APIVerve - Fast, Scalable, and Reliable APIs",
    "twitter:description": "APIVerve offers fast, scalable, and reliable APIs for developers. Access data enrichment, validation, and integration services with enterprise-grade performance.",
    "twitter:image": "https://apiverve.com/images/posterImage.png",
    "twitter:image:alt": "",
    "twitter:card": "summary_large_image",
    "twitter:site": "",
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
        "text": "API Platform"
      },
      {
        "level": "h5",
        "text": "Core Platform"
      },
      {
        "level": "h5",
        "text": "Developer Tools"
      },
      {
        "level": "h5",
        "text": "Integrations"
      },
      {
        "level": "h4",
        "text": "Solutions"
      },
      {
        "level": "h5",
        "text": "By Industry"
      },
      {
        "level": "h5",
        "text": "By Use Case"
      },
      {
        "level": "h4",
        "text": "Resources"
      },
      {
        "level": "h5",
        "text": "Learn & Build"
      },
      {
        "level": "h5",
        "text": "Support & Community"
      },
      {
        "level": "h5",
        "text": "Trust & Transparency"
      },
      {
        "level": "h1",
        "text": "Fast, Scalable, and Reliable |"
      },
      {
        "level": "h2",
        "text": "Trusted by over 40,000 forward thinking developers"
      },
      {
        "level": "h2",
        "text": "Why Developers Choose APIVerve"
      },
      {
        "level": "h3",
        "text": "⚡ Unmatched Reliability"
      },
      {
        "level": "h3",
        "text": "🔑 True One-Key Simplicity"
      },
      {
        "level": "h3",
        "text": "🌐 GraphQL & Mocking"
      },
      {
        "level": "h2",
        "text": "Most Popular APIs"
      },
      {
        "level": "h3",
        "text": "Daily API Performance"
      },
      {
        "level": "h2",
        "text": "Trusted by Developers Worldwide"
      },
      {
        "level": "h4",
        "text": "Tomasz K."
      },
      {
        "level": "h4",
        "text": "Priya M."
      },
      {
        "level": "h4",
        "text": "Rafael S."
      },
      {
        "level": "h2",
        "text": "Native SDKs & Libraries"
      },
      {
        "level": "h4",
        "text": "JavaScript/TypeScript"
      },
      {
        "level": "h4",
        "text": "React"
      },
      {
        "level": "h4",
        "text": "Vue.js"
      },
      {
        "level": "h4",
        "text": "Angular"
      },
      {
        "level": "h4",
        "text": "Node.js"
      },
      {
        "level": "h4",
        "text": "Next.js"
      },
      {
        "level": "h2",
        "text": "Frequently Asked Questions"
      },
      {
        "level": "h3",
        "text": "How much usage is included with the Free Trial plan?"
      },
      {
        "level": "h3",
        "text": "How do I get an API Key?"
      },
      {
        "level": "h3",
        "text": "How does APIVerve use my data?"
      },
      {
        "level": "h3",
        "text": "Can I change my plan at any time?"
      },
      {
        "level": "h3",
        "text": "How do I know my plan usage?"
      },
      {
        "level": "h3",
        "text": "Can I cancel my plan anytime?"
      },
      {
        "level": "h3",
        "text": "Where can I find my invoices?"
      },
      {
        "level": "h3",
        "text": "What are your accepted payment methods?"
      },
      {
        "level": "h3",
        "text": "What happens when I go over the token limit for the month?"
      },
      {
        "level": "h3",
        "text": "What is a token?"
      },
      {
        "level": "h3",
        "text": "Do you offer student discounts?"
      },
      {
        "level": "h2",
        "text": "Ready to build something amazing?"
      },
      {
        "level": "h3",
        "text": "APIVerve"
      },
      {
        "level": "h4",
        "text": "Product"
      },
      {
        "level": "h4",
        "text": "Integrations"
      },
      {
        "level": "h4",
        "text": "Solutions"
      },
      {
        "level": "h4",
        "text": "Resources"
      },
      {
        "level": "h4",
        "text": "Compare"
      },
      {
        "level": "h4",
        "text": "SDKs"
      },
      {
        "level": "h4",
        "text": "Company"
      },
      {
        "level": "h4",
        "text": "Legal"
      }
    ],
    "imgTags": [
      {
        "src": "/images/favicon.png",
        "alt": "APIVerve"
      },
      {
        "src": "/images/wreath.svg",
        "alt": "Award"
      },
      {
        "src": "/images/brands/brand06.png",
        "alt": "Postman"
      },
      {
        "src": "/images/brands/brand01.png",
        "alt": "Microsoft"
      },
      {
        "src": "/images/brands/brand02.png",
        "alt": "DuckDuckGo"
      },
      {
        "src": "/images/brands/brand03.png",
        "alt": "Topdanmark"
      },
      {
        "src": "/images/brands/brand04.png",
        "alt": "University of Maryland"
      },
      {
        "src": "/images/brands/brand05.png",
        "alt": "Postman"
      },
      {
        "src": "/images/brands/brand06.png",
        "alt": "RapidAPI"
      },
      {
        "src": "/images/brands/brand07.png",
        "alt": "Zapier"
      },
      {
        "src": "/images/brands/brand08.svg",
        "alt": "Brand"
      },
      {
        "src": "/images/brands/brand01.png",
        "alt": "Microsoft"
      },
      {
        "src": "/images/brands/brand02.png",
        "alt": "DuckDuckGo"
      },
      {
        "src": "/images/brands/brand03.png",
        "alt": "Topdanmark"
      },
      {
        "src": "/images/brands/brand04.png",
        "alt": "University of Maryland"
      },
      {
        "src": "/images/brands/brand05.png",
        "alt": "Postman"
      },
      {
        "src": "/images/brands/brand06.png",
        "alt": "RapidAPI"
      },
      {
        "src": "/images/brands/brand07.png",
        "alt": "Zapier"
      },
      {
        "src": "/images/brands/brand08.svg",
        "alt": "Brand"
      },
      {
        "src": "/images/favicon.png",
        "alt": "APIVerve"
      }
    ],
    "responseBody": "",
    "viewport": "width=device-width, initial-scale=1,width=device-width, initial-scale=1",
    "googlebot": "index, follow",
    "theme-color": "#ffffff",
    "application-name": "APIVerve",
    "msapplication-TileColor": "#3b82f6",
    "mobile-web-app-capable": "yes",
    "apple-mobile-web-app-title": "APIVerve",
    "apple-mobile-web-app-status-bar-style": "default",
    "og:image:alt": "APIVerve - Fast, Scalable, and Reliable APIs"
  }
}
```

---

## Customer Support

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact?utm_source=npm&utm_medium=readme).

---

## Updates

Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms?utm_source=npm&utm_medium=readme), [Privacy Policy](https://apiverve.com/privacy?utm_source=npm&utm_medium=readme), and [Refund Policy](https://apiverve.com/refund?utm_source=npm&utm_medium=readme).

---

## License
Licensed under the The MIT License (MIT)

Copyright (&copy;) 2026 APIVerve, and EvlarSoft LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
