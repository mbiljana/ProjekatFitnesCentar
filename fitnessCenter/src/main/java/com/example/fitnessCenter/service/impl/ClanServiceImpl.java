package com.example.fitnessCenter.service.impl;

import com.example.fitnessCenter.entity.Clan;
import com.example.fitnessCenter.entity.Trening;
import com.example.fitnessCenter.repository.ClanRepository;
import com.example.fitnessCenter.service.ClanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClanServiceImpl implements ClanService {

    @Autowired
    public ClanRepository clanRepository;

    @Override
    public Clan findByKorisnickoIme(String korisnickoIme) {
        return clanRepository.findByKorisnickoIme(korisnickoIme);
    }

    @Override
    public Clan findByKorisnickoImeAndLozinka(String korisnickoIme, String lozinka) {
        return clanRepository.findByKorisnickoImeAndLozinka(korisnickoIme,lozinka);
    }

    @Override
    public Clan findByKorisnickoImeAndLozinkaAndAktivan(String korisnickoIme, String lozinka, boolean aktivan) {
        return clanRepository.findByKorisnickoImeAndLozinkaAndAktivan(korisnickoIme,lozinka,aktivan);
    }

    @Override
    public Clan save (Clan clan) throws Exception{
        if(clan.getId() != null){
            throw new Exception("ID mora biti jedinstven");
        }
        Clan noviClan = clanRepository.save(clan);
        return  noviClan;
    }

    @Override
    public void delete(Long id){
        clanRepository.deleteById(id);
    }

    @Override
    public List<Clan> findAll(){
        return clanRepository.findAll();
    }
    @Override
    public Clan findOne(Long id){
        return clanRepository.getOne(id);
    }
}
