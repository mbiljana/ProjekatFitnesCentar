package com.example.fitnessCenter.contoller;

import com.example.fitnessCenter.entity.DTO.KorisnikDTO;
import com.example.fitnessCenter.entity.DTO.PrijavaKorisnikaDTO;
import com.example.fitnessCenter.entity.Korisnik;
import com.example.fitnessCenter.service.KorisnikService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KorisnikController {


    private KorisnikService korisnikService;

   /* @PostMapping(
            value="/login",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<KorisnikDTO> login(@RequestBody PrijavaKorisnikaDTO prijavaKorisnikaDTO)throws Exception{
        Korisnik korisnik=this.korisnikService.loginProvera(prijavaKorisnikaDTO);
        if(korisnik==null){
            throw new Exception("Greska");
        }
        if(korisnik.getAktivan()==false){
            throw new Exception("Korisnik nije aktivan"); //korisnik mora da bude aktivan
        }
        KorisnikDTO korisnikDTO= new KorisnikDTO(korisnik.getId(),korisnik.getIme(),
                korisnik.getPrezime(),korisnik.getKorisnickoIme(),korisnik.getLozinka(),korisnik.getTelefon(),
                korisnik.getEmail(),korisnik.getDatumRodjenja(),korisnik.getUloga(),true);
        return new ResponseEntity<>(korisnikDTO, HttpStatus.OK);
    } */
}
