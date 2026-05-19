package com.example.ms_usuario.client;

import com.example.ms_usuario.model.DTO.EquipoDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="ms-equipo", url="http://localhost:8081")
public interface EquipoFeignClient {

    @GetMapping("/equipos/{id}")
    EquipoDTO obtenerEquipo(@PathVariable("id") Integer id);
}