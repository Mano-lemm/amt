package com.example.amtgroupproject.models.repositories;

import com.example.amtgroupproject.models.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
}
