package com.example.amtgroupproject.services.mappers;

import com.example.amtgroupproject.models.dto.AccountResponse;
import com.example.amtgroupproject.models.dto.CreateAccount;
import com.example.amtgroupproject.models.entities.AccountEntity;
import com.example.amtgroupproject.models.entities.KlantEntity;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public AccountEntity toEntity(CreateAccount req){
        KlantEntity entity = new KlantEntity();
        entity.setId(req.getOwnerId());
        return new AccountEntity(req.getInitialBalance(), entity);
    }

    public AccountResponse toResponse(AccountEntity entity){
        return new AccountResponse(entity.getId());
    }
}
