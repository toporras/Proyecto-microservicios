package com.example.ms_estadio.controller;

import com.example.ms_estadio.model.Estadio;
import com.example.ms_estadio.service.EstadioService;
import com.example.ms_estadio.assemblers.EstadioModelAssembler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/v2/estadio")
public class EstadioControllerV2 {


    @Autowired
    private EstadioService estadioService;

    @Autowired
    private EstadioModelAssembler assembler;


    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public CollectionModel<EntityModel<Estadio>> getAllEstadios() {

        List<EntityModel<Estadio>> estadios = estadioService.listar()
                .stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());


        return CollectionModel.of(
                estadios,
                linkTo(methodOn(EstadioControllerV2.class)
                .getAllEstadios())
                .withSelfRel()
        );
    }


    @GetMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public EntityModel<Estadio> getEstadioById(@PathVariable int id) {

        Estadio estadio = estadioService.findById(id);

        return assembler.toModel(estadio);
    }


    @PostMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Estadio>> createEstadio(
            @RequestBody Estadio estadio) {


        Estadio newEstadio = estadioService.guardar(estadio);


        return ResponseEntity
                .created(
                    linkTo(methodOn(EstadioControllerV2.class)
                    .getEstadioById(newEstadio.getId()))
                    .toUri()
                )
                .body(assembler.toModel(newEstadio));
    }



    @PutMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Estadio>> updateEstadio(
            @PathVariable int id,
            @RequestBody Estadio estadio) {
        Estadio estadioActual = estadioService.findById(id);
        estadioActual.setNombre(estadio.getNombre());
        Estadio updatedEstadio = estadioService.guardar(estadioActual);
        return ResponseEntity
                .ok(assembler.toModel(updatedEstadio));
    }

    @DeleteMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<?> deleteEstadio(@PathVariable int id) {

        estadioService.eliminar(id);

        return ResponseEntity.noContent().build();
    }

}