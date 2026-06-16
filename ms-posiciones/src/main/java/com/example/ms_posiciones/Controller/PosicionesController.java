package com.example.ms_posiciones.Controller;

import com.example.ms_posiciones.Model.Posiciones;
import com.example.ms_posiciones.Service.PosicionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oar.annotations.Operation;
import io.swagger.v3.oar.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/posiciones")
@Tag(name = "posiciones", description = "Operaciones relacionadas con las posicones")
public class PosicionesController {

    @Autowired
    private PosicionesService posicionesService;


    @PostMapping
    @Operation(summary = "Crea una posicion", description = "Crea una nueva posicion")
    public Posiciones crear(@RequestBody Posiciones posiciones){
        log.info("Informacion: Alguien solicita crear una nueva posicion");
        return posicionesService.crear(posiciones);
    }

    @GetMapping
    @Operation(summary = "Lista las posiciones", description = "Lista todas las posiciones")
    public List<Posiciones> listarPosiciones(){
        log.info("Informacion: Alguien solicita listar todas las posiciones");
        return posicionesService.listarPosiciones();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtiene una posicion", description = "Obtiene una posicion segun su id")
    public Posiciones listarPorId(@PathVariable int id){
        log.info("Informacion: Alguien solicita una posicion por su id");
        return posicionesService.listarPorId(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina una posicion", description = "Elimina una posicion segun su id")
    public String eliminar(@PathVariable int id){
        log.info("Informacion: Alguien solicita eliminar una posicion por su id");
        posicionesService.eliminar(id);
        return "La posicion se ha eliminado correctamente";
    }
}
