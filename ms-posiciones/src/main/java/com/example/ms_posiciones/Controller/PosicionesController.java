package com.example.ms_posiciones.Controller;

import com.example.ms_posiciones.Model.Posiciones;
import com.example.ms_posiciones.Service.PosicionesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/posiciones")
@Tag(name = "posiciones", description = "Operaciones relacionadas con las posiciones")
public class PosicionesController {

    @Autowired
    private PosicionesService posicionesService;

    @PostMapping
    @Operation(summary = "Crea una posicion", description = "Crea una nueva posicion")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Posicion creada con exito",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Posiciones.class)))
    })
    public Posiciones crear(@RequestBody Posiciones posiciones){
        log.info("Informacion: Alguien solicita crear una nueva posicion");
        return posicionesService.crear(posiciones);
    }

    @GetMapping
    @Operation(summary = "Lista las posiciones", description = "Lista todas las posiciones")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Posiciones listadas con exito",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Posiciones.class))),
        @ApiResponse(responseCode = "404", description = "Posicion no encontrada")
    })
    public List<Posiciones> listarPosiciones(){
        log.info("Informacion: Alguien solicita listar todas las posiciones");
        return posicionesService.listarPosiciones();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtiene una posicion", description = "Obtiene una posicion segun su id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Posicion obtenida con exito",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Posiciones.class))),
        @ApiResponse(responseCode = "404", description = "Posicion no encontrada")
    })
    public Posiciones listarPorId(@PathVariable Integer id){
        log.info("Informacion: Alguien solicita una posicion por su id");
        return posicionesService.listarPorId(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina una posicion", description = "Elimina una posicion segun su id")
        @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Posiciones eliminada con exito"),
        @ApiResponse(responseCode = "404", description = "Posicion no encontrada")
    })
    public String eliminar(@PathVariable Integer id){
        log.info("Informacion: Alguien solicita eliminar una posicion por su id");
        posicionesService.eliminar(id);
        return "La posicion se ha eliminado correctamente";
    }
}
