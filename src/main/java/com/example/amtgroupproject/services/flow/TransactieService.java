package com.example.amtgroupproject.services.flow;

import com.example.amtgroupproject.models.dto.CreateTransactie;
import com.example.amtgroupproject.models.dto.TransactieResponse;
import com.example.amtgroupproject.models.entities.AccountEntity;
import com.example.amtgroupproject.models.entities.TransactieEntity;
import com.example.amtgroupproject.models.repositories.AccountRepository;
import com.example.amtgroupproject.models.repositories.TransactieRepository;
import com.example.amtgroupproject.services.exceptions.AccountException;
import com.example.amtgroupproject.services.exceptions.TransactieException;
import com.example.amtgroupproject.services.mappers.TransactieMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactieService {
    private final TransactieRepository repository;
    private final AccountRepository accRepo;
    private final TransactieMapper mapper;

    public TransactieResponse createTransactie(CreateTransactie req){
        Optional<AccountEntity> fromAccount = accRepo.findById(req.getFromId());
        Optional<AccountEntity> toAccount = accRepo.findById(req.getToId());
        if(fromAccount.isEmpty() || toAccount.isEmpty()){
            throw new AccountException();
        }
        TransactieEntity ent;
        try {
            ent = mapper.toEntity(req);
            ent.setFrom(fromAccount.get());
            ent.setTo(toAccount.get());
            ent = repository.save(ent);
        } catch (Exception e){
            throw new TransactieException();
        }
        return mapper.toResponse(ent);
    }
}
