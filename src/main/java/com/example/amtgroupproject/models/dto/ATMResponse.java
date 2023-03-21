package com.example.amtgroupproject.models.dto;

import lombok.Data;

@Data
public class ATMResponse {
    private Long id;

    public ATMResponse(Long id) {
        this.id = id;
    }
}
