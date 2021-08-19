package com.example.fitnessCenter.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

@Entity
public class Sala implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //inkrementalno generisanje kljuceva prilikom cuvanja u bazi
    private Long id;
    @Column(nullable = false)
    private String oznaka;
    @Column(nullable = false)
    private int kapacitet;

    /*@ManyToMany
    @JoinTable(name = "termini",
                joinColumns = @JoinColumn(name = "sala_id",referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "termin_id",referencedColumnName = "id")
    )
    private Set<ListaTreninga>listaTreningaTerminska = new HashSet<>(); */

   /* @ManyToOne(fetch = FetchType.EAGER)
    private FitnessCentar fitnessCentar; */
    @OneToMany(mappedBy = "sala", fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<ListaTreninga> listaTreninga = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private FitnessCentar fitnessCentar;


    public Sala() {
    }
}
