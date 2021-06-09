package com.example.fitnessCenter.service.impl;

import com.example.fitnessCenter.entity.FitnessCentar;
import com.example.fitnessCenter.repository.FitnessCentarRepository;
import com.example.fitnessCenter.service.FitnessCentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    @Override
    public FitnessCentar findOne(Long id) {
        return fitnessCentarRepository.getOne(id);
    }

    @Override
    public List<FitnessCentar> findAll() {
        return fitnessCentarRepository.findAll();
    }
}
