package com.example.fitnessCenter.repository;

import com.example.fitnessCenter.entity.Trening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreningRepository extends JpaRepository<Trening,Long> {

}
