package com.peliculasJPA.demo.repository;

import com.peliculasJPA.demo.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroRepository extends JpaRepository<Genero, Long> {
}
