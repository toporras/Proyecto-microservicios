package com.example.ms_estadio.controller;

import com.example.ms_estadio.model.Estadio;
import com.example.ms_estadio.service.EstadioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

/*http://localhost:8084/doc/swagger-ui/index.html#/ */
@RestController
@RequestMapping("/estadios")
@Tag(name="Equipos", description = "Operaciones relacionadas con los estadios")
public class EstadioController {

    @Autowired
    private EstadioService service;

    @GetMapping
    @Operation( summary = "Listar estadios", description = "Obtiene una lista con todos los estadios registrados")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de estadio  s obtenida exitosamente",
            content = @Content( mediaType = "application/json",
                    schema = @Schema(implementation = Estadio.class)))
})
    public List<Estadio> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar estadio por ID",description = "Obtiene a un estadio mediante su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Equipo encontrado",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Estadio.class))),
        @ApiResponse(responseCode = "404",description = "Estadio no encontrado")
})
    public Estadio buscarPorId(@PathVariable Integer id){
        return service.buscarPorId(id);
    }

    @PostMapping
    @Operation(summary = "Añade un estadio", description = "Añade un nuevo estadio en la lista")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201",description = "Estadio creado exitosamente",
            content = @Content( mediaType = "application/json",
                    schema = @Schema(implementation = Estadio.class))),
        @ApiResponse(responseCode = "400",description = "Datos inválidos")
})
    public Estadio guardar(@RequestBody Estadio estadio){
        return service.guardar(estadio);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar estadios", description = "Actualiza los datos de un estadio existente mediante su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Estadio actualizado exitosamente ",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Estadio.class))),
        @ApiResponse(responseCode = "404", description = "Estadio no encontrada")
    })
    public Estadio actualizar(@PathVariable Integer id,@RequestBody Estadio estadio){

        return service.actualizar(id, estadio);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar estadio",description = "Elimina un estadio existente mediante su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Estadio eliminado exitosamente"),
        @ApiResponse( responseCode = "404",description = "Estadio no encontrado")
})
    public void eliminar(@PathVariable Integer id){
        service.eliminar(id);
        System.out.println("eliminado");
    }
}