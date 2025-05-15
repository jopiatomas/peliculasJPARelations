package com.peliculasJPA.demo.service;

import com.peliculasJPA.demo.model.Director;
import com.peliculasJPA.demo.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorService {

    @Autowired
    private DirectorRepository directorRepository;


    public Optional<Director> saveDirector(Director director){

        return Optional.of(directorRepository.save(director));

    }

    public List<Director> getAllDirectores(){
        return directorRepository.findAll();
    }

}
