package com.example.fitnessCenter.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Clan extends Korisnik{

    @ManyToMany
    @JoinTable(name = "odradjeniTreninzi",
                joinColumns = @JoinColumn(name="clan_id",referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "trening_id",referencedColumnName = "id")
    )
    private Set<ListaTreninga> odradjeniTreninzi = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "prijavljeniTreninzi",
            joinColumns = @JoinColumn(name="clan_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "trening_id",referencedColumnName = "id")
    )
    private Set<Trening> prijavljeniTreninzi = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "ocenjeniTreninzi",
            joinColumns = @JoinColumn(name="clan_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ocena_treninga_id",referencedColumnName = "id")
    )
    private Set<OcenaTreninga> ocene = new HashSet<>();

    public Set<ListaTreninga> getOdradjeniTreninzi() {
        return odradjeniTreninzi;
    }

    public void setOdradjeniTreninzi(Set<ListaTreninga> odradjeniTreninzi) {
        this.odradjeniTreninzi = odradjeniTreninzi;
    }

    public Set<Trening> getPrijavljeniTreninzi() {
        return prijavljeniTreninzi;
    }

    public void setPrijavljeniTreninzi(Set<Trening> prijavljeniTreninzi) {
        this.prijavljeniTreninzi = prijavljeniTreninzi;
    }

    public Set<OcenaTreninga> getOceneTreninga() {
        return ocene;
    }

    public void setOceneTreninga(Set<OcenaTreninga> ocene) {
        this.ocene = ocene;
    }

    public Clan() {

    }
}
