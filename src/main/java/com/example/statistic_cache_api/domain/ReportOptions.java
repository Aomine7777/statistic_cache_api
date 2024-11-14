package com.example.statistic_cache_api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ReportOptions(String dateGranularity, String asinGranularity) {}