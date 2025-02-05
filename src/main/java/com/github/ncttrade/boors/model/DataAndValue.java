package com.github.ncttrade.boors.model;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DataAndValue {
    private Integer year;
    private String value;
}
