package com.example.fitnessCenter.service.impl;

import com.example.fitnessCenter.entity.Administrator;
import com.example.fitnessCenter.entity.Trener;
import com.example.fitnessCenter.repository.AministratorRepository;
import com.example.fitnessCenter.service.AdministratorService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    public AministratorRepository aministratorRepository;

    @Override
    public Administrator save(Administrator admin) throws Exception {
        if(admin.getId() != null){
            throw new Exception("ID mora biti jedinstven");
        }
        Administrator noviAdmin = aministratorRepository.save(admin);
        return  noviAdmin;
    }

    @Override
    public void delete(Long id) {
        aministratorRepository.deleteById(id);
    }

    @Override
    public Administrator findByKorisnickoImeAndLozinka(String korisnicko, String lozinka) {
        return aministratorRepository.findByKorisnickoImeAndLozinka(korisnicko,lozinka);
    }

    @Override
    public Administrator findOne(Long id) {
        return aministratorRepository.getOne(id);
    }

    @Override
    public List<Administrator> findAll() {
        return aministratorRepository.findAll();
    }
}
