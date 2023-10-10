package com.example.zuki.Service;

import com.example.zuki.Entity.PuntosGanados;

import java.util.List;

public interface PuntosGanadosService {
    List<PuntosGanados> listaDePuntosGanados();

    PuntosGanados buscarPuntosGanadosPorId(Long id);

    PuntosGanados guardarPuntosGanados(PuntosGanados PuntosGanadosNuevo);

    void borrarPuntosGanadosNuevo(Long id);

    PuntosGanados editarPuntosGanados(Long id, PuntosGanados nivelActualizado);
}
