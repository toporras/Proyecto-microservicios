package com.example.ms_torneo.Model.DTO;
import lombok.Data;

@Data
public class TorneoDTO {
    private String nombre;
    private String fecha_inicio;
    private String fecha_fin;
    private Integer cantidad_equipos;
}
