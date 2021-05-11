package com.example.fitnessCenter.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Sala implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //inkrementalno generisanje kljuceva prilikom cuvanja u bazi
    private Long id;
    @Column(nullable = false)
    private String oznakaSale;
    @Column(nullable = false)
    private int kapacitetSale;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<ListaTreninga> terminskaListaTreninga = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<ListaTreninga> treninzi = new HashSet<>();

    public Sala() {
    }
}
