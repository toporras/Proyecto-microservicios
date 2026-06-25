package com.example.ms_usuario.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.ms_usuario.client.*;
import com.example.ms_usuario.model.DTO.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class UsuarioServiceTest {

    @Autowired
    private UsuarioService usuarioService;

    @MockBean
    private EquipoFeignClient equipoFeignClient;

    @MockBean
    private JugadorFeignClient jugadorFeignClient;

    @MockBean
    private PartidoFeignClient partidoFeignClient;

    @MockBean
    private EstadioFeignClient estadioFeignClient;

    @MockBean
    private EntrenadorFeignClient entrenadorFeignClient;

    @MockBean
    private TorneoFeignClient torneoFeignClient;

    @Test
    public void testObtenerEquipo() {
        Integer id = 1;
        EquipoDTO equipoDTO = new EquipoDTO();

        when(equipoFeignClient.obtenerEquipo(id)).thenReturn(equipoDTO);

        EquipoDTO result = usuarioService.obtenerEquipo(id);

        assertNotNull(result);
    }

    @Test
    public void testObtenerJugador() {
        Integer id = 1;
        JugadorDTO jugadorDTO = new JugadorDTO();

        when(jugadorFeignClient.obtenerJugador(id)).thenReturn(jugadorDTO);

        JugadorDTO result = usuarioService.obtenerJugador(id);

        assertNotNull(result);
    }

    @Test
    public void testObtenerPartido() {
        Integer id = 1;
        PartidoDTO partidoDTO = new PartidoDTO();

        when(partidoFeignClient.obtenerPartido(id)).thenReturn(partidoDTO);

        PartidoDTO result = usuarioService.obtenerPartido(id);

        assertNotNull(result);
    }

    @Test
    public void testObtenerEstadio() {
        Integer id = 1;
        EstadioDTO estadioDTO = new EstadioDTO();

        when(estadioFeignClient.obtenerEstadio(id)).thenReturn(estadioDTO);

        EstadioDTO result = usuarioService.obtenerEstadio(id);

        assertNotNull(result);
    }

    @Test
    public void testObtenerEntrenador() {
        Integer id = 1;
        EntrenadorDTO entrenadorDTO = new EntrenadorDTO();

        when(entrenadorFeignClient.obtenerEntrenador(id)).thenReturn(entrenadorDTO);

        EntrenadorDTO result = usuarioService.obtenerEntrenador(id);

        assertNotNull(result);
    }

    @Test
    public void testObtenerTorneo() {
        Integer id = 1;
        TorneoDTO torneoDTO = new TorneoDTO();

        when(torneoFeignClient.obtenerTorneo(id)).thenReturn(torneoDTO);

        TorneoDTO result = usuarioService.obtenerTorneo(id);

        assertNotNull(result);
    }
}