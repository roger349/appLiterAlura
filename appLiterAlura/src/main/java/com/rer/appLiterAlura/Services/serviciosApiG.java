package com.rer.appLiterAlura.Services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rer.appLiterAlura.Model.LibroApi;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class serviciosApiG {
    private LibroApi libApi;
    private ObjectMapper mapper = new ObjectMapper();

    public void datosLibApi() throws JsonProcessingException {
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
        System.out.println(json);
        try {
            libApi = mapper.readValue(json, LibroApi.class);
            System.out.println(libApi);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    public void buscarPorTitulo(String titulo){
    }
}
