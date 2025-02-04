package com.github.ncttrade.service;

import com.github.ncttrade.api.LivePrice;
import com.github.ncttrade.exception.InvalidSymbolException;
import com.github.ncttrade.model.Symbol;
import com.github.ncttrade.model.dto.MarginRequest;
import com.github.ncttrade.model.dto.PositionSizeRequest;
import com.github.ncttrade.util.Help;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;

@Service
@RequiredArgsConstructor
public class ForexCalculatorImpl implements ForexCalculator {
    private final LivePrice livePrice;

    @Override
    public ResponseEntity<Double> positionSize(PositionSizeRequest req) throws URISyntaxException, IOException, InterruptedException, InvalidSymbolException {
        Symbol liveSymbol = livePrice.getLivePrice(req.getSymbol());
        return ResponseEntity.ok(positionSizeCalculate(req, liveSymbol));
    }

    private double positionSizeCalculate(PositionSizeRequest req, Symbol liveSymbol) throws InvalidSymbolException {
        return Math.abs(((req.getBalance() * req.getAmountOfRiskInPercent()) / (liveSymbol.getPrice() - req.getStopLoss()))
                / valueOfOnePip(req.getSymbol(), liveSymbol.getPrice()));
    }

    @Override
    public Double valueOfOnePip(String symbol, Double livePrice) throws InvalidSymbolException {
        return (Help.getPipLocation(symbol) / livePrice) * 100_000;
    }

    @Override
    public ResponseEntity<Double> margin(MarginRequest marginRequest) throws URISyntaxException, IOException, InterruptedException, InvalidSymbolException {
        String finalSymbol = marginRequest.getSymbol().substring(0, 3).concat(marginRequest.getAccountCurrency());
        return ResponseEntity.ok(marginCalculate(marginRequest, marginRequest.getTradeSize(), finalSymbol));
    }

    private double marginCalculate(MarginRequest marginRequest, Double tradeSize, String finalSymbol) throws URISyntaxException, IOException, InterruptedException, InvalidSymbolException {
        tradeSize *= 100_000;
        return (tradeSize * livePrice.getLivePrice(finalSymbol).getPrice()) / marginRequest.getMarginRatio();
    }
}
