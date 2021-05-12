package com.example.fitnessCenter.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class OcenaTreninga implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //inkrementalno generisanje kljuceva prilikom cuvanja u bazi
    private Long id;
    @Column
    private double ocena;

    public OcenaTreninga() {
    }
}
