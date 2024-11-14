package com.example.statistic_cache_api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SalesByDate(
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
) {}