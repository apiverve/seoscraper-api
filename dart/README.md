# SEO Data Scraper API - Dart/Flutter Client

SEO Data Scraper parses any public URL to collect title tags, meta descriptions, robots directives, and Open Graph or Twitter card previews. Paid plans add canonical URLs to verify indexing rules.

[![pub package](https://img.shields.io/pub/v/apiverve_seoscraper.svg)](https://pub.dev/packages/apiverve_seoscraper)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [SEO Data Scraper API](https://apiverve.com/marketplace/seoscraper?utm_source=dart&utm_medium=referral&utm_content=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_seoscraper: ^1.2.6
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_seoscraper/apiverve_seoscraper.dart';

void main() async {
  final client = SeoscraperClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'url': 'https://apiverve.com'
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

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

## API Reference

- **API Home:** [SEO Data Scraper API](https://apiverve.com/marketplace/seoscraper?utm_source=dart&utm_medium=referral&utm_content=readme)
- **Documentation:** [docs.apiverve.com/ref/seoscraper](https://docs.apiverve.com/ref/seoscraper?utm_source=dart&utm_medium=referral&utm_content=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme)
