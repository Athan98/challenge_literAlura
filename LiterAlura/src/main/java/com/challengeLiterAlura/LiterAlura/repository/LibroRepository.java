package com.challengeLiterAlura.LiterAlura.repository;

import com.challengeLiterAlura.LiterAlura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro,Long> {
    Optional<Libro> findByTituloContainingIgnoreCase(String nombreLibro);
    Optional<List<Libro>> findByIdiomaIgnoreCase(String idioma);
}
