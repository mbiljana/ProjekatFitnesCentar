package com.example.fitnessCenter.entity;


import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Administrator extends Korisnik{
    public Administrator() {
    }

    public Administrator(String korisnickoIme, String lozinka, String ime, String prezime, String telefon, String email, Date datumRodjenja, Uloga uloga, Boolean aktivan) {
        super(korisnickoIme, lozinka, ime, prezime, telefon, email, datumRodjenja, uloga, aktivan);
    }

    public Administrator(Long id, String korisnickoIme, String lozinka, String ime, String prezime, String telefon, String email, Date datumRodjenja, Uloga uloga, Boolean aktivan, boolean daLiJeRegistrovan) {
        super(id, korisnickoIme, lozinka, ime, prezime, telefon, email, datumRodjenja, uloga, aktivan, daLiJeRegistrovan);
    }

}
