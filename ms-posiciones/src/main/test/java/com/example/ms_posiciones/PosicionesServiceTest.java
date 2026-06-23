package com.example.ms_posiciones;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.ms_posiciones.Model.*;
import com.example.ms_posiciones.Repository.*;
import com.example.ms_posiciones.Service.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class PosicionesServiceTest {

    @Autowired
    private PosicionesService posicionesService;

    @MockitoBean 
    private PosicionesRepository posicionesRepository;

    @Test 
    public void testCrearPosicion(){
        Posiciones posiciones = new Posiciones(1, "Grupo 1", "Finales", "Delantero");
        when(posicionesRepository.save(posiciones)).thenReturn(posiciones);
        Posiciones saved = posicionesService.crear(posiciones);

        assertNotNull(saved);
        assertEquals("Delantero", saved.getPosicion());
    }


    @Test 
    public void testListar(){
        when(posicionesRepository.findAll()).thenReturn(List.of(new Posiciones(1, "Grupo 1", "Finales", "Delantero")));
        List<Posiciones> posiciones = posicionesService.listarPosiciones();

        assertNotNull(posiciones);
        assertEquals(1, posiciones.size());
    }


    @Test 
    public void testListarPorId(){
        Integer id = 1;

        Posiciones posiciones = new Posiciones(1, "Grupo 1", "Finales", "Delantero");
        when(posicionesRepository.findById(id)).thenReturn(Optional.of(posiciones));
        Posiciones found = posicionesService.listarPorId(id);

        assertNotNull(found);
        assertEquals(id, found.getId());
    }


    @Test 
    public void testEliminarPorId(){
        Integer id = 1;

        doNothing().when(posicionesRepository).deleteById(id);
        posicionesService.eliminar(id);
        verify(posicionesRepository, times(1)).deleteById(id);
    }
}
