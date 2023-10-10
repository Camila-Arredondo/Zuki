package com.example.zuki.Controller;

import com.example.zuki.Entity.TipoMision;
import com.example.zuki.ServiceImplement.TipoMisionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class TipoMisionRestController {
    @Autowired
    TipoMisionServiceImpl service;

    @GetMapping("/tipoMisiones")
    public List<TipoMision> lista(){
        List<TipoMision> mostrar = service.lista();
        return mostrar;
    }
    @GetMapping("/tipoMisiones/{id}")
    public TipoMision buscarPorId (@PathVariable Long id){
        TipoMision mostrar = service.buscarPorId(id);
        return mostrar;
    }
    @PostMapping("/tipoMisiones")
    public TipoMision guardar (@RequestBody TipoMision nuevo){
        TipoMision guardar= service.guardar(nuevo);
        return guardar;
    }
    @DeleteMapping("/tipoMisiones/{id}")
    public String borrarPorId (@PathVariable Long id){
        service.borrarPorId(id);
        return "El tipo de misión ha sido borrrado";
    }
    @PutMapping("/tipoMisiones/{id}")
    public TipoMision editarPorId (@PathVariable Long id, @RequestBody TipoMision actualizado) {
        TipoMision editado = service.editarPorId(id, actualizado);
        return editado;
    }
}
