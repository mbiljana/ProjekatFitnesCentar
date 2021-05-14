package com.example.fitnessCenter.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Trening implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //inkrementalno generisanje kljuceva prilikom cuvanja u bazi
    private Long id;
    @Column(nullable = false)
    private String naziv;
    @Column
    private String opis;
    @Column(nullable = false)
    private TipTreninga tipTreninga;
    @Column(nullable = false)
    private String trajanje;

    @OneToMany(mappedBy = "trening", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<OcenaTreninga> oceneTreninga = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Trener> treneri = new HashSet<>();

    @ManyToMany(mappedBy = "treninzi")
    private Set<Clan> odradiliTrening= new HashSet<>();

    @ManyToMany(mappedBy = "prijavljeniTreninzi")
    private Set<Clan> prijavljeniClanovi = new HashSet<>();

    @ManyToMany(mappedBy = "trening")
    private Set<RasporedTreninga> rasporediTreninga = new HashSet<>();

    public Trening() {
    }


}
