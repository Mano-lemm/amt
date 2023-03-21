package com.example.amtgroupproject.services.mappers;

import com.example.amtgroupproject.models.dto.BankResponse;
import com.example.amtgroupproject.models.dto.CreateBank;
import com.example.amtgroupproject.models.entities.BankEntity;
import com.example.amtgroupproject.services.exceptions.BankException;
import org.springframework.stereotype.Component;

@Component
public class BankMapper {
    public BankResponse toResponse(BankEntity ent){
        return new BankResponse(ent.getId());
    }

    public BankEntity toEntity(CreateBank req){
        BankEntity ent = new BankEntity();
        ent.setAdress(req.getAdress());
        ent.setName(req.getName());
        return ent;
    }
}
