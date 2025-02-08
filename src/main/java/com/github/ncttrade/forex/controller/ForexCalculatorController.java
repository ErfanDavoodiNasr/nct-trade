package com.github.ncttrade.forex.controller;


import com.github.ncttrade.forex.exception.InvalidSymbolException;
import com.github.ncttrade.forex.model.dto.MarginRequest;
import com.github.ncttrade.forex.model.dto.PositionSizeRequest;
import com.github.ncttrade.forex.model.dto.ResultResponse;
import com.github.ncttrade.forex.service.ForexCalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/v1/forex-calculator")
@RequiredArgsConstructor
public class ForexCalculatorController {
    private final ForexCalculatorService forexCalculator;

    @PostMapping("/position-size")
    public ResponseEntity<ResultResponse> positionSize(@RequestBody PositionSizeRequest req) throws URISyntaxException, IOException, InterruptedException, InvalidSymbolException {
        return ResponseEntity.ok(forexCalculator.positionSize(req));
    }

    @PostMapping("/margin")
    public ResponseEntity<ResultResponse> margin(@RequestBody MarginRequest req) throws URISyntaxException, IOException, InterruptedException, InvalidSymbolException {
        return ResponseEntity.ok(forexCalculator.margin(req));
    }
}
