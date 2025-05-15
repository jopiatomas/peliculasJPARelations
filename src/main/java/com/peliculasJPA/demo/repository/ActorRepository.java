package com.peliculasJPA.demo.repository;

import com.peliculasJPA.demo.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}
