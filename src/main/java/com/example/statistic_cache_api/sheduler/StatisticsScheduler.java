package com.example.statistic_cache_api.sheduler;

import com.example.statistic_cache_api.domain.ReportSpecification;
import com.example.statistic_cache_api.entity.Statistics;
import com.example.statistic_cache_api.repository.StatisticsRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class StatisticsScheduler {

    public static final String REPORT_SPECIFICATION = "reportSpecification";
    public static final String SALES_BY_DATE = "salesAndTrafficByDate";
    public static final String SALES_BY_ASIN = "salesAndTrafficByAsin";

    @Autowired
    private StatisticsRepository statisticsRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Scheduled(cron = "0 * * * * *")
    public void updateStatistics() {
        try {
            var jsonNode = objectMapper.readTree(new File("statistics_data.json"));
            var reportOptions = objectMapper.convertValue(jsonNode.get(REPORT_SPECIFICATION), new TypeReference<ReportSpecification>() {});

            var allSales = new ArrayList<>(processSales(jsonNode.get(SALES_BY_DATE), reportOptions, true));
            allSales.addAll(processSales(jsonNode.get(SALES_BY_ASIN), reportOptions, false));

            this.statisticsRepository.saveAll(allSales);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private List<Statistics> processSales(JsonNode salesNode, ReportSpecification reportOptions, boolean byDate) {
        var sales = objectMapper.convertValue(salesNode, new TypeReference<List<Statistics>>() {});
        var existsSales = byDate ?
                this.statisticsRepository.findByDateAndOptions(
                        sales.stream()
                                .map(Statistics::getDate)
                                .collect(Collectors.toList()),
                        reportOptions
                ) :
                this.statisticsRepository.findByAsinAndOptions(
                        sales.stream()
                                .map(Statistics::getParentAsin)
                                .collect(Collectors.toList()),
                        reportOptions
                );

        sales.forEach(sale -> {
            var existsSale = existsSales.stream()
                    .filter(existing -> byDate ? existing.getDate().equals(sale.getDate()) : existing.getParentAsin().equals(sale.getParentAsin()))
                    .findFirst()
                    .orElseGet(Statistics::new);

            sale.setId(existsSale.getId());
            sale.setReportSpecification(reportOptions);
        });

        return sales;
    }
}
