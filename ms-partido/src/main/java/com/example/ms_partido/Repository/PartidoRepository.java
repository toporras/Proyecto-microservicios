package com.example.ms_partido.Repository;

import com.example.ms_partido.Model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartidoRepository extends JpaRepository<Partido, Integer> {
}
