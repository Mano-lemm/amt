package com.example.amtgroupproject.presentation.controllers;

import com.example.amtgroupproject.models.dto.BankResponse;
import com.example.amtgroupproject.models.dto.CreateBank;
import com.example.amtgroupproject.services.exceptions.BankException;
import com.example.amtgroupproject.services.flow.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/bank")
public class BankController {
    private final BankService service;

    @PostMapping("/create")
    public BankResponse create(@RequestBody CreateBank req){
        try {
            return service.create(req);
        } catch (BankException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
