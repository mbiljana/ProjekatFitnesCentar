package com.example.fitnessCenter.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class RasporedTreninga implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //inkrementalno generisanje kljuceva prilikom cuvanja u bazi
    private Long id;
    @Column
    private double cena;
    @Column
    private Date datumPocetkaTreninga;
    @Column
    private Date datumKrajaTreninga;
    @Column
    private double cenaTreninga;

    @ManyToOne(fetch = FetchType.EAGER)
    private FitnessCentar fitnessCentar;


}
