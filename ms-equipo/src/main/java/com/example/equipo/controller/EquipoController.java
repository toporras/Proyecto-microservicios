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


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


import java.util.List;

/*http://localhost:8081/doc/swagger-ui/index.html#/ */
@RestController
@RequestMapping("/equipos")
@Tag(name="Equipos", description = "Operaciones relacionadas con los equipos")
public class EquipoController {


    @Autowired
    private EquipoService service;


    /*listar todos */
    @GetMapping
    @Operation( summary = "Listar equipos", description = "Obtiene una lista con todos los equipos registrados")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de equipos obtenida exitosamente",
            content = @Content( mediaType = "application/json",
                    schema = @Schema(implementation = Equipo.class)))
})
    public List<Equipo> listar(){
        return service.listar();
    }


    /*listar por ID */
    @GetMapping("/{id}")
    @Operation(summary = "Buscar equipo por ID",description = "Obtiene a un equipo mediante su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Equipo encontrado",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Equipo.class))),
        @ApiResponse(responseCode = "404",description = "Equipo no encontrado")
})
    public Equipo buscarPorId(@PathVariable Integer id){
        return service.buscarPorId(id);
    }


    /* el post (guardar otro equipo)  */
    @PostMapping
    @Operation(summary = "Añade un equipo", description = "Añade un nuevo equipo en la lista")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201",description = "Equipo creado exitosamente",
            content = @Content( mediaType = "application/json",
                    schema = @Schema(implementation = Equipo.class))),
        @ApiResponse(responseCode = "400",description = "Datos inválidos")
})
    public Equipo guardar(@RequestBody Equipo equipo){
        return service.guardar(equipo);
    }


    /*actualizar equipos */
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar equipos", description = "Actualiza los datos de un equipo existente mediante su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Equipo actualizado exitosamente ",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Equipo.class))),
        @ApiResponse(responseCode = "404", description = "Equipo no encontrada")
    })
    public Equipo actualizar(@PathVariable Integer id,@RequestBody Equipo equipo){
      equipo.setId(id);  
      return service.actualizar(id, equipo);
    }


    /*eliminar equiipos */
    /*no lleva content porque no devuelve informacion osea no se documenta solo confirma la eliminacion*/
   @DeleteMapping("/{id}")
   @Operation(summary = "Eliminar equipo",description = "Elimina un equipo existente mediante su ID")
   @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Equipo eliminado exitosamente"),
        @ApiResponse( responseCode = "404",description = "Equipo no encontrado")
})
 
   public void eliminar(@PathVariable Integer id){
      service.eliminar(id);
   }
}
