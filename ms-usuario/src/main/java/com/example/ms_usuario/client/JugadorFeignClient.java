package com.example.ms_usuario.client;

import com.example.ms_usuario.model.DTO.JugadorDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="ms-jugador", url="http://localhost:8082")
public interface JugadorFeignClient {

    @GetMapping("/jugadores/{id}")
    JugadorDTO obtenerJugador(@PathVariable("id") Integer id);
}