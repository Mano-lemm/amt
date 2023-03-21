package com.example.amtgroupproject.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class TransactieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private AccountEntity from;

    @ManyToOne
    private AccountEntity to;

    private BigDecimal amount;

    public TransactieEntity(){
    }

    public TransactieEntity(AccountEntity from, AccountEntity to, BigDecimal amount){
        this.from = from;
        this.to = to;
        this.amount = amount;
    }
}
