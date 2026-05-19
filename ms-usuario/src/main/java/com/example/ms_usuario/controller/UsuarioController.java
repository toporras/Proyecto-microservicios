package com.example.ms_usuario.controller;

import com.example.ms_usuario.model.DTO.*;
import com.example.ms_usuario.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/equipo/{id}")
    public EquipoDTO obtenerEquipo(@PathVariable Integer id){
        return service.obtenerEquipo(id);
    }

    @GetMapping("/jugador/{id}")
    public JugadorDTO obtenerJugador(@PathVariable Integer id){
        return service.obtenerJugador(id);
    }

    @GetMapping("/partido/{id}")
    public PartidoDTO obtenerPartido(@PathVariable Integer id){
        return service.obtenerPartido(id);
    }

    @GetMapping("/estadio/{id}")
    public EstadioDTO obtenerEstadio(@PathVariable Integer id){
        return service.obtenerEstadio(id);
    }

    @GetMapping("/entrenador/{id}")
    public EntrenadorDTO obtenerEntrenador(@PathVariable Integer id){
        return service.obtenerEntrenador(id);
    }
    @GetMapping("/torneo/{id}")
    public TorneoDTO obtenerTorneo(@PathVariable Integer id){
        return service.obtenerTorneo(id);
}
}