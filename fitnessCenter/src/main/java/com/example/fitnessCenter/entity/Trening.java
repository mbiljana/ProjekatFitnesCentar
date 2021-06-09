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
    /*
    @Column(name = "TIPTRENINGA" ,nullable = false)
    private TipTreninga tipTreninga;
     */
    @Column(name = "TIPTRENINGA",nullable = false)
    private String tipTreninga;
    @Column(nullable = false)
    private String trajanje;

    @OneToMany(mappedBy = "trening", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<OcenaTreninga> oceneTreninga = new HashSet<>();



    @ManyToOne(fetch = FetchType.EAGER)
    private Trener trener;

    @ManyToMany(mappedBy = "treninzi")
    private Set<Clan> odradiliTrening= new HashSet<>();

    @ManyToMany(mappedBy = "prijavljeniTreninzi")
    private Set<Clan> prijavljeniClanovi = new HashSet<>();

    @ManyToMany(mappedBy = "trening")
    private Set<ListaTreninga> rasporediTreninga = new HashSet<>();

    public Trening() {
    }

    public Trening(Long id, String naziv, String opis, String tipTreninga, String trajanje) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.tipTreninga = tipTreninga;
        this.trajanje = trajanje;
    }

    public Trening(Long id, String naziv, String opis, String tipTreninga, String trajanje, Trener trener) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.tipTreninga = tipTreninga;
        this.trajanje = trajanje;
        this.trener = trener;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getTipTreninga() {
        return tipTreninga;
    }

    public void setTipTreninga(String tipTreninga) {
        this.tipTreninga = tipTreninga;
    }

    public String getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(String trajanje) {
        this.trajanje = trajanje;
    }

    public Trener getTrener() {
        return trener;
    }

    public void setTrener(Trener trener) {
        this.trener = trener;
    }
}
