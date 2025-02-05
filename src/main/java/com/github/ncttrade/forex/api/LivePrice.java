package com.github.ncttrade.forex.api;

import com.github.ncttrade.forex.exception.InvalidSymbolException;
import com.github.ncttrade.forex.model.Symbol;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;

@Component
public interface LivePrice {
    Symbol getLivePrice(String symbol) throws URISyntaxException, IOException, InterruptedException, InvalidSymbolException;
}
