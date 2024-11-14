package com.example.statistic_cache_api.dto;

import com.example.statistic_cache_api.domain.AmountWithCurrency;
import com.example.statistic_cache_api.domain.SalesByDate;

import java.math.BigDecimal;

public record SalesByDateDTO(
        AmountWithCurrency orderedProductSales,
        AmountWithCurrency orderedProductSalesB2B,
        Integer unitsOrdered,
        Integer unitsOrderedB2B,
        Integer totalOrderItems,
        Integer totalOrderItemsB2B,
        AmountWithCurrency averageSalesPerOrderItem,
        AmountWithCurrency averageSalesPerOrderItemB2B,
        BigDecimal averageUnitsPerOrderItem,
        BigDecimal averageUnitsPerOrderItemB2B,
        AmountWithCurrency averageSellingPrice,
        AmountWithCurrency averageSellingPriceB2B,
        Integer unitsRefunded,
        BigDecimal refundRate,
        BigDecimal claimsGranted,
        AmountWithCurrency claimsAmount,
        AmountWithCurrency shippedProductSales,
        Integer unitsShipped,
        Integer ordersShipped
) {
    public SalesByDateDTO(SalesByDate statistic) {
        this(
                statistic.orderedProductSales(),
                statistic.orderedProductSalesB2B(),
                statistic.unitsOrdered(),
                statistic.unitsOrderedB2B(),
                statistic.totalOrderItems(),
                statistic.totalOrderItemsB2B(),
                statistic.averageSalesPerOrderItem(),
                statistic.averageSalesPerOrderItemB2B(),
                statistic.averageUnitsPerOrderItem(),
                statistic.averageUnitsPerOrderItemB2B(),
                statistic.averageSellingPrice(),
                statistic.averageSellingPriceB2B(),
                statistic.unitsRefunded(),
                statistic.refundRate(),
                statistic.claimsGranted(),
                statistic.claimsAmount(),
                statistic.shippedProductSales(),
                statistic.unitsShipped(),
                statistic.ordersShipped()
        );
    }
}