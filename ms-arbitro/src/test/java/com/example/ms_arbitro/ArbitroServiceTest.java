package com.example.ms_arbitro;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.ms_arbitro.Model.*;
import com.example.ms_arbitro.Repository.*;
import com.example.ms_arbitro.Service.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ArbitroServiceTest {

    @Autowired
    private ArbitroService arbitroService;

    @MockitoBean 
    private ArbitroRepository arbitroRepository;

    @Test 
    public void testCrear(){
        Arbitro arbitro = new Arbitro(1, "Pedro", "12-12-2000", 123456789);
        when(arbitroRepository.save(arbitro)).thenReturn(arbitro);
        Arbitro saved = arbitroService.AñadirArbitro(arbitro);

        assertNotNull(saved);
        assertEquals("Pedro", saved.getNombre());
    }

    @Test 
    public void testListar(){
        when(arbitroRepository.findAll()).thenReturn(List.of(new Arbitro(1, "Pedro", "12-12-2000", 123456789)));
        List<Arbitro> arbitro = arbitroService.obtenerArbitros();

        assertNotNull(arbitro);
        assertEquals(1, arbitro.size());
    }

    @Test
    public void testFindById(){
        Integer id = 1;

        Arbitro arbitro = new Arbitro(1, "Pedro", "12-12-2000", 123456789);
        when(arbitroRepository.findById(id)).thenReturn(Optional.of(arbitro));
        Arbitro found = arbitroService.obtenerPorId(id);

        assertNotNull(found);
        assertEquals(id, found.getId());
    }


    @Test
    public void testActualizar(){
        Integer id = 1;

        Arbitro arbitroOriginal = new Arbitro(1, "Pedro", "12-12-2000", 123456789);
        Arbitro arbitroActualizado = new Arbitro(1, "Pedro", "12-12-2000", 987654321);

        when(arbitroRepository.findById(id)).thenReturn(Optional.of(arbitroOriginal));
        when(arbitroRepository.save(arbitroActualizado)).thenReturn((arbitroActualizado));
        
        Arbitro actualizado = arbitroService.actualizar(arbitroActualizado);

        assertNotNull(actualizado);
        assertEquals(987654321, actualizado.getTelefono());
    }


    @Test 
    public void testEliminar(){
        Integer id = 1;
        doNothing().when(arbitroRepository).deleteById(id);
        arbitroService.eliminar(id);
        verify(arbitroRepository, times(1)).deleteById(id);;
    }
}
