package com.example.ms_entrenador.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.ms_entrenador.client.EquipoFeignClient;
import com.example.ms_entrenador.model.Entrenador;
import com.example.ms_entrenador.model.DTO.EquipoDTO;
import com.example.ms_entrenador.repository.EntrenadorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class EntrenadorServiceTest {

    @Autowired
    private EntrenadorService entrenadorService;

    @MockBean
    private EntrenadorRepository entrenadorRepository;

    @MockBean
    private EquipoFeignClient equipoFeignClient;

    @Test
    public void testListar() {
        when(entrenadorRepository.findAll()).thenReturn(List.of(new Entrenador(1, "Marcelo", 50, 2)));

        List<Entrenador> entrenadores = entrenadorService.listar();

        assertNotNull(entrenadores);
        assertEquals(1, entrenadores.size());
    }

    @Test
    public void testBuscarPorId() {
        Integer id = 1;
        Entrenador entrenador = new Entrenador(id, "Marcelo", 50, 2);

        when(entrenadorRepository.findById(id)).thenReturn(Optional.of(entrenador));

        Entrenador found = entrenadorService.buscarPorId(id);

        assertNotNull(found);
        assertEquals(id, found.getId());
    }

    @Test
    public void testGuardar() {
        Entrenador entrenador = new Entrenador(1, "Marcelo", 50, 2);

        when(entrenadorRepository.save(entrenador)).thenReturn(entrenador);

        Entrenador saved = entrenadorService.guardar(entrenador);

        assertNotNull(saved);
        assertEquals("Marcelo", saved.getNombre());
    }

    @Test
    public void testObtenerEquipo() {
        Integer equipoId = 2;
        EquipoDTO equipoDTO = new EquipoDTO();

        when(equipoFeignClient.obtenerEquipoPorId(equipoId)).thenReturn(equipoDTO);

        EquipoDTO foundEquipo = entrenadorService.obtenerEquipo(equipoId);

        assertNotNull(foundEquipo);
    }

    @Test
    public void testActualizar() {
        Integer id = 1;
        Entrenador entrenadorExistente = new Entrenador(id, "Marcelo", 50, 2);
        Entrenador entrenadorNuevosDatos = new Entrenador(id, "Marcelo Actualizado", 51, 2);

        when(entrenadorRepository.findById(id)).thenReturn(Optional.of(entrenadorExistente));
        when(entrenadorRepository.save(entrenadorExistente)).thenReturn(entrenadorNuevosDatos);

        Entrenador updated = entrenadorService.actualizar(id, entrenadorNuevosDatos);

        assertNotNull(updated);
        assertEquals("Marcelo Actualizado", updated.getNombre());
        assertEquals(51, updated.getEdad());
    }

    @Test
    public void testEliminar() {
        Integer id = 1;

        doNothing().when(entrenadorRepository).deleteById(id);

        entrenadorService.eliminar(id);

        verify(entrenadorRepository, times(1)).deleteById(id);
    }
}