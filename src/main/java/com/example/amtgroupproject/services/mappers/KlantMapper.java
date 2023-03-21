package com.example.amtgroupproject.services.mappers;

import com.example.amtgroupproject.models.dto.CreateKlant;
import com.example.amtgroupproject.models.dto.KlantResponse;
import com.example.amtgroupproject.models.entities.KlantEntity;
import org.springframework.stereotype.Component;

@Component
public class KlantMapper {
    public KlantResponse toResponse(KlantEntity entity){
        return new KlantResponse(entity.getId());
    }

    public KlantEntity toEntity(CreateKlant req){
        return new KlantEntity(req.getName());
    }
}
