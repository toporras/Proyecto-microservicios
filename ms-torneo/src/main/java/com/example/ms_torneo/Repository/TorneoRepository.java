package com.example.ms_torneo.Repository;

import com.example.ms_torneo.Model.Torneo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TorneoRepository extends JpaRepository<Torneo, Integer> {
}
