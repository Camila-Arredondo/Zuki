package com.example.zuki.Service;

import com.example.zuki.Entity.TipoMascota;

import java.util.List;

public interface TipoMascotaService {

    List<TipoMascota> lista();

    TipoMascota buscarPorId(Long id);

    TipoMascota guardar(TipoMascota nuevo);

    void borrarPorId(Long id);

    TipoMascota editarPorId(Long id, TipoMascota actualizado);
}
