package com.example.ms_partido;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.ms_partido.Model.*;
import com.example.ms_partido.Repository.*;
import com.example.ms_partido.Service.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class PartidoServiceTest {

    @Autowired
    private PartidoService partidoService;

    @MockitoBean
    private PartidoRepository partidoRepository;

    @Test 
    public void testCrearPartido(){
        Partido partido = new Partido();
        partido.setId(1);
        partido.setNombre("Partido 1");
        partido.setFecha_partido("12-12-2025");
        partido.setHora_partido("12:00");
        partido.setEstadio("Gran Estadio");
        when(partidoRepository.save(partido)).thenReturn(partido);
        Partido saved = partidoService.crearPartido(partido);

        assertNotNull(saved);
        assertEquals("Partido 1", saved.getNombre());
    
    }
    
    
    @Test 
    public void testListar(){
        Partido partido = new Partido();
        partido.setId(1);
        partido.setNombre("Partido 1");
        partido.setFecha_partido("12-12-2025");
        partido.setHora_partido("12:00");
        partido.setEstadio("Gran Estadio");
        when(partidoRepository.findAll()).thenReturn(List.of(partido));
        List<Partido> partidos = partidoService.verPartidos();
        
        assertNotNull(partido);
        assertEquals(1, partidos.size());
    }


    @Test 
    public void testListarPorId(){
        Integer id = 1;

        Partido partido = new Partido();
        partido.setId(1);
        partido.setNombre("Partido 1");
        partido.setFecha_partido("12-12-2025");
        partido.setHora_partido("12:00");
        partido.setEstadio("Gran Estadio");
        when(partidoRepository.findById(id)).thenReturn(Optional.of(partido));
        Partido found = partidoService.buscarPorId(id);

        assertNotNull(found);
        assertEquals(id, found.getId());
    }


    @Test 
    public void testActualizar(){
        Integer id = 1;

        Partido partidoOriginal = new Partido();
        partidoOriginal.setId(1);
        partidoOriginal.setNombre("Partido 1");
        partidoOriginal.setFecha_partido("12-12-2025");
        partidoOriginal.setHora_partido("12:00");
        partidoOriginal.setEstadio("Gran Estadio");
        
        Partido partidoActualizado = new Partido();
        partidoActualizado.setId(1);
        partidoActualizado.setNombre("Partido 1");
        partidoActualizado.setFecha_partido("12-12-2025");
        partidoActualizado.setHora_partido("22:00");
        partidoActualizado.setEstadio("Gran Estadio");

        when(partidoRepository.findById(id)).thenReturn(Optional.of(partidoOriginal));
        when(partidoRepository.save(partidoActualizado)).thenReturn(partidoActualizado);
        
        Partido actualizado = partidoService.actualizar(partidoActualizado);

        assertNotNull(actualizado);
        assertEquals("22:00", actualizado.getHora_partido());
    }


    @Test 
    public void testEliminar(){
        Integer id = 1;
        doNothing().when(partidoRepository).deleteById(id);
        partidoService.eliminar(id);
        verify(partidoRepository, times(1)).deleteById(id);;
    }
}
