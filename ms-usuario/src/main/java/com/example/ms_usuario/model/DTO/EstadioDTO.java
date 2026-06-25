package com.example.ms_usuario.model.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstadioDTO {

    private Integer id;
    private String nombre;
    private Integer capacidad;
    private String ciudad;
}
