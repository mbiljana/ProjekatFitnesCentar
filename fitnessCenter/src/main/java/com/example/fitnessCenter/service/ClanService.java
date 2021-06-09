package com.example.fitnessCenter.service;

import com.example.fitnessCenter.entity.Clan;

import java.util.List;

public interface ClanService {
    Clan findByKorisnickoIme(String korisnickoIme);
    Clan findByKorisnickoImeAndLozinka(String korisnickoIme, String lozinka);
    Clan findByKorisnickoImeAndLozinkaAndAktivan(String korisnickoIme, String lozinka, boolean aktivan);
    Clan save (Clan clan) throws Exception;
    void delete(Long id);
    List<Clan> findAll();
    Clan findOne(Long id);
}
