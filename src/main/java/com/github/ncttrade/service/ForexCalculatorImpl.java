package com.github.ncttrade.service;

import com.github.ncttrade.api.LivePrice;
import com.github.ncttrade.exception.InvalidSymbolException;
import com.github.ncttrade.model.Symbol;
import com.github.ncttrade.model.dto.PositionSizeRequest;
import com.github.ncttrade.model.dto.PositionSizeResponse;
import com.github.ncttrade.util.Help;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;

@Service
@RequiredArgsConstructor
public class ForexCalculatorImpl implements ForexCalculator {
    private final LivePrice livePrice;

    @Override
    public PositionSizeResponse positionSize(PositionSizeRequest req) throws URISyntaxException, IOException, InterruptedException, InvalidSymbolException {
        Symbol result = livePrice.getLivePrice(req.symbol());
        return new PositionSizeResponse(Math.abs(((req.balance() * req.amountOfRiskInPercent()) / (result.getPrice() - req.stopLoss()))
                / valueOfOnePip(req.symbol(), result.getPrice())));
    }

    @Override
    public Double valueOfOnePip(String symbol, Double livePrice) throws InvalidSymbolException {
        double pipLocation = Help.getPipLocation(symbol);
        return (pipLocation / livePrice) * 100_000;
    }
}
