package com.example.fitnessCenter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class ListaTreninga implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //inkrementalno generisanje kljuceva prilikom cuvanja u bazi
    private Long id;

    @Column
    private int brojPrijavljenih;
    @Column(nullable = false)
    private double cena;
    @Column(nullable = false)
    private Date datumPocetkaTreninga;
    @Column
    private Date datumKrajaTreninga;

    @ManyToMany(mappedBy = "listaTreningaTerminska")
    private Set<Sala> sale = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "treninzi",
            joinColumns = @JoinColumn(name = "raspored_treninga_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "trening_id",referencedColumnName = "id")
    )
    private Set<Trening> trening = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private FitnessCentar fitnessCentar;












}
