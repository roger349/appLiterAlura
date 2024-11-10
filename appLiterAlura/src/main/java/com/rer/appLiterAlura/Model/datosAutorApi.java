package com.rer.appLiterAlura.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record datosAutorApi(
        @JsonAlias("name")
        String nombre,
        @JsonAlias("birth_year")
        Integer año_nacimiento,
        @JsonAlias("death_year")
        Integer año_fallecimiento) {}
