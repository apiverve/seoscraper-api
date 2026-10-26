declare module '@apiverve/seoscraper' {
  export interface seoscraperOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface seoscraperResponse {
    status: string;
    error: string | null;
    data: SEODataScraperData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface SEODataScraperData {
      url:                  null | string;
      title:                null | string;
      description:          null | string;
      keywords:             null | string;
      author:               null | string;
      canonical:            null | string;
      ogTitle:              null | string;
      ogDescription:        null | string;
      ogImage:              null | string;
      ogURL:                null | string;
      ogType:               null | string;
      ogSiteName:           null | string;
      twitterCard:          null | string;
      twitterTitle:         null | string;
      twitterDescription:   null | string;
      twitterImage:         null | string;
      twitterSite:          null | string;
      robots:               null | string;
      viewport:             null | string;
      charset:              null | string;
      titleRelevance:       number | null;
      descriptionRelevance: number | null;
  }

  export default class seoscraperWrapper {
    constructor(options: seoscraperOptions);

    execute(callback: (error: any, data: seoscraperResponse | null) => void): Promise<seoscraperResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: seoscraperResponse | null) => void): Promise<seoscraperResponse>;
    execute(query?: Record<string, any>): Promise<seoscraperResponse>;
  }
}
