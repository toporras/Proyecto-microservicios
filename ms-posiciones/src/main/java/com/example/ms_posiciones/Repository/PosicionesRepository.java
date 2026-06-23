package com.example.ms_posiciones.Repository;

import com.example.ms_posiciones.Model.Posiciones;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PosicionesRepository extends JpaRepository<Posiciones,Integer> {
}
