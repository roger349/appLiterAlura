package com.rer.appLiterAlura.Interfaces;

import com.rer.appLiterAlura.Model.autoresBd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorRepository extends JpaRepository<autoresBd, Integer> {

    @Query("SELECT a FROM autoresBd a")
    List<autoresBd> findAllAutores();

   /* @Query("select a from Author a where  a.birth_year<=:year and a.death_year>=:year")
    List<autoresBd> findbyFecha(Integer year);
    @Query("select a from Author a where a.author_name ilike %:author_name%")
    List<autoresBd> findautorbyNombre_autor(String nombre_autor);
    @Query("select a from Author a where a.birth_year=:year")
    List<autoresBd> findautorbyAño_nacimiento(Integer year);
    @Query("select a from Author a where a.año_fallecimiento=:año")
    List<autoresBd> findautorbyAño_fallecimiento(Integer year);*/
}

