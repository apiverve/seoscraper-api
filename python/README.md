SEO Data Scraper API
============

SEO Data Scraper parses any public URL to collect title tags, meta descriptions, robots directives, and Open Graph or Twitter card previews. Paid plans add canonical URLs to verify indexing rules.


[![PyPI version](https://img.shields.io/pypi/v/apiverve-seodatascraper.svg)](https://pypi.org/project/apiverve-seodatascraper/)

This is a Python wrapper for the [SEO Data Scraper API](https://apiverve.com/marketplace/seoscraper?utm_source=pypi&utm_medium=referral&utm_content=readme)

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

Before using the SEO Data Scraper API client, you have to setup your account and obtain your API Key.
You can get it by signing up at [https://apiverve.com](https://apiverve.com?utm_source=pypi&utm_medium=referral&utm_content=readme)

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

The SEO Data Scraper API documentation is found here: [https://docs.apiverve.com/ref/seoscraper](https://docs.apiverve.com/ref/seoscraper?utm_source=pypi&utm_medium=referral&utm_content=readme).
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
    "url": "https://apiverve.com",
    "title": "APIVerve — One key for 300+ production APIs",
    "description": "Consistent schemas, predictable credit pricing, and an uptime SLA on every paid plan across 300+ production APIs. One key, one bill, zero glue code.",
    "keywords": "",
    "author": "",
    "canonical": "",
    "og:title": "APIVerve — One key for 300+ production APIs",
    "og:description": "Consistent schemas, predictable credit pricing, and an uptime SLA on every paid plan across 300+ production APIs. One key, one bill, zero glue code.",
    "og:image": "https://apiverve.com/social-images/page-home.png",
    "og:url": "https://apiverve.com",
    "og:type": "website",
    "og:site_name": "APIVerve",
    "twitter:card": "summary_large_image",
    "twitter:title": "APIVerve — One key for 300+ production APIs",
    "twitter:description": "Consistent schemas, predictable credit pricing, and an uptime SLA on every paid plan across 300+ production APIs.",
    "twitter:image": "https://apiverve.com/social-images/page-home.png",
    "twitter:site": "",
    "robots": "",
    "viewport": "width=device-width, initial-scale=1, maximum-scale=1",
    "charset": "utf-8",
    "titleRelevance": 47.91,
    "descriptionRelevance": 51.65
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

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact?utm_source=pypi&utm_medium=referral&utm_content=readme).

---

## Updates
Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms?utm_source=pypi&utm_medium=referral&utm_content=readme) and all legal documents and agreements.

---

## License
Licensed under the MIT License (MIT)

Copyright (&copy;) 2026 APIVerve, and EvlarSoft LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
