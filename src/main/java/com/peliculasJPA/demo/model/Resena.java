package com.peliculasJPA.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "resena")
public class Resena {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El comentario de la reseña no puede ser nulo")
    private String comentario;

    @Min(value = 1, message = "La puntuacion minima es 1.")
    @Max(value = 5, message = "La puntuacion maxima es 5.")
    @Column(nullable = false)
    private Integer puntuacion;

    @ManyToOne
    @JoinColumn(name = "pelicula_id")
    @JsonBackReference
    @NotNull
    private Pelicula pelicula;

    public Resena() {
    }

    public Resena(Long id, String comentario, Integer puntuacion) {
        this.id = id;
        this.comentario = comentario;
        this.puntuacion = puntuacion;
    }

    public Resena(String comentario, Integer puntuacion) {
        this.comentario = comentario;
        this.puntuacion = puntuacion;
    }

    // para la relacion inversa
    public Resena(Long id, String comentario, Integer puntuacion, Pelicula pelicula) {
        this.id = id;
        this.comentario = comentario;
        this.puntuacion = puntuacion;
        this.pelicula = pelicula;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
}
