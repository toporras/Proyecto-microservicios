package com.example.ms_torneo.Controller;

import com.example.ms_torneo.Model.Torneo;
import com.example.ms_torneo.Service.TorneoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/torneos")
public class TorneoController {
    @Autowired
    private TorneoService torneoService;

    @PostMapping
    public Torneo crear(@RequestBody Torneo torneo){
        return torneoService.crearTorneo(torneo);
    }

    @GetMapping
    public List<Torneo> obtenerTodos(){
        return torneoService.obtenerTorneos();
    }

    @GetMapping("/{id}")
    public Torneo obtenerPorId(@PathVariable int id) {
        return torneoService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public Torneo actualizar(@PathVariable int id, @RequestBody Torneo torneo){
        return torneoService.actualizar(id, torneo);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id){
        torneoService.eliminar(id);
        return "Se ha eliminado correctamente";
    }
}
