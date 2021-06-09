package com.example.fitnessCenter.service;

import com.example.fitnessCenter.entity.FitnessCentar;

import java.util.List;

public interface FitnessCentarService {
    FitnessCentar findByNazivCentra(String naziv);
    void delete(Long id);
    FitnessCentar save(FitnessCentar fitnessCentar);
    FitnessCentar findOne(Long id);
    List<FitnessCentar> findAll();
}
