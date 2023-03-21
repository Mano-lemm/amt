package com.example.amtgroupproject.services.mappers;

import com.example.amtgroupproject.models.dto.AccountResponse;
import com.example.amtgroupproject.models.dto.CreateAccount;
import com.example.amtgroupproject.models.entities.AccountEntity;
import com.example.amtgroupproject.models.entities.BankEntity;
import com.example.amtgroupproject.models.entities.KlantEntity;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public AccountEntity toEntity(CreateAccount req){
        KlantEntity entity = new KlantEntity();
        entity.setId(req.getOwnerId());
        BankEntity bankEntity = new BankEntity();
        bankEntity.setId(req.getBankId());
        return new AccountEntity(req.getInitialBalance(), entity, bankEntity);
    }

    public AccountResponse toResponse(AccountEntity entity){
        return new AccountResponse(entity.getId());
    }
}
