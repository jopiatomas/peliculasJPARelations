package com.peliculasJPA.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "actor")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El nombre del actor no puede ser nulo")
    private String nombre;

    private String nacionalidad;

    @ManyToMany(mappedBy = "actores")
    @JsonIgnore // para evitar recursividad
    private List<Pelicula> peliculas = new ArrayList<>();


    // me salta este error org.hibernate.PersistentObjectException: detached entity passed to persist: com.peliculasJPA.demo.model.Actor
    public Actor() {
    }

    public Actor(Long id, String nombre, String nacionalidad) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
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

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }


    /* POSTMAN
        {
    "titulo":"Segunda prueba",
    "anioEstreno": 2010,
    "duracion": 123,
    "genero": {"id": 1},
    "generosSecundarios":
    [   {"id": 2},
        {"id": 3}

    ],
    "actores":[
        {"id": 1},
        {"id": 2}
    ],

    "director": {"id": 1}

}

     */
}
