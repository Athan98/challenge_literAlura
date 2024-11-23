package com.challengeLiterAlura.LiterAlura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLibro;
    private String titulo;
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;
    private String idioma;
    private Integer cantidadDescargas;

    public Libro(){}

    public Libro(DatosLibro datosLibro){
        this.titulo=datosLibro.titulo();
        this.autor = datosLibro.autores().get(0);
        this.idioma = datosLibro.idiomas().get(0);
        this.cantidadDescargas=datosLibro.cantidadDescargas();
    }

    @Override
    public String toString() {
        return "------ LIBRO ------\nTitulo: "+this.titulo+"\nAutor: "+this.autor.getNombre()+"\nIdioma: "+this.idioma+"\nNumero de descargas: "+this.cantidadDescargas+"\n-------------------";
    }

    public Long getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Long idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getCantidadDescargas() {
        return cantidadDescargas;
    }

    public void setCantidadDescargas(Integer cantidadDescargas) {
        this.cantidadDescargas = cantidadDescargas;
    }
}
