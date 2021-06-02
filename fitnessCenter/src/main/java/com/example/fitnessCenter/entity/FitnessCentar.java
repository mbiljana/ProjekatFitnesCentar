package com.example.fitnessCenter.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

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

    @OneToMany(mappedBy = "fitnessCentar",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Trener> treneri = new HashSet<>();

    @OneToMany(mappedBy = "fitnessCentar",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Sala> sale = new HashSet<>();

    @OneToMany(mappedBy = "fitnessCentar",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<RasporedTreninga> rasporediTreninga = new HashSet<>();

    public FitnessCentar() {
    }
}
