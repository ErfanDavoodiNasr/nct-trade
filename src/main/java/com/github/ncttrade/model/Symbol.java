package com.github.ncttrade.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Symbol {
    private String name;

    @JsonProperty("close|60")
    private Double price;

    @Builder.Default
    private LocalDateTime date = LocalDateTime.now();
}
