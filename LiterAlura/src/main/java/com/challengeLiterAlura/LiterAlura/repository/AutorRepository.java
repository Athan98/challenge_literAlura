package com.challengeLiterAlura.LiterAlura.repository;

import com.challengeLiterAlura.LiterAlura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor,Long> {

    @Query("SELECT a FROM Autor a WHERE a.añoNacimiento <= :año AND (a.añoFallecimiento IS NULL OR a.añoFallecimiento >= :año)")
    Optional<List<Autor>> findAutoresVivosEnAño(@Param("año") int año);

    Optional<Autor> findByNombreIgnoreCase(String nombre);

}
