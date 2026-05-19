package com.example.ms_usuario.model.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JugadorDTO {

    private Integer id;
    private String nombre;
    private String posicion;
    private Integer equipoId;
}