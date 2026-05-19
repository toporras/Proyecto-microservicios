package com.example.jugador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jugador.model.Jugador;
import com.example.jugador.model.DTO.EquipoDTO;
import com.example.jugador.service.JugadorService;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService service;

    @GetMapping
    public List<Jugador> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public Jugador buscarPorId(@PathVariable Integer id){
        return service.buscarPorId(id);
    }

    @PostMapping
    public Jugador guardar(@RequestBody Jugador jugador){
        return service.guardar(jugador);
    }

    @PutMapping("/{id}")
    public Jugador actualizar(@PathVariable Integer id,@RequestBody Jugador jugador){

        return service.actualizar(id, jugador);
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
