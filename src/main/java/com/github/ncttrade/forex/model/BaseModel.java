package com.github.ncttrade.forex.model;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@SuperBuilder
@Data
@NoArgsConstructor
public class BaseModel<ID extends Number> implements Serializable {

    @Id
    @GeneratedValue
    private ID id;

    @Column(name = "create_at")
    private LocalDateTime createAt;
}
