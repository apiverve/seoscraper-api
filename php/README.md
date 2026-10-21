# SEO Data Scraper API - PHP Package

SEO Data Scraper parses any public URL to collect title tags, meta descriptions, robots directives, and Open Graph or Twitter card previews. Paid plans add canonical URLs to verify indexing rules.

## Installation

Install via Composer:

```bash
composer require apiverve/seoscraper
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Seoscraper\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute(['url' => 'https://apiverve.com']);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Seoscraper\Client;
use APIVerve\Seoscraper\Exceptions\APIException;
use APIVerve\Seoscraper\Exceptions\ValidationException;

try {
    $response = $client->execute(['url' => 'https://apiverve.com']);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
```

## Example Response

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
    "charset": "utf-8"
  }
}
```

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/seoscraper?utm_source=packagist&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/seoscraper?utm_source=php&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/seoscraper?utm_source=php&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
