package com.example.fitnessCenter.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
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

    public ListaTreninga() {
    }

    @ManyToOne(fetch = FetchType.EAGER)
    private FitnessCentar fitnessCentar;

    public ListaTreninga(Long id, int brojPrijavljenih, double cena, Date datumPocetkaTreninga, Date datumKrajaTreninga, Set<Sala> sale, Set<Trening> trening, FitnessCentar fitnessCentar) {
        this.id = id;
        this.brojPrijavljenih = brojPrijavljenih;
        this.cena = cena;
        this.datumPocetkaTreninga = datumPocetkaTreninga;
        this.datumKrajaTreninga = datumKrajaTreninga;
        this.sale = sale;
        this.trening = trening;
        this.fitnessCentar = fitnessCentar;
    }

    public ListaTreninga(Long id, int brojPrijavljenih, double cena, Date datumPocetkaTreninga, Date datumKrajaTreninga) {
        this.id = id;
        this.brojPrijavljenih = brojPrijavljenih;
        this.cena = cena;
        this.datumPocetkaTreninga = datumPocetkaTreninga;
        this.datumKrajaTreninga = datumKrajaTreninga;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBrojPrijavljenih() {
        return brojPrijavljenih;
    }

    public void setBrojPrijavljenih(int brojPrijavljenih) {
        this.brojPrijavljenih = brojPrijavljenih;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Date getDatumPocetkaTreninga() {
        return datumPocetkaTreninga;
    }

    public void setDatumPocetkaTreninga(Date datumPocetkaTreninga) {
        this.datumPocetkaTreninga = datumPocetkaTreninga;
    }

    public Date getDatumKrajaTreninga() {
        return datumKrajaTreninga;
    }

    public void setDatumKrajaTreninga(Date datumKrajaTreninga) {
        this.datumKrajaTreninga = datumKrajaTreninga;
    }

    public Set<Sala> getSale() {
        return sale;
    }

    public void setSale(Set<Sala> sale) {
        this.sale = sale;
    }

    public Set<Trening> getTrening() {
        return trening;
    }

    public void setTrening(Set<Trening> trening) {
        this.trening = trening;
    }

    public FitnessCentar getFitnessCentar() {
        return fitnessCentar;
    }

    public void setFitnessCentar(FitnessCentar fitnessCentar) {
        this.fitnessCentar = fitnessCentar;
    }
}
