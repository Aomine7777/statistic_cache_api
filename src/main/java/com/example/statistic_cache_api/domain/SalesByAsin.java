package com.example.statistic_cache_api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public record SalesByAsin(
        Integer unitsOrdered,
        Integer unitsOrderedB2B,
        AmountWithCurrency orderedProductSales,
        AmountWithCurrency orderedProductSalesB2B,
        Integer totalOrderItems,
        Integer totalOrderItemsB2B
) {}