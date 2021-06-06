package com.example.fitnessCenter.entity.DTO;

import java.io.Serializable;

public class PrijavaKorisnikaDTO implements Serializable {

    private String korisnickoIme;
    private String loznika;


    public PrijavaKorisnikaDTO(String korisnickoIme, String loznika) {
        this.korisnickoIme = korisnickoIme;
        this.loznika = loznika;
    }

    public PrijavaKorisnikaDTO() {
    }

    @Override
    public String toString() {
        return "PrijavaKorisnikaDTO{" +
                "korisnickoIme='" + korisnickoIme + '\'' +
                ", loznika='" + loznika + '\'' +
                '}';
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLoznika() {
        return loznika;
    }

    public void setLoznika(String loznika) {
        this.loznika = loznika;
    }
}
