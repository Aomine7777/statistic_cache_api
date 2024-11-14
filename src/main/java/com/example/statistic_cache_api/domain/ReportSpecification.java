package com.example.statistic_cache_api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ReportSpecification(
        String reportType,
        ReportOptions reportOptions,
        String dataStartTime,
        String dataEndTime,
        List<String> marketplaceIds
) {}