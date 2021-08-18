package com.example.fitnessCenter.repository;

import com.example.fitnessCenter.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaRepository extends JpaRepository<Sala,Long> {

    List<Sala> findAll();
    void deleteById(Long id);

}
