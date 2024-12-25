package com.rer.appLiterAlura.Interfaces;

import com.rer.appLiterAlura.Model.autoresBd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<autoresBd, Integer> {
    @Query("select a from autoresBd a where a.nombre_autor = :nombre_autor")
    autoresBd findByNombre_autor(@Param("nombre_autor") String nombre_autor);
    @Query("select exists (select 1 from autoresBd where nombre_autor = :nombre_autor)")
    boolean existsByNombre_autor(@Param("nombre_autor") String nombre_autor);
    @Query("SELECT a FROM autoresBd a")
    List<autoresBd> findAllAutores();
    @Query("select a from autoresBd a where :año >= a.año_nacimiento and :año <= a.año_fallecimiento")
    List<autoresBd> findbyAño(Integer año);
    @Query("select a from autoresBd a join fetch a.libros where lower(a.nombre_autor) ilike %:nombre_autor%")
    Optional<autoresBd> findByNombre_autorContainingIgnoreCase(@Param("nombre_autor") String nombre_autor);
}

