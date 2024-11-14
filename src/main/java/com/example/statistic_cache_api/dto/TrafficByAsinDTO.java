package com.example.statistic_cache_api.dto;

import com.example.statistic_cache_api.domain.TrafficByAsin;

import java.math.BigDecimal;

public record TrafficByAsinDTO(
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
) {
    public TrafficByAsinDTO(TrafficByAsin statistic) {
        this(
                statistic.browserSessions(),
                statistic.browserSessionsB2B(),
                statistic.mobileAppSessions(),
                statistic.mobileAppSessionsB2B(),
                statistic.sessions(),
                statistic.sessionsB2B(),
                statistic.browserSessionPercentage(),
                statistic.browserSessionPercentageB2B(),
                statistic.mobileAppSessionPercentage(),
                statistic.mobileAppSessionPercentageB2B(),
                statistic.sessionPercentage(),
                statistic.sessionPercentageB2B(),
                statistic.browserPageViews(),
                statistic.browserPageViewsB2B(),
                statistic.mobileAppPageViews(),
                statistic.mobileAppPageViewsB2B(),
                statistic.pageViews(),
                statistic.pageViewsB2B(),
                statistic.browserPageViewsPercentage(),
                statistic.browserPageViewsPercentageB2B(),
                statistic.mobileAppPageViewsPercentage(),
                statistic.mobileAppPageViewsPercentageB2B(),
                statistic.pageViewsPercentage(),
                statistic.pageViewsPercentageB2B(),
                statistic.buyBoxPercentage(),
                statistic.buyBoxPercentageB2B(),
                statistic.unitSessionPercentage(),
                statistic.unitSessionPercentageB2B()
        );
    }
}