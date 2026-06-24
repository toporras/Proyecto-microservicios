package com.example.ms_estadio.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.example.ms_estadio.controller.EstadioControllerV2;
import com.example.ms_estadio.model.Estadio;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;    

@Component
public class EstadioModelAssembler implements RepresentationModelAssembler<Estadio, EntityModel<Estadio>> {

    @Override
    public EntityModel<Estadio> toModel(Estadio estadio) {
        return EntityModel.of(estadio,
                linkTo(methodOn(EstadioControllerV2.class).getEstadioById(estadio.getId())).withSelfRel(),
                linkTo(methodOn(EstadioControllerV2.class).getAllEstadios()).withRel("Estadios"));
    }
}