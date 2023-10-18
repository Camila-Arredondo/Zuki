package com.example.zuki.ServiceImplement;

import com.example.zuki.Entity.Mascota;
import com.example.zuki.Entity.Usuario;
import com.example.zuki.Repository.MascotaRepository;
import com.example.zuki.Service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MascotaServiceImpl implements MascotaService {
    // Inyección de dependencia

    @Autowired
    private MascotaRepository mascotaRepository;

    @Override
    public List<Mascota> lista() {
        return mascotaRepository.findAll();
    }

    @Override
    public Mascota buscarPorId(Long id) {
        Boolean existe = mascotaRepository.existsById(id);
        if (existe) {
            Mascota inidicada = mascotaRepository.findById(id).get();
            return inidicada;
        } else {
            System.out.println("El ID indicado no existe");
            return null;
        }
    }

    @Override
    public Mascota guardar(Mascota nuevo) {
        return mascotaRepository.save((nuevo));
    }

    @Override
    public void borrarPorId(Long id) {
        mascotaRepository.deleteById(id);
    }

    @Override
    public Mascota editarPorId(Long id, Mascota actualizado) {
        Boolean existe = mascotaRepository.existsById(id);
        if (existe) {
            Mascota indicada = mascotaRepository.findById(id).get();
            actualizado.setMascotaId(id);
            System.out.println("la mascota ha sido actualizado");
            return mascotaRepository.save(actualizado);
        } else {
            System.out.println("El ID indicado no existe");
            return null;
        }
    }
    @Override
    public Mascota buscarMascotaPorIdUsuario(Usuario usuario) {
        return mascotaRepository.findByUsuario(usuario);
    }
}
