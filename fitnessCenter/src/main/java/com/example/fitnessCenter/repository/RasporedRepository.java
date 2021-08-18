package com.example.fitnessCenter.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.fitnessCenter.entity.RasporedTreninga;

import java.util.Date;
import java.util.List;

public interface RasporedRepository extends JpaRepository<RasporedTreninga,Long>{


    List<RasporedTreninga> findByDatumPocetkaTreninga(Date pocetak);
    List<RasporedTreninga> findByDatumKrajaTreninga(Date kraj);
    List<RasporedTreninga> findByCena(double cena);

}
