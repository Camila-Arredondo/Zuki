package com.example.zuki.Service;

import com.example.zuki.Entity.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> lista();
    Usuario buscarPorId(Long id);
    Usuario guardar(Usuario usuarioNuevo);
    void borrarPorId(Long id);
    Usuario editarPorId(Long id,Usuario usuarioActualizado);

}
