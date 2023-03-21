package com.example.amtgroupproject.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@ToString
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal balance;

    @ManyToOne
    private BankEntity bank;

    @ManyToOne
    private KlantEntity klant;

    public AccountEntity(){
    }

    public AccountEntity(BigDecimal balance, KlantEntity klant, BankEntity bank){
        this.balance = balance;
        this.klant = klant;
        this.bank = bank;
    }

    @PrePersist
    public void init(){
        if(this.balance == null && this.klant != null){
            this.balance = new BigDecimal(0);
        }
    }
}
