package com.github.ncttrade.forex.service;

import com.github.ncttrade.forex.api.LivePrice;
import com.github.ncttrade.forex.exception.InvalidSymbolException;
import com.github.ncttrade.forex.model.Symbol;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;


@RequiredArgsConstructor
@Service
public class ForexPriceServiceImpl implements ForexPriceService {
    private final LivePrice livePrice;

    @Override
    public ResponseEntity<Symbol> livePrice(String symbol) throws URISyntaxException, IOException, InterruptedException, InvalidSymbolException {
        return ResponseEntity.ok(livePrice.getLivePrice(symbol));
    }
}
