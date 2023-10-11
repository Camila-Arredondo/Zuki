package com.example.zuki.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="puntosGanados")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PuntosGanados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long puntosGanadosId;

    public Integer puntosExperiencia;

    @ManyToOne
    @JoinColumn(name = "misiones_id")
    private Misiones misiones;

    @ManyToOne
    @JoinColumn(name = "mascota_id")
    private Mascota mascota;

}
