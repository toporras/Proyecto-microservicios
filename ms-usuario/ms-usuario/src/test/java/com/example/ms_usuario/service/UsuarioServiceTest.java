package com.example.ms_usuario.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.ms_usuario.model.Usuario;
import com.example.ms_usuario.repository.UsuarioRepository;

@SpringBootTest
class UsuarioServiceTest {

    @Autowired
    private UsuarioService usuarioService;

    @MockBean
    private UsuarioRepository usuarioRepository;

    @Test
    void testListar() {

        // Configuración
        Usuario usuario1 = new Usuario(1, "Juan Keteleare", "juank@gmail.com", "912345678");
        Usuario usuario2 = new Usuario(2, "Sofia Costa", "sofia@gmail.com", "987654321");
        when(usuarioRepository.findAll()).thenReturn(List.of(usuario1, usuario2));

        // Ejecutar
        List<Usuario> lista = usuarioService.listar();

        // Verificar
        assertNotNull(lista);
        assertEquals(2, lista.size());
        assertEquals("Juan Keteleare", lista.get(0).getNombre());

        verify(usuarioRepository, times(1)).findAll();
    }

    @Test
    void testBuscarPorId() {

        Usuario mockUsuario = new Usuario(1, "Juan Keteleare", "juank@gmail.com", "912345678");

        when(usuarioRepository.findById(1)).thenReturn(Optional.of(mockUsuario));

        Usuario resultado = usuarioService.buscarPorId(1);

        assertNotNull(resultado);
        assertEquals("Juan Keteleare", resultado.getNombre());

        verify(usuarioRepository, times(1)).findById(1);
    }

    @Test
    void testGuardar() {

        Usuario usuarioAGuardar =
                new Usuario(null, "Juan Keteleare", "juank@gmail.com", "912345678");

        Usuario usuarioGuardado =
                new Usuario(1, "Juan Keteleare", "juank@gmail.com", "912345678");

        when(usuarioRepository.save(usuarioAGuardar)).thenReturn(usuarioGuardado);

        Usuario resultado = usuarioService.guardar(usuarioAGuardar);

        assertNotNull(resultado);
        assertEquals(1, resultado.getId());
        assertEquals("Juan Keteleare", resultado.getNombre());

        verify(usuarioRepository, times(1)).save(usuarioAGuardar);
    }

    @Test
    void testActualizar() {

        Usuario usuarioExistente =
                new Usuario(1, "Juan", "juank@gmail.com", "912345678");

        Usuario usuarioActualizado =
                new Usuario(1, "Juan Keteleare", "juank@gmail.com", "999999999");

        when(usuarioRepository.findById(1)).thenReturn(Optional.of(usuarioExistente));
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuarioActualizado);

        Usuario resultado = usuarioService.actualizar(1, usuarioActualizado);

        assertNotNull(resultado);
        assertEquals("Juan Keteleare", resultado.getNombre());
        assertEquals("juank@gmail.com", resultado.getCorreo());
        assertEquals("999999999", resultado.getTelefono());

        verify(usuarioRepository, times(1)).findById(1);
        verify(usuarioRepository, times(1)).save(any(Usuario.class));
    }

    @Test
    void testEliminar() {

        Integer idAEliminar = 1;
        doNothing().when(usuarioRepository).deleteById(idAEliminar);
        usuarioService.eliminar(idAEliminar);
        verify(usuarioRepository, times(1)).deleteById(idAEliminar);
    }
}