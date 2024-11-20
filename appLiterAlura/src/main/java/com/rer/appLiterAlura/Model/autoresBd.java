package com.rer.appLiterAlura.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name="autoresBd")
public class autoresBd {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false,unique = true)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Integer id;
    @Column(name = "nombre_autor", nullable = false)
    private String nombre_autor;
    @Column(name = "año_nacimiento", nullable = true)
    private int año_nacimiento;
    @Column(name = "año_fallecimiento", nullable = true)
    private int año_fallecimiento;

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
}
