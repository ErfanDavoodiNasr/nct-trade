package com.github.ncttrade.forex.model.dto;

public record CurrencyConvertResponse(String firstCurrency, Double firstCurrencyPrice,
                                      String secondCurrency, Double secondCurrencyPrice) {
}
