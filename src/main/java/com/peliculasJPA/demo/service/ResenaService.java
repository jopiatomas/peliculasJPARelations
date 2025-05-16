package com.peliculasJPA.demo.service;

import com.peliculasJPA.demo.model.Pelicula;
import com.peliculasJPA.demo.model.Resena;
import com.peliculasJPA.demo.repository.PeliculaRepository;
import com.peliculasJPA.demo.repository.ResenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResenaService {

    @Autowired
    private ResenaRepository resenaRepository;

    @Autowired
    private PeliculaRepository peliculaRepository;

    public Optional<Resena> saveResena(Long peliculaId, Resena resena){
        Pelicula pelicula = peliculaRepository.findById(peliculaId)
                .orElseThrow(() -> new RuntimeException("Pelicula no encontrada"));

        resena.setPelicula(pelicula);
        return Optional.of(resenaRepository.save(resena));

    }

    public List<Resena> getAllResenas(){
        return resenaRepository.findAll();
    }

    public void eliminarPorId(Long id) {
        resenaRepository.deleteById(id);
    }

    // agregar una resena ya creada a una pelicula ya creada NO FUNCIONA NADA
    // al crear una reseñan ya tiene que tener una película, qué sentido tendría
    public Resena vinculaResenaAPelicula(Long resenaId, Long peliculaId){

        Resena resena = resenaRepository.findById(resenaId)
                .orElseThrow(() -> new RuntimeException("La reseña no encontrada"));

        Pelicula pelicula = peliculaRepository.findById(peliculaId)
                .orElseThrow(() -> new RuntimeException("La pelicula no fue encontrada"));

        resena.setPelicula(pelicula);

        return resenaRepository.save(resena); // guardo los cambios
    }

    public void eliminarTodas(){
        resenaRepository.deleteAll();
    }

}