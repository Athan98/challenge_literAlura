package com.challengeLiterAlura.LiterAlura.dto;

import com.challengeLiterAlura.LiterAlura.model.Libro;

import java.util.List;

public record AutorDTO(
        Long idAutor,
        String nombre,
        int añoNacimiento,
        int añoFallecimiento,
        List<Libro> libros
) {
}
