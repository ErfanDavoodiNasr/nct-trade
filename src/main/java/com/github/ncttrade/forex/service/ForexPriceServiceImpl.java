package com.github.ncttrade.forex.service;

import com.github.ncttrade.forex.api.LivePrice;
import com.github.ncttrade.forex.exception.InvalidSymbolException;
import com.github.ncttrade.forex.model.Symbol;
import com.github.ncttrade.forex.util.Help;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Symbol> livePrice(String symbol) throws URISyntaxException, IOException, InterruptedException, InvalidSymbolException {
        return ResponseEntity.ok(livePrice.getLivePrice(symbol));
    }

    @Override
    public ResponseEntity<Set<Symbol>> livePriceAll() throws URISyntaxException, IOException, InterruptedException {
        Set<Symbol> symbols = new HashSet<>(Help.symbols.size());
        for (String symbol : Help.symbols) {
            try {
                symbols.add(livePrice.getLivePrice(symbol));
            } catch (InvalidSymbolException ignore) {
            }
        }
        return ResponseEntity.ok(symbols);
    }
}
