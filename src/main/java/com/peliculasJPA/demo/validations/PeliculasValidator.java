package com.peliculasJPA.demo.validations;

import com.peliculasJPA.demo.model.Pelicula;
import org.springframework.stereotype.Component;

@Component
public class PeliculasValidator {

    public void validarParaCreacion(Pelicula pelicula){
        if(pelicula.getTitulo() == null){
            throw new RuntimeException("El titulo no puede ser nulo.");
        }

        else if (pelicula.getAnioEstreno() < 1895){
            throw new RuntimeException("El año no puede ser menor a 1895");
        }

        else if(pelicula.getDuracion() <= 0){
            throw new RuntimeException("La pelicula debe tener una duracion mayor a 0.");
        }
    }


}
