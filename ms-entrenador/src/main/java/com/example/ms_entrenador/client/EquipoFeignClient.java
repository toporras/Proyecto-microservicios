package com.example.ms_entrenador.client;

import com.example.ms_entrenador.model.DTO.EquipoDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "ms-equipo", url = "http://localhost:8081")
public interface EquipoFeignClient {

    @GetMapping("/equipos/{id}")
    EquipoDTO obtenerEquipoPorId(@PathVariable("id") Integer id);
}
