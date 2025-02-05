package com.github.ncttrade.boors.model;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class Title {
    private Integer id;
    private String name;
    private List<DataAndValue> data;
}
