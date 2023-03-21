package com.example.amtgroupproject.services.flow;

import com.example.amtgroupproject.models.dto.BankResponse;
import com.example.amtgroupproject.models.dto.CreateBank;
import com.example.amtgroupproject.models.entities.BankEntity;
import com.example.amtgroupproject.models.repositories.BankRepository;
import com.example.amtgroupproject.services.exceptions.BankException;
import com.example.amtgroupproject.services.mappers.BankMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BankService {
    private final BankRepository repository;
    private final BankMapper mapper;

    public BankResponse create(CreateBank req) throws BankException {
        BankEntity ent;
        try {
            ent = mapper.toEntity(req);
            ent = repository.save(ent);
        } catch (Exception e){
            throw new BankException();
        }
        return mapper.toResponse(ent);
    }
}
