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
    public List<TipoMascota> ListaTipoMascota(){return tipoMascotaRepository.findAll();}

    @Override
    public TipoMascota buscarTipoMascotaPorId(Long id){return tipoMascotaRepository.findById(id).get();}

    @Override
    public TipoMascota guardarTipoMascota (TipoMascota TipoMascotaNuevo){return tipoMascotaRepository.save(TipoMascotaNuevo);}

    @Override
    public void borrarTipoMascota(Long id){}

    @Override
    public TipoMascota editarTipoMascotaPorId(Long id, TipoMascota TipoMascotaActualizado){return null;}


}
