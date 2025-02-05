package com.github.ncttrade.forex.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.ncttrade.forex.exception.InvalidSymbolException;
import com.github.ncttrade.forex.model.Symbol;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class TradingViewApi implements LivePrice {
    private final ObjectMapper objectMapper;


    @Override
    public Symbol getLivePrice(String symbol) throws URISyntaxException, IOException, InterruptedException, InvalidSymbolException {
        objectMapper.registerModule(new JavaTimeModule());
        HttpClient client = HttpClient.newHttpClient();
        String query = String.format(
                "symbol=FX:%s&fields=%s&no_404=true",
                symbol,
                "close|60"
        );
        URI uri = new URI(
                "https",
                "scanner.tradingview.com",
                "/symbol",
                query,
                null
        );
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .version(HttpClient.Version.HTTP_2)
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Symbol result = objectMapper.readValue(response.body(), Symbol.class);
        if (result == null) {
            throw new InvalidSymbolException("please enter valid symbol");
        }
        result.setName(symbol);
        return result;
    }


}
