package com.example.fitnessCenter.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/*@Getter
@Setter
@AllArgsConstructor */

@Entity
public class Trening implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //inkrementalno generisanje kljuceva prilikom cuvanja u bazi
    private Long id;
    @Column(nullable = false)
    private String naziv;
    @Column
    private String opis;
    @Column(name = "TIPTRENINGA" ,nullable = false)
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
    private Set<ListaTreninga> rasporediTreninga = new HashSet<>();

    public Trening() {
    }

    public Trening(Long id, String naziv, String opis, TipTreninga tipTreninga, String trajanje) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.tipTreninga = tipTreninga;
        this.trajanje = trajanje;
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

    public TipTreninga getTipTreninga() {
        return tipTreninga;
    }

    public void setTipTreninga(TipTreninga tipTreninga) {
        this.tipTreninga = tipTreninga;
    }

    public String getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(String trajanje) {
        this.trajanje = trajanje;
    }
}
