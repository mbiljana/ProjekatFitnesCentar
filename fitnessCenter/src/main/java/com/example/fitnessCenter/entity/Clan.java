package com.example.fitnessCenter.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Clan extends Korisnik{

    @ManyToMany
    @JoinTable(name = "odradjeniTreninzi",
                joinColumns = @JoinColumn(name="clan_id",referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "trening_id",referencedColumnName = "id")
    )
    private Set<Trening> treninzi = new HashSet<>();

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

    public Set<Trening> getTreninzi() {
        return treninzi;
    }

    public void setTreninzi(Set<Trening> treninzi) {
        this.treninzi = treninzi;
    }

    public Set<Trening> getPrijavljeniTreninzi() {
        return prijavljeniTreninzi;
    }

    public void setPrijavljeniTreninzi(Set<Trening> prijavljeniTreninzi) {
        this.prijavljeniTreninzi = prijavljeniTreninzi;
    }

    public Set<OcenaTreninga> getOcene() {
        return ocene;
    }

    public void setOcene(Set<OcenaTreninga> ocene) {
        this.ocene = ocene;
    }


    public Clan() {

    }
    public Clan(String korisnickoIme, String lozinka, String ime, String prezime, String telefon, String email, Date datumRodjenja, Uloga uloga, Boolean aktivan,Boolean daLiJeRegistrovan){
        super();
    }

}
