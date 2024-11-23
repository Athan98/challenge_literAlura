package com.challengeLiterAlura.LiterAlura.controller;

import com.challengeLiterAlura.LiterAlura.dto.LibroDTO;
import com.challengeLiterAlura.LiterAlura.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroService service;

    @GetMapping()
    public List<LibroDTO>listarLibros(){
        return service.listarTodosLosLibros();
    }

    @GetMapping("/{idioma}")
    public List<LibroDTO>listarLibrosPorIdioma(@PathVariable String idioma){
        return service.listarLibrosPorIdioma(idioma);
    }

}
