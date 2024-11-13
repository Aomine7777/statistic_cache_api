package com.example.statistic_cache_api.entity;

import com.example.statistic_cache_api.domain.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "statistics")
public class Statistics {
    @Id
    private String id;
    private ReportSpecification reportSpecification;

    private String date;
    private SalesByDate salesByDate;
    private TrafficByDate trafficByDate;

    private String parentAsin;
    private SalesByAsin salesByAsin;
    private TrafficByAsin trafficByAsin;
}
