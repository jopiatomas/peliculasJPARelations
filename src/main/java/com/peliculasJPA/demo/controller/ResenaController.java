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

    @PostMapping("/peliculas/{peliculaId}") // tiene que compartir nombre con el @PathVariable
    public ResponseEntity<?> crearResena(@PathVariable Long peliculaId, @RequestBody Resena resena){
        Optional<Resena> resenaAux = resenaService.saveResena(peliculaId, resena);

        return ResponseEntity.ok(resenaAux);
    }

    @GetMapping
    public List<Resena> listarTodasLasResenas(){
        return resenaService.getAllResenas();
    }

    @DeleteMapping
    public void borrarResenas(){
        resenaService.eliminarTodas();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarResena(@PathVariable Long id) {
        resenaService.eliminarPorId(id);
        return ResponseEntity.ok("Reseña eliminada correctamente");
    }





}
