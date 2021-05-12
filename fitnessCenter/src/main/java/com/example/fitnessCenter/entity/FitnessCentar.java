package com.example.fitnessCenter.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class FitnessCentar implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //inkrementalno generisanje kljuceva prilikom cuvanja u bazi
    private Long id;
    @Column(nullable = false)
    private String nazivCentra;
    @Column(nullable = false)
    private String adresaCentra;
    @Column
    private String brojTelefonaCentrale;
    @Column
    private String emailCentra;

    @OneToMany
    private List<Trener> treneri = new ArrayList<>();

    @OneToMany
    private List<Sala> sale = new ArrayList<>();

    public FitnessCentar() {
    }
}
