package com.example.amtgroupproject.presentation.controllers;

import com.example.amtgroupproject.models.dto.CreateKlant;
import com.example.amtgroupproject.models.dto.DeleteKlant;
import com.example.amtgroupproject.models.dto.KlantResponse;
import com.example.amtgroupproject.services.exceptions.KlantException;
import com.example.amtgroupproject.services.flow.KlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("api/v1/klant")
@RequiredArgsConstructor
public class KlantController {
    private final KlantService service;

    @PostMapping("/create")
    public KlantResponse create(@RequestBody @Validated CreateKlant req) {
        try {
            return service.createKlant(req);
        } catch (KlantException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/delete")
    public KlantResponse delete(@RequestBody @Validated DeleteKlant req) {
        try {
            return service.createKlant(req);
        } catch (KlantException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
