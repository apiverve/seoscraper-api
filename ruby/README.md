# SEO Data Scraper API - Ruby Gem

SEO Data Scraper parses any public URL to collect title tags, meta descriptions, robots directives, and Open Graph or Twitter card previews. Paid plans add canonical URLs to verify indexing rules.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_seoscraper'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_seoscraper
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_seoscraper'

# Initialize the client
client = APIVerve::Seoscraper::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({ url: "https://apiverve.com" })

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ url: "https://apiverve.com" })
  puts response["data"]
rescue APIVerve::Seoscraper::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Seoscraper::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Seoscraper::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
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

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/seoscraper?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/seoscraper?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/seoscraper?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
