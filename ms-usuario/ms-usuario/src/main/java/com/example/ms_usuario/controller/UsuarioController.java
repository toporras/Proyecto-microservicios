package com.example.ms_usuario.controller;

import com.example.ms_usuario.model.Usuario;
import com.example.ms_usuario.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/*http://localhost:8090/doc/swagger-ui/index.html#/ */
@RestController
@RequestMapping("/usuarios")
@Tag(name = "Usuarios", description = "Operaciones relacionadas con los usuarios del sistema")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    /* Listar todos */
    @GetMapping
    @Operation(
        summary = "Listar usuarios",
        description = "Obtiene una lista con todos los usuarios registrados en el sistema."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Lista de usuarios obtenida exitosamente.",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Usuario.class)
            )
        )
    })
    public List<Usuario> listar() {
        return service.listar();
    }

    /* Buscar por ID */
    @GetMapping("/{id}")
    @Operation(
        summary = "Buscar usuario por ID",
        description = "Obtiene la información de un usuario registrado mediante su identificador."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Usuario encontrado exitosamente.",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Usuario.class)
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Usuario no encontrado."
        )
    })
    public Usuario buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    /* Guardar */
    @PostMapping
    @Operation(
        summary = "Registrar usuario",
        description = "Registra un nuevo usuario dentro del sistema."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "201",
            description = "Usuario registrado exitosamente.",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Usuario.class)
            )
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Los datos enviados son inválidos."
        )
    })
    public Usuario guardar(@RequestBody Usuario usuario) {
        return service.guardar(usuario);
    }

    /* Actualizar */
    @PutMapping("/{id}")
    @Operation(
        summary = "Actualizar usuario",
        description = "Actualiza la información de un usuario existente mediante su identificador."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Usuario actualizado exitosamente.",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Usuario.class)
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Usuario no encontrado."
        )
    })
    public Usuario actualizar(@PathVariable Integer id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        return service.actualizar(id, usuario);
    }

    /* Eliminar */
    @DeleteMapping("/{id}")
    @Operation(
        summary = "Eliminar usuario",
        description = "Elimina un usuario registrado mediante su identificador."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Usuario eliminado exitosamente."
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Usuario no encontrado."
        )
    })
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}