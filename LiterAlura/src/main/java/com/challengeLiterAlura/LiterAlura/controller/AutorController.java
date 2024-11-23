package com.challengeLiterAlura.LiterAlura.controller;

import com.challengeLiterAlura.LiterAlura.dto.AutorDTO;
import com.challengeLiterAlura.LiterAlura.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService service;

    @GetMapping()
    public List<AutorDTO> listarAutores(){
        return service.obtenerTodosLosAutores();
    }

    @GetMapping("/{año}")
    public List<AutorDTO>listarAutoresVivos(@PathVariable int año){
        return service.obtenerAutoresVivosEnAño(año);
    }
}
