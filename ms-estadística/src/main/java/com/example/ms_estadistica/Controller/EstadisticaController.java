package com.example.ms_estadistica.Controller;

import com.example.ms_estadistica.Model.Estadistica;
import com.example.ms_estadistica.Service.EstadisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oar.annotation.Operation;
import io.swagger.v3.oar.annotation.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/estadisticas")
@Tag(name = "estadisticas", description = "Operaciones relacionadas con las estadisticas")
public class EstadisticaController {
    @Autowired
    private EstadisticaService estadisticaService;


    @PostMapping
    @Operation(summary = "Crea estadistica", description = "Crea una nueva estadistica")
    public Estadistica crear(@RequestBody Estadistica estadistica){
        log.info("Informacion: Alguien solicita crear una nueva estadistica");
        System.out.println(estadistica.getNombre());
        return estadisticaService.crear(estadistica);
    }

    @GetMapping
    @Operation(summary = "Lista las estadisticas", description = "Lista todas las estadisticas")
    public ResponseEntity<List<Estadistica>> obtenerEstadisticas(){
        log.info("Informacion: Alguien solicita listar todas las estadisticas");
        return ResponseEntity.ok(estadisticaService.obtenerEstadisticas());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualiza estadistica", description = "Actualiza estadistica")
    public Estadistica actualizar (@PathVariable int id, @RequestBody Estadistica estadistica){
        log.info("Informacion: Alguien solicita actualizar una estadistica");
        estadistica.setId(id);
        return estadisticaService.actualizar(estadistica);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina estadistica", description = "Elimina una estadistica segun su id")
    public String delete(@PathVariable int id){
        log.debug("Debug: Alguien solicita eliminar una estadistica");
        estadisticaService.delete(id);
        return "Se ha eliminado correctamente";
    }


}
