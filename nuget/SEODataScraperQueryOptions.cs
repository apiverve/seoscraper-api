using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.SEODataScraper
{
    /// <summary>
    /// Query options for the SEO Data Scraper API
    /// </summary>
    public class SEODataScraperQueryOptions
    {
        /// <summary>
        /// The URL of the web page to scrape SEO data from
        /// </summary>
        [JsonProperty("url")]
        public string Url { get; set; }
    }
}
