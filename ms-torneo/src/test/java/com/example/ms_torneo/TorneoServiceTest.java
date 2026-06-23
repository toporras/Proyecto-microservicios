package com.example.ms_torneo;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.ms_torneo.Model.*;
import com.example.ms_torneo.Repository.*;
import com.example.ms_torneo.Service.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@SpringBootTest
public class TorneoServiceTest {

    @Autowired
    private TorneoService torneoService;

    @MockitoBean
    private TorneoRepository torneoRepository;
                                                                                
    @Test 
    public void testCrear(){
    Torneo torneo = new Torneo();
    torneo.setId(1);
    torneo.setNombre("Torneo 1");
    torneo.setFecha_inicio("12-12-2025");
    torneo.setFecha_fin("12-12-2026");
    torneo.setCantidad_equipos(5);
    when(torneoRepository.save(torneo)).thenReturn(torneo);
    Torneo saved = torneoService.crearTorneo(torneo);

    assertNotNull(saved);
    assertEquals("Torneo 1", saved.getNombre());
    }
    
    
    @Test
    public void testFindAll(){
        Torneo torneo1 = new Torneo();
        torneo1.setId(1);
        torneo1.setNombre("Torneo 1");
        torneo1.setFecha_inicio("12-12-2025");
        torneo1.setFecha_fin("12-12-2026");
        torneo1.setCantidad_equipos(5);
        torneo1.setPartidos(new ArrayList<>());
        when(torneoRepository.findAll()).thenReturn(List.of(torneo1));
        List<Torneo> torneo = torneoService.obtenerTorneos();
        
        assertNotNull(torneo);
        assertEquals(1, torneo.size());
    }

    @Test 
    public void testFindById(){
    Integer id = 1;

    Torneo torneo = new Torneo();
        torneo.setId(1);
        torneo.setNombre("Torneo 1");
        torneo.setFecha_inicio("12-12-2025");
        torneo.setFecha_fin("12-12-2026");
        torneo.setCantidad_equipos(5);
    when(torneoRepository.findById(id)).thenReturn(Optional.of(torneo));
    Torneo found = torneoService.obtenerPorId(id);

    assertNotNull(found);
    assertEquals(id, found.getId());
}

    @Test 
    public void testDeleteById(){
        Integer id = 1;

        doNothing().when(torneoRepository).deleteById(id);
        torneoService.eliminar(id);
        verify(torneoRepository, times(1)).deleteById(id);
    }
}
