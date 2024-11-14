package com.example.statistic_cache_api.dto;

import com.example.statistic_cache_api.domain.ReportSpecification;
import com.example.statistic_cache_api.entity.Statistics;

import java.util.List;
import java.util.stream.Collectors;

public record StatisticsByDateDTO(
        String id,
        ReportSpecification reportSpecification,
        String date,
        SalesByDateDTO salesByDate,
        TrafficByDateDTO trafficByDate
) {
    public StatisticsByDateDTO(Statistics statistics) {
        this(
                statistics.getId(),
                statistics.getReportSpecification(),
                statistics.getDate(),
                new SalesByDateDTO(statistics.getSalesByDate()),
                new TrafficByDateDTO(statistics.getTrafficByDate())
        );
    }

    public static List<StatisticsByDateDTO> convertStatistic(List<Statistics> statistics) {
        return statistics.stream()
                .map(StatisticsByDateDTO::new)
                .collect(Collectors.toList());
    }
}