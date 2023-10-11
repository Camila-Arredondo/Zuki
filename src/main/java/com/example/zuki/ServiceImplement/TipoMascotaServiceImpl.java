package com.example.zuki.ServiceImplement;

import com.example.zuki.Entity.TipoMascota;
import com.example.zuki.Repository.TipoMascotaRepository;
import com.example.zuki.Service.TipoMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TipoMascotaServiceImpl implements TipoMascotaService {

    @Autowired
    private TipoMascotaRepository tipoMascotaRepository;

    @Override
    public List<TipoMascota> lista() {
        return tipoMascotaRepository.findAll();
    }

    @Override
    public TipoMascota buscarPorId(Long id) {
        Boolean existe= tipoMascotaRepository.existsById(id);
        if(existe){
            TipoMascota inidicada= tipoMascotaRepository.findById(id).get();
            return inidicada;
        }else{
            System.out.println("El ID indicado no existe");
            return null;
        }
    }

    @Override
    public TipoMascota guardar(TipoMascota nuevo) {
        return tipoMascotaRepository.save((nuevo));
    }

    @Override
    public void borrarPorId(Long id) {
        tipoMascotaRepository.deleteById(id);
    }

    @Override
    public TipoMascota editarPorId(Long id, TipoMascota actualizado) {
        Boolean existe = tipoMascotaRepository.existsById(id);
        if (existe){
            TipoMascota indicada = tipoMascotaRepository.findById(id).get();
            actualizado.setTipoMascotaId(id);
            System.out.println("El tipo de mascota ha sido actualizado");
            return tipoMascotaRepository.save(actualizado);
        }else{
            System.out.println("El ID indicado no existe");
            return null;
        }
    }
}
