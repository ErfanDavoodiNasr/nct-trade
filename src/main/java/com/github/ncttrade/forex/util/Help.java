package com.github.ncttrade.forex.util;

import com.github.ncttrade.forex.exception.InvalidSymbolException;


public class Help {

    public static Double getPipLocation(String symbol) throws InvalidSymbolException {
        if (symbol == null || symbol.length() < 6) {
            throw new InvalidSymbolException("Symbol cannot be null or empty");
        }
        return symbol.contains("JPY") ? 0.01 : 0.0001;
    }
}
