package com.example.zuki.Controller;

import com.example.zuki.Entity.Nivel;
import com.example.zuki.ServiceImplement.NivelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NivelRestController {


    @Autowired
    private NivelServiceImpl nivelService;

    @GetMapping("/nivel")
    public List<Nivel> lista(){
        List<Nivel> mostrar = nivelService.lista();
        return mostrar;
    }

    @PostMapping(value = "/nivel")
    public String save(@RequestBody Nivel Nivel) {
        nivelService.guardar(Nivel);
        return "Nivel guardado";
    }


    @GetMapping("/nivel/{id}")
    public Nivel buscarPorId(@PathVariable Long id) {
        Nivel mostrar = nivelService.buscarPorId(id);
        return mostrar;
    }

    @DeleteMapping("/nivel/{id}")
    public String borrarPorId(@PathVariable Long id) {
        nivelService.borrarPorId(id);
        return "El nivel ha sido borrrado";
    }

    @PutMapping("/nivel/{id}")
    public Nivel editarPorId(@PathVariable Long id, @RequestBody Nivel actualizado) {
        Nivel editado = nivelService.editarPorId(id, actualizado);
        return editado;

    }
}
