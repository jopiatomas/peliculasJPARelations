package com.peliculasJPA.demo.service;

import com.peliculasJPA.demo.model.Actor;
import com.peliculasJPA.demo.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    public Optional<Actor> saveActor(Actor actor){


        return Optional.of(actorRepository.save(actor));
    }

    public List<Actor> getAllActores(){
        return actorRepository.findAll();
    }

    // estaría bueno completar con otros metodos como getById etc etc

}
