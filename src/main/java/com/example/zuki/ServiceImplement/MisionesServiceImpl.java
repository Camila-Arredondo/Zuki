package com.example.zuki.ServiceImplement;



import com.example.zuki.Entity.Misiones;
import com.example.zuki.Repository.MisionesRepository;
import com.example.zuki.Service.MisionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MisionesServiceImpl implements MisionesService {
    @Autowired
    MisionesRepository repository;

    @Override
    public List<Misiones> lista() {
        return repository.findAll();
    }

    @Override
    public Misiones buscarPorId(Long id) {
        Boolean existe= repository.existsById(id);
        if(existe){
            Misiones inidcada= repository.findById(id).get();
            return inidcada;
        }else{
            System.out.println("El ID indicado no existe");
            return null;
        }
    }

    @Override
    public Misiones guardar(Misiones nuevo) {
        return repository.save((nuevo));
    }

    @Override
    public void borrarPorId(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Misiones editarPorId(Long id, Misiones actualizado) {
        Boolean existe = repository.existsById(id);
        if (existe){
            Misiones indicada = repository.findById(id).get();
            actualizado.setMisionID(id);
            System.out.println("La misión ha sido actualizada");
            return repository.save(actualizado);
        }else{
            System.out.println("El ID indicado no existe");
            return null;
        }
    }

    @Override
    public List<Misiones> misionesPorTipoNoRealizadas(Long tipomision, List<Long> ids) {
        return repository.findMisionesByTipoAndNotInIds(tipomision, ids);
    }
}
