package com.example.fitnessCenter.contoller;

import com.example.fitnessCenter.entity.DTO.FitnessCentarDTO;
import com.example.fitnessCenter.entity.DTO.IDKorisnikaDTO;
import com.example.fitnessCenter.entity.DTO.SalaDTO;
import com.example.fitnessCenter.entity.DTO.TreninziKorisnikaDTO;
import com.example.fitnessCenter.entity.FitnessCentar;
import com.example.fitnessCenter.entity.Sala;
import com.example.fitnessCenter.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/sale")
public class SalaController {

    private final SalaService salaService;

    @Autowired
    public SalaController(SalaService salaService){
        this.salaService = salaService;
    }


    //sve sale
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SalaDTO>> getSale(){
        List<Sala> salaList = this.salaService.findAll();
        List<SalaDTO> salaDTOS = new ArrayList<>();
        for(Sala fc : salaList){
            SalaDTO salaDTO = new SalaDTO(fc.getId(),fc.getOznaka(),fc.getKapacitet(), fc.getFitnessCentar());
            salaDTOS.add(salaDTO);
        }
        return new ResponseEntity<>(salaDTOS, HttpStatus.OK);
    }

    @PostMapping(value = "/brisanje",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> brisanje(@RequestBody IDKorisnikaDTO id) {
        this.salaService.delete(id.getIdKorisnika());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
