package com.rer.appLiterAlura.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="autoresBd")
public class autoresBd {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false,unique = true)
    @JdbcTypeCode(SqlTypes.INTEGER)
    public Integer id;
    @Column(name = "nombre_autor", nullable = false)
    public String nombre_autor;
    @Column(name = "año_nacimiento", nullable = true)
    public int año_nacimiento;
    @Column(name = "año_fallecimiento", nullable = true)
    public int año_fallecimiento;
    @OneToMany(mappedBy = "autor_libro",cascade = CascadeType.PERSIST)
    public List<LibrosBd> libros = new ArrayList<>();

    public autoresBd() {
    }
    public autoresBd(String nombre_autor, int año_nacimiento, int año_fallecimiento) {
        this.nombre_autor = nombre_autor;
        this.año_nacimiento = año_nacimiento;
        this.año_fallecimiento = año_fallecimiento;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre_autor() {
        return nombre_autor;
    }
    public void setNombre_autor(String nombre_autor) {
        this.nombre_autor = nombre_autor;
    }
    public int getAño_nacimiento() {
        return año_nacimiento;
    }
    public void setAño_nacimiento(int año_nacimiento) {
        this.año_nacimiento = año_nacimiento;
    }
    public int getAño_fallecimiento() {
        return año_fallecimiento;
    }
    public void setAño_fallecimiento(int año_fallecimiento) {
        this.año_fallecimiento = año_fallecimiento;
    }
    public List<LibrosBd> getLibros() {return libros;}
    public void setLibros(List<LibrosBd> libros) {this.libros = libros;}
}
