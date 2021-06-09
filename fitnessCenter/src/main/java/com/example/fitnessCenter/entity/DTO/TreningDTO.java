package com.example.fitnessCenter.entity.DTO;

import com.example.fitnessCenter.entity.TipTreninga;

import java.io.Serializable;

public class TreningDTO implements Serializable {
    private Long id;
    private String naziv;
    private String opis;
    private TipTreninga tip;
    private String trajanje;

    public TreningDTO(Long id, String naziv, String opis, TipTreninga tip, String trajanje) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.tip = tip;
        this.trajanje = trajanje;
    }

    public TreningDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public TipTreninga getTip() {
        return tip;
    }

    public void setTip(TipTreninga tip) {
        this.tip = tip;
    }

    public String getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(String trajanje) {
        this.trajanje = trajanje;
    }

    public TreningDTO(String naziv, String opis, TipTreninga tip, String trajanje) {
        this.naziv = naziv;
        this.opis = opis;
        this.tip = tip;
        this.trajanje = trajanje;
    }
}
