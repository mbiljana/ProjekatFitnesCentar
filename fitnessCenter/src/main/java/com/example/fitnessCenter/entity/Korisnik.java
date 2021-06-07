package com.example.fitnessCenter.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@MappedSuperclass
public class Korisnik implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //inkrementalno generisanje kljuceva prilikom cuvanja u bazi
    private Long id;
    @Column(name = "KORISNICKOIME",nullable = false)
    private String korisnickoIme;
    @Column(nullable = false)
    private String lozinka;
    @Column
    private String ime;
    @Column
    private String prezime;
    @Column
    private String telefon;
    @Column
    private String email;
    @Column(name = "DATUMRODJENJA")
    private Date datumRodjenja;
    @Column(nullable = false)
    private Uloga uloga;
    @Column(nullable = false)
    private Boolean aktivan;

    public Korisnik() {
    }

    public Long getId() {
        return id;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getEmail() {
        return email;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public Uloga getUloga() {
        return uloga;
    }

    public Boolean getAktivan() {
        return aktivan;
    }
}
