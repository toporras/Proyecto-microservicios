package com.example.ms_usuario.client;

import com.example.ms_usuario.model.DTO.EntrenadorDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="ms-entrenador", url="http://localhost:8085")
public interface EntrenadorFeignClient {

    @GetMapping("/entrenadores/{id}")
    EntrenadorDTO obtenerEntrenador(@PathVariable("id") Integer id);
}