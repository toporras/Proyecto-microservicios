package com.example.ms_usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ms_usuario.model.Usuario;
import com.example.ms_usuario.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    // Listar todos
    public List<Usuario> listar() {
        return repository.findAll();
    }

    // Buscar por ID
    public Usuario buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    // Guardar
    public Usuario guardar(Usuario usuario) {
        return repository.save(usuario);
    }

    // Actualizar
    public Usuario actualizar(Integer id, Usuario usuario) {

        Usuario usuarioExistente = repository.findById(id).orElse(null);

        if (usuarioExistente != null) {

            usuarioExistente.setNombre(usuario.getNombre());
            usuarioExistente.setCorreo(usuario.getCorreo());
            usuarioExistente.setTelefono(usuario.getTelefono());

            return repository.save(usuarioExistente);
        }

        return null;
    }

    // Eliminar
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

}