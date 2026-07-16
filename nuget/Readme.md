SEODataScraper API
============

SEO Scraper is a simple tool for scraping SEO data. It returns the meta title, meta description, and more.

![Build Status](https://img.shields.io/badge/build-passing-green)
![Code Climate](https://img.shields.io/badge/maintainability-B-purple)
![Prod Ready](https://img.shields.io/badge/production-ready-blue)

This is a .NET Wrapper for the [SEODataScraper API](https://apiverve.com/marketplace/seoscraper?utm_source=nuget&utm_medium=readme)

---

## Installation

Using the .NET CLI:
```
dotnet add package APIVerve.API.SEODataScraper
```

Using the Package Manager:
```
nuget install APIVerve.API.SEODataScraper
```

Using the Package Manager Console:
```
Install-Package APIVerve.API.SEODataScraper
```

From within Visual Studio:

1. Open the Solution Explorer
2. Right-click on a project within your solution
3. Click on Manage NuGet Packages
4. Click on the Browse tab and search for "APIVerve.API.SEODataScraper"
5. Click on the APIVerve.API.SEODataScraper package, select the appropriate version in the right-tab and click Install

---

## Configuration

Before using the seoscraper API client, you have to setup your account and obtain your API Key.
You can get it by signing up at [https://apiverve.com](https://apiverve.com?utm_source=nuget&utm_medium=readme)

---

## Quick Start

Here's a simple example to get you started quickly:

```csharp
using System;
using APIVerve.API.SEODataScraper;

class Program
{
    static async Task Main(string[] args)
    {
        // Initialize the API client
        var apiClient = new SEODataScraperAPIClient("[YOUR_API_KEY]");

        var queryOptions = new SEODataScraperQueryOptions {
    url = "https://apiverve.com"
};

        // Make the API call
        try
        {
            var response = await apiClient.ExecuteAsync(queryOptions);

            if (response.Error != null)
            {
                Console.WriteLine($"API Error: {response.Error}");
            }
            else
            {
                Console.WriteLine("Success!");
                // Access response data using the strongly-typed ResponseObj properties
                Console.WriteLine(Newtonsoft.Json.JsonConvert.SerializeObject(response, Newtonsoft.Json.Formatting.Indented));
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Exception: {ex.Message}");
        }
    }
}
```

---

## Usage

The SEODataScraper API documentation is found here: [https://docs.apiverve.com/ref/seoscraper](https://docs.apiverve.com/ref/seoscraper?utm_source=nuget&utm_medium=readme).
You can find parameters, example responses, and status codes documented here.

### Setup

###### Authentication
SEODataScraper API uses API Key-based authentication. When you create an instance of the API client, you can pass your API Key as a parameter.

```csharp
// Create an instance of the API client
var apiClient = new SEODataScraperAPIClient("[YOUR_API_KEY]");
```

---

## Usage Examples

### Basic Usage (Async/Await Pattern - Recommended)

The modern async/await pattern provides the best performance and code readability:

```csharp
using System;
using System.Threading.Tasks;
using APIVerve.API.SEODataScraper;

public class Example
{
    public static async Task Main(string[] args)
    {
        var apiClient = new SEODataScraperAPIClient("[YOUR_API_KEY]");

        var queryOptions = new SEODataScraperQueryOptions {
    url = "https://apiverve.com"
};

        var response = await apiClient.ExecuteAsync(queryOptions);

        if (response.Error != null)
        {
            Console.WriteLine($"Error: {response.Error}");
        }
        else
        {
            Console.WriteLine(Newtonsoft.Json.JsonConvert.SerializeObject(response, Newtonsoft.Json.Formatting.Indented));
        }
    }
}
```

### Synchronous Usage

If you need to use synchronous code, you can use the `Execute` method:

```csharp
using System;
using APIVerve.API.SEODataScraper;

public class Example
{
    public static void Main(string[] args)
    {
        var apiClient = new SEODataScraperAPIClient("[YOUR_API_KEY]");

        var queryOptions = new SEODataScraperQueryOptions {
    url = "https://apiverve.com"
};

        var response = apiClient.Execute(queryOptions);

        if (response.Error != null)
        {
            Console.WriteLine($"Error: {response.Error}");
        }
        else
        {
            Console.WriteLine(Newtonsoft.Json.JsonConvert.SerializeObject(response, Newtonsoft.Json.Formatting.Indented));
        }
    }
}
```

---

## Error Handling

The API client provides comprehensive error handling. Here are some examples:

### Handling API Errors

```csharp
using System;
using System.Threading.Tasks;
using APIVerve.API.SEODataScraper;

public class Example
{
    public static async Task Main(string[] args)
    {
        var apiClient = new SEODataScraperAPIClient("[YOUR_API_KEY]");

        var queryOptions = new SEODataScraperQueryOptions {
    url = "https://apiverve.com"
};

        try
        {
            var response = await apiClient.ExecuteAsync(queryOptions);

            // Check for API-level errors
            if (response.Error != null)
            {
                Console.WriteLine($"API Error: {response.Error}");
                Console.WriteLine($"Status: {response.Status}");
                return;
            }

            // Success - use the data
            Console.WriteLine("Request successful!");
            Console.WriteLine(Newtonsoft.Json.JsonConvert.SerializeObject(response, Newtonsoft.Json.Formatting.Indented));
        }
        catch (ArgumentException ex)
        {
            // Invalid API key or parameters
            Console.WriteLine($"Invalid argument: {ex.Message}");
        }
        catch (System.Net.Http.HttpRequestException ex)
        {
            // Network or HTTP errors
            Console.WriteLine($"Network error: {ex.Message}");
        }
        catch (Exception ex)
        {
            // Other errors
            Console.WriteLine($"Unexpected error: {ex.Message}");
        }
    }
}
```

### Comprehensive Error Handling with Retry Logic

```csharp
using System;
using System.Threading.Tasks;
using APIVerve.API.SEODataScraper;

public class Example
{
    public static async Task Main(string[] args)
    {
        var apiClient = new SEODataScraperAPIClient("[YOUR_API_KEY]");

        // Configure retry behavior (max 3 retries)
        apiClient.SetMaxRetries(3);        // Retry up to 3 times (default: 0, max: 3)
        apiClient.SetRetryDelay(2000);     // Wait 2 seconds between retries

        var queryOptions = new SEODataScraperQueryOptions {
    url = "https://apiverve.com"
};

        try
        {
            var response = await apiClient.ExecuteAsync(queryOptions);

            if (response.Error != null)
            {
                Console.WriteLine($"API Error: {response.Error}");
            }
            else
            {
                Console.WriteLine("Success!");
                Console.WriteLine(Newtonsoft.Json.JsonConvert.SerializeObject(response, Newtonsoft.Json.Formatting.Indented));
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Failed after retries: {ex.Message}");
        }
    }
}
```

---

## Advanced Features

### Custom Headers

Add custom headers to your requests:

```csharp
var apiClient = new SEODataScraperAPIClient("[YOUR_API_KEY]");

// Add custom headers
apiClient.AddCustomHeader("X-Custom-Header", "custom-value");
apiClient.AddCustomHeader("X-Request-ID", Guid.NewGuid().ToString());

var queryOptions = new SEODataScraperQueryOptions {
    url = "https://apiverve.com"
};

var response = await apiClient.ExecuteAsync(queryOptions);

// Remove a header
apiClient.RemoveCustomHeader("X-Custom-Header");

// Clear all custom headers
apiClient.ClearCustomHeaders();
```

### Request Logging

Enable logging for debugging:

```csharp
var apiClient = new SEODataScraperAPIClient("[YOUR_API_KEY]", isDebug: true);

// Or use a custom logger
apiClient.SetLogger(message =>
{
    Console.WriteLine($"[LOG] {DateTime.Now:yyyy-MM-dd HH:mm:ss} - {message}");
});

var queryOptions = new SEODataScraperQueryOptions {
    url = "https://apiverve.com"
};

var response = await apiClient.ExecuteAsync(queryOptions);
```

### Retry Configuration

Customize retry behavior for failed requests:

```csharp
var apiClient = new SEODataScraperAPIClient("[YOUR_API_KEY]");

// Set retry options
apiClient.SetMaxRetries(3);           // Retry up to 3 times (default: 0, max: 3)
apiClient.SetRetryDelay(1500);        // Wait 1.5 seconds between retries (default: 1000ms)

var queryOptions = new SEODataScraperQueryOptions {
    url = "https://apiverve.com"
};

var response = await apiClient.ExecuteAsync(queryOptions);
```

### Dispose Pattern

The API client implements `IDisposable` for proper resource cleanup:

```csharp
var queryOptions = new SEODataScraperQueryOptions {
    url = "https://apiverve.com"
};

using (var apiClient = new SEODataScraperAPIClient("[YOUR_API_KEY]"))
{
    var response = await apiClient.ExecuteAsync(queryOptions);
    Console.WriteLine(Newtonsoft.Json.JsonConvert.SerializeObject(response, Newtonsoft.Json.Formatting.Indented));
}
// HttpClient is automatically disposed here
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

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact?utm_source=nuget&utm_medium=readme).

---

## Updates
Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms?utm_source=nuget&utm_medium=readme) and all legal documents and agreements.

---

## License
Licensed under the The MIT License (MIT)

Copyright (&copy;) 2026 APIVerve, and EvlarSoft LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
