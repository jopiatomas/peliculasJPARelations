package com.peliculasJPA.demo.controller;


import com.peliculasJPA.demo.model.Director;
import com.peliculasJPA.demo.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/directores")
public class DirectorController {

    @Autowired
    private DirectorService directorService;


    @PostMapping
    public ResponseEntity<?> crearDirector(@RequestBody Director director){
        directorService.saveDirector(director);

        return ResponseEntity.ok("El director fue guardado correctamente.");
    }

    @GetMapping
    public List<Director> getAllDirectores(){
        return directorService.getAllDirectores();
    }

}
