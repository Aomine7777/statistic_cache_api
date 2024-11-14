package com.example.statistic_cache_api.dto;

import com.example.statistic_cache_api.domain.TrafficByDate;

import java.math.BigDecimal;

public record TrafficByDateDTO(
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
) {
    public TrafficByDateDTO(TrafficByDate statistic) {
        this(
                statistic.browserPageViews(),
                statistic.browserPageViewsB2B(),
                statistic.mobileAppPageViews(),
                statistic.mobileAppPageViewsB2B(),
                statistic.pageViews(),
                statistic.pageViewsB2B(),
                statistic.browserSessions(),
                statistic.browserSessionsB2B(),
                statistic.mobileAppSessions(),
                statistic.mobileAppSessionsB2B(),
                statistic.sessions(),
                statistic.sessionsB2B(),
                statistic.buyBoxPercentage(),
                statistic.buyBoxPercentageB2B(),
                statistic.orderItemSessionPercentage(),
                statistic.orderItemSessionPercentageB2B(),
                statistic.unitSessionPercentage(),
                statistic.unitSessionPercentageB2B(),
                statistic.averageOfferCount(),
                statistic.averageParentItems(),
                statistic.feedbackReceived(),
                statistic.negativeFeedbackReceived(),
                statistic.receivedNegativeFeedbackRate()
        );
    }
}