package com.peliculasJPA.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "director")
public class Director {

    // tiene que ser generado así?
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El nombre del director no puede ser nulo")
    private String nombre;


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
