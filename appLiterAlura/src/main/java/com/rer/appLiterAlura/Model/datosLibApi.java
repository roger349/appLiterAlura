package com.rer.appLiterAlura.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record datosLibApi(
        @JsonAlias("title")
        String titulo,
        @JsonAlias("authors")
        String autores,
        @JsonAlias("languages")
        String idiomas,
        @JsonAlias("download_count")
        float numero_descargas) {}
