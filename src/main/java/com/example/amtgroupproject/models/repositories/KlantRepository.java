package com.example.amtgroupproject.models.repositories;

import com.example.amtgroupproject.models.entities.KlantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KlantRepository extends JpaRepository<KlantEntity, Long> {
}
