package com.example.zuki.Service;

import com.example.zuki.Entity.Mascota;

import java.util.List;

public interface MascotaService {
    List<Mascota> listaDeMascota();

    Mascota buscarMascotaPorId(Long id);

    Mascota guardarMascota(Mascota mascotaNuevo);

    void borrarMascota(Long id);

    Mascota editarMascotaPorId(Long id, Mascota nivelActualizado);
}
