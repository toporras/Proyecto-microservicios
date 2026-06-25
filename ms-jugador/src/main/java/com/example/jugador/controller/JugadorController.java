package com.example.jugador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jugador.model.Jugador;
import com.example.jugador.model.DTO.EquipoDTO;
import com.example.jugador.service.JugadorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/*http://localhost:8082/doc/swagger-ui/index.html#/ */
@RestController
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService service;
    
    @GetMapping
    @Operation(summary = "Listar jugadores",description = "Obtiene una lista con todos los jugadores registrados")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Lista de jugadores obtenida exitosamente",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Jugador.class)))
})
    public List<Jugador> listar(){
        return service.listar();
    }


    @GetMapping("/{id}")
    @Operation(summary = "Buscar jugador por ID",description = "Obtiene la información de un jugador mediante su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Jugador encontrado",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Jugador.class))),
    @ApiResponse( responseCode = "404",description = "Jugador no encontrado")
})
    public Jugador buscarPorId(@PathVariable Integer id){
        return service.buscarPorId(id);
    }



    @PostMapping
    @Operation(summary = "Crear jugador",description = "Registra un nuevo jugador en el sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201",description = "Jugador creado exitosamente",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Jugador.class))),
    @ApiResponse(responseCode = "400",description = "Datos inválidos")
})
    public Jugador guardar(@RequestBody Jugador jugador){
        return service.guardar(jugador);
    }



    @PutMapping("/{id}")
    @Operation(summary = "Actualizar jugador",description = "Actualiza los datos de un jugador existente mediante su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Jugador actualizado exitosamente",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Jugador.class))),
    @ApiResponse(responseCode = "404",description = "Jugador no encontrado")
})
    public Jugador actualizar(@PathVariable Integer id,@RequestBody Jugador jugador){
        return service.actualizar(id, jugador);
    }


    @DeleteMapping("/{id}")
    @Operation( summary = "Eliminar jugador", description = "Elimina un jugador existente mediante su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Jugador eliminado exitosamente"),
    @ApiResponse(responseCode = "404",description = "Jugador no encontrado")
})
    public void eliminar(@PathVariable Integer id){
        service.eliminar(id);
        
    }


    @GetMapping("/equipo/{id}")
    @Operation(summary = "Obtener equipo por ID",description = "Consulta un equipo desde el microservicio de equipos mediante OpenFeign")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Equipo obtenido exitosamente",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = EquipoDTO.class))),
    @ApiResponse(responseCode = "404",description = "Equipo no encontrado")
})

public EquipoDTO obtenerEquipo(@PathVariable Integer id){
    return service.obtenerEquipo(id);
}
}