package com.example.fitnessCenter.repository;

import com.example.fitnessCenter.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AministratorRepository extends JpaRepository<Administrator,Long> {
}
