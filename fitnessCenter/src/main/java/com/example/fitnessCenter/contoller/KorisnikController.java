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


}
