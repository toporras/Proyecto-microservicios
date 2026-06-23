package com.example.ms_partido.Controller;

import com.example.ms_partido.Model.Partido;
import com.example.ms_partido.Service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/partidos")
@Tag(name = "partidos", description = "Operaciones relacionadas con el partido")
public class PartidoController {
    @Autowired
    private PartidoService partidoService;

    @PostMapping
    @Operation(summary = "Crea un partido", description = "Crea un nuevo partido")
    public Partido crearPartido(@RequestBody Partido partido){
        log.info("Informacion: Alguien solicita crear un partido");
        System.out.println(partido.getNombre());
        return partidoService.crearPartido(partido);
    }

    @GetMapping
    @Operation(summary = "Lista los partidos", description = "Lista todos los partidos")
    public ResponseEntity<List<Partido>> verPartidos(){
        log.info("Informacion: Alguien solicita ver los partidos");
        return ResponseEntity.ok(partidoService.verPartidos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Lista los partidos por su id", description = "Obtiene un partido por su id")
    public Partido buscarPorId(@PathVariable int id){
        log.info("Informacion: Alguien solicita obtener un partido");
        return partidoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualiza un partido", description = "Actualiza un partido por su id")
    public Partido actualizar(@PathVariable int id,@RequestBody Partido partido){
        log.info("Informacion: Alguien actualizar un partido");
        return partidoService.actualizar(partido);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina un partido", description = "Elimina un partido por su id")
    public String eliminar(@PathVariable int id){
        log.info("Informacion: Alguien eliminar un partido");
        partidoService.eliminar(id);
        return "Se ha eliminado correctamente";
    }
}
