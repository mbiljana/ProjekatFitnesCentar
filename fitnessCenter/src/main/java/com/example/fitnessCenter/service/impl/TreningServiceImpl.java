package com.example.fitnessCenter.service.impl;

import com.example.fitnessCenter.entity.TipTreninga;
import com.example.fitnessCenter.entity.Trening;
import com.example.fitnessCenter.repository.TreningRepository;
import com.example.fitnessCenter.service.TrenerService;
import com.example.fitnessCenter.service.TreningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TreningServiceImpl implements TreningService {
    @Autowired
    private TreningRepository treningRepository;


    //trazenje po nazivu
    @Override
    public Trening findByNaziv(String naziv){
        return treningRepository.findByNaziv(naziv);
    }


    //sortirano po nazivu
    @Override
    public List<Trening>findAllByNazivOrderByNaziv(String naziv){
        return treningRepository.findAllByNazivOrderByNaziv(naziv);
    }

    //jedan trening
    @Override
    public Trening findOne(Long id){
        return treningRepository.getOne(id);
    }


    //svi treninzi
    @Override
    public List<Trening> findAll(){
        return treningRepository.findAll();
    }


    //kreiranje novog treninga
    @Override
    public Trening save(Trening trening) throws Exception{
        if(trening.getId() != null){
            throw new Exception("ID mora biti jedinstven");
        }
        Trening noviTrening = treningRepository.save(trening);
        return  noviTrening;
    }

    //brisanje postojeceg treninga preko id-a
    @Override
    public void delete(Long id){
        treningRepository.deleteById(id);
    }


    //sortiranje po nazivu
    @Override
    public List<Trening>sortNaziv(){
        return treningRepository.findAllByOrderByNaziv();
    }

    @Override
    //sortiranje po vrsti treninga
    public List<Trening>sortTipTreninga(){
        return treningRepository.findAllByOrderByTipTreninga();
    }

    //dobavljanje po tipu
    @Override
    public List<Trening> findAllByTipTreninga(TipTreninga tip){
        return treningRepository.findAllByTipTreninga(tip);
    }




}
