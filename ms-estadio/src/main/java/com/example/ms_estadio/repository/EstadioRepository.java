package com.example.ms_estadio.repository;


import com.example.ms_estadio.model.Estadio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadioRepository extends JpaRepository<Estadio,Integer> {
}