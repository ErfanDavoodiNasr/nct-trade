package com.github.ncttrade.forex.util;

import com.github.ncttrade.forex.api.LivePrice;
import com.github.ncttrade.forex.model.Symbol;

import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LivePriceProcessor {

    public static void processSymbols(Set<Symbol> symbols, LivePrice livePrice, int numberOfThreads) throws InterruptedException {
        int totalSymbols = Help.symbols.size();
        int symbolsPerThread = totalSymbols / numberOfThreads;
        int remainingSymbols = totalSymbols % numberOfThreads;

        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

        int startIndex = 0;
        for (int i = 0; i < numberOfThreads; i++) {
            int endIndex = startIndex + symbolsPerThread + (i < remainingSymbols ? 1 : 0);
            executorService.submit(new SymbolProcessor(symbols, livePrice, startIndex, endIndex));
            startIndex = endIndex;
        }

        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    }

    private record SymbolProcessor(Set<Symbol> symbols, LivePrice livePrice, int startIndex,
                                   int endIndex) implements Runnable {

        @Override
        public void run() {
            for (int i = startIndex; i < endIndex; i++) {
                try {
                    symbols.add(livePrice.getLivePrice(Help.symbols.get(i)));
                } catch (Exception ignore) {
                }
            }
        }
    }
}