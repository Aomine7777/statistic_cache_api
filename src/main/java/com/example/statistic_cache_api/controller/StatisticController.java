package com.example.statistic_cache_api.controller;

import com.example.statistic_cache_api.dto.StatisticsByAsinDTO;
import com.example.statistic_cache_api.dto.StatisticsByDateDTO;
import com.example.statistic_cache_api.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.statistic_cache_api.dto.StatisticsByDateDTO.convertStatistic;


@RestController
@RequestMapping("/api/statistics")
public class StatisticController {

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping("/byDate/{startDate}/{endDate}")
    public List<StatisticsByDateDTO> getByDate(@PathVariable String startDate, @PathVariable String endDate) {
        return convertStatistic(this.statisticsService.getStatisticsByDate(startDate, endDate));
    }

    @GetMapping("/byDate/{date}")
    public List<StatisticsByDateDTO> getByDate(@PathVariable String date) {
        return convertStatistic(this.statisticsService.getStatisticsByDate(date));
    }

    @PostMapping("/byAsins")
    public List<StatisticsByAsinDTO> getByAsin(@RequestBody List<String> values) {
        return StatisticsByAsinDTO.convertStatistic(this.statisticsService.getStatisticsByAsins(values));
    }

    @GetMapping("/aggregateStatisticByAllDates")
    public StatisticsByDateDTO getAggregatedStatisticByAllDates() {
        return new StatisticsByDateDTO(this.statisticsService.getStatisticsByAllDates());
    }

    @GetMapping("/aggregateStatisticByAllAsins")
    public StatisticsByAsinDTO getAggregatedStatisticByAllAsins() {
        return new StatisticsByAsinDTO(this.statisticsService.getStatisticsByAllAsins());
    }
}