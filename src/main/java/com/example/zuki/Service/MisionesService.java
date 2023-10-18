package com.example.zuki.Service;

import com.example.zuki.Entity.Misiones;

import java.util.List;

public interface MisionesService {
    List<Misiones> lista();
    Misiones buscarPorId(Long id);
    Misiones guardar(Misiones nuevo);
    void borrarPorId(Long id);
    Misiones editarPorId(Long id,Misiones actualizado);
    List<Misiones> misionesPorTipoNoRealizadas (Long tipomision, List<Long> ids);
}
