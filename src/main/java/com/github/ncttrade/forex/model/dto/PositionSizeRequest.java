package com.github.ncttrade.forex.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PositionSizeRequest {
    private Double balance;
    private Double amountOfRiskInPercent;
    private String symbol;
    private Double stopLoss;
}
