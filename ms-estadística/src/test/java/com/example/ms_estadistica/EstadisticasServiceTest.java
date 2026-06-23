package com.example.ms_estadistica;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.ms_estadistica.Model.*;
import com.example.ms_estadistica.Repository.*;
import com.example.ms_estadistica.Service.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class EstadisticasServiceTest {

    @Autowired
    private EstadisticaService estadisticaService;

    @MockitoBean
    private EstadisticaRepository estadisticaRepository;

    @Test 
    public void testCrear(){
        Estadistica estadistica = new Estadistica(1, "Estadistica 1");
        when(estadisticaRepository.save(estadistica)).thenReturn(estadistica);
        Estadistica saved = estadisticaService.crear(estadistica);

        assertNotNull(saved);
        assertEquals("estadistica 1", saved.getNombre());
    }

    @Test 
    public void testListar(){
        when(estadisticaRepository.findAll()).thenReturn(List.of(new Estadistica(1, "Estadistica 1")));
        List<Estadistica> estadisticas = estadisticaService.obtenerEstadisticas();

        assertNotNull(estadisticas);
        assertEquals(1, estadisticas.size());
    }

    @Test 
    public void testActualizar(){
        Integer id = 1;

        Estadistica estadisticaOriginal = new Estadistica(1, "Estadistica 1");
        Estadistica estadisticaActualizada = new Estadistica(1, "Estadistica final");

        when(estadisticaRepository.findById(id)).thenReturn(Optional.of(estadisticaOriginal));
        when(estadisticaRepository.save(estadisticaActualizada)).thenReturn(estadisticaActualizada);
    
        Estadistica actualizado = estadisticaService.actualizar(estadisticaActualizada);

        assertNotNull(actualizado);
        assertEquals(1, actualizado.getNombre());
    }

    @Test 
    public void testEliminar(){
        Integer id = 1;
        doNothing().when(estadisticaRepository).deleteById(id);
        estadisticaService.delete(id);
        verify(estadisticaRepository, times(1));
    }
}
