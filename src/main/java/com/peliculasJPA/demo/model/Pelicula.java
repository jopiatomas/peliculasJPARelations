package com.peliculasJPA.demo.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "peliculas")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false, unique = true)
    private String titulo;

    @Column(nullable = false)
    private Integer anioEstreno;

    @Min(value = 1, message = "La duracion debe ser mayor a 0")
    private Integer duracion;

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "generos_secundarios",
            joinColumns = @JoinColumn(name = "pelicula_id"), // id de esta clase
            inverseJoinColumns = @JoinColumn(name = "genero_id") // id de la otra clase
    )
    private List<Genero> generosSecundarios = new ArrayList<>();


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "actores",
            joinColumns = @JoinColumn(name = "pelicula_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<Actor> actores = new ArrayList<>();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "director_id")
    @JsonBackReference
    private Director director;

    @OneToMany(mappedBy = "pelicula", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Resena> listaResenas = new ArrayList<>();


    public Pelicula() {
    }

    public Pelicula(Long id, String titulo, Integer anioEstreno, Integer duracion) {
        this.id = id;
        this.titulo = titulo;
        this.anioEstreno = anioEstreno;
        this.duracion = duracion;
    }

    public Pelicula(String titulo, Integer anioEstreno, Integer duracion) {
        this.titulo = titulo;
        this.anioEstreno = anioEstreno;
        this.duracion = duracion;
    }

    // constructor con todos los atributos
    public Pelicula(Long id, String titulo, Integer anioEstreno, Integer duracion, Genero genero, List<Genero> generosSecundarios, List<Actor> actores, Director director, List<Resena> listaResenas) {
        this.id = id;
        this.titulo = titulo;
        this.anioEstreno = anioEstreno;
        this.duracion = duracion;
        this.genero = genero;
        this.generosSecundarios = generosSecundarios;
        this.actores = actores;
        this.director = director;
        this.listaResenas = listaResenas;
    }

    // hay que hacer el metodo para agregar generos secundarios

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnioEstreno() {
        return anioEstreno;
    }

    public void setAnioEstreno(Integer anioEstreno) {
        this.anioEstreno = anioEstreno;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<Genero> getGenerosSecundarios() {
        return generosSecundarios;
    }

    public void setGenerosSecundarios(List<Genero> generosSecundarios) {
        this.generosSecundarios = generosSecundarios;
    }

    public List<Actor> getActores() {
        return actores;
    }

    public void setActores(List<Actor> actores) {
        this.actores = actores;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Resena> getListaResenas() {
        return listaResenas;
    }

    public void setListaResenas(List<Resena> listaResenas) {
        this.listaResenas = listaResenas;
    }
}
