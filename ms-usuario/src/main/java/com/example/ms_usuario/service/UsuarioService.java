package com.example.ms_usuario.service;


import com.example.ms_usuario.client.*;
import com.example.ms_usuario.model.DTO.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private EquipoFeignClient equipoFeignClient;

    @Autowired
    private JugadorFeignClient jugadorFeignClient;

    @Autowired
    private PartidoFeignClient partidoFeignClient;

    @Autowired
    private EstadioFeignClient estadioFeignClient;

    @Autowired
    private EntrenadorFeignClient entrenadorFeignClient;

    @Autowired
    private TorneoFeignClient torneoFeignClient;

    public EquipoDTO obtenerEquipo(Integer id){
        return equipoFeignClient.obtenerEquipo(id);
    }

    public JugadorDTO obtenerJugador(Integer id){
        return jugadorFeignClient.obtenerJugador(id);
    }

    public PartidoDTO obtenerPartido(Integer id){
        return partidoFeignClient.obtenerPartido(id);
    }

    public EstadioDTO obtenerEstadio(Integer id){
        return estadioFeignClient.obtenerEstadio(id);
    }

    public EntrenadorDTO obtenerEntrenador(Integer id){
        return entrenadorFeignClient.obtenerEntrenador(id);
    }
    public TorneoDTO obtenerTorneo(Integer id){
        return torneoFeignClient.obtenerTorneo(id);
    }
}