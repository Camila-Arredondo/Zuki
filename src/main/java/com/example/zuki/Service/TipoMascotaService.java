package com.example.zuki.Service;

import com.example.zuki.Entity.TipoMascota;

import java.util.List;

public interface TipoMascotaService {
    List<TipoMascota> ListaTipoMascota();

    TipoMascota buscarTipoMascotaPorId(Long id);

    TipoMascota guardarTipoMascota(TipoMascota TipoMascotaNuevo);

    void borrarTipoMascota(Long id);

    TipoMascota editarTipoMascotaPorId(Long id, TipoMascota TipoMascotaActualizado);

}
