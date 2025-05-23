package com.peliculasJPA.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "genero")
public class Genero {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", unique = true)
    @NotNull(message = "El nombre no puede ser nulo")
    private String nombre;

    @ManyToMany(mappedBy = "generosSecundarios") // el nombre del array
    @JsonIgnore // evita recursividad
    private List<Pelicula> peliculasConEsteGenero = new ArrayList<>();

    public Genero(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Genero() {
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
