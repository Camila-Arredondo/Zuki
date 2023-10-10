package com.example.zuki.Service;
import com.example.zuki.Entity.Nivel;

import java.util.List;

public interface NivelService {
    List<Nivel> listaDeNiveles();

    Nivel guardarNivel(Nivel nivelNuevo);

    Nivel buscarPorId(Long id);

    void borrarNivel(Long id);

    Nivel editarNivel(Long id, Nivel nivelActualizado);
}
