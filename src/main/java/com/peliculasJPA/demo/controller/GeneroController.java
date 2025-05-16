package com.peliculasJPA.demo.controller;


import com.peliculasJPA.demo.model.Genero;
import com.peliculasJPA.demo.service.GeneroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/generos")
public class GeneroController {

    @Autowired
    private GeneroService generoService;


    @PostMapping
    public ResponseEntity<?> crearGenero(@RequestBody @Valid Genero genero){
        Optional<Genero> generoAux = generoService.guardarGenero(genero);

        return ResponseEntity.ok(generoAux);
    }

    @GetMapping
    public List<Genero> listarGeneros(){
        return generoService.leerGeneros();
    }
}
