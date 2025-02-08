package com.github.ncttrade.forex.service;

import com.github.ncttrade.forex.api.LivePrice;
import com.github.ncttrade.forex.exception.InvalidSymbolException;
import com.github.ncttrade.forex.model.Symbol;
import com.github.ncttrade.forex.model.dto.*;
import com.github.ncttrade.forex.util.Help;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;

@Service
@RequiredArgsConstructor
public class ForexCalculatorServiceImpl implements ForexCalculatorService {
    private final LivePrice livePrice;

    @Override
    public ResultResponse positionSize(PositionSizeRequest req) throws URISyntaxException, IOException, InterruptedException, InvalidSymbolException {
        Symbol liveSymbol = livePrice.getLivePrice(req.symbol());
        return positionSizeCalculate(req, liveSymbol);
    }

    private ResultResponse positionSizeCalculate(PositionSizeRequest req, Symbol liveSymbol) throws InvalidSymbolException {
        double result = Math.abs(((req.balance() * req.amountOfRiskInPercent()) / (liveSymbol.getPrice() - req.stopLoss()))
                / valueOfOnePip(liveSymbol.getName(), liveSymbol.getPrice()).result());
        return new ResultResponse(result, "successful");
    }

    @Override
    public ResultResponse valueOfOnePip(String symbol, Double livePrice) throws InvalidSymbolException {
        Double result = (Help.getPipLocation(symbol) / livePrice) * 100_000;
        return new ResultResponse(result, "successful");
    }

    @Override
    public ResultResponse margin(MarginRequest marginRequest) throws URISyntaxException, IOException, InterruptedException, InvalidSymbolException {
        String finalSymbol = marginRequest.symbol().substring(0, 3).concat(marginRequest.accountCurrency());
        return marginCalculate(marginRequest, marginRequest.tradeSize(), finalSymbol);
    }

    @Override
    public ResultResponse valueOfOnePip(String symbol) throws InvalidSymbolException, URISyntaxException, IOException, InterruptedException {
        Double pipLocation = Help.getPipLocation(symbol);
        Double result = (pipLocation / livePrice.getLivePrice(symbol).getPrice()) * 100_000;
        return new ResultResponse(result, "successful");
    }

    @Override
    public ResultResponse leverage(LeverageRequest req) throws URISyntaxException, IOException, InterruptedException, InvalidSymbolException {
        Double result = (livePrice.getLivePrice(req.symbol()).getPrice() * req.tradeSize() * 100_000) / req.margin();
        return new ResultResponse(result, "successful");
    }

    @Override
    public ResultResponse riskOfRuin(RiskOfRuinRequest req) {
        Double expectedValue = (req.winRateInPercent() * req.averageWin()) - ((1 - req.winRateInPercent()) * (req.averageLoss()));
        Double result = (Math.pow(((req.averageLoss() - expectedValue) / (req.averageLoss() + expectedValue)), (req.lossLevelInPercent() / req.riskPerTradeInPercent()))) * 100;
        return new ResultResponse(result, "successful");
    }

    private ResultResponse marginCalculate(MarginRequest marginRequest, Double tradeSize, String finalSymbol) throws URISyntaxException, IOException, InterruptedException, InvalidSymbolException {
        tradeSize *= 100_000;
        Double result = (tradeSize * livePrice.getLivePrice(finalSymbol).getPrice()) / marginRequest.marginRatio();
        return new ResultResponse(result, "successful");
    }
}
