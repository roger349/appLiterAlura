package com.rer.appLiterAlura.Interfaces;

import com.rer.appLiterAlura.Model.autoresBd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface AutorRepository extends JpaRepository<autoresBd, Integer> {

    //@Query("select a from autoresBd a where a.nombre_autor ilike %:nombre_autor%")

    default boolean existsByNombreAutor(String nombre_autor) {
        return false;
    }
    @Query("SELECT a FROM autoresBd a")
    List<autoresBd> findAllAutores();
    @Query("select a from autoresBd a where :año >= a.año_nacimiento and :año <= a.año_fallecimiento")
    List<autoresBd> findbyAño(Integer año);
    //@Query("select a from autoresBd a where lower(a.nombre_autor) like lower(concat('%', :nombre_autor, '%'))")
    //default List<autoresBd> findByNombreAutorContainingIgnoreCase(String nombre_autor) {return null;}
    //@Query("select a from LibrosBd a where a.nombre_autor ilike %:nombre_autor%")
    default List<autoresBd> findByNombre_autor(String nombre_autor) {return null;}
}

