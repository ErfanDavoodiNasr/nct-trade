package com.github.ncttrade.forex.service;

import com.github.ncttrade.forex.exception.InvalidSymbolException;
import com.github.ncttrade.forex.model.dto.*;

import java.io.IOException;
import java.net.URISyntaxException;

public interface ForexCalculatorService {
    ResultResponse positionSize(PositionSizeRequest req) throws URISyntaxException, IOException, InterruptedException, InvalidSymbolException;

    ResultResponse valueOfOnePip(String symbol, Double livePrice) throws InvalidSymbolException;

    ResultResponse margin(MarginRequest req) throws URISyntaxException, IOException, InterruptedException, InvalidSymbolException;

    ResultResponse valueOfOnePip(String symbol) throws InvalidSymbolException, URISyntaxException, IOException, InterruptedException;

    ResultResponse leverage(LeverageRequest req);

    ResultResponse riskOfRuin(RiskOfRuinRequest req);
}
