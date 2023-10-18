package com.example.zuki.ServiceImplement;

import com.example.zuki.Entity.Usuario;
import com.example.zuki.Repository.UsuarioRepository;
import com.example.zuki.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImp implements UsuarioService {
    @Autowired
    UsuarioRepository repository;

    @Override
    public List<Usuario> lista() {
        return repository.findAll();
    }

    @Override
    public Usuario buscarPorId(Long id) {
        Boolean existe = repository.existsById(id);
        if (existe) {
            Usuario indicado = repository.findById(id).get();
            return indicado;
        } else {
            System.out.println("El ID indicado no existe");
            return null;
        }
    }

    @Override
    public Usuario guardar(Usuario usuarioNuevo) {
        return repository.save((usuarioNuevo));
    }

    @Override
    public void borrarPorId(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Usuario editarPorId(Long id, Usuario usuarioActualizado) {
        Boolean existe = repository.existsById(id);
        if (existe) {
            Usuario indicada = repository.findById(id).get();
            usuarioActualizado.setUsuarioId(id);
            System.out.println("El usuario ha sido actualizado");
            return repository.save(usuarioActualizado);
        } else {
            System.out.println("El ID indicado no existe");
            return null;
        }

    }

    @Override
    public Usuario IniciarSesion(String correo, String clave){
        return repository.findByCorreoAndClave(correo, clave);
    }

    @Override
    public Usuario buscarPorCorreo(String correo){
        return  repository.findByCorreo(correo);
    }
}
