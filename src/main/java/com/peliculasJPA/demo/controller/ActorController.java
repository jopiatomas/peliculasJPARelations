package com.peliculasJPA.demo.controller;

import com.peliculasJPA.demo.model.Actor;
import com.peliculasJPA.demo.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/actores")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @PostMapping
    public ResponseEntity<?> crearActor(@RequestBody Actor actor){

        Optional<Actor> actorAux = actorService.saveActor(actor);

        return ResponseEntity.ok(actorAux);

    }

    @GetMapping
    public List<Actor> listarTodosLosActores(){
        return actorService.getAllActores();
    }
}
