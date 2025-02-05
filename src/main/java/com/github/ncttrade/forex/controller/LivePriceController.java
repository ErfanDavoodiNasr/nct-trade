package com.github.ncttrade.forex.controller;


import com.github.ncttrade.forex.exception.InvalidSymbolException;
import com.github.ncttrade.forex.model.Symbol;
import com.github.ncttrade.forex.service.ForexPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("api/forex-prices")
@RequiredArgsConstructor
public class LivePriceController {

    private final ForexPriceService forexPrice;

    @GetMapping("/symbol={symbol}")
    public ResponseEntity<Symbol> livePrice(@PathVariable("symbol") String symbol) throws URISyntaxException, IOException, InterruptedException, InvalidSymbolException {
        return forexPrice.livePrice(symbol);
    }
}
