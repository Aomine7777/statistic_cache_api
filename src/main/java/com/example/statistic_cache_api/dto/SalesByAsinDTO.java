package com.example.statistic_cache_api.dto;

import com.example.statistic_cache_api.domain.AmountWithCurrency;
import com.example.statistic_cache_api.domain.SalesByAsin;

public record SalesByAsinDTO(
        Integer unitsOrdered,
        Integer unitsOrderedB2B,
        AmountWithCurrency orderedProductSales,
        AmountWithCurrency orderedProductSalesB2B,
        Integer totalOrderItems,
        Integer totalOrderItemsB2B
) {
    public SalesByAsinDTO(SalesByAsin statistic) {
        this(
                statistic.unitsOrdered(),
                statistic.unitsOrderedB2B(),
                statistic.orderedProductSales(),
                statistic.orderedProductSalesB2B(),
                statistic.totalOrderItems(),
                statistic.totalOrderItemsB2B()
        );
    }
}