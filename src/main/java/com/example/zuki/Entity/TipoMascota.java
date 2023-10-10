package com.example.zuki.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tipoMascota")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class TipoMascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tipoMascotaId;

    public String imagen;

    public String tipoMascota;
}
