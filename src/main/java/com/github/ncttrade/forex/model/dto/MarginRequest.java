package com.github.ncttrade.forex.model.dto;


public record MarginRequest(Double tradeSize, String symbol, String accountCurrency, Integer marginRatio) {
}
