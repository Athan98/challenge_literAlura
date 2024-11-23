package com.challengeLiterAlura.LiterAlura.principal;

import com.challengeLiterAlura.LiterAlura.dto.AutorDTO;
import com.challengeLiterAlura.LiterAlura.model.DatosLibro;
import com.challengeLiterAlura.LiterAlura.model.Libro;
import com.challengeLiterAlura.LiterAlura.service.AutorService;
import com.challengeLiterAlura.LiterAlura.service.ConsumoAPI;
import com.challengeLiterAlura.LiterAlura.service.ConvierteDatos;
import com.challengeLiterAlura.LiterAlura.service.LibroService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "http://gutendex.com/books/";
    private ConvierteDatos conversor = new ConvierteDatos();
    private LibroService libroService;
    private AutorService autorService;


    public Principal(LibroService libroService,AutorService autorService){
        this.libroService=libroService;
        this.autorService=autorService;
    }

    public void muestraElMenu() {
        while (true) {
            var menu = """
                1 - Buscar y registrar en la BD libro por titulo 
                2 - Listar libros registrados en la BD
                3 - Listar autores registrados en la BD
                4 - Listar autores de la BD vivos en un período de tiempo
                5 - Listar libros de la BD por idioma  
                                    
                0 - Salir
                """;
            System.out.println(menu);

            try {
                var opcion = teclado.nextInt();
                teclado.nextLine(); // Limpiar el buffer
                switch (opcion) {
                    case 1:
                        buscarRegistrarLibro();
                        break;
                    case 2:
                        listarLosLibrosRegistrados();
                        break;
                    case 3:
                        listarLosAutoresRegistrados();
                        break;
                    case 4:
                        listarAutoresVivos();
                        break;
                    case 5:
                        listarLibrosPorIdioma();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Opción inválida, intente nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                teclado.nextLine(); // Limpiar el buffer para evitar un bucle infinito
            }
        }
    }

    private DatosLibro getDatosLibro() {
        System.out.println("Escribe el nombre del libro que deseas buscar");
        var nombreLibro = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE +"/?search="+ nombreLibro.replace(" ", "+"));
        DatosLibro datos = conversor.obtenerDatos(json, DatosLibro.class);
        return datos;
    }

    private void buscarRegistrarLibro(){
        DatosLibro datos=getDatosLibro();
        if(datos==null){
            System.out.println("No se encuentra el libro buscado en la API");
            return;
        }else{
            Libro libro=new Libro(datos);
            libroService.crearLibro(libro);
            System.out.println(libro);
        }
    }

    private void listarLosAutoresRegistrados(){
     autorService.obtenerTodosLosAutores().stream()
             .map(autor -> {
                 StringBuilder autorInfo = new StringBuilder("------ AUTOR ------\n");
                 autorInfo.append("Nombre: ").append(autor.nombre()).append("\n")
                         .append("Año de Nacimiento: ").append(autor.añoNacimiento()).append("\n")
                         .append("Año de Fallecimiento: ").append(autor.añoFallecimiento()).append("\n")
                         .append("Libros:\n");

                 autor.libros().forEach(libro -> {
                     autorInfo.append("  - ").append(libro.getTitulo()).append("\n");
                 });

                 autorInfo.append("-------------------");
                 return autorInfo.toString();
             })
             .forEach(System.out::println);
    }

    private void listarAutoresVivos() {
        System.out.println("Ingrese el año que desea buscar");
        System.out.println("-------------------------------");
        int año = teclado.nextInt();

        List<AutorDTO> autoresVivos = autorService.obtenerAutoresVivosEnAño(año);

        if (autoresVivos.isEmpty()) {
            System.out.println("No hay autores vivos en el año " + año);
        } else {
            System.out.println("Los autores vivos en el año " + año + " son:");
            autoresVivos.stream()
                    .map(autor -> {
                        StringBuilder autorInfo = new StringBuilder("------ AUTOR ------\n");
                        autorInfo.append("Nombre: ").append(autor.nombre()).append("\n")
                                .append("Año de Nacimiento: ").append(autor.añoNacimiento()).append("\n")
                                .append("Año de Fallecimiento: ").append(autor.añoFallecimiento()).append("\n")
                                .append("Libros:\n");

                        autor.libros().forEach(libro -> {
                            autorInfo.append("  - ").append(libro.getTitulo()).append("\n");
                        });

                        autorInfo.append("-------------------");
                        return autorInfo.toString();
                    })
                    .forEach(System.out::println);
        }
    }

    private void listarLosLibrosRegistrados(){
       libroService.listarTodosLosLibros().stream()
               .map(libro -> "------ LIBRO ------\n" +
                       "Titulo: " + libro.titulo() + "\n" +
                       "Autor: " + libro.autor().getNombre() + "\n" +
                       "Idioma: " + libro.idioma() + "\n" +
                       "Numero de descargas: " + libro.cantidadDescargas() + "\n" +
                       "-------------------")
               .forEach(System.out::println);
    }

    private void listarLibrosPorIdioma(){
        System.out.println("Ingrese el idioma para buscar los libros");
        System.out.println("-------------------");
        System.out.println("IDIOMAS DISPONIBLES");
        System.out.println("es- español");
        System.out.println("en- inglés");
        System.out.println("fr- francés");
        System.out.println("pt- portugués");
        System.out.println("-------------------");
        var idioma=teclado.nextLine();

        libroService.listarLibrosPorIdioma(idioma).stream()
                .map(libro -> "------ LIBRO ------\n" +
                        "Titulo: " + libro.titulo() + "\n" +
                        "Autor: " + libro.autor().getNombre() + "\n" +
                        "Idioma: " + libro.idioma() + "\n" +
                        "Numero de descargas: " + libro.cantidadDescargas() + "\n" +
                        "-------------------")
                .forEach(System.out::println);
    }


}
