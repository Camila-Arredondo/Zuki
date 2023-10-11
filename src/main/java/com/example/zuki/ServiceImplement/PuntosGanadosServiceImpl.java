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
    public List<PuntosGanados> lista() {
        return puntosGanadosRepository.findAll();
    }

    @Override
    public PuntosGanados buscarPorId(Long id) {
        Boolean existe = puntosGanadosRepository.existsById(id);
        if (existe) {
            PuntosGanados inidicada = puntosGanadosRepository.findById(id).get();
            return inidicada;
        } else {
            System.out.println("El ID indicado no existe");
            return null;
        }
    }

    @Override
    public PuntosGanados guardar(PuntosGanados nuevo) {
        return puntosGanadosRepository.save((nuevo));
    }

    @Override
    public void borrarPorId(Long id) {
        puntosGanadosRepository.deleteById(id);
    }

    @Override
    public PuntosGanados editarPorId(Long id, PuntosGanados actualizado) {
        Boolean existe = puntosGanadosRepository.existsById(id);
        if (existe) {
            PuntosGanados indicada = puntosGanadosRepository.findById(id).get();
            indicada.setPuntosGanadosId(actualizado.getPuntosGanadosId());
            System.out.println("El tipo de misión ha sido actualizado");
            return puntosGanadosRepository.save(indicada);
        } else {
            System.out.println("El ID indicado no existe");
            return null;
        }
    }
}
