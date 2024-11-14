package com.example.statistic_cache_api.service.impl;

import com.example.statistic_cache_api.entity.Statistics;
import com.example.statistic_cache_api.repository.StatisticsRepository;
import com.example.statistic_cache_api.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticsServiceImpl implements StatisticsService {

    private final StatisticsRepository statisticsRepository;

    @Cacheable(value = "statisticsByDate", key = "#startDate + '_' + #endDate")
    @Override
    public List<Statistics> getStatisticsByDate(String startDate, String endDate) {
        return this.statisticsRepository.findByDateBetween(startDate, endDate);
    }

    @Cacheable(value = "statisticsByDate", key = "#date")
    @Override
    public List<Statistics> getStatisticsByDate(String date) {
        return this.statisticsRepository.findByDate(date);
    }

    @Cacheable(value = "statisticsByAsin", key = "#asins")
    @Override
    public List<Statistics> getStatisticsByAsins(List<String> asins) {
        return this.statisticsRepository.findByAsinIn(asins);
    }

    @Cacheable(value = "statisticsByAllDates")
    @Override
    public Statistics getStatisticsByAllAsins() {
        return this.statisticsRepository.aggregateStatisticByAllAsins();
    }

    @Cacheable(value = "statisticsByAllAsins")
    @Override
    public Statistics getStatisticsByAllDates() {
        return this.statisticsRepository.aggregateStatisticByAllDates();
    }
}