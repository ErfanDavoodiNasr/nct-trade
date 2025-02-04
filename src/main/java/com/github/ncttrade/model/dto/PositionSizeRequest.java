package com.github.ncttrade.model.dto;

public record PositionSizeRequest(Double balance, Double amountOfRiskInPercent, String symbol, Double stopLoss) {
}
