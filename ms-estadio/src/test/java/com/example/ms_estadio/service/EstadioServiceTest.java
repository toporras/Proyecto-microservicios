package com.example.ms_estadio.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.ms_estadio.model.Estadio;
import com.example.ms_estadio.repository.EstadioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class EstadioServiceTest {

    @Autowired
    private EstadioService estadioService;

    @MockBean
    private EstadioRepository estadioRepository;

    @Test
    public void testListar() {
        when(estadioRepository.findAll()).thenReturn(List.of(new Estadio(1, "Nacional", 45000, "Santiago")));

        List<Estadio> estadios = estadioService.listar();

        assertNotNull(estadios);
        assertEquals(1, estadios.size());
    }

    @Test
    public void testBuscarPorId() {
        Integer id = 1;
        Estadio estadio = new Estadio(id, "Nacional", 45000, "Santiago");

        when(estadioRepository.findById(id)).thenReturn(Optional.of(estadio));

        Estadio found = estadioService.buscarPorId(id);

        assertNotNull(found);
        assertEquals(id, found.getId());
    }

    @Test
    public void testGuardar() {
        Estadio estadio = new Estadio(1, "Nacional", 45000, "Santiago");

        when(estadioRepository.save(estadio)).thenReturn(estadio);

        Estadio saved = estadioService.guardar(estadio);

        assertNotNull(saved);
        assertEquals("Nacional", saved.getNombre());
    }

    @Test
    public void testActualizar() {
        Integer id = 1;
        Estadio estadioExistente = new Estadio(id, "Nacional", 45000, "Santiago");
        Estadio estadioNuevosDatos = new Estadio(id, "Nacional Actualizado", 50000, "Santiago");

        when(estadioRepository.findById(id)).thenReturn(Optional.of(estadioExistente));
        when(estadioRepository.save(estadioExistente)).thenReturn(estadioNuevosDatos);

        Estadio updated = estadioService.actualizar(id, estadioNuevosDatos);

        assertNotNull(updated);
        assertEquals("Nacional Actualizado", updated.getNombre());
        assertEquals(50000, updated.getCapacidad());
    }

    @Test
    public void testEliminar() {
        Integer id = 1;

        doNothing().when(estadioRepository).deleteById(id);

        estadioService.eliminar(id);
        verify(estadioRepository, times(1)).deleteById(id);
    }
}