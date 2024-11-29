package com.rer.appLiterAlura.Interfaces;

import com.rer.appLiterAlura.Model.autoresBd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorRepository extends JpaRepository<autoresBd, Integer> {

    @Query("SELECT a FROM autoresBd a")
    List<autoresBd> findAllAutores();
    @Query("select a from autoresBd a where :año >= a.año_nacimiento and :año <= a.año_fallecimiento")
    List<autoresBd> findbyAño(Integer año);

}

