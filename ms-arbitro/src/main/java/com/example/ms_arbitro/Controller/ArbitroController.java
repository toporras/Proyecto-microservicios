package com.example.ms_arbitro.Controller;

import com.example.ms_arbitro.Model.Arbitro;
import com.example.ms_arbitro.Service.ArbitroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/arbitros")
public class ArbitroController{
    @Autowired
    private ArbitroService arbitroService;

    @PostMapping
    public Arbitro añadir(@RequestBody Arbitro arbitro){
        System.out.println();
        return arbitroService.AñadirArbitro(arbitro);
    }

    @GetMapping
    public ResponseEntity<List<Arbitro>> obtenerTodos(){
        return ResponseEntity.ok( arbitroService.obtenerArbitros());
    }

    @GetMapping("/{id}")
    public Arbitro obtenerPorId(@PathVariable int id) {
        return arbitroService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public Arbitro actualizar(@PathVariable int id, @RequestBody Arbitro arbitro){
        return arbitroService.actualizar(arbitro);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id){
        arbitroService.eliminar(id);
        return "Se ha eliminado correctamente";
    }
}
