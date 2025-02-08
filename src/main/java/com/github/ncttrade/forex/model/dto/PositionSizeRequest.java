package com.github.ncttrade.forex.model.dto;

public record PositionSizeRequest(Double balance, Double amountOfRiskInPercent, String symbol, Double stopLoss) {
}
