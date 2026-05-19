package com.example.ms_usuario.client;

import com.example.ms_usuario.model.DTO.EstadioDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="ms-estadio", url="http://localhost:8084")
public interface EstadioFeignClient {

    @GetMapping("/estadios/{id}")
    EstadioDTO obtenerEstadio(@PathVariable("id") Integer id);
}