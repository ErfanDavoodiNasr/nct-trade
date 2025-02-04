package com.github.ncttrade.util;

import com.github.ncttrade.exception.InvalidSymbolException;


public class Help {

    public static Double getPipLocation(String symbol) throws InvalidSymbolException {
        if (symbol == null || symbol.length() < 6) {
            throw new InvalidSymbolException("Symbol cannot be null or empty");
        }
        return symbol.contains("JPY") ? 0.01 : 0.0001;
    }
}
