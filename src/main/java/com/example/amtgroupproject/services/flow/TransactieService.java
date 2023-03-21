package com.example.amtgroupproject.services.flow;

import com.example.amtgroupproject.models.dto.CreateTransactie;
import com.example.amtgroupproject.models.dto.DepositToAccount;
import com.example.amtgroupproject.models.dto.TransactieResponse;
import com.example.amtgroupproject.models.entities.ATMEntity;
import com.example.amtgroupproject.models.entities.AccountEntity;
import com.example.amtgroupproject.models.entities.TransactieEntity;
import com.example.amtgroupproject.models.repositories.ATMRepository;
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
    private final ATMRepository atmRepository;
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
            ent.setUitvoerendeBank(fromAccount.get().getBank());
            ent = repository.save(ent);
            fromAccount.get().setBalance(fromAccount.get().getBalance().subtract(req.getAmount()));
            toAccount.get().setBalance(toAccount.get().getBalance().add(req.getAmount()));
            accRepo.save(fromAccount.get());
            accRepo.save(toAccount.get());
        } catch (Exception e){
            throw new TransactieException();
        }
        return mapper.toResponse(ent);
    }

    public TransactieResponse depositToAccount(final DepositToAccount req) throws AccountException{
        Optional<ATMEntity> optionalATM = atmRepository.findById(req.getATMId());
        optionalATM.orElseThrow(() -> new TransactieException("ATM with id " + req.getATMId() + " does not exist."));
        Optional<AccountEntity> optionalAccount = accRepo.findById(req.getAccId());
        optionalAccount.orElseThrow(() -> new TransactieException("Account with id " + req.getAccId() + " does not exist."));
        TransactieEntity ent;
        try {
            ent = mapper.toEntity(req);
            ent.setFrom(optionalATM.get().getAccount());
            ent.setTo(optionalAccount.get());
            ent = repository.save(ent);
            optionalAccount.get().setBalance(optionalAccount.get().getBalance().add(req.getAmount()));
            accRepo.save(optionalAccount.get());
        } catch (Exception e){
            throw new TransactieException(e.getMessage(), e);
        }
        return mapper.toResponse(ent);
    }
}
