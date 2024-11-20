package com.rer.appLiterAlura.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rer.appLiterAlura.Model.*;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class serviciosApiG {

    public datosApi buscarLibApi(String titulo) throws Exception {

        String direccion = "https://gutendex.com/books?search=" + titulo;



        HttpClient client = HttpClient.newBuilder().followRedirects(HttpClient.Redirect.NORMAL).build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion)).header("User-Agent", "My Java Application")
                .header("Accept", "application/json").build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        ObjectMapper mapper = new ObjectMapper();
        datosApi da = mapper.readValue(json, datosApi.class);
        return da;
    }
}
