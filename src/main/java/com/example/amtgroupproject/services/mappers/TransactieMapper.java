package com.example.amtgroupproject.services.mappers;

import com.example.amtgroupproject.models.dto.CreateTransactie;
import com.example.amtgroupproject.models.dto.DepositToAccount;
import com.example.amtgroupproject.models.dto.TransactieResponse;
import com.example.amtgroupproject.models.entities.AccountEntity;
import com.example.amtgroupproject.models.entities.TransactieEntity;
import org.springframework.stereotype.Component;

@Component
public class TransactieMapper {

    public TransactieEntity toEntity(CreateTransactie req){
        AccountEntity from = new AccountEntity();
        AccountEntity to = new AccountEntity();
        from.setId(req.getFromId());
        to.setId(req.getToId());
        return new TransactieEntity(from, to, req.getAmount());
    }

    public TransactieEntity toEntity(DepositToAccount req){
        AccountEntity from = new AccountEntity();
        AccountEntity to = new AccountEntity();
        to.setId(req.getAccId());
        return new TransactieEntity(from, to, req.getAmount());
    }

    public TransactieResponse toResponse(TransactieEntity ent){
        return new TransactieResponse(ent.getId());
    }
}
