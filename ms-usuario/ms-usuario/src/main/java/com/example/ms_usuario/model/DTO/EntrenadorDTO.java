package com.example.ms_usuario.model.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntrenadorDTO {

    private Integer id;
    private String nombre;
    private Integer edad;
    private Integer equipoId;
}