package com.example.fitnessCenter.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

@Entity
public class Trener extends Korisnik {

    @Column
    private double prosecnaOcena;

    @ManyToMany(mappedBy = "treneri",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Trening> treninziKojeDrzi = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private FitnessCentar fitnessCentar;

    public Trener() {
    }
}
