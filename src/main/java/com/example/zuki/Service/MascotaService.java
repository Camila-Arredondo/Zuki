package com.example.zuki.Service;

import com.example.zuki.Entity.Mascota;
import com.example.zuki.Entity.Usuario;

import java.util.List;

public interface MascotaService {

    List<Mascota> lista();

    Mascota buscarPorId(Long id);

    Mascota guardar(Mascota nuevo);

    void borrarPorId(Long id);

    Mascota editarPorId(Long id, Mascota actualizado);
    Mascota buscarMascotaPorIdUsuario (Usuario usuario);
}
