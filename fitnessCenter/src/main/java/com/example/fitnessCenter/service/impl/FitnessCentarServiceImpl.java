package com.example.fitnessCenter.service;

import com.example.fitnessCenter.entity.FitnessCentar;
import com.example.fitnessCenter.repository.FitnessCentarRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class FitnessCentarServiceImpl implements FitnessCentarService {
    @Autowired
    private FitnessCentarRepository fitnessCentarRepository;

    @Override
    public FitnessCentar findByNazivCentra(String naziv) {
        return fitnessCentarRepository.findByNazivCentra(naziv);
    }

    @Override
    public void delete(Long id) {
        fitnessCentarRepository.deleteById(id);
    }

    @Override
    public FitnessCentar save(FitnessCentar fitnessCentar) {
        return this.fitnessCentarRepository.save(fitnessCentar);
    }
}
