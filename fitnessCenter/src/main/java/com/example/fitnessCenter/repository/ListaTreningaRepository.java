package com.example.fitnessCenter.repository;

import com.example.fitnessCenter.entity.ListaTreninga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaTreningaRepository extends JpaRepository<ListaTreninga,Long> {
}
