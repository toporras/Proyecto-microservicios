package com.example.ms_torneo.Controller;

import com.example.ms_torneo.Model.Torneo;
import com.example.ms_torneo.Service.TorneoService;
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
@RequestMapping("/api/v1/torneos")
@Tag(name = "Torneo", description = "Operaciones relacionadas con el torneo")
public class TorneoController {
    @Autowired
    private TorneoService torneoService;

    @PostMapping
    @Operation(summary = "Crea un torneo", description = "Crea un nuevo torneo")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Torneo creado con exito",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Torneo.class)))
    })
    public Torneo crear(@RequestBody Torneo torneo){
        log.info("Informacion: Alguien a creado un torneo");
        return torneoService.crearTorneo(torneo);
    }

    @GetMapping
    @Operation(summary = "Muestra los torneo", description = "Muestra los torneo ya existentes")
       @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operacion exitosa",
                content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Torneo.class))),
            @ApiResponse(responseCode = "404", description = "Torneo no encontrado")
    })
    public List<Torneo> obtenerTodos(){
        log.info("Informacion: Alguien a solicitado ver los torneos");
        return torneoService.obtenerTorneos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Muestra los torneo segun su id", description = "Lista los torneo segun su id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operacion exitosa",
                content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Torneo.class))),
            @ApiResponse(responseCode = "404", description = "Torneo no encontrado")
    })
    public Torneo obtenerPorId(@PathVariable Integer id) {
        log.info("Informacion: Alguien a solicitado ver un torneo por su id");
        return torneoService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualiza un torneo", description = "Actualiza un torneo segun su id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Torneo actualizado con exito",
                content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Torneo.class))),
            @ApiResponse(responseCode = "404", description = "Torneo no encontrado")
    })
    public Torneo actualizar(@PathVariable Integer id, @RequestBody Torneo torneo){
        log.info("Informacion: Alguien a solicitado actualizar un torneo");
        return torneoService.actualizar(id, torneo);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina un torneo", description = "Elimina un torneo segun su id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Torneo eliminado con exito"),
            @ApiResponse(responseCode = "404", description = "Torneo no encontrado")
    })
    public String eliminar(@PathVariable Integer id){
        log.info("Informacion: Alguien a solicitado eliminar un torneo segun su id");
        torneoService.eliminar(id);
        return "Se ha eliminado correctamente";
    }
}
