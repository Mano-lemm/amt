package com.example.amtgroupproject.models.repositories;

import com.example.amtgroupproject.models.entities.TransactieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactieRepository extends JpaRepository<TransactieEntity, Long> {
}
