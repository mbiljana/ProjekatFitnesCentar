package com.example.fitnessCenter.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Clan extends Korisnik{

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<ListaTreninga> odradjeniTreninzi = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<ListaTreninga> prijavljeniTreninzi = new HashSet<>();



    public Clan() {

    }
}
