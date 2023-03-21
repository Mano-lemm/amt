package com.example.amtgroupproject.services.flow;

import com.example.amtgroupproject.models.dto.AccountResponse;
import com.example.amtgroupproject.models.dto.CreateAccount;
import com.example.amtgroupproject.models.entities.AccountEntity;
import com.example.amtgroupproject.models.entities.BankEntity;
import com.example.amtgroupproject.models.entities.KlantEntity;
import com.example.amtgroupproject.models.repositories.AccountRepository;
import com.example.amtgroupproject.models.repositories.BankRepository;
import com.example.amtgroupproject.models.repositories.KlantRepository;
import com.example.amtgroupproject.services.exceptions.AccountException;
import com.example.amtgroupproject.services.mappers.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository repository;
    private final KlantRepository klantRepository;
    private final BankRepository bankRepository;
    private final AccountMapper mapper;


    public AccountResponse createAccount(CreateAccount req){
        Optional<KlantEntity> found = klantRepository.findById(req.getOwnerId());
        if(found.isEmpty()){
            throw new AccountException();
        }
        Optional<BankEntity> bankById = bankRepository.findById(req.getBankId());
        if(bankById.isEmpty()){
            System.out.printf("bank(%d) not found.\n", req.getBankId());
            throw new AccountException();
        }
        AccountEntity entity = mapper.toEntity(req);
        entity.setKlant(found.get());
        entity.setBank(bankById.get());
        AccountEntity savedentity = repository.save(entity);
        return mapper.toResponse(savedentity);
    }
}
