package com.rer.appLiterAlura.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name="LibrosBd")
public class LibrosBd {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.FLOAT)
    private Integer id;
    @Column(name = "titulo", nullable = false)
    public String titulo;
    @Column(name = "autor", nullable = false)
    public String autor;
    @Column(name = "idioma", nullable = false)
    public String idioma;
    @Column(name = "numero_descarga", nullable = false)
    public float numero_descarga;

    public LibrosBd() {
    }
    public LibrosBd(String titulo, String autor, String idioma, float numero_descarga) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.idioma = idioma;
        this.numero_descarga = numero_descarga;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getIdioma() {
        return idioma;
    }
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    public float getNumero_descarga() {
        return numero_descarga;
    }
    public void setNumero_descarga(float numero_descarga) {
        this.numero_descarga = numero_descarga;
    }
}
