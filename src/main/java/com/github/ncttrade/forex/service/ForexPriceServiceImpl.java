package com.github.ncttrade.forex.service;

import com.github.ncttrade.forex.api.LivePrice;
import com.github.ncttrade.forex.exception.InvalidSymbolException;
import com.github.ncttrade.forex.model.Symbol;
import com.github.ncttrade.forex.model.dto.CurrencyConvertResponse;
import com.github.ncttrade.forex.util.Help;
import com.github.ncttrade.forex.util.LivePriceProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;


@RequiredArgsConstructor
@Service
public class ForexPriceServiceImpl implements ForexPriceService {
    private final LivePrice livePrice;

    @Override
    public Symbol livePrice(String symbol) throws URISyntaxException, IOException, InterruptedException, InvalidSymbolException {
        return livePrice.getLivePrice(symbol);
    }

    @Override
    public Set<Symbol> livePriceAll() throws URISyntaxException, IOException, InterruptedException {
        Set<Symbol> symbols = new HashSet<>(Help.symbols.size());
        LivePriceProcessor.processSymbols(symbols, livePrice, 6);
        return symbols;
    }

    @Override
    public CurrencyConvertResponse currencyConvert(String firstCurrency, String secondCurrency) throws URISyntaxException, IOException, InterruptedException, InvalidSymbolException {
        Double firstCurrencyResult = livePrice.getLivePrice(firstCurrency.substring(0, 3).concat(secondCurrency.substring(3))).getPrice();
        Double secondCurrencyResult = livePrice.getLivePrice(secondCurrency.substring(0, 3).concat(firstCurrency.substring(3))).getPrice();
        return new CurrencyConvertResponse(firstCurrency, firstCurrencyResult, secondCurrency, secondCurrencyResult);
    }

}