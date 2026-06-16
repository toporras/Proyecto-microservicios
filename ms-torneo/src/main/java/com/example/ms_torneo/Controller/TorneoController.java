package com.example.ms_torneo.Controller;

import com.example.ms_torneo.Model.Torneo;
import com.example.ms_torneo.Service.TorneoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oars.annotations.Operation;
import io.swagger.v3.oars.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/torneos")
@Tag(name = "Torneo", description = "Operaciones relacionadas con el torneo")
public class TorneoController {
    @Autowired
    private TorneoService torneoService;

    @PostMapping
    @Operation(summary = "Crea un torneo", description = "Crea un nuevo torneo")
    public Torneo crear(@RequestBody Torneo torneo){
        log.info("Informacion: Alguien a creado un torneo");
        return torneoService.crearTorneo(torneo);
    }

    @GetMapping
    @Operation(summary = "Muestra los torneo", description = "Muestra los torneo ya existentes")
    public List<Torneo> obtenerTodos(){
        log.info("Informacion: Alguien a solicitado ver los torneos");
        return torneoService.obtenerTorneos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Muestra los torneo segun su id", description = "Lista los torneo segun su id")
    public Torneo obtenerPorId(@PathVariable int id) {
        log.info("Informacion: Alguien a solicitado ver un torneo por su id");
        return torneoService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualiza un torneo", description = "Actualiza un torneo segun su id")
    public Torneo actualizar(@PathVariable int id, @RequestBody Torneo torneo){
        log.info("Informacion: Alguien a solicitado actualizar un torneo");
        return torneoService.actualizar(id, torneo);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina un torneo", description = "Elimina un torneo segun su id")
    public String eliminar(@PathVariable int id){
        log.debug("Debug: Alguien a solicitado eliminar un torneo segun su id");
        torneoService.eliminar(id);
        return "Se ha eliminado correctamente";
    }
}
