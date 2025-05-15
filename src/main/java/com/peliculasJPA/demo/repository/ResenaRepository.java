package com.peliculasJPA.demo.repository;

import com.peliculasJPA.demo.model.Resena;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResenaRepository extends JpaRepository<Resena, Long> {
}
