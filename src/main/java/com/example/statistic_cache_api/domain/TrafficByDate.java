package com.example.statistic_cache_api.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TrafficByDate(
        Integer browserPageViews,
        Integer browserPageViewsB2B,
        Integer mobileAppPageViews,
        Integer mobileAppPageViewsB2B,
        Integer pageViews,
        Integer pageViewsB2B,
        Integer browserSessions,
        Integer browserSessionsB2B,
        Integer mobileAppSessions,
        Integer mobileAppSessionsB2B,
        Integer sessions,
        Integer sessionsB2B,
        BigDecimal buyBoxPercentage,
        BigDecimal buyBoxPercentageB2B,
        BigDecimal orderItemSessionPercentage,
        BigDecimal orderItemSessionPercentageB2B,
        BigDecimal unitSessionPercentage,
        BigDecimal unitSessionPercentageB2B,
        Integer averageOfferCount,
        Integer averageParentItems,
        Integer feedbackReceived,
        Integer negativeFeedbackReceived,
        BigDecimal receivedNegativeFeedbackRate
) {}