package com.github.ncttrade.forex.model.dto;

public record RiskOfRuinRequest(Double winRateInPercent, Double averageWin, Double averageLoss,
                                Double riskPerTradeInPercent, Double lossLevelInPercent) {
}
