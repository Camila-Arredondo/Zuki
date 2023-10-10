package com.example.zuki.Controller;

import com.example.zuki.Entity.TipoMision;
import com.example.zuki.Entity.Usuario;
import com.example.zuki.ServiceImplement.TipoMisionServiceImpl;
import com.example.zuki.ServiceImplement.UsuarioServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioRestController {
    @Autowired
    UsuarioServiceImp service;

    @GetMapping("/usuario")
    public List<Usuario> lista(){
        List<Usuario> mostrar = service.lista();
        return mostrar;
    }
    @GetMapping("/usuario/{id}")
    public Usuario buscarPorId (@PathVariable Long id){
        Usuario mostrar = service.buscarPorId(id);
        return mostrar;
    }
    @PostMapping("/usuario")
    public Usuario guardar (@RequestBody Usuario nuevo){
        Usuario guardar= service.guardar(nuevo);
        return guardar;
    }
    @DeleteMapping("/usuario/{id}")
    public String borrarPorId (@PathVariable Long id){
        service.borrarPorId(id);
        return "El usuario ha sido borrrado";
    }
    @PutMapping("/usuario/{id}")
    public Usuario editarPorId (@PathVariable Long id, @RequestBody Usuario actualizado) {
        Usuario editado = service.editarPorId(id, actualizado);
        return editado;
    }
}
