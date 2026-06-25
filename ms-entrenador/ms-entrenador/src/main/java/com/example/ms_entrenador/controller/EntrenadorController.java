package com.example.ms_entrenador.controller;

import com.example.ms_entrenador.model.DTO.EquipoDTO;
import com.example.ms_entrenador.model.Entrenador;
import com.example.ms_entrenador.service.EntrenadorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8085/doc/swagger-ui/index.html#/ */
@RestController
@RequestMapping("/entrenadores")
@Tag(name = "Entrenadores",description = "Operaciones relacionadas con la gestión de entrenadores")
public class EntrenadorController {

    @Autowired
    private EntrenadorService service;

    @GetMapping
    @Operation(summary = "Listar entrenadores",description = "Obtiene una lista con todos los entrenadores registrados")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Lista de entrenadores obtenida exitosamente",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Entrenador.class)))
})
    public List<Entrenador> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar entrenador por ID",description = "Obtiene la información de un entrenador mediante su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Entrenador encontrado",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Entrenador.class))),
    @ApiResponse(responseCode = "404",description = "Entrenador no encontrado")
})
    public Entrenador buscarPorId(@PathVariable Integer id){
        return service.buscarPorId(id);
    }

    @PostMapping
    @Operation(summary = "Crear entrenador",description = "Registra un nuevo entrenador en el sistema")
    @ApiResponses(value = {
        @ApiResponse(  responseCode = "201",description = "Entrenador creado exitosamente",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Entrenador.class))),
    @ApiResponse(responseCode = "400",description = "Datos inválidos")
})
    public Entrenador guardar(@RequestBody Entrenador entrenador){
        return service.guardar(entrenador);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar entrenador",description = "Actualiza los datos de un entrenador existente mediante su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Entrenador actualizado exitosamente",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Entrenador.class))),
    @ApiResponse(responseCode = "404",description = "Entrenador no encontrado")
})
    public Entrenador actualizar(@PathVariable Integer id,@RequestBody Entrenador entrenador){

        return service.actualizar(id, entrenador);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar entrenador",description = "Elimina un entrenador existente mediante su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Entrenador eliminado exitosamente"),
        @ApiResponse(responseCode = "404",description = "Entrenador no encontrado")
})
    public void eliminar(@PathVariable Integer id){
        service.eliminar(id);
    }

    @GetMapping("/equipo/{id}")
    @Operation(summary = "Obtener equipo por ID",description = "Consulta un equipo desde el microservicio ms-equipo mediante OpenFeign")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Equipo obtenido exitosamente",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = EquipoDTO.class))),
    @ApiResponse(responseCode = "404",description = "Equipo  no encontrado")
})
    public EquipoDTO obtenerEquipo(@PathVariable Integer id){
        return service.obtenerEquipo(id);
    }
}
