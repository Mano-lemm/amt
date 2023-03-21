package com.example.amtgroupproject.models.repositories;

import com.example.amtgroupproject.models.entities.ATMEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ATMRepository extends JpaRepository<ATMEntity, Long> {
}
