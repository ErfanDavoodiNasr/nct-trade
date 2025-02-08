package com.github.ncttrade.forex.controller;


import com.github.ncttrade.forex.exception.InvalidSymbolException;
import com.github.ncttrade.forex.model.dto.*;
import com.github.ncttrade.forex.service.ForexCalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/v1/forex-calculator")
@RequiredArgsConstructor
public class ForexCalculatorController {
    private final ForexCalculatorService ForexCalculatorService;

    @PostMapping("/position-size")
    public ResponseEntity<ResultResponse> positionSize(@RequestBody PositionSizeRequest req) throws URISyntaxException, IOException, InterruptedException, InvalidSymbolException {
        return ResponseEntity.ok(ForexCalculatorService.positionSize(req));
    }

    @PostMapping("/margin")
    public ResponseEntity<ResultResponse> margin(@RequestBody MarginRequest req) throws URISyntaxException, IOException, InterruptedException, InvalidSymbolException {
        return ResponseEntity.ok(ForexCalculatorService.margin(req));
    }

    @PostMapping("/valueOfOnePip={symbol}")
    public ResponseEntity<ResultResponse> valueOfOnePip(@PathVariable("symbol") String symbol) throws URISyntaxException, IOException, InterruptedException, InvalidSymbolException {
        return ResponseEntity.ok(ForexCalculatorService.valueOfOnePip(symbol));
    }

    @PostMapping("/riskOfRuin")
    public ResponseEntity<ResultResponse> riskOfRuin(@RequestBody RiskOfRuinRequest req) {
        return ResponseEntity.ok(ForexCalculatorService.riskOfRuin(req));
    }

    @PostMapping("/leverage")
    public ResponseEntity<ResultResponse> leverage(@RequestBody LeverageRequest req) throws URISyntaxException, IOException, InterruptedException, InvalidSymbolException {
        return ResponseEntity.ok(ForexCalculatorService.leverage(req));
    }
}
