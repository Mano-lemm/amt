package com.example.amtgroupproject.presentation.controllers;

import com.example.amtgroupproject.models.dto.ATMResponse;
import com.example.amtgroupproject.models.dto.CreateATM;
import com.example.amtgroupproject.services.exceptions.ATMException;
import com.example.amtgroupproject.services.flow.ATMService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("api/v1/ATM")
@RequiredArgsConstructor
public class ATMController {
    private final ATMService service;

    @PostMapping("/create")
    public ATMResponse createATM(@RequestBody CreateATM req){
        try {
            return service.create(req);
        } catch (ATMException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }
}
