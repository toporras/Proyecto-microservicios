package com.example.ms_entrenador.controller;

import com.example.ms_entrenador.model.DTO.EquipoDTO;
import com.example.ms_entrenador.model.Entrenador;
import com.example.ms_entrenador.service.EntrenadorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entrenadores")
public class EntrenadorController {

    @Autowired
    private EntrenadorService service;

    @GetMapping
    public List<Entrenador> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public Entrenador buscarPorId(@PathVariable Integer id){
        return service.buscarPorId(id);
    }

    @PostMapping
    public Entrenador guardar(@RequestBody Entrenador entrenador){
        return service.guardar(entrenador);
    }

    @PutMapping("/{id}")
    public Entrenador actualizar(@PathVariable Integer id,@RequestBody Entrenador entrenador){

        return service.actualizar(id, entrenador);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id){
        service.eliminar(id);
    }

    @GetMapping("/equipo/{id}")
    public EquipoDTO obtenerEquipo(@PathVariable Integer id){
        return service.obtenerEquipo(id);
    }
}
