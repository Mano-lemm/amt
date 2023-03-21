package com.example.amtgroupproject.presentation.controllers;

import com.example.amtgroupproject.models.dto.CreateTransactie;
import com.example.amtgroupproject.models.dto.TransactieResponse;
import com.example.amtgroupproject.services.exceptions.TransactieException;
import com.example.amtgroupproject.services.flow.TransactieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/transactie")
@RequiredArgsConstructor
public class TransactieController {
    private final TransactieService service;

    @PostMapping("/create")
    public TransactieResponse create(@RequestBody CreateTransactie req){
        try {
            return service.createTransactie(req);
        } catch (TransactieException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
