package com.example.fitnessCenter.repository;

import com.example.fitnessCenter.entity.TipTreninga;
import com.example.fitnessCenter.entity.Trening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreningRepository extends JpaRepository<Trening,Long> {
    List<Trening> findByNaziv(String naziv);
    List<Trening> findByNazivOrderByNaziv (String naziv);
    List<Trening> findByOrderByNaziv();
    List<Trening> findByOrderByTipTreninga();
    List<Trening> findByTipTreninga(String tip);
    List<Trening> findByOrderByTrajanje();

}
