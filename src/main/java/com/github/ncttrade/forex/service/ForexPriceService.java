package com.github.ncttrade.forex.service;

import com.github.ncttrade.forex.exception.InvalidSymbolException;
import com.github.ncttrade.forex.model.Symbol;
import com.github.ncttrade.forex.model.dto.CurrencyConvertResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Set;

@Component
public interface ForexPriceService {
    Symbol livePrice(String symbol) throws URISyntaxException, IOException, InterruptedException, InvalidSymbolException;

    Set<Symbol> livePriceAll() throws URISyntaxException, IOException, InterruptedException, InvalidSymbolException;

    CurrencyConvertResponse currencyConvert(String firstCurrency, String secondCurrency) throws URISyntaxException, IOException, InterruptedException, InvalidSymbolException;
}
