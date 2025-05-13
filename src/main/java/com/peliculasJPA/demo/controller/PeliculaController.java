package com.peliculasJPA.demo.controller;

import com.peliculasJPA.demo.model.Pelicula;
import com.peliculasJPA.demo.model.Resena;
import com.peliculasJPA.demo.repository.PeliculaRepository;
import com.peliculasJPA.demo.service.PeliculaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaRepository peliculaRepository;

    private PeliculaService peliculaService;


    //id/pelicula/resena
    @PostMapping()
    public ResponseEntity<?> agregarResena(@PathVariable Long peliculaId, @RequestBody Resena resena){

        peliculaService.agregarResena(peliculaId, resena);

        return ResponseEntity.of("Resena agregada a la pelicula con id: ");

    }

}
