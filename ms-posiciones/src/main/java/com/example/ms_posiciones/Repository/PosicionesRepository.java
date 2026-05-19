package com.example.ms_posiciones.Repository;

import com.example.ms_posiciones.Model.Posiciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosicionesRepository extends JpaRepository<Posiciones,Integer> {
}
