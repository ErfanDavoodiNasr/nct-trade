package com.github.ncttrade.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@Table(name = License.TABLE_NAME)
public class License extends BaseModel<Long> {
    public static final String TABLE_NAME = "licenses";

    @Column
    private LocalDateTime start;

    @Column
    private LocalDateTime end;

    @Column(name = "is_active")
    private Boolean isActive;

    @OneToOne(mappedBy = "license")
    @JoinColumn(name = "user_id")
    private User user;
}
