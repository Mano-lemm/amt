package com.example.amtgroupproject.presentation.controllers;

import com.example.amtgroupproject.models.dto.AccountResponse;
import com.example.amtgroupproject.models.dto.CreateAccount;
import com.example.amtgroupproject.services.exceptions.AccountException;
import com.example.amtgroupproject.services.flow.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("api/v1/account")
public class AccountController {
    private final AccountService service;

    public AccountController(AccountService service){
        this.service = service;
    }

    @PostMapping("/create")
    public AccountResponse create(@RequestBody CreateAccount req){
        System.out.println(req);
        try {
            return service.createAccount(req);
        } catch (AccountException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/create/params")
    public AccountResponse create(@RequestParam Long Klantid){
        CreateAccount ca = new CreateAccount();
        ca.setOwnerId(Klantid);
        try {
            return service.createAccount(ca);
        } catch (AccountException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
