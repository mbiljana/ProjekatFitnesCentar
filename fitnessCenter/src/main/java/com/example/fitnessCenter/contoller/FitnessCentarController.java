package com.example.fitnessCenter.contoller;

import com.example.fitnessCenter.entity.DTO.DodajSaluDTO;
import com.example.fitnessCenter.entity.DTO.FitnessCentarDTO;
import com.example.fitnessCenter.entity.DTO.IDKorisnikaDTO;
import com.example.fitnessCenter.entity.FitnessCentar;
import com.example.fitnessCenter.entity.Sala;
import com.example.fitnessCenter.service.FitnessCentarService;
import com.example.fitnessCenter.service.SalaService;
import com.example.fitnessCenter.service.TrenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.*;

@RestController
@RequestMapping(value = "api/sviFitnesCentri")
public class FitnessCentarController {


    private final TrenerService trenerService;
    private final FitnessCentarService fitnessCentarService;
    private final SalaService salaService;

    @Autowired
    public FitnessCentarController(FitnessCentarService fitnessCentarService, TrenerService trenerService, SalaService salaService)
    {
        this.fitnessCentarService = fitnessCentarService;
        this.trenerService = trenerService;
        this.salaService = salaService;
    }


    //dobavljanje svih fitnes centara
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FitnessCentarDTO>> getFitnesCentri(){
        List<FitnessCentar> fitnessCentarList = this.fitnessCentarService.findAll();
        List<FitnessCentarDTO> fitnessCentarDTOS = new ArrayList<>();
        for(FitnessCentar fc : fitnessCentarList){
            FitnessCentarDTO fitnessCentarDTO = new FitnessCentarDTO(fc.getId(),fc.getNazivCentra(),fc.getAdresaCentra(),fc.getBrojTelefonaCentrale(),fc.getEmailCentra());
            fitnessCentarDTOS.add(fitnessCentarDTO);
        }
        return new ResponseEntity<>(fitnessCentarDTOS, HttpStatus.OK);
    }

    //dodavanje novog fitnes centra
    /*@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnessCentarDTO> saveFitnessCentar(@RequestBody FitnessCentarDTO fitnessCentarDTO) throws Exception {
        FitnessCentar fitnessCentar = new FitnessCentar(fitnessCentarDTO.getId(),fitnessCentarDTO.getNazivCentra(),fitnessCentarDTO.getAdresaCentra(),fitnessCentarDTO.getBrojTelefonaCentrale(),fitnessCentarDTO.getEmailCentra());
        //novi fc
        FitnessCentar noviFC = fitnessCentarService.save(fitnessCentar);
        //mapiranje na dto
        FitnessCentarDTO fitnessCentarDTO1 = new FitnessCentarDTO(noviFC.getId(),noviFC.getNazivCentra(),noviFC.getAdresaCentra(),noviFC.getBrojTelefonaCentrale(),noviFC.getEmailCentra());
        return new ResponseEntity<>(fitnessCentarDTO1,HttpStatus.CREATED);
    } */


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnessCentarDTO> getFitnessCenter(@PathVariable("id") Long id)
    {
        FitnessCentar fitnessCentar = this.fitnessCentarService.findOne(id);
        FitnessCentarDTO trazeniFitnessCentar = new FitnessCentarDTO();
        trazeniFitnessCentar.setId(fitnessCentar.getId());
        trazeniFitnessCentar.setAdresaCentra(fitnessCentar.getAdresaCentra());
        trazeniFitnessCentar.setNazivCentra(fitnessCentar.getNazivCentra());
        trazeniFitnessCentar.setBrojTelefonaCentrale(fitnessCentar.getBrojTelefonaCentrale());
        trazeniFitnessCentar.setEmailCentra(fitnessCentar.getEmailCentra());
        return new ResponseEntity<>(trazeniFitnessCentar, HttpStatus.OK);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnessCentarDTO> createFitnessCenter(@RequestBody FitnessCentarDTO fcDTO) throws Exception {

        if((salaService.findOne(fcDTO.getIdSale()) == null)){
            throw new Exception("Ova sala ne postoji!");
        }else {
            Sala sala = salaService.findOne(fcDTO.getIdSale());
            Set<Sala> sale = new HashSet<>();
            sale.add(sala);
            FitnessCentar fitnessCentar = new FitnessCentar(fcDTO.getNazivCentra(), fcDTO.getAdresaCentra(), fcDTO.getBrojTelefonaCentrale(), fcDTO.getEmailCentra(), sale);

            FitnessCentar noviFitnesCentar = this.fitnessCentarService.save(fitnessCentar);
            FitnessCentarDTO fitnesCentarDTO = new FitnessCentarDTO(noviFitnesCentar.getId(), noviFitnesCentar.getNazivCentra(),
                    noviFitnesCentar.getAdresaCentra(), noviFitnesCentar.getBrojTelefonaCentrale(), noviFitnesCentar.getEmailCentra());
            return new ResponseEntity<>(fitnesCentarDTO, HttpStatus.CREATED);
        }

    }

    @PostMapping(value = "/izmena",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> izmena(@RequestBody FitnessCentarDTO fcDTO) throws Exception {
        FitnessCentar fitnesCentar = fitnessCentarService.findOne(fcDTO.getId());
        fitnesCentar.setAdresaCentra(fcDTO.getAdresaCentra());
        fitnesCentar.setNazivCentra(fcDTO.getNazivCentra());
        fitnesCentar.setEmailCentra(fcDTO.getEmailCentra());
        fitnesCentar.setBrojTelefonaCentrale(fcDTO.getBrojTelefonaCentrale());
        fitnessCentarService.update(fitnesCentar);
        return new ResponseEntity<>(HttpStatus.OK);

    }


    //brisanje
    @PostMapping(value = "/brisanje",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> brisanje(@RequestBody IDKorisnikaDTO id) {
        this.fitnessCentarService.delete(id.getIdKorisnika());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "/dodajSalu",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DodajSaluDTO> dodajSalu(@RequestBody DodajSaluDTO fcDTO) throws Exception {

        if((fitnessCentarService.findOne(fcDTO.getIdCentra()) == null)){
            throw new Exception("Fitnes centar ne postoji!");
        }else {
            FitnessCentar fitnessCentar = fitnessCentarService.findOne(fcDTO.getIdCentra());
            Sala sala = new Sala(fcDTO.getId(),fcDTO.getNaziv(),fcDTO.getKapacitet(),fitnessCentar);


            Sala novaSala = this.salaService.save(sala);
            DodajSaluDTO dodajSaluDTO = new DodajSaluDTO(novaSala.getId(),novaSala.getOznaka(),novaSala.getKapacitet(),novaSala.getFitnessCentar().getId());
            return new ResponseEntity<>(dodajSaluDTO, HttpStatus.CREATED);
        }

    }




}
