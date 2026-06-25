package com.example.ms_usuario.controller;

import com.example.ms_usuario.model.DTO.*;
import com.example.ms_usuario.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/*http://localhost:8090/doc/swagger-ui/index.html#/ */
@RestController
@RequestMapping("/usuarios")
@Tag(
    name = "Usuario",description = "Consultas integradas mediante OpenFeign hacia otros microservicios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/equipo/{id}")
    @Operation(summary = "Obtener equipo por ID",description = "Consulta un equipo desde el microservicio ms-equipo mediante OpenFeign")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Equipo obtenido exitosamente",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = EquipoDTO.class))),
    @ApiResponse(responseCode = "404",description = "Equipo no encontrado")
})
    public EquipoDTO obtenerEquipo(@PathVariable Integer id){
        return service.obtenerEquipo(id);
    }

    @GetMapping("/jugador/{id}")
    @Operation(summary = "Obtener jugador por ID",description = "Consulta un jugador desde el microservicio ms-jugador mediante OpenFeign")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Jugador obtenido exitosamente",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = JugadorDTO.class))),
    @ApiResponse(responseCode = "404",description = "Jugador no encontrado")
})
    public JugadorDTO obtenerJugador(@PathVariable Integer id){
        return service.obtenerJugador(id);
    }

    @GetMapping("/partido/{id}")
    @Operation(summary = "Obtener partido por ID",description = "Consulta un partido desde el microservicio ms-partido mediante OpenFeign")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",  description = "Partido obtenido exitosamente",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = PartidoDTO.class))),
    @ApiResponse(responseCode = "404",description = "Partido no encontrado")
})
    public PartidoDTO obtenerPartido(@PathVariable Integer id){
        return service.obtenerPartido(id);
    }

    @GetMapping("/estadio/{id}")
    @Operation(summary = "Obtener estadio por ID",description = "Consulta un estadio desde el microservicio ms-estadio mediante OpenFeign"    )   
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Estadio obtenido exitosamente",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = EstadioDTO.class))),
    @ApiResponse(responseCode = "404",description = "Estadio no encontrado")
})
    public EstadioDTO obtenerEstadio(@PathVariable Integer id){
        return service.obtenerEstadio(id);
    }

    @GetMapping("/entrenador/{id}")
    @Operation(summary = "Obtener entrenador por ID",description = "Consulta un entrenador desde el microservicio ms-entrenador mediante OpenFeign")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Entrenador obtenido exitosamente",
            content = @Content(
                mediaType = "application/json",schema = @Schema(implementation = EntrenadorDTO.class))),
    @ApiResponse(responseCode = "404",description = "Entrenador no encontrado")
})
    public EntrenadorDTO obtenerEntrenador(@PathVariable Integer id){
        return service.obtenerEntrenador(id);
    }


    @GetMapping("/torneo/{id}")
    @Operation(summary = "Obtener torneo por ID",description = "Consulta un torneo desde el microservicio ms-torneo mediante OpenFeign")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Torneo obtenido exitosamente",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = TorneoDTO.class))),
    @ApiResponse(responseCode = "404",description = "Torneo no encontrado")
})
    public TorneoDTO obtenerTorneo(@PathVariable Integer id){
        return service.obtenerTorneo(id);
}
}