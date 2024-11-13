package com.example.statistic_cache_api.domain;

import java.math.BigDecimal;

public record AmountWithCurrency(BigDecimal amount, String currencyCode) {}
