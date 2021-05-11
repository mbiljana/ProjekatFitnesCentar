package com.example.fitnessCenter.entity;

import javax.persistence.*;
import java.io.Serializable;

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

    public FitnessCentar() {
    }
}
