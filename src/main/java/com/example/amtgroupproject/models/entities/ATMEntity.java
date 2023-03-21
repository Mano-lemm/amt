package com.example.amtgroupproject.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class ATMEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String filiaal;

    @ManyToOne
    private BankEntity eigenaar;

    @OneToOne
    private AccountEntity account;
}
