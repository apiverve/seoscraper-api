/// Response models for the SEO Data Scraper API.

/// API Response wrapper.
class SeoscraperResponse {
  final String status;
  final dynamic error;
  final SeoscraperData? data;

  /// Set only when the current plan locks one or more fields; null otherwise.
  final PremiumInfo? premium;

  SeoscraperResponse({
    required this.status,
    this.error,
    this.data,
    this.premium,
  });

  factory SeoscraperResponse.fromJson(Map<String, dynamic> json) => SeoscraperResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? SeoscraperData.fromJson(json['data']) : null,
    premium: json['premium'] != null ? PremiumInfo.fromJson(json['premium']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
    if (premium != null) 'premium': premium!.toJson(),
  };
}

/// Describes fields the current plan does not unlock. Locked fields arrive as null
/// in [data], and [lockedFields] names them (nested ones use dot paths).
class PremiumInfo {
  final String? message;
  final String? upgradeUrl;
  final List<String>? lockedFields;

  PremiumInfo({this.message, this.upgradeUrl, this.lockedFields});

  factory PremiumInfo.fromJson(Map<String, dynamic> json) => PremiumInfo(
    message: json['message'] as String?,
    upgradeUrl: json['upgrade_url'] as String?,
    lockedFields: (json['locked_fields'] as List?)?.map((e) => e.toString()).toList(),
  );

  Map<String, dynamic> toJson() => {
    if (message != null) 'message': message,
    if (upgradeUrl != null) 'upgrade_url': upgradeUrl,
    if (lockedFields != null) 'locked_fields': lockedFields,
  };
}

/// Response data for the SEO Data Scraper API.

class SeoscraperData {
  String? url;
  String? title;
  String? description;
  String? keywords;
  String? author;
  String? canonical;
  String? og:title;
  String? og:description;
  String? og:image;
  String? og:url;
  String? og:type;
  String? og:siteName;
  String? twitter:card;
  String? twitter:title;
  String? twitter:description;
  String? twitter:image;
  String? twitter:site;
  String? robots;
  String? viewport;
  String? charset;
  num? titleRelevance;
  num? descriptionRelevance;

  SeoscraperData({
    this.url,
    this.title,
    this.description,
    this.keywords,
    this.author,
    this.canonical,
    this.og:title,
    this.og:description,
    this.og:image,
    this.og:url,
    this.og:type,
    this.og:siteName,
    this.twitter:card,
    this.twitter:title,
    this.twitter:description,
    this.twitter:image,
    this.twitter:site,
    this.robots,
    this.viewport,
    this.charset,
    this.titleRelevance,
    this.descriptionRelevance,
  });

  factory SeoscraperData.fromJson(Map<String, dynamic> json) => SeoscraperData(
      url: json['url'],
      title: json['title'],
      description: json['description'],
      keywords: json['keywords'],
      author: json['author'],
      canonical: json['canonical'],
      og:title: json['og:title'],
      og:description: json['og:description'],
      og:image: json['og:image'],
      og:url: json['og:url'],
      og:type: json['og:type'],
      og:siteName: json['og:site_name'],
      twitter:card: json['twitter:card'],
      twitter:title: json['twitter:title'],
      twitter:description: json['twitter:description'],
      twitter:image: json['twitter:image'],
      twitter:site: json['twitter:site'],
      robots: json['robots'],
      viewport: json['viewport'],
      charset: json['charset'],
      titleRelevance: json['titleRelevance'],
      descriptionRelevance: json['descriptionRelevance'],
    );
}

class SeoscraperRequest {
  String url;

  SeoscraperRequest({
    required this.url,
  });

  Map<String, dynamic> toJson() => {
      'url': url,
    };
}
