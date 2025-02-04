package com.github.ncttrade.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MarginRequest {
    private Double tradeSize;
    private String symbol;
    private String accountCurrency;
    private Integer marginRatio;
}
