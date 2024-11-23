package com.challengeLiterAlura.LiterAlura.service;

import com.challengeLiterAlura.LiterAlura.dto.AutorDTO;
import com.challengeLiterAlura.LiterAlura.model.Autor;
import com.challengeLiterAlura.LiterAlura.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AutorService {

    @Autowired
    AutorRepository autorRepository;

    //METODO PARA LISTAR TODOS LOS AUTORES
    public List<AutorDTO> obtenerTodosLosAutores(){
        return convierteDatos(autorRepository.findAll());
    }

    //METODO PARA OBTENER TODOS LOS AUTORES EN DETERMINADO AÑO
    public List<AutorDTO> obtenerAutoresVivosEnAño(int año) {
        return convierteDatos(autorRepository.findAutoresVivosEnAño(año).orElse(Collections.emptyList()));
    }

    public List<AutorDTO> convierteDatos(List<Autor> autores){
        return autores.stream()
                .map(a -> new AutorDTO(a.getIdAutor(), a.getNombre(), a.getAñoNacimiento(),
                        a.getAñoFallecimiento(),a.getLibros()))
                .collect(Collectors.toList());
    }
}
