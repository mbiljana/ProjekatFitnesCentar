package com.example.fitnessCenter.contoller;

import com.example.fitnessCenter.entity.DTO.FitnessCentarDTO;
import com.example.fitnessCenter.entity.FitnessCentar;
import com.example.fitnessCenter.service.FitnessCentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/sviFitnesCentri")
public class FitnessCentarController {
    @Autowired
    public FitnessCentarService fitnessCentarService;

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



}
