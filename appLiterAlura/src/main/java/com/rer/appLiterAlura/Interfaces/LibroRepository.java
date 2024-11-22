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
    @Query("SELECT a FROM LibrosBd a")
    List<LibrosBd> findAllLibros();
}


