package com.example.statistic_cache_api.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TrafficByAsin(
        Integer browserSessions,
        Integer browserSessionsB2B,
        Integer mobileAppSessions,
        Integer mobileAppSessionsB2B,
        Integer sessions,
        Integer sessionsB2B,
        BigDecimal browserSessionPercentage,
        BigDecimal browserSessionPercentageB2B,
        BigDecimal mobileAppSessionPercentage,
        BigDecimal mobileAppSessionPercentageB2B,
        BigDecimal sessionPercentage,
        BigDecimal sessionPercentageB2B,
        Integer browserPageViews,
        Integer browserPageViewsB2B,
        Integer mobileAppPageViews,
        Integer mobileAppPageViewsB2B,
        Integer pageViews,
        Integer pageViewsB2B,
        BigDecimal browserPageViewsPercentage,
        BigDecimal browserPageViewsPercentageB2B,
        BigDecimal mobileAppPageViewsPercentage,
        BigDecimal mobileAppPageViewsPercentageB2B,
        BigDecimal pageViewsPercentage,
        BigDecimal pageViewsPercentageB2B,
        BigDecimal buyBoxPercentage,
        BigDecimal buyBoxPercentageB2B,
        BigDecimal unitSessionPercentage,
        BigDecimal unitSessionPercentageB2B
) {}