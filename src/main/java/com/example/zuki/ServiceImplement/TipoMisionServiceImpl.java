package com.example.zuki.ServiceImplement;

import com.example.zuki.Entity.TipoMision;
import com.example.zuki.Repository.TipoMisionRepository;
import com.example.zuki.Service.TipoMisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoMisionServiceImpl implements TipoMisionService {
    @Autowired
    TipoMisionRepository repository;

    @Override
    public List<TipoMision> lista() {
        return repository.findAll();
    }

    @Override
    public TipoMision buscarPorId(Long id) {
        Boolean existe= repository.existsById(id);
        if(existe){
            TipoMision inidicada= repository.findById(id).get();
            return inidicada;
        }else{
            System.out.println("El ID indicado no existe");
            return null;
        }
    }

    @Override
    public TipoMision guardar(TipoMision nuevo) {
        return repository.save((nuevo));
    }

    @Override
    public void borrarPorId(Long id) {
        repository.deleteById(id);
    }

    @Override
    public TipoMision editarPorId(Long id, TipoMision actualizado) {
        Boolean existe = repository.existsById(id);
        if (existe){
            TipoMision indicada = repository.findById(id).get();
            indicada.setTipoMision(actualizado.getTipoMision());
            System.out.println("El tipo de misión ha sido actualizado");
            return repository.save(indicada);
        }else{
            System.out.println("El ID indicado no existe");
            return null;
        }
    }
}
