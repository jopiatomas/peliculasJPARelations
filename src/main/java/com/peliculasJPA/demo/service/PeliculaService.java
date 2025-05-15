package com.peliculasJPA.demo.service;

import com.peliculasJPA.demo.model.Pelicula;
import com.peliculasJPA.demo.model.Resena;
import com.peliculasJPA.demo.repository.PeliculaRepository;
import com.peliculasJPA.demo.validations.PeliculasValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Autowired
    private PeliculasValidator peliculasValidator;

    public Optional<Pelicula> guardarPelicula(Pelicula pelicula){
        peliculasValidator.validarParaCreacion(pelicula);

        return Optional.of(peliculaRepository.save(pelicula));
    }

    public List<Pelicula> getAllPeliculas(){
        return peliculaRepository.findAll();
    }

    public Optional<Pelicula> getById(Long id){
        return peliculaRepository.findById(id);
    }

    public List<Pelicula> findByDirectorNombre(String nombre){
        return peliculaRepository.findByDirectorNombre(nombre);
    }

    public void agregarResena(Long peliculaId, Resena resena){

        Pelicula pelicula = peliculaRepository.findById(peliculaId)
                .orElseThrow(()-> new RuntimeException("Pelicula no encontrada"));

        resena.setPelicula(pelicula);
        pelicula.getListaResenas().add(resena);

        peliculaRepository.save(pelicula);

    }



}
