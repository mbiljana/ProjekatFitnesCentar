package com.example.fitnessCenter.service.impl;

import com.example.fitnessCenter.entity.ListaTreninga;
import com.example.fitnessCenter.entity.Sala;
import com.example.fitnessCenter.repository.RasporedRepository;
import com.example.fitnessCenter.repository.SalaRepository;
import com.example.fitnessCenter.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaServiceImpl implements SalaService {
    private final SalaRepository salaRepository;
    @Autowired
    public SalaServiceImpl(SalaRepository salaRepository){this.salaRepository = salaRepository;}

    @Override
    public Sala findOne(Long id){
        Sala sala = this.salaRepository.findById(id).get();
        return sala;
    }



}
