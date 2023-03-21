package com.example.amtgroupproject.services.flow;

import com.example.amtgroupproject.models.dto.ATMResponse;
import com.example.amtgroupproject.models.dto.CreateATM;
import com.example.amtgroupproject.models.entities.ATMEntity;
import com.example.amtgroupproject.models.entities.AccountEntity;
import com.example.amtgroupproject.models.repositories.ATMRepository;
import com.example.amtgroupproject.models.repositories.AccountRepository;
import com.example.amtgroupproject.services.exceptions.ATMException;
import com.example.amtgroupproject.services.mappers.ATMMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ATMService {
    private final ATMRepository repository;
    private final AccountRepository accRepo;
    private final ATMMapper mapper;

    public ATMResponse create(CreateATM req) throws ATMException{
        ATMEntity ent;
        try {
            ent = mapper.toEntity(req);
            AccountEntity account = new AccountEntity(null, null, ent.getEigenaar());
            account = accRepo.save(account);
            ent.setAccount(account);
            ent = repository.save(ent);
        } catch (Exception e){
            throw new ATMException(e.getMessage(), e);
        }
        return mapper.toResponse(ent);
    }
}
