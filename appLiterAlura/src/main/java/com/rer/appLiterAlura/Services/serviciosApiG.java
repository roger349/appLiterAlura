package com.rer.appLiterAlura.Services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.rer.appLiterAlura.Model.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class serviciosApiG {
    public LibrosBd librosBd;
    private final ObjectMapper mapper = new ObjectMapper();
    private JsonNode jsonApi;

    public void datosLibApi() throws JsonProcessingException {
        /*String Titulo=titulo.replace(" ", "%20");*/
        String direccion = "https://gutendex.com/books/";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(direccion)).build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        String json = response.body();
        jsonApi = mapper.readTree(json);
        // Datos de libros
        JsonNode resultados = jsonApi.get("results");
        ArrayNode array = (ArrayNode) resultados;
        datosLibApi[] datoslibApi = new datosLibApi[array.size()];

        for (int i = 0; i < array.size(); i++) {
            JsonNode libroApi = array.get(i);
            // Tomar solo el primer autor
            JsonNode autoresApi = libroApi.get("authors");
            String autorApi;
            if (autoresApi != null && autoresApi.size() > 0) {
                autorApi = autoresApi.get(0).get("name").asText();
                int año_nacimiento = autoresApi.get(0).get("birth_year").asInt();
                int año_fallecimiento = autoresApi.get(0).get("death_year").asInt();
                autoresBd autorBd = new autoresBd(autorApi,año_nacimiento,año_fallecimiento);
            } else {
                System.out.println("libro sin autores");
                autorApi ="Sin Autores";
                int año_nacimiento = 0;
                int año_fallecimiento = 0;
                autoresBd autorBd = new autoresBd(autorApi, año_nacimiento, año_fallecimiento);
            }
            // Tomar solo el primer idioma
            JsonNode idiomasApi = libroApi.get("languages");
            String idiomaA = idiomasApi.get(0).asText();
            // Datos del libro
            String titulo=libroApi.get("title").asText();
            int numero_descarga=libroApi.get("download_count").asInt();
            datosLibApi datoslibroApi = new datosLibApi(titulo,autorApi,idiomaA,numero_descarga);
            LibrosBd librosBd = new LibrosBd(titulo,autorApi,idiomaA,numero_descarga);
            System.out.println("titulo: " + librosBd.getTitulo() + "; autor: " + librosBd.getAutor() + "; idioma: "
                               + librosBd.getIdioma() + "; numero de descargas: " + librosBd.getNumero_descarga());
            datoslibApi[i] = datoslibroApi;
            System.out.println(datoslibApi[i].toString());
        }
    }
}
