package com.example.ms_estadio.controller;

import com.example.ms_estadio.model.Estadio;
import com.example.ms_estadio.service.EstadioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estadios")
public class EstadioController {

    @Autowired
    private EstadioService service;

    @GetMapping
    public List<Estadio> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public Estadio buscarPorId(@PathVariable Integer id){
        return service.buscarPorId(id);
    }

    @PostMapping
    public Estadio guardar(@RequestBody Estadio estadio){
        return service.guardar(estadio);
    }

    @PutMapping("/{id}")
    public Estadio actualizar(@PathVariable Integer id,@RequestBody Estadio estadio){

        return service.actualizar(id, estadio);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id){
        service.eliminar(id);
        System.out.println("eliminado");
    }
}