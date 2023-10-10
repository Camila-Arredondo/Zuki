package com.example.zuki.ServiceImplement;

import com.example.zuki.Entity.Mascota;
import com.example.zuki.Repository.MascotaRepository;
import com.example.zuki.Service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MascotaServiceImpl implements MascotaService {
    @Autowired
    private MascotaRepository mascotaRepository;
    @Override
    public List<Mascota> listaDeMascota() {
        return mascotaRepository.findAll();
    }

    @Override
    public Mascota buscarMascotaPorId(Long id) {return mascotaRepository.findById(id).get();}

    @Override
    public Mascota guardarMascota (Mascota mascotaNuevo) {
        return mascotaRepository.save(mascotaNuevo);
    }

    @Override
    public void borrarMascota(Long id) {

    }

    @Override
    public Mascota editarMascotaPorId(Long id, Mascota mascotaActualizado) {
        return null;
    }
}
