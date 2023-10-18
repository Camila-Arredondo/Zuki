package com.example.zuki.DTO;


import com.example.zuki.Entity.TipoMascota;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InfoUsuario {
    private String nombreUsuario;
    private String nombreMascota;
    private TipoMascota tipoMascota;
    private Integer nivel;
    private Integer expTotal;
    private Integer expSigNivel;

    private String Token;
}
