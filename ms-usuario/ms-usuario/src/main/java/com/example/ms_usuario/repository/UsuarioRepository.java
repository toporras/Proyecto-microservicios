package com.example.ms_usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ms_usuario.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}