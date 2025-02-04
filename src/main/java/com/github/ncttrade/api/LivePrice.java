package com.github.ncttrade.api;

import com.github.ncttrade.exception.InvalidSymbolException;
import com.github.ncttrade.model.Symbol;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;

@Component
public interface LivePrice {
    Symbol getLivePrice(String symbol) throws URISyntaxException, IOException, InterruptedException, InvalidSymbolException;
}
