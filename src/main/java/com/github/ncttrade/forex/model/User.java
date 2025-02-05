package com.github.ncttrade.forex.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@Table(name = User.TABLE_NAME)
public class User extends BaseModel<Long> {

    public static final String TABLE_NAME = "users";

    @Column
    private String name;

    @Column(unique = true)
    private String email;

    @Column(unique = true, name = "phone_number")
    private String phoneNumber;

    @Column
    private String password;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "license_id")
    private License license;
}
