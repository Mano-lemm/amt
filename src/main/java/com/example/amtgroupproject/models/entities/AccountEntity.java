package com.example.amtgroupproject.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal balance;

    @ManyToOne
    private KlantEntity klant;

    public AccountEntity(){
    }

    public AccountEntity(BigDecimal balance, KlantEntity klant){
        this.balance = balance;
        this.klant = klant;
    }

    @PrePersist
    public void init(){
        if(this.balance == null){
            this.balance = new BigDecimal(0);
        }
    }
}
