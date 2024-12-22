package com.rer.appLiterAlura.MenuLibro;

import com.rer.appLiterAlura.Interfaces.AutorRepository;
import com.rer.appLiterAlura.Interfaces.LibroRepository;
import com.rer.appLiterAlura.Model.LibrosBd;
import com.rer.appLiterAlura.Model.autoresBd;
import com.rer.appLiterAlura.Model.datosApi;
import com.rer.appLiterAlura.Services.serviciosApiG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class Menu {
    Scanner sc = new Scanner(System.in);
    @Autowired
    LibroRepository libroRepo;
    @Autowired
    AutorRepository autorRepo;
    public void menuOpciones() {
        boolean salir = false;
        while(!salir){
                        System.out.println("=========" +         "\n" +
                        "Elige una opción:                        \n" +
                        "1:  Buscar libro por titulo              \n" +
                        "2:  Listar libros registrados            \n" +
                        "3:  Listar autores registrados           \n" +
                        "4:  Listar autores vivos por año         \n" +
                        "5:  Listar libros por idioma             \n" +
                        "6:  Listar top 10 libros mas descargados \n" +
                        "7:  Listar libros por nombre de autor    \n" +
                        "8:  otras consultas                      \n" +
                        "0.- Salir\n=========");

                int opcion= Integer.parseInt(sc.nextLine());
                switch(opcion){
                    case 1:
                        buscarLibro();
                        break;
                    case 2:
                        listarLibros();
                        break;
                    case 3:
                        listarAutores();
                        break;
                    case 4:
                        listarAutoresVivos();
                        break;
                    case 5:
                        listarLibrosPorIdioma();
                        break;
                    case 6:
                        listarTop10();
                        break;
                    case 7:
                        listarLibrosPorNombreAutor();
                        break;
                    case 8:
                        otrasConsultas();
                        break;
                    case 0:
                        salir = true;
                        break;
                    default:
                        System.out.println("Número Invalido");
                        break;
                }
        }
    }
    public void buscarLibro() {
        boolean salir = false;
        while(!salir) {

            System.out.println("Elige una opción:            \n" +
                    "1: ingresar titulo para buscar el libro \n" +
                    "s: volver menu principal                ");
            String opcion=sc.nextLine();

          if(!"s".equals(opcion)) {
              System.out.println("Ingrese el titulo del libro: ");
              String titulo = sc.nextLine().toUpperCase().replace(" ", "%20");
              try {
                  serviciosApiG serv = new serviciosApiG();
                  datosApi da = serv.buscarLibApi(titulo);

                  if (da.resultados() != null && !da.resultados().isEmpty()) {
                      String tituloLibroapi = da.resultados().get(0).titulo();
                      String autor = da.resultados().get(0).autor().get(0).nombre();
                      Integer añoNac = da.resultados().get(0).autor().get(0).año_nacimiento();
                      Integer añoFall = da.resultados().get(0).autor().get(0).año_fallecimiento();
                      String idioma = da.resultados().get(0).idiomas().get(0);
                      float numeroDescargas = da.resultados().get(0).numero_descargas();
                      LibrosBd librosBd = new LibrosBd(tituloLibroapi, autor, idioma, numeroDescargas);
                      autoresBd autorBd = new autoresBd(autor, añoNac, añoFall);
                      librosBd.setAutor_libro(autorBd);
                      if (!libroRepo.existsByTitulo(tituloLibroapi)) {
                            if (!autorRepo.existsByNombreAutor(autor)) {
                              autorRepo.save(autorBd);
                              System.out.println("autor guardado");
                              System.out.println("autor: " + autor + "; año nacimiento: " + añoNac
                                      + "; año fallecimiento: " + añoFall);
                            }
                            else {
                              System.out.println("El autor ya existe");
                            }
                       libroRepo.save(librosBd);
                       System.out.println("Libro guardado");
                       System.out.println("titulo: " + tituloLibroapi + "; autor: " + autor + "; idioma: "
                                  + idioma + "; numero de descargas: " + numeroDescargas);
                      }
                      else {
                          System.out.println("El libro ya existe");
                      }
                  }
                  else {
                      System.out.println("No se encontraron resultados");
                  }
              } catch (Exception e) {
                  System.out.println("Error al buscar libro ");
              }
          }
          else {
              salir=true;
          }
        }
    }
    public void listarLibros() {
            boolean b=true;
            List<LibrosBd> librosBd = libroRepo.findAllLibros();
            for (LibrosBd libro : librosBd) {
                if(b){
                    System.out.println("Libros Registrados por Titulo: \t");
                    b=false;
                }
                int nd= (int) libro.getNumero_descarga();
                System.out.printf("%s\n",libro.getTitulo());
        }
    }
    public void listarAutores() {
        boolean b=true;
        List<autoresBd> autoresBd = autorRepo.findAllAutores();
        for (autoresBd autor : autoresBd) {
            if(b){
                System.out.println("Libros Registrados por Autor: \t");
                b=false;
            }
            System.out.printf("%s\n",autor.getNombre_autor());
        }
    }
    public void listarAutoresVivos() {
        boolean salir = false;
        while(!salir) {
            System.out.println("Elige una opción:            \n" +
                    "1: ingresar el año:                     \n" +
                    "s: volver menu principal                ");
            String opcion=sc.nextLine();
            if(!"s".equals(opcion)) {
                System.out.println("ingrese el año: ");
                String op=sc.nextLine();
                Integer año = Integer.valueOf(op);
                boolean b = true;
                List<autoresBd> autoresBd = autorRepo.findbyAño(año);
                if (!autoresBd.isEmpty()) {
                    for (autoresBd autor : autoresBd) {
                        if (b) {
                            System.out.println("Libros Registrados por Autores vivos en un determinado año: \t");
                            b = false;
                        }
                        System.out.printf("%s\n", autor.getNombre_autor());
                    }
                } else {
                    System.out.println("Año sin resultados");
                }
            }
            else {
                salir=true;
            }
        }
    }
    public void listarLibrosPorIdioma(){
        boolean salir = false;
        while(!salir) {
            System.out.println("Elige una opción: \n" +
                    "en: ingles                   \n" +
                    "fr: frances                  \n" +
                    "es: español                  \n" +
                    "s : volver menu principal");
            String opcion = sc.nextLine();
            if(!"s".equals(opcion)) {
                List<LibrosBd> librosBd = libroRepo.findByIdioma(opcion);
                boolean b = true;
                if (!librosBd.isEmpty()) {
                    for (LibrosBd libro : librosBd) {
                        if (b) {
                            System.out.println("Listado de libros por idioma: \t");
                            b = false;
                        }
                        System.out.println("Titulo: " + libro.getTitulo() + "      Idioma:" + libro.getIdioma());
                    }
                } else {
                    System.out.println("Idioma no disponible");
                }
            }
            else{
               salir=true;
            }
        }
    }
    public void listarTop10(){
        List<LibrosBd> librosBd=libroRepo.findAllLibros();
        librosBd.stream().sorted(Comparator.comparing(LibrosBd::getNumero_descarga).reversed()).limit(10)
                .forEach(libro -> System.out.println("Título: " + libro.getTitulo() + ", Descargas: "
                        + libro.getNumero_descarga()));

    }
    public void listarLibrosPorNombreAutor(){
        boolean salir = false;
        while(!salir) {
            System.out.println("Elige una opción:            \n" +
                    "1: ingresar el nombre del autor          \n" +
                    "s: volver menu principal                ");
            String opcion = sc.nextLine();
            if (!"s".equals(opcion)) {
                System.out.println("ingrese el nombre del autor: ");
                String nombre=sc.nextLine();
                List<autoresBd> autores = autorRepo.findByNombre_autor(nombre);
                if (!autores.isEmpty()) {
                    for (autoresBd autor : autores) {
                        List<LibrosBd> libros = autor.getLibros();
                        if (!libros.isEmpty()) {
                            System.out.println("Libros del autor " + autor.getNombre_autor() + ":");
                            for (LibrosBd libro : libros) {
                                System.out.println(libro.getTitulo());
                            }
                        }
                        else {
                            System.out.println("No se encontraron libros del autor " + opcion);
                        }
                    }
                }
                else {
                    System.out.println("No se encontraron autores con el nombre " + opcion);
                }
            } else {
                salir = true;
            }
        }
    }
    public void otrasConsultas(){
        boolean salir = false;
        while(!salir) {
            System.out.println("Elige una opción:       \n" +
                    "1: promedio de libros descargados  \n" +
                    "2: libro mas leido                 \n" +
                    "3: libro menos leido               \n" +
                    "s: volver menu principal            ");
            String opcion = sc.nextLine();
            if(!"s".equals(opcion)){
                List<LibrosBd> libroBd = libroRepo.findAllLibros();
                if (!libroBd.isEmpty()) {
                    if("1".equals(opcion)){
                        Double promedio = libroBd.stream().collect(Collectors
                                          .averagingDouble(LibrosBd::getNumero_descarga));
                        System.out.println("Promedio de libros descargados: " + promedio);
                    }
                    if("2".equals(opcion)){
                        Optional<LibrosBd> libroMenosLeido = libroBd.stream()
                                .filter(libro -> libro.getNumero_descarga() != 0.0)
                                .max(Comparator.comparingDouble(LibrosBd::getNumero_descarga));
                            System.out.println("El libro mas leído es: " + libroMenosLeido.get().getTitulo());
                    }
                    if("3".equals(opcion)){
                        Optional<LibrosBd> libroMenosLeido = libroBd.stream()
                                .filter(libro -> libro.getNumero_descarga() != 0.0)
                                .min(Comparator.comparingDouble(LibrosBd::getNumero_descarga));
                        System.out.println("El libro menos leído es: " + libroMenosLeido.get().getTitulo());
                    }
                }
                else{
                    System.out.println("Busqueda sin resultados");
                }
            }
            else {
               salir=true;
            }
        }
    }
}

