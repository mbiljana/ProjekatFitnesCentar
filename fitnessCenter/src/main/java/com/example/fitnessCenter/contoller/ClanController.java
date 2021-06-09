package com.example.fitnessCenter.contoller;

import com.example.fitnessCenter.entity.Clan;
import com.example.fitnessCenter.entity.DTO.ClanDTO;
import com.example.fitnessCenter.repository.ClanRepository;
import com.example.fitnessCenter.service.ClanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/clanovi")
public class ClanController {
    @Autowired
    public ClanService clanService;
    @Autowired
    public ClanRepository clanRepository;

    //prikaz svih clanova
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClanDTO>> getClanovi(){
        List<Clan> clanList = this.clanService.findAll();
        List<ClanDTO> clanDTOS = new ArrayList<>();
        for(Clan c : clanList){
            ClanDTO clanDTO = new ClanDTO(c.getId(),c.getKorisnickoIme(),c.getLozinka(),c.getIme(),c.getPrezime(),c.getTelefon(),c.getEmail(),c.getDatumRodjenja(),c.getUloga(),c.getAktivan());
            clanDTOS.add(clanDTO);
        }
        return new ResponseEntity<>(clanDTOS, HttpStatus.OK);
    }

    //prikaz jednog clana
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClanDTO>getClan(@PathVariable(name="id") Long id){
        Clan clan = this.clanService.findOne(id);
        ClanDTO clanDTO = new ClanDTO();
        clanDTO.setIme(clan.getIme());
        clanDTO.setDatumRodjenja(clan.getDatumRodjenja());
        clanDTO.setEmail(clan.getEmail());
        clanDTO.setAktivan(clan.getAktivan());
        clanDTO.setKorisnickoIme(clan.getKorisnickoIme());
        clanDTO.setLozinka(clan.getLozinka());
        clanDTO.setPrezime(clan.getPrezime());
        clanDTO.setTelefon(clan.getTelefon());
        clanDTO.setUloga(clan.getUloga());
        return new ResponseEntity<>(clanDTO,HttpStatus.OK);
    }

    //kreiranje novog clana
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClanDTO>kreiranjeClana(@RequestBody ClanDTO clanDTO) throws Exception{
        Clan postojeciClan = this.clanService.findByKorisnickoIme(clanDTO.getKorisnickoIme());
        //clan vec postoji
        if(postojeciClan != null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        //u drugom slucaju
        Clan clan = new Clan(clanDTO.getKorisnickoIme(),clanDTO.getLozinka(),clanDTO.getIme(),clanDTO.getPrezime(),clanDTO.getTelefon(),clanDTO.getEmail(),clanDTO.getDatumRodjenja(),clanDTO.getUloga(),true,true);
        clan.setAktivan(false);
        clanRepository.save(clan);
        ClanDTO clanDTO1 = new ClanDTO(clan.getId(),clan.getKorisnickoIme(),clan.getLozinka(),clan.getIme(),clan.getPrezime(),clan.getTelefon(),clan.getEmail(),clan.getDatumRodjenja(),clan.getUloga(),clan.getAktivan());
        return new ResponseEntity<>(clanDTO1,HttpStatus.OK);

    }





}
