package com.challengeLiterAlura.LiterAlura.service;

import com.challengeLiterAlura.LiterAlura.dto.LibroDTO;
import com.challengeLiterAlura.LiterAlura.model.Autor;
import com.challengeLiterAlura.LiterAlura.model.Libro;
import com.challengeLiterAlura.LiterAlura.repository.AutorRepository;
import com.challengeLiterAlura.LiterAlura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;


    //METODO PARA CREAR UN NUEVO LIBRO
    public void crearLibro(Libro libro) {
        // Verificar si el libro ya existe por título
        Optional<Libro> libroExistente = libroRepository.findByTituloContainingIgnoreCase(libro.getTitulo());

        if (libroExistente.isPresent()) {
            System.out.println("------------------------------------------");
            System.out.println("El libro ya se encuentra cargado en la BD.");
            System.out.println("------------------------------------------");
            return;
        }

        // Buscar al autor en la base de datos
        Optional<Autor> autorExistente = autorRepository.findByNombreIgnoreCase(libro.getAutor().getNombre());

        // Manejar la creación del autor si no existe
        Autor autor = autorExistente.orElseGet(() -> {
            System.out.println("El autor del libro no se encuentra en la base de datos. Guardando autor nuevo...");
            Autor nuevoAutor = new Autor();
            nuevoAutor.setNombre(libro.getAutor().getNombre());
            nuevoAutor.setAñoFallecimiento(libro.getAutor().getAñoFallecimiento());
            nuevoAutor.setAñoNacimiento(libro.getAutor().getAñoNacimiento());
            return autorRepository.save(nuevoAutor);
        });

        // Asignar el autor al libro y guardar el libro
        System.out.println(autorExistente.isPresent() ?
                "Se encontró una coincidencia de autor en la BD. Guardando el nuevo libro..." :
                "Autor nuevo creado. Guardando el libro...");

        libro.setAutor(autor);
        libroRepository.save(libro);
    }

    //METODO PARA LISTAR LOS LIBROS DE LA BD
    public List<LibroDTO> listarTodosLosLibros(){
        return convierteDatos(libroRepository.findAll());
    }

    //METODO PARA LISTAR LIBROS POR IDIOMA
    public List<LibroDTO> listarLibrosPorIdioma(String idioma){
        return convierteDatos(libroRepository.findByIdiomaIgnoreCase(idioma).orElse(Collections.emptyList()));
    }

    //METODO PARA TRANSFORMAR UNA LISTA DE TIPO LIBRO EN LIBRO_DTO
    public List<LibroDTO> convierteDatos(List<Libro> libro){
        return libro.stream()
                .map(l -> new LibroDTO(l.getIdLibro(), l.getTitulo(), l.getAutor(),
                        l.getIdioma(), l.getCantidadDescargas()))
                .collect(Collectors.toList());
    }


}
