package com.example.amtgroupproject.models.repositories;

import com.example.amtgroupproject.models.entities.BankEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<BankEntity, Long> {
}
