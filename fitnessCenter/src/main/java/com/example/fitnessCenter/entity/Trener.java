package com.example.fitnessCenter.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Trener extends Korisnik {

    @Column
    private double prosecnaOcena;

    @OneToMany(mappedBy = "trener",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Trening> treninziKojeDrzi = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private FitnessCentar fitnessCentar;

    public Trener() {
    }
}
