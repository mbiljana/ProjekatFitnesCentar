package com.example.fitnessCenter.entity.DTO;

import com.example.fitnessCenter.entity.ListaTreninga;
import com.example.fitnessCenter.entity.Sala;
import com.example.fitnessCenter.entity.Trener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class FitnessCentarDTO implements Serializable {
    private Long id;
    private String nazivCentra;
    private String adresaCentra;
    private String brojTelefonaCentrale;
    private String emailCentra;
    private Set<Trener> treneri = new HashSet<>();
    private Set<Sala> sale = new HashSet<>();
    private Set<ListaTreninga> rasporediTreninga = new HashSet<>();

    public FitnessCentarDTO(Long id, String nazivCentra, String adresaCentra, String brojTelefonaCentrale, String emailCentra, Set<Trener> treneri, Set<Sala> sale, Set<ListaTreninga> rasporediTreninga) {
        this.id = id;
        this.nazivCentra = nazivCentra;
        this.adresaCentra = adresaCentra;
        this.brojTelefonaCentrale = brojTelefonaCentrale;
        this.emailCentra = emailCentra;
        this.treneri = treneri;
        this.sale = sale;
        this.rasporediTreninga = rasporediTreninga;
    }

    public FitnessCentarDTO(Long id, String nazivCentra, String adresaCentra, String brojTelefonaCentrale, String emailCentra) {
        this.id = id;
        this.nazivCentra = nazivCentra;
        this.adresaCentra = adresaCentra;
        this.brojTelefonaCentrale = brojTelefonaCentrale;
        this.emailCentra = emailCentra;
    }

    public FitnessCentarDTO(String nazivCentra, String adresaCentra, String brojTelefonaCentrale, String emailCentra) {
        this.nazivCentra = nazivCentra;
        this.adresaCentra = adresaCentra;
        this.brojTelefonaCentrale = brojTelefonaCentrale;
        this.emailCentra = emailCentra;
    }

    public FitnessCentarDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazivCentra() {
        return nazivCentra;
    }

    public void setNazivCentra(String nazivCentra) {
        this.nazivCentra = nazivCentra;
    }

    public String getAdresaCentra() {
        return adresaCentra;
    }

    public void setAdresaCentra(String adresaCentra) {
        this.adresaCentra = adresaCentra;
    }

    public String getBrojTelefonaCentrale() {
        return brojTelefonaCentrale;
    }

    public void setBrojTelefonaCentrale(String brojTelefonaCentrale) {
        this.brojTelefonaCentrale = brojTelefonaCentrale;
    }

    public String getEmailCentra() {
        return emailCentra;
    }

    public void setEmailCentra(String emailCentra) {
        this.emailCentra = emailCentra;
    }

    public Set<Trener> getTreneri() {
        return treneri;
    }

    public void setTreneri(Set<Trener> treneri) {
        this.treneri = treneri;
    }

    public Set<Sala> getSale() {
        return sale;
    }

    public void setSale(Set<Sala> sale) {
        this.sale = sale;
    }

    public Set<ListaTreninga> getRasporediTreninga() {
        return rasporediTreninga;
    }

    public void setRasporediTreninga(Set<ListaTreninga> rasporediTreninga) {
        this.rasporediTreninga = rasporediTreninga;
    }
}
