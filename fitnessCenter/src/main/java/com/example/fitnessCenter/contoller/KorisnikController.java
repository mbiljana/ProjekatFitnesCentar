package com.example.fitnessCenter.contoller;

import com.example.fitnessCenter.entity.Administrator;
import com.example.fitnessCenter.entity.Clan;
import com.example.fitnessCenter.entity.DTO.*;
import com.example.fitnessCenter.entity.Korisnik;
import com.example.fitnessCenter.entity.Trener;
import com.example.fitnessCenter.service.AdministratorService;
import com.example.fitnessCenter.service.ClanService;
import com.example.fitnessCenter.service.KorisnikService;
import com.example.fitnessCenter.service.TrenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/korisnik")
public class KorisnikController {
    @Autowired
    public ClanService clanService;
    @Autowired
    public AdministratorService administratorService;
    @Autowired
    public TrenerService trenerService;


    @PostMapping(value = ("/prijava"),consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PrijavljenKorisnikDTO> prijava(@RequestBody PrijavaKorisnikaDTO prijavaKorisnikaDTO) throws Exception{
        Clan clan = this.clanService.findByKorisnickoImeAndLozinka(prijavaKorisnikaDTO.getKorisnickoIme(),prijavaKorisnikaDTO.getLoznika());
        Administrator administrator = this.administratorService.findByKorisnickoImeAndLozinka(prijavaKorisnikaDTO.getKorisnickoIme(),prijavaKorisnikaDTO.getLoznika());
        Trener trener = this.trenerService.findByKorisnickoImeAndLozinka(prijavaKorisnikaDTO.getKorisnickoIme(),prijavaKorisnikaDTO.getLoznika());


        //dto objekat prijavljenog
        PrijavljenKorisnikDTO prijavljenDTO = new PrijavljenKorisnikDTO();

        if(clan != null){
            if((clan.getAktivan() == false) && (clan.getDaLiJeRegistrovan() == false)){
                throw  new Exception("Ovaj nalog je nepostojeci.");
            }
            prijavljenDTO = new PrijavljenKorisnikDTO(clan.getId(),clan.getKorisnickoIme(),clan.getIme(),clan.getPrezime(),"aaa",clan.getTelefon(),clan.getEmail(),clan.getDatumRodjenja(),clan.getAktivan(),clan.getUloga());
            return new ResponseEntity<>(prijavljenDTO,HttpStatus.OK);
        }else if(administrator != null){
            if((administrator.getAktivan() == false) && (administrator.getDaLiJeRegistrovan() == false)){
                throw  new Exception("Ovaj nalog je nepostojeci.");
            }
            prijavljenDTO = new PrijavljenKorisnikDTO(clan.getId(),clan.getKorisnickoIme(),clan.getIme(),clan.getPrezime(),"aaa",clan.getTelefon(),clan.getEmail(),clan.getDatumRodjenja(),clan.getAktivan(),clan.getUloga());
            return new ResponseEntity<>(prijavljenDTO,HttpStatus.OK);
        }else if(trener != null){
            if((trener.getAktivan() == false) && (trener.getDaLiJeRegistrovan() == false)){
                throw  new Exception("Ovaj nalog je nepostojeci.");
            }
            prijavljenDTO = new PrijavljenKorisnikDTO(clan.getId(),clan.getKorisnickoIme(),clan.getIme(),clan.getPrezime(),"aaa",clan.getTelefon(),clan.getEmail(),clan.getDatumRodjenja(),clan.getAktivan(),clan.getUloga());
            return new ResponseEntity<>(prijavljenDTO,HttpStatus.OK);
        }else{
            throw new Exception("Uneli ste pogresno korisnicko ime ili lozinku");
        }

    }


    @PostMapping(value="/registracija" ,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegistracijaKorisnikaDTO> registracija(@RequestBody RegistrovanjeDTO registrovanjeDTO) throws Exception {
        Clan korisnik = new Clan(registrovanjeDTO.getKorisnickoIme(),registrovanjeDTO.getLozinka(),registrovanjeDTO.getIme(),registrovanjeDTO.getPrezime(),registrovanjeDTO.getTelefon(),registrovanjeDTO.getEmail(),registrovanjeDTO.getDatumRodjenja(),registrovanjeDTO.getUloga());
        korisnik.setDaLiJeRegistrovan(false);
        korisnik.setAktivan(true);
        Clan noviKorisnik = this.clanService.save(korisnik);
        RegistracijaKorisnikaDTO korisnikDTO = new RegistracijaKorisnikaDTO(noviKorisnik.getId(), noviKorisnik.getKorisnickoIme(),
                noviKorisnik.getLozinka(), noviKorisnik.getIme(), noviKorisnik.getPrezime(),noviKorisnik.getDatumRodjenja(),
                noviKorisnik.getEmail(), noviKorisnik.getTelefon(), noviKorisnik.getUloga());
        return new ResponseEntity<>(korisnikDTO, HttpStatus.CREATED);

    }


}
