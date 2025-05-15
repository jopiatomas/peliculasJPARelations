package com.peliculasJPA.demo.controller;

import com.peliculasJPA.demo.model.Pelicula;
import com.peliculasJPA.demo.model.Resena;
import com.peliculasJPA.demo.service.PeliculaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {


    @Autowired
    private PeliculaService peliculaService;

    @PostMapping
    public ResponseEntity<?> crearPelicula(@RequestBody @Valid Pelicula pelicula){
        Optional<Pelicula> peliculaAux = peliculaService.guardarPelicula(pelicula);

        return ResponseEntity.ok(peliculaAux);
    }

/*
    @PostMapping("/{peliculaId}/resenas") // será así con actor?
    public ResponseEntity<?> agregarResena(@PathVariable Long peliculaId, @RequestBody Resena resena){

        peliculaService.agregarResena(peliculaId, resena);

        return ResponseEntity.ok("Resena agregada a la pelicula con id: ");

    }*/

    @GetMapping
    public List<Pelicula> listarTodasLasPeliculas(){
        return peliculaService.getAllPeliculas();
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return peliculaService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/director/{nombre}")
    public List<Pelicula> buscarPorDirector(@PathVariable String nombre){
        return peliculaService.findByDirectorNombre(nombre);
    }

}
