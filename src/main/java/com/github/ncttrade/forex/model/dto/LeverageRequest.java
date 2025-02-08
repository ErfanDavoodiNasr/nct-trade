package com.github.ncttrade.forex.model.dto;

public record LeverageRequest(String symbol, Double margin, Double tradeSize) {
}
