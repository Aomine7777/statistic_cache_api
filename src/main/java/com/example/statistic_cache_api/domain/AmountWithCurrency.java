package com.example.statistic_cache_api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AmountWithCurrency(BigDecimal amount, String currencyCode) {}