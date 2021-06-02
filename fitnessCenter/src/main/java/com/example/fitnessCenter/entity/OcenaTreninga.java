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
public class OcenaTreninga implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //inkrementalno generisanje kljuceva prilikom cuvanja u bazi
    private Long id;
    @Column
    private double ocena;
    @ManyToOne(fetch = FetchType.EAGER)
    private Trening trening;

    @ManyToMany(mappedBy = "ocene")
    private Set<Clan> clanovi = new HashSet<>();

    public OcenaTreninga() {
    }

}
