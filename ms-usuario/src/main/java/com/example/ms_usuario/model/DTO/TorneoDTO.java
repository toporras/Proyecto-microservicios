package com.example.ms_usuario.model.DTO;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TorneoDTO {

    private Integer id;
    private String nombre;
    private String fecha_inicio;
    private String fecha_fin;
    private Integer cantidad_equipos;
}
