package com.example.fitnessCenter.service.impl;

import com.example.fitnessCenter.entity.RasporedTreninga;
import com.example.fitnessCenter.repository.RasporedRepository;
import com.example.fitnessCenter.service.RasporedTreningaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RasporedTreningaServiceImpl implements RasporedTreningaService {

    private final RasporedRepository rasporedRepository;

    @Autowired
    public RasporedTreningaServiceImpl(RasporedRepository rasporedRepository){this.rasporedRepository = rasporedRepository;}



    @Override
    public RasporedTreninga save(RasporedTreninga termin) throws Exception {
        if(termin.getId() != null) {
            throw new Exception("ID must be null!");
        }
        RasporedTreninga noviTermin = this.rasporedRepository.save(termin);
        return noviTermin;
    }


    @Override
    public RasporedTreninga findOne(Long id){
        RasporedTreninga termin = this.rasporedRepository.findById(id).get();
        return termin;
    }

    @Override
    public List<RasporedTreninga> findAll() {
        List<RasporedTreninga> termini = this.rasporedRepository.findAll();
        return termini;
    }

    @Override
    public RasporedTreninga update(RasporedTreninga termin) throws Exception {
        RasporedTreninga TerminZaIzmenu = this.rasporedRepository.findById(termin.getId()).get();
        if(termin.getId() == null) {
            throw new Exception("Termin ne postoji!");
        }
        TerminZaIzmenu.setBrojClanova(termin.getBrojClanova());
        TerminZaIzmenu.setCena(termin.getCena());
        TerminZaIzmenu.setDatumKrajaTreninga(termin.getDatumKraja());
        TerminZaIzmenu.setDatumPocetkaTreninga(termin.getDatumPocetka());
        TerminZaIzmenu.setFitnesCentar(termin.getFitnesCentar());
        TerminZaIzmenu.setSala(termin.getSala());
        TerminZaIzmenu.setTrening(termin.getTrening());
        RasporedTreninga izmenjenTermin = rasporedRepository.save(TerminZaIzmenu);
        return izmenjenTermin;
    }

    @Override
    public void delete(Long id) {
        this.rasporedRepository.deleteById(id);
    }
}
