package com.example.zuki.Controller;

import com.example.zuki.Entity.Nivel;
import com.example.zuki.Entity.TipoMision;
import com.example.zuki.ServiceImplement.NivelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NivelRestController {


    @Autowired
    private NivelServiceImpl nivelServiceImpl;

    @GetMapping(value = "/tipomascota")
    public String TipoMascota() {
        return "Tipos de mascotas";
    }

    @GetMapping("/tipoMisiones")
    public List<Nivel> lista(){
        List<Nivel> mostrar = nivelServiceImpl.lista();
        return mostrar;
    }

    @PostMapping(value = "/nuevotipomascota")
    public String save(@RequestBody Nivel Nivel) {
        nivelServiceImpl.guardar(Nivel);
        return "Tipo de masccota Guardado";
    }


    @GetMapping("/tipoMascota/{id}")
    public Nivel buscarPorId(@PathVariable Long id) {
        Nivel mostrar = nivelServiceImpl.buscarPorId(id);
        return mostrar;
    }

    @DeleteMapping("/tipoMascota/{id}")
    public String borrarPorId(@PathVariable Long id) {
        nivelServiceImpl.borrarPorId(id);
        return "El tipo de mascota ha sido borrrado";
    }

    @PutMapping("/tipoMisiones/{id}")
    public Nivel editarPorId(@PathVariable Long id, @RequestBody Nivel actualizado) {
        Nivel editado = nivelServiceImpl.editarPorId(id, actualizado);
        return editado;

    }
}
