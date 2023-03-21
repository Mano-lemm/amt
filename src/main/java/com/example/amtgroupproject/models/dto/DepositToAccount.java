package com.example.amtgroupproject.models.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DepositToAccount {
    private Long accId;
    private Long ATMId;
    private BigDecimal amount;
}
