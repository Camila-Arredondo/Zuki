package com.example.zuki.ServiceImplement;

import com.example.zuki.Entity.PuntosGanados;
import com.example.zuki.Repository.PuntosGanadosRepository;
import com.example.zuki.Service.PuntosGanadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PuntosGanadosServiceImpl implements PuntosGanadosService {

    @Autowired
    private PuntosGanadosRepository puntosGanadosRepository;
    @Override
    public List<PuntosGanados> listaDePuntosGanados() {
        return puntosGanadosRepository.findAll();
    }

    @Override
    public PuntosGanados buscarPuntosGanadosPorId(Long id) {
        return puntosGanadosRepository.findById(id).get();
    }

    @Override
    public PuntosGanados guardarPuntosGanados (PuntosGanados PuntosGanadosNuevo) {
        return puntosGanadosRepository.save(PuntosGanadosNuevo);
    }

    @Override
    public void borrarPuntosGanadosNuevo(Long id) {
    }

    @Override
    public PuntosGanados editarPuntosGanados(Long id, PuntosGanados nivelActualizado) {
        return null;
    }

}
