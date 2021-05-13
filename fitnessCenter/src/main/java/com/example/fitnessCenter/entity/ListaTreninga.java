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
    private int brojPrijavljenih;

    @ManyToMany(mappedBy = "listaTreninga")
    private Set<Sala> sale = new HashSet<>();

    @ManyToMany(mappedBy = "listaTreninga")
    private Set<RasporedTreninga> rasporediTreninga = new HashSet<>();






}
