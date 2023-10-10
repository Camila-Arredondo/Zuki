package com.example.zuki.ServiceImplement;

import com.example.zuki.Entity.Nivel;
import com.example.zuki.Repository.NivelRepository;
import com.example.zuki.Service.NivelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NivelServiceImpl implements NivelService {

    @Autowired
    NivelRepository nivelRepository;

    @Override
    public List<Nivel> listaDeNiveles() {
        return nivelRepository.findAll();
    }

    @Override
    public Nivel guardarNivel(Nivel nivelNuevo) {
        return nivelRepository.save(nivelNuevo);
    }

    @Override
    public Nivel buscarPorId(Long id){
        return nivelRepository.findById(id).get();
    }

    @Override
    public void borrarNivel(Long id) {
        nivelRepository.deleteById(id);
    }

    @Override
    public Nivel editarNivel(Long id, Nivel nivelActualizado) {
        Boolean existe = nivelRepository.existsById(id);
        if (existe) {
            Nivel nivelSeleccionado = nivelRepository.findById(id).get();
            nivelSeleccionado.setNivel(nivelActualizado.getNivel());
            nivelSeleccionado.setExperiencia(nivelSeleccionado.getExperiencia());
            return nivelRepository.save(nivelSeleccionado);
        } else {
            System.out.println("El Nivel es incorrecto o no existe");
            return null;
        }
    }
}
