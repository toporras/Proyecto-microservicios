package com.example.ms_posiciones.Controller;

import com.example.ms_posiciones.Model.Posiciones;
import com.example.ms_posiciones.Service.PosicionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posiciones")
public class PosicionesController {

    @Autowired
    private PosicionesService posicionesService;


    @PostMapping
    public Posiciones crear(@RequestBody Posiciones posiciones){
        return posicionesService.crear(posiciones);
    }

    @GetMapping
    public List<Posiciones> listarPosiciones(){
        return posicionesService.listarPosiciones();
    }

    @GetMapping("/{id}")
    public Posiciones listarPorId(@PathVariable int id){
        return posicionesService.listarPorId(id);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id){
        posicionesService.eliminar(id);
        return "La posicion se ha eliminado correctamente";
    }
}
