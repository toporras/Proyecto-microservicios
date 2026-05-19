package com.example.ms_partido.Controller;

import com.example.ms_partido.Model.Partido;
import com.example.ms_partido.Service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partidos")
public class PartidoController {
    @Autowired
    private PartidoService partidoService;

    @PostMapping
    public Partido crearPartido(@RequestBody Partido partido){
        System.out.println(partido.getNombre());
        return partidoService.crearPartido(partido);
    }

    @GetMapping
    public ResponseEntity<List<Partido>> verPartidos(){
        return ResponseEntity.ok(partidoService.verPartidos());
    }

    @GetMapping("/{id}")
    public Partido buscarPorId(@PathVariable int id){
        return partidoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Partido actualizar(@PathVariable int id,@RequestBody Partido partido){
        return partidoService.actualizar(partido);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id){
        partidoService.eliminar(id);
        return "Se ha eliminado correctamente";
    }
}
