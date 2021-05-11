package com.example.fitnessCenter.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Trener extends Korisnik {

    @Column
    private double prosecnaOcena;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<ListaTreninga> treninziKojeDrzi = new HashSet<>();

    public Trener() {
    }
}
