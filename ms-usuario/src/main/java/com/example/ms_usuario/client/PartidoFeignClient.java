package com.example.ms_usuario.client;

import com.example.ms_usuario.model.DTO.PartidoDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="partido-client", url="http://localhost:8083")
public interface PartidoFeignClient {

    @GetMapping("/partidos/{id}")
    PartidoDTO obtenerPartido(@PathVariable("id") Integer id);
}