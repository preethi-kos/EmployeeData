package com.example.Repository;

import com.example.Entity.LoginInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogonRepository extends JpaRepository<LoginInfoEntity,Integer> {
}
