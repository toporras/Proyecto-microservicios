package com.example.ms_usuario.client;

import com.example.ms_usuario.model.DTO.TorneoDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="torneo-client", url="http://localhost:8089")
public interface TorneoFeignClient {

    @GetMapping("/torneos/{id}")
    TorneoDTO obtenerTorneo(@PathVariable("id") Integer id);

}
