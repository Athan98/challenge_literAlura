package com.challengeLiterAlura.LiterAlura.dto;

import com.challengeLiterAlura.LiterAlura.model.Autor;

public record LibroDTO(
        Long idLibro,
        String titulo,
        Autor autor,
        String idioma,
        Integer cantidadDescargas
) {
}
