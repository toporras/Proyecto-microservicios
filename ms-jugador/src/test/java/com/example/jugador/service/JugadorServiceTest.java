package com.example.jugador.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.*;

import org.junit.jupiter.api.*;
import org.mockito.*;

import com.example.jugador.client.EquipoFeignClient;
import com.example.jugador.model.Jugador;
import com.example.jugador.model.DTO.EquipoDTO;
import com.example.jugador.repository.JugadorRepository;

public class JugadorServiceTest {

    @Mock
    private JugadorRepository jugadorRepository;

    @Mock
    private EquipoFeignClient equipoFeignClient;

    @InjectMocks
    private JugadorService jugadorService;

    private Jugador jugador;

    @BeforeEach
    public void setUp() {
   
        MockitoAnnotations.openMocks(this); 
        
        jugador = new Jugador();
        jugador.setId(1);
        jugador.setNombre("Juan");
        jugador.setPosicion("Delantero");
        jugador.setEquipo_id(1);
    }

    @Test
    public void testListar() {
        when(jugadorRepository.findAll()).thenReturn(Arrays.asList(jugador));

        List<Jugador> resultado = jugadorService.listar();

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
    }

    @Test
    public void testBuscarPorId() {
        when(jugadorRepository.findById(1)).thenReturn(Optional.of(jugador));

        Jugador resultado = jugadorService.buscarPorId(1);

        assertNotNull(resultado);
        assertEquals("Juan", resultado.getNombre());
    }

    @Test
    public void testGuardar() {
        when(jugadorRepository.save(jugador)).thenReturn(jugador);

        Jugador resultado = jugadorService.guardar(jugador);

        assertNotNull(resultado);
        assertEquals("Juan", resultado.getNombre());
    }

    @Test
    public void testActualizar() {
        when(jugadorRepository.findById(1)).thenReturn(Optional.of(jugador));
        when(jugadorRepository.save(jugador)).thenReturn(jugador);

        Jugador resultado = jugadorService.actualizar(1, jugador);

        assertNotNull(resultado);
        assertEquals("Juan", resultado.getNombre());
    }

    @Test
    public void testEliminar() {
        jugadorService.eliminar(1);
        
        verify(jugadorRepository).deleteById(1);
    }

    @Test
    public void testObtenerEquipo() {
        EquipoDTO equipoDTO = new EquipoDTO();
        when(equipoFeignClient.obtenerEquipoPorId(1)).thenReturn(equipoDTO);

        EquipoDTO resultado = jugadorService.obtenerEquipo(1);

        assertNotNull(resultado);
    }
}