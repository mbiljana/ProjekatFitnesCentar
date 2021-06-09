package com.example.fitnessCenter.service;

import com.example.fitnessCenter.entity.Trener;

import java.util.List;

public interface TrenerService {
    Trener save(Trener trener) throws Exception;
    void delete(Long id);
    Trener findByKorisnickoImeAndLozinka(String korisnicko,String lozinka);
    Trener findOne(Long id);
    List<Trener> findAll();
}
