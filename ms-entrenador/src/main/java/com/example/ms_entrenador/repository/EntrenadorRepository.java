package com.example.ms_entrenador.repository;

import com.example.ms_entrenador.model.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrenadorRepository extends JpaRepository<Entrenador,Integer> {
}