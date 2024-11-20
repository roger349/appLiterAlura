package com.rer.appLiterAlura.MenuLibro;

import com.rer.appLiterAlura.Interfaces.AutorRepository;
import com.rer.appLiterAlura.Interfaces.LibroRepository;
import com.rer.appLiterAlura.Model.LibrosBd;
import com.rer.appLiterAlura.Model.autoresBd;
import com.rer.appLiterAlura.Model.datosApi;
import com.rer.appLiterAlura.Services.serviciosApiG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class Menu {
    Scanner sc = new Scanner(System.in);
    @Autowired
    LibroRepository libroRepo;
    @Autowired
    AutorRepository autorRepo;
    public void menuOpciones() throws Exception {
        boolean salir = false;
        while(!salir){
                        System.out.println("=============" + "\n" +
                        "Elige una opción:\n" +
                        "1.- Buscar libro por titulo" + "\n" +
                        "2.- Listar libros registrados    \n" +
                        "3.- Listar autores registrados   \n" +
                        "4.- Listar autores vivos por año \n" +
                        "5.- Listar libros por idioma     \n" +
                        "0.- Salir\n=============");

                int opcion= Integer.parseInt(sc.nextLine());
                switch(opcion){
                    case 1:
                        buscarLibro();
                        break;
                    case 2:
                        System.out.println("salida 2");
                        break;
                    case 3:
                        System.out.println("salida 3");
                        break;
                    case 4:
                        System.out.println("salida 4");
                        break;
                    case 5:
                        System.out.println("salida 5");
                        break;
                    case 0:
                        salir = true;
                        System.out.println("salida 0");
                        break;
                    default:
                        System.out.println("Número Invalido");
                        break;
                }
        }
    }
    public void buscarLibro() {

        System.out.println("Ingrese titulo del libro: ");
        String titulo = sc.nextLine().toUpperCase().replace(" ", "%20");

        try {
            serviciosApiG serv = new serviciosApiG();
            datosApi da = serv.buscarLibApi(titulo);

            if (da.resultados() != null && !da.resultados().isEmpty()) {
                String tituloLibroapi=da.resultados().get(0).titulo();
                String autor =da.resultados().get(0).autor().get(0).nombre();
                Integer añoNac =da.resultados().get(0).autor().get(0).año_nacimiento();
                Integer añoFall =da.resultados().get(0).autor().get(0).año_fallecimiento();
                String idioma = da.resultados().get(0).idiomas().get(0);
                float numeroDescargas=da.resultados().get(0).numero_descargas();
                LibrosBd librosBd = new LibrosBd(tituloLibroapi,autor,idioma,numeroDescargas);
                autoresBd autorBd=new autoresBd(autor,añoNac,añoFall);
                libroRepo.save(librosBd);
                autorRepo.save(autorBd);
                System.out.println("titulo: " + tituloLibroapi + "; autor: " + autor + "; idioma: " + idioma +
                                   "; numero de descargas: " + numeroDescargas);
                System.out.println("autor: " + autor + "; año nacimiento: " + añoNac + "; año fallecimiento: " + añoFall);
            } else {
                System.out.println("No se encontraron resultados");
            }
        } catch (Exception e) {
            System.out.println("Error al buscar libro: " + e.getMessage());
        }
    }
}
