package com.rer.appLiterAlura.Interfaces;

import com.rer.appLiterAlura.Model.LibrosBd;
import com.rer.appLiterAlura.Model.autoresBd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<LibrosBd, Integer> {
    @Query("select exists (select 1 from LibrosBd where titulo = :titulo)")
    boolean existsByTitulo(String titulo);
    @Query("select l from LibrosBd l")
    List<LibrosBd> findAllLibros();
    @Query("select l from LibrosBd l where l.idioma = :idioma")
    List<LibrosBd> findByIdioma(String idioma);
}


