package com.example.statistic_cache_api.controller;

import com.example.statistic_cache_api.dto.StatisticsByAsinDTO;
import com.example.statistic_cache_api.dto.StatisticsByDateDTO;
import com.example.statistic_cache_api.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static com.example.statistic_cache_api.dto.StatisticsByDateDTO.convertStatistic;
import static io.netty.util.internal.StringUtil.isNullOrEmpty;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/statistics")
public class StatisticController {

    private final StatisticsService statisticsService;

    @GetMapping("/date")
    public List<StatisticsByDateDTO> getByDate(
            @RequestParam String startDate,
            @RequestParam(required = false) String endDate) {
        if (isNullOrEmpty(endDate)) {
            return convertStatistic(this.statisticsService.getStatisticsByDate(startDate));
        } else {
            return convertStatistic(this.statisticsService.getStatisticsByDate(startDate, endDate));
        }
    }

    @GetMapping("/asin")
    public List<StatisticsByAsinDTO> getByAsin(@RequestParam List<String> asins) {
        if (asins == null || asins.isEmpty()) {
            throw new IllegalArgumentException("At least one ASIN must be provided");
        }
        return StatisticsByAsinDTO.convertStatistic(this.statisticsService.getStatisticsByAsins(asins));
    }

    @GetMapping("/date/total")
    public StatisticsByDateDTO getStatisticByAllDates() {
        return new StatisticsByDateDTO(this.statisticsService.getStatisticsByAllDates());
    }

    @GetMapping("/asin/total")
    public StatisticsByAsinDTO getStatisticByAllAsins() {
        return new StatisticsByAsinDTO(this.statisticsService.getStatisticsByAllAsins());
    }
}