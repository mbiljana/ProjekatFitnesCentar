package com.example.fitnessCenter.repository;

import com.example.fitnessCenter.entity.FitnessCentar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FitnessCentarRepository extends JpaRepository<FitnessCentar,Long> {

    FitnessCentar findByNazivCentra(String naziv);


}
