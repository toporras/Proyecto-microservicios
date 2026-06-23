package com.example.ms_estadistica.Controller;

import com.example.ms_estadistica.Model.Estadistica;
import com.example.ms_estadistica.Service.EstadisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/estadisticas")
@Tag(name = "estadisticas", description = "Operaciones relacionadas con las estadisticas")
public class EstadisticaController {
    
    @Autowired
    private EstadisticaService estadisticaService;

    @PostMapping
    @Operation(summary = "Crea estadistica", description = "Crea una nueva estadistica")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Estadistica creada con exito",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Estadistica.class)))
    })
    public Estadistica crear(@RequestBody Estadistica estadistica){
        log.info("Informacion: Alguien solicita crear una nueva estadistica");
        System.out.println(estadistica.getNombre());
        return estadisticaService.crear(estadistica);
    }

    @GetMapping
    @Operation(summary = "Lista las estadisticas", description = "Lista todas las estadisticas")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Estadisticas listadas con exito",
            content = @Content(mediaType = "applocation/json",
                schema = @Schema(implementation = Estadistica.class)))
    })
    public ResponseEntity<List<Estadistica>> obtenerEstadisticas(){
        log.info("Informacion: Alguien solicita listar todas las estadisticas");
        return ResponseEntity.ok(estadisticaService.obtenerEstadisticas());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualiza estadistica", description = "Actualiza estadistica")
        @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Estadisticas listadas con exito",
            content = @Content(mediaType = "applocation/json",
                schema = @Schema(implementation = Estadistica.class)))
    })
    @ApiResponse(responseCode = "404", description = "Estadisticas no encontradas")
    public Estadistica actualizar (@PathVariable Integer id, @RequestBody Estadistica estadistica){
        log.info("Informacion: Alguien solicita actualizar una estadistica");
        estadistica.setId(id);
        return estadisticaService.actualizar(estadistica);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina estadistica", description = "Elimina una estadistica segun su id")
        @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Estadisticas eliminada con exito",
            content = @Content(mediaType = "applocation/json",
                schema = @Schema(implementation = Estadistica.class)))
    })
    @ApiResponse(responseCode = "404", description = "Estadisticas no encontradas")
    public String delete(@PathVariable Integer id){
        log.info("Informacion: Alguien solicita eliminar una estadistica");
        estadisticaService.delete(id);
        return "Se ha eliminado correctamente";
    }
}
