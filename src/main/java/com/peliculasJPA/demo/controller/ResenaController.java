package com.peliculasJPA.demo.controller;


import com.peliculasJPA.demo.model.Resena;
import com.peliculasJPA.demo.service.ResenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/resena")
public class ResenaController {

    @Autowired
    private ResenaService resenaService;

    @PostMapping
    public ResponseEntity<?> crearResena(@RequestBody Resena resena){
        Optional<Resena> resenaAux = resenaService.saveResena(resena);

        return ResponseEntity.ok(resenaAux);
    }

    @GetMapping
    public List<Resena> listarTodasLasResenas(){
        return resenaService.getAllResenas();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarResena(@PathVariable Long id) {
        resenaService.eliminarPorId(id);
        return ResponseEntity.ok("Reseña eliminada correctamente");
    }


    // NO FUNCIONA NADA
    @PutMapping("/{resenaId}/peliculas/{peliculaId}")
    public ResponseEntity<?> agregarlePeliculaAResena(@PathVariable Long resenaId, @PathVariable Long peliculaId){
        Resena actualizada = resenaService.vinculaResenaAPelicula(resenaId, peliculaId);

        return ResponseEntity.ok(actualizada);
    }

}
