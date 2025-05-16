package com.peliculasJPA.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "director")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El nombre del director no puede ser nulo")
    private String nombre;
/*
    @OneToMany(mappedBy = "director")
    @JsonManagedReference
    private List<Pelicula> peliculas = new ArrayList<>();*/

    public Director(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Director() {
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
