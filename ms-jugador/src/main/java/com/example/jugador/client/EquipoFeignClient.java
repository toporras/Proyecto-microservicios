package com.example.jugador.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.jugador.model.DTO.EquipoDTO;



@FeignClient(name = "equipo", url = "http://localhost:8081")
public interface EquipoFeignClient {

    @GetMapping("/equipos")
    List<EquipoDTO> listarEquipos();

    @GetMapping("/equipos/{id}")
    EquipoDTO obtenerEquipoPorId(@PathVariable("id") Integer id);
}


