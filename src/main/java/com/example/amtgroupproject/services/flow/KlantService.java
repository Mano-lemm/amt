package com.example.amtgroupproject.services.flow;

import com.example.amtgroupproject.models.dto.CreateKlant;
import com.example.amtgroupproject.models.dto.DeleteKlant;
import com.example.amtgroupproject.models.dto.KlantResponse;
import com.example.amtgroupproject.models.entities.KlantEntity;
import com.example.amtgroupproject.models.repositories.KlantRepository;
import com.example.amtgroupproject.services.exceptions.KlantException;
import com.example.amtgroupproject.services.mappers.KlantMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KlantService {
    private final KlantRepository repository;
    private final KlantMapper mapper;

    public KlantResponse createKlant(CreateKlant req) throws KlantException {
        KlantEntity newKlant = null;
        try {
            newKlant = mapper.toEntity(req);
            newKlant = repository.save(newKlant);
        } catch (Exception e){
            throw new KlantException();
        }
        return mapper.toResponse(newKlant);
    }

    public KlantResponse deleteKlant(DeleteKlant req) throws KlantException{
        KlantEntity Klant=null;
        try{
            Klant=mapper.toEntity(req);
            repository.delete(Klant);
        } catch (Exception e){
            throw new KlantException(e);
        }
        return mapper.toResponse(Klant);
    }
}

