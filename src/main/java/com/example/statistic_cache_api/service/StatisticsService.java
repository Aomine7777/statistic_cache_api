package com.example.statistic_cache_api.service;

import com.example.statistic_cache_api.entity.Statistics;

import java.util.List;

public interface StatisticsService {
    List<Statistics> getStatisticsByDate(String startDate, String endDate);
    List<Statistics> getStatisticsByDate(String date);
    List<Statistics> getStatisticsByAsins(List<String> asins);
    Statistics getStatisticsByAllDates();
    Statistics getStatisticsByAllAsins();
}
