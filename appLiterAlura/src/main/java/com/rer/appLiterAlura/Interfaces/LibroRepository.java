package com.rer.appLiterAlura.Interfaces;

import com.rer.appLiterAlura.Model.LibrosBd;
import com.rer.appLiterAlura.Model.autoresBd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<LibrosBd, Integer> {
    boolean existsByTitulo(String titulo);
    @Query("select a from LibrosBd a")
    List<LibrosBd> findAllLibros();
    @Query("select i from LibrosBd i where i.idioma = :idioma")
    List<LibrosBd> findByIdioma(String idioma);
    // @Query("select l from LibrosBd l order by l.numero_descargas desc limit 10")
    @Query("select l from LibrosBd l where l.autor ilike %:nombre%")
    List<LibrosBd> findByAutor(String nombre);
}


