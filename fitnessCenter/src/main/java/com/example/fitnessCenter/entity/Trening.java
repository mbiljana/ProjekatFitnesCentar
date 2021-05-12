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
    private String nazivTreninga;
    @Column
    private String opisTreninga;
    @Column
    private TipTreninga tipTreninga;
    @Column(nullable = false)
    private String trajanje;

    @OneToMany
    private Set<ListaTreninga> treninzi = new HashSet<>();

    public Trening() {
    }


}
