package com.github.ncttrade.forex.util;

import com.github.ncttrade.forex.exception.InvalidSymbolException;

import java.util.List;


public class Help {
    public static final List<String> symbols = List.of(
            "AUDCAD", "AUDCHF", "AUDJPY", "AUDNZD", "AUDSGD", "AUDUSD", "CADUSD",
            "CADAUD", "CADCHF", "CADHKD", "CADJPY", "CADPLN", "CADSGD", "CADINR",
            "CHFHKD", "CHFJPY", "CHFPLN", "CHFUSD", "CHFSAR", "CHFTWD",
            "DKKHKD", "DKKJPY", "DKKNOK", "DKKPLN", "DKKSEK", "DKKUSD",
            "EURAUD", "EURCAD", "EURCHF", "EURDKK", "EURGBP", "EURHKD", "EURHUF",
            "EURINR", "EURJPY", "EURNOK", "EURNZD", "EURPLN", "EURRON", "EURRUB",
            "EURSEK", "EURSGD", "EURTRY", "EURUSD", "GBPCHF", "GBPCAD", "GBPAUD",
            "GBPNOK", "GBPNZD", "GBPPLN", "GBPSEK", "GBPUSD", "GBPJPY", "GBPZAR",
            "JPYPLN", "JPYSGD", "JPYTWD", "JPYUSD", "NOKJPY", "NOKPLN", "NOKSEK",
            "NOKUSD", "NZDAUD", "NZDCAD", "NZDCHF", "NZDJPY", "NZDPLN", "NZDSGD",
            "NZDUSD", "PLNJPY", "PLNTWD", "PLNUSD", "SEKJPY", "SEKPLN",
            "SEKUSD", "SGDCHF", "SGDHKD", "SGDINR", "SGDJPY", "SGDPLN", "SGDTWD",
            "SGDUSD", "USDARS", "USDAUD", "USDCAD", "USDCHF", "USDHKD", "USDHUF",
            "USDILS", "USDINR", "USDMXN", "USDNOK", "USDPLN", "USDRON", "USDRUB",
            "USDSEK", "USDSGD", "USDTRY", "USDZAR", "USDJPY", "AUDHKD", "AUDINR",
            "AUDPLN"
    );

    public static Double getPipLocation(String symbol) throws InvalidSymbolException {
        if (symbol == null || symbol.length() < 6) {
            throw new InvalidSymbolException("Symbol cannot be null or empty");
        }
        return symbol.contains("JPY") ? 0.01 : 0.0001;
    }
}
