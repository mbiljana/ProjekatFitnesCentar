package com.example.fitnessCenter.entity.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OdobriRegistracijuDTO {
    private String ime;
    private String prezime;
    private String email;
    private String telefon;
    private boolean aktivan;

    public OdobriRegistracijuDTO() {
    }

    public OdobriRegistracijuDTO(String ime, String prezime, String email, String telefon, boolean aktivan) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.telefon = telefon;
        this.aktivan = aktivan;
    }
}
