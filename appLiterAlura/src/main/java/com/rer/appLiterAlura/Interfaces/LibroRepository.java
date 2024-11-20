package com.rer.appLiterAlura.Interfaces;

import com.rer.appLiterAlura.Model.LibrosBd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibroRepository extends JpaRepository<LibrosBd, Integer> {

}


