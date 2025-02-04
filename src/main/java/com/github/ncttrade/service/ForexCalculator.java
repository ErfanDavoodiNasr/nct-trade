package com.github.ncttrade.service;

import com.github.ncttrade.exception.InvalidSymbolException;
import com.github.ncttrade.model.dto.MarginRequest;
import com.github.ncttrade.model.dto.PositionSizeRequest;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.net.URISyntaxException;

public interface ForexCalculator {
    ResponseEntity<Double> positionSize(PositionSizeRequest positionSizeRequest) throws URISyntaxException, IOException, InterruptedException, InvalidSymbolException;

    Double valueOfOnePip(String symbol, Double livePrice) throws InvalidSymbolException;

    ResponseEntity<Double> margin(MarginRequest marginRequest) throws URISyntaxException, IOException, InterruptedException, InvalidSymbolException;
}
