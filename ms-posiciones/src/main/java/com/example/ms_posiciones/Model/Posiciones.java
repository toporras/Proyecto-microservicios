package com.example.ms_posiciones.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "posiciones")
public class Posiciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="grupo")
    private String grupo;

    @Column(name="tipo_clasificacion")
    private String tipo_clasificacion;

    @Column(name="posicion")
    private String posicion;

}
