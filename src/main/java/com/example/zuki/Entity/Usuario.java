package com.example.zuki.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="usuario")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long usuarioId;

    @NotNull
    public String usuario;

    @NotNull
    public String correo;

    @NotNull
    public String clave;


    @OneToOne(mappedBy = "usuario")
    private Mascota mascota;


}
