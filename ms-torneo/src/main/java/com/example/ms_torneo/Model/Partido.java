package com.example.ms_torneo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "partido")
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fecha_partido")
    private String fecha_partido;

    @Column(name = "hora_partido")
    private String hora_partido;

    @Column(name = "estadio")
    private String estadio;

    @ManyToOne
    @JoinColumn(name = "id_torneo")
    private Torneo torneo;

}
