package com.example.ms_usuario.model.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PartidoDTO {
    private String nombre;
    private String fecha_partido;
    private String hora_partido;
    private String estadio;
}


