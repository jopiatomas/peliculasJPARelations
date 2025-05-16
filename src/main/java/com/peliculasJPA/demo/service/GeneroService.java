package com.peliculasJPA.demo.service;

import com.peliculasJPA.demo.model.Genero;
import com.peliculasJPA.demo.repository.GeneroRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    // no necesito el peliculaId porque el genero ya existe, no así como la reseña
    public Optional<Genero> guardarGenero(Genero genero){

        return Optional.of(generoRepository.save(genero));

    }

    public List<Genero> leerGeneros(){
        return generoRepository.findAll();
    }

}
