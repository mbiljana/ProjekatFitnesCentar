package com.example.fitnessCenter.repository;

import com.example.fitnessCenter.entity.Trener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrenerRepository extends JpaRepository<Trener,Long> {
}
