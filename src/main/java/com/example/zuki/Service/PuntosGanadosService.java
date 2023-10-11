package com.example.zuki.Service;

import com.example.zuki.Entity.PuntosGanados;

import java.util.List;

public interface PuntosGanadosService {

    List<PuntosGanados> lista();

    PuntosGanados buscarPorId(Long id);

    PuntosGanados guardar(PuntosGanados nuevo);

    void borrarPorId(Long id);

    PuntosGanados editarPorId(Long id, PuntosGanados actualizado);
}
