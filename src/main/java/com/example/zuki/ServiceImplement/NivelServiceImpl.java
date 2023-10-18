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
    public List<Nivel> lista() {
        return nivelRepository.findAll ();
    }

    @Override
    public Nivel buscarPorId(Long id) {
        Boolean existe= nivelRepository.existsById(id);
        if(existe){
            Nivel inidicada= nivelRepository.findById(id).get();
            return inidicada;
        }else{
            System.out.println("El ID indicado no existe");
            return null;
        }
    }

    @Override
    public Nivel guardar(Nivel nuevo) {
        return nivelRepository.save((nuevo));
    }

    @Override
    public void borrarPorId(Long id) {
        nivelRepository.deleteById(id);
    }

    @Override
    public Nivel editarPorId(Long id, Nivel actualizado) {
        Boolean existe = nivelRepository.existsById(id);
        if (existe){
            Nivel indicada = nivelRepository.findById(id).get();
            actualizado.setNivelId(id);
            System.out.println("El tipo de misión ha sido actualizado");
            return nivelRepository.save(actualizado);
        }else{
            System.out.println("El ID indicado no existe");
            return null;
        }
    }
    @Override
    public Nivel encontrarNivel(Integer puntos){
        return nivelRepository.encontrarNivel(puntos);
    }
    @Override
    public Nivel sigNivel (Integer nivelActual){
        return nivelRepository.sigNivel(nivelActual);
    }
}
