package com.example.fitnessCenter.repository;

import com.example.fitnessCenter.entity.Clan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClanRepository extends JpaRepository<Clan,Long> {

    Clan findByKorisnickoIme(String korisnickoIme);
    Clan findByKorisnickoImeAndLozinka(String korisnickoIme, String lozinka);
    Clan findByKorisnickoImeAndLozinkaAndAktivan(String korisnickoIme, String lozinka, boolean aktivan);

}
