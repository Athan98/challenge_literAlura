package com.challengeLiterAlura.LiterAlura.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAutor;
    @JsonProperty("name")
    private String nombre;
    @JsonProperty("birth_year")
    private int añoNacimiento;
    @JsonProperty("death_year")
    private int añoFallecimiento;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libros;

    public Autor(){}

    public Autor(DatosAutor datosAutor){
        this.nombre=datosAutor.nombre();
        this.añoNacimiento= datosAutor.añoNacimiento();
        this.añoFallecimiento= datosAutor.añoFallecimiento();
    }

    @Override
    public String toString() {
        return
                "nombre='" + nombre + '\'' +
                ", añoNacimiento=" + añoNacimiento +
                ", añoFallecimiento=" + añoFallecimiento
                ;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAñoNacimiento() {
        return añoNacimiento;
    }

    public void setAñoNacimiento(int añoNacimiento) {
        this.añoNacimiento = añoNacimiento;
    }

    public int getAñoFallecimiento() {
        return añoFallecimiento;
    }

    public void setAñoFallecimiento(int añoFallecimiento) {
        this.añoFallecimiento = añoFallecimiento;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}
