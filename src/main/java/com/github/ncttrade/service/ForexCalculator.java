package com.github.ncttrade.service;

import com.github.ncttrade.exception.InvalidSymbolException;
import com.github.ncttrade.model.dto.PositionSizeRequest;
import com.github.ncttrade.model.dto.PositionSizeResponse;

import java.io.IOException;
import java.net.URISyntaxException;

public interface ForexCalculator {
    PositionSizeResponse positionSize(PositionSizeRequest positionSizeRequest) throws URISyntaxException, IOException, InterruptedException, InvalidSymbolException;

    Double valueOfOnePip(String symbol, Double livePrice) throws InvalidSymbolException;
}
