package com.example.fitnessCenter.service;

import com.example.fitnessCenter.entity.DTO.PrijavaKorisnikaDTO;
import com.example.fitnessCenter.entity.Korisnik;
import com.example.fitnessCenter.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class KorisnikServiceImpl implements KorisnikService{

    /*
    @Autowired
private KorisnikRepository korisnikRepository;

    @Override
    public Korisnik findByKorisnickoIme(String korisnicko) {
        Korisnik korisnik = this.korisnikRepository.findByKorisnickoIme(korisnicko);
        return  korisnik;
    }

    @Override
    public Korisnik save(Korisnik korisnik) {
        return this.korisnikRepository.save(korisnik);
    }

    @Override
    public List<Korisnik> findAll() {
        List<Korisnik> korisnici = this.korisnikRepository.findAll();
        return korisnici;
    }

    @Override
    public void delete(Long id) {
        this.korisnikRepository.deleteById(id);
    }

    @Override
    public Korisnik findByKorisnickoImeAndLozinka(String korisnicko, String lozinka) {
        Korisnik korisnik = this.korisnikRepository.findByKorisnickoImeAndLozinka(korisnicko,lozinka);
        return korisnik;
    }

    @Override
    public Korisnik loginProvera(PrijavaKorisnikaDTO korisnik) {
        Korisnik korisnik1 = this.korisnikRepository.findByKorisnickoImeAndLozinka(korisnik.getKorisnickoIme(),korisnik.getLoznika());
        return korisnik1;
    }
*/


}
