package com.example.fitnessCenter.service;

import com.example.fitnessCenter.entity.RasporedTreninga;

import java.util.List;

public interface RasporedTreningaService {

    RasporedTreninga save(RasporedTreninga trening) throws Exception;
    RasporedTreninga update(RasporedTreninga trening) throws Exception;
    void delete(Long id);
    RasporedTreninga findOne(Long id);
    List<RasporedTreninga> findAll();
}
