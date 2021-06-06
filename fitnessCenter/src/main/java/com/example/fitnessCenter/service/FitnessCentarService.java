package com.example.fitnessCenter.service;

import com.example.fitnessCenter.entity.FitnessCentar;

public interface FitnessCentarService {
    FitnessCentar findByNazivCentra(String naziv);
    void delete(Long id);
    FitnessCentar save(FitnessCentar fitnessCentar);
}
