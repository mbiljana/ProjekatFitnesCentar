package com.example.fitnessCenter.service;

import com.example.fitnessCenter.entity.Administrator;

import java.util.List;

public interface AdministratorService {
    Administrator save(Administrator admin) throws Exception;
    void delete(Long id);
    Administrator findByKorisnickoImeAndLozinka(String korisnicko,String lozinka);
    Administrator findOne(Long id);
    List<Administrator> findAll();
}
