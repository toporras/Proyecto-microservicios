package com.example.equipo.controller;

import com.example.equipo.model.Equipo;
import com.example.equipo.service.EquipoService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/equipos")
public class EquipoController {

    @Autowired
    private EquipoService service;

    /*listar todos */
    @GetMapping
    public List<Equipo> listar(){
        return service.listar();
    }

    /*listar por ID */
    @GetMapping("/{id}")
    public Equipo buscarPorId(@PathVariable Integer id){
        return service.buscarPorId(id);
    }

    /* el post (guardar otro equipo)  */
    @PostMapping
    public Equipo guardar(@RequestBody Equipo equipo){
        return service.guardar(equipo);
    }

    /*actualizar equipos */
    @PutMapping("/{id}")
    public Equipo actualizar(@PathVariable Integer id,@RequestBody Equipo equipo){
      return service.actualizar(id, equipo);
    }

    /*eliminar equiipos */
   @DeleteMapping("/{id}")
   public void eliminar(@PathVariable Integer id){
      service.eliminar(id);
   }
}

