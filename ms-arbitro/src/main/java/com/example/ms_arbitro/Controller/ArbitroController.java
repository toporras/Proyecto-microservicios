package com.example.ms_arbitro.Controller;

import com.example.ms_arbitro.Model.Arbitro;
import com.example.ms_arbitro.Service.ArbitroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/arbitros")
@Tag(name = "arbitro", description = "Operaciones relacionadas al arbitro")
public class ArbitroController{
    @Autowired
    private ArbitroService arbitroService;

    @PostMapping
    @Operation(summary = "Añadir arbitro", description = "Añade a la lista un nuevo arbitro")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Arbitro añadido con exito",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Arbitro.class)))
    })
    public Arbitro añadir(@RequestBody Arbitro arbitro){
        log.info("Informacion: Alguien a soliciado Añadir un arbitro");
        System.out.println();
        return arbitroService.AñadirArbitro(arbitro);
    }

    @GetMapping
    @Operation(summary = "Listar arbitros", description = "Listar a todos los arbitros")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Arbitros listados con exito",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Arbitro.class)))
    })
    public ResponseEntity<List<Arbitro>> obtenerTodos(){
        log.info("Informacion: Alguien a soliciado listar a los arbitros");
        return ResponseEntity.ok( arbitroService.obtenerArbitros());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Listar por id arbitros", description = "Listar a los arbitros segun su id")
        @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Arbitro encontrado con exito",
                content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Arbitro.class))),
            @ApiResponse(responseCode = "404", description = "Arbitro no encontrado")
        })
    
    public Arbitro obtenerPorId(@PathVariable Integer id) {
        log.info("Informacion: Alguien a soliciado listar a los arbitros segun su id");
        return arbitroService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar  arbitro", description = "Actualizar a los arbitros segun su id")
        @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Arbitro actualizado con exito",
                content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Arbitro.class))),
            @ApiResponse(responseCode = "404", description = "Arbitro no encontrado")
        })
    
    public Arbitro actualizar(@PathVariable Integer id, @RequestBody Arbitro arbitro){
        log.info("Informacion: Alguien a soliciado actualizar a un arbitro segun su id");
        return arbitroService.actualizar(arbitro);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar arbitro", description = "Eliminar a los arbitros segun su id")
        @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Arbitro eliminado con exito",
                content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Arbitro.class))),
            @ApiResponse(responseCode = "404", description = "Arbitro no encontrado")
        })
    public String eliminar(@PathVariable Integer id){
        log.info("Informacion: Alguien a soliciado eliminar a un arbitro segun su id");
        arbitroService.eliminar(id);
        return "Se ha eliminado correctamente";
    }
}
