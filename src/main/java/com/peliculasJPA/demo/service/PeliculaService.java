package com.peliculasJPA.demo.service;

import com.peliculasJPA.demo.model.Pelicula;
import com.peliculasJPA.demo.model.Resena;
import com.peliculasJPA.demo.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;
    // tengo que hacer el PeliculasValidator


    public Optional<Pelicula> guardarPelicula(Pelicula pelicula){
        // agregar también el validator
        // peliculaValidator.validar(pelicula) algo así

        return Optional.of(peliculaRepository.save(pelicula));
    }

    public List<Pelicula> findByDirector(String nombre){
        return peliculaRepository.findByDirector(nombre);
    }

    public void agregarResena(Long peliculaId, Resena resena){

        Pelicula pelicula = peliculaRepository.findById(peliculaId)
                .orElseThrow(()-> new RuntimeException("Pelicula no encontrada"));

        resena.setPelicula(pelicula);
        pelicula.getListaResenas().add(resena);

        peliculaRepository.save(pelicula);

    }


}
