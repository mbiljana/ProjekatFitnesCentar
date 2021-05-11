package com.example.fitnessCenter.repository;

import com.example.fitnessCenter.entity.FitnessCentar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FitnessCentarRepository extends JpaRepository<FitnessCentar,Long> {
}
