package com.example.fitnessCenter.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Trener extends Korisnik {

    @Column
    private double prosecnaOcena;


    @OneToMany(mappedBy = "trener", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Trening> listaTreninga = new HashSet<Trening>();

    @ManyToOne(fetch = FetchType.EAGER)
    private FitnessCentar fitnessCentar;

    public Trener() {
    }

    public Trener(String korisnickoIme, String lozinka, String ime, String prezime, String telefon, String email, Date datumRodjenja, Uloga uloga, Boolean aktivan) {
        super(korisnickoIme, lozinka, ime, prezime, telefon, email, datumRodjenja, uloga, aktivan);
    }

    public Trener(String korisnickoIme, String lozinka, String ime, String prezime, String telefon, String email, Date datumRodjenja, Uloga uloga, Boolean aktivan, double prosecnaOcena, Set<Trening> listaTreninga, FitnessCentar fitnessCentar) {
        super(korisnickoIme, lozinka, ime, prezime, telefon, email, datumRodjenja, uloga, aktivan);
        this.prosecnaOcena = prosecnaOcena;
        this.listaTreninga = listaTreninga;
        this.fitnessCentar = fitnessCentar;
    }
}
