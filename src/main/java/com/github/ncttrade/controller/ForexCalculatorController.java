package com.github.ncttrade.controller;


import com.github.ncttrade.exception.InvalidSymbolException;
import com.github.ncttrade.model.dto.PositionSizeRequest;
import com.github.ncttrade.model.dto.PositionSizeResponse;
import com.github.ncttrade.service.ForexCalculator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/forex-calculator")
@RequiredArgsConstructor
public class ForexCalculatorController {
    private final ForexCalculator forexCalculator;

    @PostMapping("/position-size")
    public PositionSizeResponse positionSize(@RequestBody PositionSizeRequest req) throws URISyntaxException, IOException, InterruptedException, InvalidSymbolException {
        return forexCalculator.positionSize(req);
    }
}
