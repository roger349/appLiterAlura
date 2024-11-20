package com.rer.appLiterAlura.Interfaces;

import com.rer.appLiterAlura.Model.autoresBd;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<autoresBd, Integer> {
}

