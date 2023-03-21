package com.example.amtgroupproject.models.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateTransactie {
    private Long fromId;
    private Long toId;
    private BigDecimal amount;
}
