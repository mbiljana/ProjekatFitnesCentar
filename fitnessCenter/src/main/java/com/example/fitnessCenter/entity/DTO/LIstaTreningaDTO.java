package com.example.fitnessCenter.entity.DTO;

import com.example.fitnessCenter.entity.FitnessCentar;
import com.example.fitnessCenter.entity.Sala;
import com.example.fitnessCenter.entity.Trening;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class LIstaTreningaDTO implements Serializable {

    private int brojPrijavljenih;
    private double cena;
    private Date datumPocetkaTreninga;
    private Date datumKrajaTreninga;
    private Set<Sala> sale = new HashSet<>();
    private Set<Trening> trening = new HashSet<>();
    private FitnessCentar fitnessCentar;

    public LIstaTreningaDTO(int brojPrijavljenih, double cena, Date datumPocetkaTreninga, Date datumKrajaTreninga, Set<Sala> sale, Set<Trening> trening, FitnessCentar fitnessCentar) {
        this.brojPrijavljenih = brojPrijavljenih;
        this.cena = cena;
        this.datumPocetkaTreninga = datumPocetkaTreninga;
        this.datumKrajaTreninga = datumKrajaTreninga;
        this.sale = sale;
        this.trening = trening;
        this.fitnessCentar = fitnessCentar;
    }

    public LIstaTreningaDTO() {
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
