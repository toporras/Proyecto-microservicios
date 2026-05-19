package com.example.ms_torneo.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "torneo")
public class Torneo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="fechaInicio")
    private String fecha_inicio;

    @Column(name="fechaFin")
    private String fecha_fin;

    @Column(name="cantidad_equipos")
    private Integer cantidad_equipos;
}
