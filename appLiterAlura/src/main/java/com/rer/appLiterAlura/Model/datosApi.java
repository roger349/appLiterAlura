package com.rer.appLiterAlura.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record datosApi(
   @JsonAlias("results")
   List<datosLibApi> resultados) {}
