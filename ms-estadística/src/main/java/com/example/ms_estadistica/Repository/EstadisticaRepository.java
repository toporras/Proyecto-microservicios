package com.example.ms_estadistica.Repository;

import com.example.ms_estadistica.Model.Estadistica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadisticaRepository extends JpaRepository<Estadistica, Integer> {
}
