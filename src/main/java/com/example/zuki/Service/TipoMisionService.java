package com.example.zuki.Service;

import com.example.zuki.Entity.TipoMision;

import java.util.List;

public interface TipoMisionService {
    List<TipoMision> lista();
    TipoMision buscarPorId(Long id);
    TipoMision guardar(TipoMision nuevo);
    void borrarPorId(Long id);
    TipoMision editarPorId(Long id,TipoMision actualizado);
}
