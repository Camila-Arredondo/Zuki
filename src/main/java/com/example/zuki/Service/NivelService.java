package com.example.zuki.Service;
import com.example.zuki.Entity.Nivel;

import java.util.List;

public interface NivelService {

    List<Nivel> lista();

    Nivel buscarPorId(Long id);

    Nivel guardar(Nivel nuevo);

    void borrarPorId(Long id);

    Nivel editarPorId(Long id, Nivel actualizado);
}
