package com.example.fitnessCenter.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

//@Entity
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


}
