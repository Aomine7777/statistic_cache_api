package com.example.statistic_cache_api.dto;

import com.example.statistic_cache_api.domain.ReportSpecification;
import com.example.statistic_cache_api.entity.Statistics;

import java.util.List;
import java.util.stream.Collectors;

public record StatisticsByAsinDTO(
        String id,
        ReportSpecification reportSpecification,
        String parentAsin,
        SalesByAsinDTO salesByAsin,
        TrafficByAsinDTO trafficByAsin
) {

    public StatisticsByAsinDTO(Statistics statistics) {
        this(
                statistics.getId(),
                statistics.getReportSpecification(),
                statistics.getParentAsin(),
                new SalesByAsinDTO(statistics.getSalesByAsin()),
                new TrafficByAsinDTO(statistics.getTrafficByAsin())
        );
    }

    public static List<StatisticsByAsinDTO> convertStatistic(List<Statistics> statistics) {
        return statistics.stream()
                .map(StatisticsByAsinDTO::new)
                .collect(Collectors.toList());
    }
}