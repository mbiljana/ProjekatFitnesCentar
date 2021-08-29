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
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/korisnik")
public class KorisnikController {
    private final ClanService clanService;
    private final TrenerService trenerService;
    private final AdministratorService administratorService;

    @Autowired
    public KorisnikController(ClanService clanService, TrenerService trenerService, AdministratorService administratorService) {this.clanService = clanService;
        this.trenerService = trenerService;
        this.administratorService = administratorService; }

/*
    @PostMapping(value = ("/prijava"),consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PrijavljenKorisnikDTO> prijava(@RequestBody PrijavaKorisnikaDTO prijavaKorisnikaDTO) throws Exception{
        Clan clan = this.clanService.getByKorisnickoImeAndLozinka(prijavaKorisnikaDTO.getKorisnickoIme(),prijavaKorisnikaDTO.getLoznika());
        Administrator administrator = this.administratorService.getByKorisnickoImeAndLozinka(prijavaKorisnikaDTO.getKorisnickoIme(),prijavaKorisnikaDTO.getLoznika());
        Trener trener = this.trenerService.getByKorisnickoImeAndLozinka(prijavaKorisnikaDTO.getKorisnickoIme(),prijavaKorisnikaDTO.getLoznika());


        //dto objekat prijavljenog
        PrijavljenKorisnikDTO prijavljenDTO = new PrijavljenKorisnikDTO();
        System.out.println("String:" + clan.getKorisnickoIme());
        System.out.println(clan.getLozinka());
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

 */


   /* @PostMapping(value="/registracija" ,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
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

    */


