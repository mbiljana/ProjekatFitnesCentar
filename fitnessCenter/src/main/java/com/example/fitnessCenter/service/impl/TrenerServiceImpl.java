package com.example.fitnessCenter.service.impl;

import com.example.fitnessCenter.entity.Trener;
import com.example.fitnessCenter.entity.Trening;
import com.example.fitnessCenter.repository.TrenerRepository;
import com.example.fitnessCenter.service.TrenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrenerServiceImpl implements TrenerService {

    @Autowired
    public TrenerRepository trenerRepository;

    @Override
    public Trener save(Trener trener) throws Exception {
        if(trener.getId() != null){
            throw new Exception("ID mora biti jedinstven");
        }
        Trener noviTrener = trenerRepository.save(trener);
        return  noviTrener;
    }

    @Override
    public void delete(Long id) {
            trenerRepository.deleteById(id);
    }

    @Override
    public Trener findByKorisnickoImeAndLozinka(String korisnicko, String lozinka) {
        return trenerRepository.findByKorisnickoImeAndLozinka(korisnicko,lozinka);
    }

    @Override
    public Trener findOne(Long id){
        return trenerRepository.getOne(id);
    }

    @Override
    public List<Trener> findAll(){
        return trenerRepository.findAll();
    }


}
