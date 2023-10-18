package com.example.zuki.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NuevoUsuario {
    private String correo;
    private String clave;
    private String nombre;
    private String nombreMascota;
    private Long tipoMascotaId;
}
