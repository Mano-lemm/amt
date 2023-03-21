package com.example.amtgroupproject.models.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateAccount {
    private BigDecimal initialBalance;

    private Long ownerId;
}
