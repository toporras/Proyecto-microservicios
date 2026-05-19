package com.example.ms_estadistica.Controller;

import com.example.ms_estadistica.Model.Estadistica;
import com.example.ms_estadistica.Service.EstadisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/estadisticas")
public class EstadisticaController {
    @Autowired
    private EstadisticaService estadisticaService;


    @PostMapping
    public Estadistica crear(@RequestBody Estadistica estadistica){
        System.out.println(estadistica.getNombre());
        return estadisticaService.crear(estadistica);
    }

    @GetMapping
    public ResponseEntity<List<Estadistica>> obtenerEstadisticas(){
        return ResponseEntity.ok(estadisticaService.obtenerEstadisticas());
    }

    @PutMapping("/{id}")
    public Estadistica actualizar (@PathVariable int id, @RequestBody Estadistica estadistica){
        estadistica.setId(id);
        return estadisticaService.actualizar(estadistica);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        estadisticaService.delete(id);
        return "Se ha eliminado correctamente";
    }


}
