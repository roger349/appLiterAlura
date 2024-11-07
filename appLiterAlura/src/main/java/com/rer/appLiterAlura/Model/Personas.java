package com.rer.appLiterAlura.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Personas {

     @JsonAlias("name")
     public String nombre;
     @JsonAlias("birth_year")
     public float año_nacimiento;
     @JsonAlias("death_year")
     public float año_fallecimiento;

     public Personas() {
     }

     public Personas(String nombre, float año_nacimiento, float año_fallecimiento) {
        this.nombre = nombre;
        this.año_nacimiento = año_nacimiento;
        this.año_fallecimiento = año_fallecimiento;
     }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getAño_nacimiento() {
        return año_nacimiento;
    }

    public void setAño_nacimiento(float año_nacimiento) {
        this.año_nacimiento = año_nacimiento;
    }

    public float getAño_fallecimiento() {
        return año_fallecimiento;
    }

    public void setAño_fallecimiento(float año_fallecimiento) {
        this.año_fallecimiento = año_fallecimiento;
    }
}
