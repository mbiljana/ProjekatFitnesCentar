package com.example.fitnessCenter.entity.DTO;

import com.example.fitnessCenter.entity.Uloga;

import java.util.Date;

public class PrijavljenKorisnikDTO {
    private Long id;
    private String korisnickoIme;
    private String ime;
    private String prezime;
    private String lozinka;
    private String telefon;
    private String email;
    private Date datumRodjenja;
    private boolean aktivan;

    private Uloga uloga;

    public PrijavljenKorisnikDTO(Long id, String korisnickoIme, String ime, String prezime, String lozinka, String telefon, String email, Date datumRodjenja, boolean aktivan, Uloga uloga) {
        this.id = id;
        this.korisnickoIme = korisnickoIme;
        this.ime = ime;
        this.prezime = prezime;
        this.lozinka = lozinka;
        this.telefon = telefon;
        this.email = email;
        this.datumRodjenja = datumRodjenja;
        this.aktivan = aktivan;
        this.uloga = uloga;
    }

    public PrijavljenKorisnikDTO(String korisnickoIme, String ime, String prezime, String lozinka, String telefon, String email, Date datumRodjenja, boolean aktivan, Uloga uloga) {
        this.korisnickoIme = korisnickoIme;
        this.ime = ime;
        this.prezime = prezime;
        this.lozinka = lozinka;
        this.telefon = telefon;
        this.email = email;
        this.datumRodjenja = datumRodjenja;
        this.aktivan = aktivan;
        this.uloga = uloga;
    }

    public PrijavljenKorisnikDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public boolean isAktivan() {
        return aktivan;
    }

    public void setAktivan(boolean aktivan) {
        this.aktivan = aktivan;
    }

    public Uloga getUloga() {
        return uloga;
    }

    public void setUloga(Uloga uloga) {
        this.uloga = uloga;
    }
}