    @GetMapping(value="/zahteviZaRegistracijuClana", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ZahteviZaRegistracijuDTO>> getRegistracijaClana() {
        List<Clan> clanovi = this.clanService.findAll();

        List<ZahteviZaRegistracijuDTO> trazeniTreneri = new ArrayList<ZahteviZaRegistracijuDTO>();

        for(Clan t : clanovi) {
            if(t.isDaLiJeRegistrovan() == false) {
                ZahteviZaRegistracijuDTO trener = new ZahteviZaRegistracijuDTO( t.getKorisnickoIme(), t.getIme(), t.getPrezime(), t.getLozinka(),
                        t.getTelefon(), t.getEmail(), t.getDatumRodjenja(), t.getUloga());
                trazeniTreneri.add(trener);
            }

        }
        return new ResponseEntity<>(trazeniTreneri, HttpStatus.OK);
    }

    @GetMapping(value="/zahteviZaRegistracijuTrenera", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ZahteviZaRegistracijuDTO>> getRegistracijaTrenera() {
        List<Trener> treneri = this.trenerService.findAll();

        List<ZahteviZaRegistracijuDTO> trazeniTreneri = new ArrayList<ZahteviZaRegistracijuDTO>();

        for(Trener t : treneri) {
            if(t.isDaLiJeRegistrovan() == false) {
                ZahteviZaRegistracijuDTO trener = new ZahteviZaRegistracijuDTO( t.getKorisnickoIme(), t.getIme(), t.getPrezime(), t.getLozinka(),
                        t.getTelefon(), t.getEmail(), t.getDatumRodjenja(), t.getUloga());
                trazeniTreneri.add(trener);
            }

        }
        return new ResponseEntity<>(trazeniTreneri, HttpStatus.OK);
    }

    @PostMapping(
            value =("/login"),
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PrijavaKorisnikaDTO> KorisnikLogin(@RequestBody PrijavljenKorisnikDTO korisnikLoginDTO) throws Exception{
        Administrator admin = this.administratorService.getByKorisnickoImeAndLozinka(korisnikLoginDTO.getKorisnickoIme(), korisnikLoginDTO.getLozinka());
        Clan clan = this.clanService.getByKorisnickoImeAndLozinka(korisnikLoginDTO.getKorisnickoIme(), korisnikLoginDTO.getLozinka());
        Trener trener = this.trenerService.getByKorisnickoImeAndLozinka(korisnikLoginDTO.getKorisnickoIme(), korisnikLoginDTO.getLozinka());
        PrijavaKorisnikaDTO korisnikDTO = new PrijavaKorisnikaDTO();
        if(admin != null) {
            if(admin.isAktivan() == false || admin.isDaLiJeRegistrovan()== false) {

                throw new Exception("Nalog nije aktiviran");
            }
            else {
                korisnikDTO = new PrijavaKorisnikaDTO(admin.getId(), admin.getKorisnickoIme(), admin.getIme(), admin.getPrezime(),
                        "ne prenosim sifru", admin.getTelefon(), admin.getEmail(), admin.getDatumRodjenja(), admin.isAktivan(), admin.getUloga());
                return new ResponseEntity<>(korisnikDTO,HttpStatus.OK);
            }


        }
        else if(clan != null) {
            if(clan.isAktivan() == false || clan.isDaLiJeRegistrovan() == false) {
                throw new Exception("Nalog nije aktiviran");
            }
            else{
                korisnikDTO = new PrijavaKorisnikaDTO(clan.getId(), clan.getKorisnickoIme(), clan.getIme(), clan.getPrezime(),
                        "ne prenosim sifru", clan.getTelefon(), clan.getEmail(), clan.getDatumRodjenja(), clan.isAktivan(), clan.getUloga());
                return new ResponseEntity<>(korisnikDTO,HttpStatus.OK);

            }


        }
        else if(trener != null) {
            if(trener.isAktivan() == false || trener.isDaLiJeRegistrovan() == false) {
                throw new Exception("Nalog nije aktiviran");
            }
            else{
                korisnikDTO = new PrijavaKorisnikaDTO(trener.getId(), trener.getKorisnickoIme(), trener.getIme(), trener.getPrezime(),
                        "ne prenosim sifru", trener.getTelefon(), trener.getEmail(), trener.getDatumRodjenja(), trener.isAktivan(), trener.getUloga());
                return new ResponseEntity<>(korisnikDTO,HttpStatus.OK);
            }

        }
        else
            throw new Exception("Kredincijali nisu tacni");

    }

    @GetMapping(value = "/clanovi/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDTO> getClan(@PathVariable("id") Long id)
    {
        Clan korisnik = this.clanService.findOne(id);
        KorisnikDTO trazeniKorisnik = new KorisnikDTO();
        trazeniKorisnik.setId(korisnik.getId());
        trazeniKorisnik.setIme(korisnik.getIme());
        trazeniKorisnik.setPrezime(korisnik.getPrezime());
        trazeniKorisnik.setDatumRodjenja(korisnik.getDatumRodjenja());
        trazeniKorisnik.setEmail(korisnik.getEmail());
        trazeniKorisnik.setTelefon(korisnik.getTelefon());
        trazeniKorisnik.setUloga(korisnik.getUloga());

        return new ResponseEntity<>(trazeniKorisnik, HttpStatus.OK);
    }

    @GetMapping(value="/clanovi", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<KorisnikDTO>> getClanovi() {
        List<Clan> korisnici = this.clanService.findAll();

        List<KorisnikDTO> trazeniKorisnici = new ArrayList<KorisnikDTO>();

        for(Clan k : korisnici) {
            KorisnikDTO korisnik = new KorisnikDTO(k.getId(),k.getIme(),k.getPrezime(),k.getTelefon(),
                    k.getEmail(),k.getDatumRodjenja(),k.getUloga());
            trazeniKorisnici.add(korisnik);
        }
        return new ResponseEntity<>(trazeniKorisnici, HttpStatus.OK);
    }

  /*  @PostMapping(value="/registrujClana" ,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KreiranjeKorisnikaDTO> createClan(@RequestBody ZahteviZaRegistracijuDTO DTO) throws Exception {
        Clan korisnik = new Clan(DTO.getKorisnickoIme(),DTO.getLozinka(),DTO.getIme(),
                DTO.getPrezime(),DTO.getTelefon(),DTO.getEmail(),DTO.getDatumRodjenja(),DTO.getUloga(),true,true
        );

        Clan noviKorisnik = this.clanService.save(korisnik);
        KreiranjeKorisnikaDTO korisnikDTO = new KreiranjeKorisnikaDTO(noviKorisnik.getId(), noviKorisnik.getKorisnickoIme(),
                noviKorisnik.getLozinka(), noviKorisnik.getIme(), noviKorisnik.getPrezime(),noviKorisnik.getDatumRodjenja(),
                noviKorisnik.getEmail(), noviKorisnik.getTelefon(), noviKorisnik.getUloga());
        return new ResponseEntity<>(korisnikDTO, HttpStatus.CREATED);

    } */

    @PostMapping(value="/registrujClana" ,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegistrujKorisnikaDTO> createClan(@RequestBody RegistrujKorisnikaDTO DTO) throws Exception {
        Clan korisnik = new Clan(DTO.getKorisnickoIme(),DTO.getLozinka(),DTO.getIme(),
                DTO.getPrezime(),DTO.getTelefon(),DTO.getEmail(),DTO.getDatumRodjenja(),DTO.getUloga(),true,true
        );

        Clan noviKorisnik = this.clanService.save(korisnik);
        RegistrujKorisnikaDTO korisnikDTO = new RegistrujKorisnikaDTO(noviKorisnik.getId(), noviKorisnik.getKorisnickoIme(),
                noviKorisnik.getLozinka(), noviKorisnik.getIme(), noviKorisnik.getPrezime(),noviKorisnik.getDatumRodjenja(),
                noviKorisnik.getEmail(), noviKorisnik.getTelefon(), noviKorisnik.getUloga(),true,true);
       return new ResponseEntity<>(korisnikDTO,HttpStatus.CREATED);

    }

    @PutMapping(value = "/clanovi/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KreiranjeKorisnikaDTO> updateClan(@PathVariable Long id,
                                                            @RequestBody KreiranjeKorisnikaDTO kreiranjeKorisnikaDTO) throws Exception {
        Clan korisnik = new Clan(
                kreiranjeKorisnikaDTO.getKorisnickoIme(),kreiranjeKorisnikaDTO.getLozinka(),kreiranjeKorisnikaDTO.getIme(),
                kreiranjeKorisnikaDTO.getPrezime(),kreiranjeKorisnikaDTO.getTelefon(),kreiranjeKorisnikaDTO.getEmail(),
                kreiranjeKorisnikaDTO.getDatumRodjenja(),kreiranjeKorisnikaDTO.getUloga()
        );
        korisnik.setId(id);
        Clan izmenjenKorisnik = clanService.update(korisnik);
        KreiranjeKorisnikaDTO azuriranKorisnik = new KreiranjeKorisnikaDTO(izmenjenKorisnik.getId(),izmenjenKorisnik.getKorisnickoIme(), izmenjenKorisnik.getLozinka(),
                izmenjenKorisnik.getIme(), izmenjenKorisnik.getPrezime(), izmenjenKorisnik.getDatumRodjenja(), izmenjenKorisnik.getEmail(),
                izmenjenKorisnik.getTelefon(), izmenjenKorisnik.getUloga());
        return new ResponseEntity<>(azuriranKorisnik, HttpStatus.OK);

    }

    @DeleteMapping(value = "/clanovi/{id}")
    public ResponseEntity<Void> deleteClan(@PathVariable Long id) {
        this.clanService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/treneri/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDTO> getTrener(@PathVariable("id") Long id)
    {
        Trener korisnik = this.trenerService.findOne(id);
        KorisnikDTO trazeniKorisnik = new KorisnikDTO();
        trazeniKorisnik.setId(korisnik.getId());
        trazeniKorisnik.setIme(korisnik.getIme());
        trazeniKorisnik.setPrezime(korisnik.getPrezime());
        trazeniKorisnik.setDatumRodjenja(korisnik.getDatumRodjenja());
        trazeniKorisnik.setEmail(korisnik.getEmail());
        trazeniKorisnik.setTelefon(korisnik.getTelefon());
        trazeniKorisnik.setUloga(korisnik.getUloga());

        return new ResponseEntity<>(trazeniKorisnik, HttpStatus.OK);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value="/treneri")
    public ResponseEntity<List<KorisnikDTO>> getTreneri() {
        List<Trener> korisnici = this.trenerService.findAll();

        List<KorisnikDTO> trazeniKorisnici = new ArrayList<KorisnikDTO>();

        for(Trener k : korisnici) {
            KorisnikDTO korisnik = new KorisnikDTO(k.getId(),k.getIme(),k.getPrezime(),k.getTelefon(),
                    k.getEmail(),k.getDatumRodjenja(),k.getUloga());
            trazeniKorisnici.add(korisnik);
        }
        return new ResponseEntity<>(trazeniKorisnici, HttpStatus.OK);
    }


    @PostMapping(value="/registrujTrenera",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KreiranjeKorisnikaDTO> createTrener(@RequestBody ZahteviZaRegistracijuDTO DTO) throws Exception {
        Trener korisnik = new Trener(
                DTO.getKorisnickoIme(),DTO.getLozinka(),DTO.getIme(),DTO.getPrezime(),
                DTO.getTelefon(),DTO.getEmail(),DTO.getDatumRodjenja(),DTO.getUloga(),true,false
        );

        Trener noviKorisnik = this.trenerService.save(korisnik);
        KreiranjeKorisnikaDTO korisnikDTO = new KreiranjeKorisnikaDTO(noviKorisnik.getId(), noviKorisnik.getKorisnickoIme(),
                noviKorisnik.getLozinka(), noviKorisnik.getIme(), noviKorisnik.getPrezime(),noviKorisnik.getDatumRodjenja(),
                noviKorisnik.getEmail(), noviKorisnik.getTelefon(), noviKorisnik.getUloga());
        return new ResponseEntity<>(korisnikDTO, HttpStatus.CREATED);

    }



    @DeleteMapping(value = "/treneri/{id}")
    public ResponseEntity<Void> deleteTrener(@PathVariable Long id) {
        this.trenerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/treneri/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KreiranjeKorisnikaDTO> updateTrener(@PathVariable Long id,
                                                              @RequestBody KreiranjeKorisnikaDTO kreiranjeKorisnikaDTO) throws Exception {
        Trener korisnik = new Trener(kreiranjeKorisnikaDTO.getKorisnickoIme(),kreiranjeKorisnikaDTO.getLozinka(),kreiranjeKorisnikaDTO.getIme(),
                kreiranjeKorisnikaDTO.getPrezime(),kreiranjeKorisnikaDTO.getTelefon(),kreiranjeKorisnikaDTO.getEmail(),
                kreiranjeKorisnikaDTO.getDatumRodjenja(),kreiranjeKorisnikaDTO.getUloga());
        korisnik.setId(id);
        Korisnik izmenjenKorisnik = trenerService.update(korisnik);
        KreiranjeKorisnikaDTO azuriranKorisnik = new KreiranjeKorisnikaDTO(izmenjenKorisnik.getId(),izmenjenKorisnik.getKorisnickoIme(), izmenjenKorisnik.getLozinka(),
                izmenjenKorisnik.getIme(), izmenjenKorisnik.getPrezime(), izmenjenKorisnik.getDatumRodjenja(), izmenjenKorisnik.getEmail(),
                izmenjenKorisnik.getTelefon(), izmenjenKorisnik.getUloga());
        return new ResponseEntity<>(azuriranKorisnik, HttpStatus.OK);

    }




}
