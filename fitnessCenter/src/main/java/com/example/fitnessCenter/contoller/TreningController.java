package com.example.fitnessCenter.contoller;

import com.example.fitnessCenter.entity.DTO.TreningDTO;
import com.example.fitnessCenter.entity.TipTreninga;
import com.example.fitnessCenter.entity.Trening;
import com.example.fitnessCenter.service.TrenerService;
import com.example.fitnessCenter.service.TreningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/pregledTreninga")
public class TreningController {
    private final TreningService treningService;
    private final TrenerService trenerService;

    @Autowired
    public TreningController(TreningService treningService, TrenerService trenerService)
    {
        this.treningService = treningService;
        this.trenerService = trenerService;
    }

    //metoda za dobavljanje svih treninga
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningDTO>> getTreninzi(){
        //poziva se metoda u servisu za dobavljanje svih zaposlenih
        List<Trening> treningList = this.treningService.findAll();
        //kreira se lista DTO objekata koja se vraca kao odgovor na zahtev
        List<TreningDTO> treningDTOS = new ArrayList<>();
        for(Trening trening : treningList){
            //kreira se treningDTO za svaki trening koga je vratila metoda iz servisa
            //ubacuje se u listu treningDTOS
            TreningDTO treningDTO = new TreningDTO(trening.getId(),trening.getNaziv(),trening.getOpis(),trening.getTipTreninga(),trening.getTrajanje(),trening.getTrener());
            treningDTOS.add(treningDTO);
        }
        //vraca se odgovor 200 OK
        return new ResponseEntity<>(treningDTOS, HttpStatus.OK);
    }

    //prikaz jednog treninga
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TreningDTO>getTrening(@PathVariable("id") Long id){
        Trening trening = this.treningService.findOne(id);
        TreningDTO treningDTO = new TreningDTO();
        treningDTO.setNaziv(trening.getNaziv());
        treningDTO.setOpis(trening.getOpis());
        treningDTO.setTip(trening.getTipTreninga());
        treningDTO.setTrajanje(trening.getTrajanje());
        return new ResponseEntity<>(treningDTO,HttpStatus.OK);
    }


    //metoda za cuvanje novog treninga
   /*
   @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TreningDTO> saveTrening(@RequestBody TreningDTO treningDTO) throws Exception{
        //kreira se objekat klase Trening a vrednosti astributa su iz DTO objekta
        Trening trening = new Trening(treningDTO.getId(),treningDTO.getNaziv(),treningDTO.getOpis(),treningDTO.getTip(),treningDTO.getTrajanje());
       //pozivanjem metode servisa kreira se novi trening
        Trening noviTrening = treningService.save(trening);
        //mapira se novi trening na DTO objekat
        TreningDTO noviTreningDTO = new TreningDTO(noviTrening.getId(),noviTrening.getNaziv(),noviTrening.getOpis(),noviTrening.getTipTreninga(),noviTrening.getTrajanje());

        //vraca se odgovor 201 created
        return new ResponseEntity<>(noviTreningDTO,HttpStatus.CREATED);
    }

    */


    //metoda za brisanje postojeceg treninga
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTrening(@PathVariable Long id){
        //brise se trening po id-u pozivanjem metode servisa
        this.treningService.delete(id);

        //vraca se odgovor 204 NO_CONTENT uspesno brisanje
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //sortiranje treninga po nazivu
    @GetMapping(value = "/sortNaziv",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningDTO>>sortNaziv(){
        List<Trening> treninzi = treningService.sortNaziv();
        List<TreningDTO>treningDTOS = new ArrayList<>();
        for(Trening t : treninzi){
            TreningDTO treningDTO = new TreningDTO(t.getNaziv(),t.getOpis(),t.getTipTreninga(),t.getTrajanje());
            treningDTOS.add(treningDTO);
        }
        return new ResponseEntity<>(treningDTOS,HttpStatus.OK);
    }

    //sortiranje treninga po tipu treninga
    @GetMapping(value = "/sortTipTreninga",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningDTO>>sortTipTreninga(){
        List<Trening> treninzi = treningService.sortTipTreninga();
        List<TreningDTO>treningDTOS = new ArrayList<>();
        for(Trening t : treninzi){
            TreningDTO treningDTO = new TreningDTO(t.getNaziv(),t.getOpis(),t.getTipTreninga(),t.getTrajanje());
            treningDTOS.add(treningDTO);
        }
        return new ResponseEntity<>(treningDTOS,HttpStatus.OK);
    }

    //sortiranje treninga po trajanju
    @GetMapping(value = "/sortTrajanje",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningDTO>>sortTrajanje(){
        List<Trening> treninzi = treningService.sortTrajanje();
        List<TreningDTO>treningDTOS = new ArrayList<>();
        for(Trening t : treninzi){
            TreningDTO treningDTO = new TreningDTO(t.getNaziv(),t.getOpis(),t.getTipTreninga(),t.getTrajanje());
            treningDTOS.add(treningDTO);
        }
        return new ResponseEntity<>(treningDTOS,HttpStatus.OK);
    }

    //dobavljanje treninga po nazivu
    /* @GetMapping(value="/naziv/{naziv}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TreningDTO>getTreningByNaziv(@PathVariable(name = "naziv") String naziv) {
        Trening trening = treningService.findByNaziv(naziv);
        TreningDTO treningDTO = new TreningDTO(trening.getId(),trening.getNaziv(),trening.getOpis(),trening.getTipTreninga(),trening.getTrajanje());
        return new ResponseEntity<>(treningDTO,HttpStatus.OK);
    } */

    //dobavljanje treninga po tipu
    @GetMapping(value="/tipTreninga/{tipTreninga}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningDTO>>getTreningByTipTreninga(@PathVariable(name = "tipTreninga")String tip){
        List<Trening> treningList = treningService.findAllByTipTreninga(tip);
        List<TreningDTO> treningDTOS = new ArrayList<>();
        for(Trening t : treningList){
            TreningDTO treningDTO = new TreningDTO(t.getNaziv(),t.getOpis(),t.getTipTreninga(),t.getTrajanje());
            treningDTOS.add(treningDTO);
        }
        return new ResponseEntity<>(treningDTOS,HttpStatus.OK);
    }



    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TreningDTO> createTraining(@RequestBody TreningDTO tDTO) throws Exception {
        Trening trening = new Trening(tDTO.getNaziv(), tDTO.getOpis(), tDTO.getTip(),tDTO.getTrajanje(), tDTO.getTrener());
        Trening noviTrening = this.treningService.save(trening);
        TreningDTO treningDTO = new TreningDTO(noviTrening.getId(), noviTrening.getNaziv(), noviTrening.getOpis(),
                noviTrening.getTipTreninga(), noviTrening.getTrajanje(), noviTrening.getTrener());
        return new ResponseEntity<>(treningDTO, HttpStatus.CREATED);

    }


    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TreningDTO> updateTraining(@PathVariable Long id,
                                                     @RequestBody TreningDTO treningDTO) throws Exception {
        Trening trening = new Trening(treningDTO.getNaziv(), treningDTO.getOpis(), treningDTO.getTip(),
                treningDTO.getTrajanje(), treningDTO.getTrener());
        trening.setId(id);
        Trening izmenjenTrening = treningService.update(trening);
        TreningDTO azuriranTrening = new TreningDTO(izmenjenTrening.getId(), izmenjenTrening.getNaziv(), izmenjenTrening.getOpis(),
                izmenjenTrening.getTipTreninga(), izmenjenTrening.getTrajanje(), izmenjenTrening.getTrener());
        return new ResponseEntity<>(azuriranTrening, HttpStatus.OK);

    }





}
