package com.example.amtgroupproject.services.mappers;

import com.example.amtgroupproject.models.dto.ATMResponse;
import com.example.amtgroupproject.models.dto.CreateATM;
import com.example.amtgroupproject.models.entities.ATMEntity;
import com.example.amtgroupproject.models.entities.BankEntity;
import org.springframework.stereotype.Component;

@Component
public class ATMMapper {
    public ATMResponse toResponse(ATMEntity ent){
        return new ATMResponse(ent.getId());
    }

    public ATMEntity toEntity(CreateATM req){
        ATMEntity ent = new ATMEntity();
        BankEntity bent = new BankEntity();
        bent.setId(req.getEigenaarId());
        ent.setEigenaar(bent);
        ent.setFiliaal(req.getFiliaalName());
        return ent;
    }
}
