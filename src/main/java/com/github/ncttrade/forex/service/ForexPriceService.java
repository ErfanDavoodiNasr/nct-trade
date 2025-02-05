package com.github.ncttrade.forex.service;

import com.github.ncttrade.forex.exception.InvalidSymbolException;
import com.github.ncttrade.forex.model.Symbol;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.net.URISyntaxException;

public interface ForexPriceService {
    ResponseEntity<Symbol> livePrice(String symbol) throws URISyntaxException, IOException, InterruptedException, InvalidSymbolException;
}
