package com.rer.appLiterAlura.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LibroApi {

    @JsonAlias("title")
    public String titulo;
    @JsonAlias("authors")
    public ArrayList<Personas> autores = new ArrayList<Personas>();
    @JsonAlias("languages")
    public ArrayList<String> lenguajes = new ArrayList<String>();
    @JsonAlias("download_count")
    public float numero_descargas;

    public LibroApi() {
    }
    public LibroApi(String titulo, ArrayList<Personas> autores, ArrayList<String> lenguajes, float numero_descargas) {
        this.titulo = titulo;
        this.autores = autores;
        this.lenguajes = lenguajes;
        this.numero_descargas = numero_descargas;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public ArrayList<Personas> getAutores() {
        return autores;
    }
    public void setAutores(ArrayList<Personas> autores) {
        this.autores = autores;
    }
    public ArrayList<String> getLenguajes() {
        return lenguajes;
    }
    public void setLenguajes(ArrayList<String> lenguajes) {
        this.lenguajes = lenguajes;
    }
    public float getNumero_descargas() {
        return numero_descargas;
    }
    public void setNumero_descargas(float numero_descargas) {
        this.numero_descargas = numero_descargas;
    }
}
