package com.example.zuki.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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



    @JsonIgnore
    @OneToMany(mappedBy = "tipoMascota")
    private List<Mascota> mascotas;
}
