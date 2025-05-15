package com.peliculasJPA.demo.repository;

import com.peliculasJPA.demo.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

    List<Pelicula> findByDirectorNombre(String nombreDirector);

}
