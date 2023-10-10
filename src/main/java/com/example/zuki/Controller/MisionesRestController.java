package com.example.zuki.Controller;

import com.example.zuki.Entity.Misiones;
import com.example.zuki.ServiceImplement.MisionesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class MisionesRestController {
    @Autowired
    MisionesServiceImpl service;

    @GetMapping("/misiones")
    public List<Misiones> lista(){
        List<Misiones> mostrar = service.lista();
        return mostrar;
    }
    @GetMapping("/misiones/{id}")
    public Misiones buscarPorId (@PathVariable Long id){
        Misiones mostrar = service.buscarPorId(id);
        return mostrar;
    }
    @PostMapping("/misiones")
    public Misiones guardar (@RequestBody Misiones nuevo){
        Misiones guardar= service.guardar(nuevo);
        return guardar;
    }
    @DeleteMapping("/misiones/{id}")
    public String borrarPorId (@PathVariable Long id){
        service.borrarPorId(id);
        return "La misión ha sido borrrada";
    }
    @PutMapping("/misiones/{id}")
    public Misiones editarPorId (@PathVariable Long id, @RequestBody Misiones actualizado) {
        Misiones editado = service.editarPorId(id, actualizado);
        return editado;
    }
}
