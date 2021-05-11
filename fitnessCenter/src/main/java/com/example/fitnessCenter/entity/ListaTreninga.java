package com.example.fitnessCenter.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ListaTreninga implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //inkrementalno generisanje kljuceva prilikom cuvanja u bazi
    private Long id;
    @Column
    private Date datumTreninga;
    @Column
    private double cenaTreninga;
    @Column
    private int brojPrijavljenih;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Trening trening;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Clan> clanoviTreninga = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Sala> saleTreninga = new HashSet<>();



}
