package com.example.zuki.Controller;

import com.example.zuki.Entity.TipoMascota;
import com.example.zuki.ServiceImplement.TipoMascotaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TipoMascotaRestController {
    @Autowired
    private TipoMascotaServiceImpl tipoMascotaservicesImpl;

    @GetMapping(value = "/tipomascota")
    public String TipoMascota() {
        return "Tipos de mascotas";
    }

    @GetMapping("/tipoMisiones")
    public List<TipoMascota> lista(){
        List<TipoMascota> mostrar = tipoMascotaservicesImpl.lista();
        return mostrar;
    }

    @PostMapping(value = "/nuevotipomascota")
    public String save(@RequestBody TipoMascota tipoMascota) {
        tipoMascotaservicesImpl.guardar(tipoMascota);
        return "Tipo de masccota Guardado";
    }


    @GetMapping("/tipoMascota/{id}")
    public TipoMascota buscarPorId(@PathVariable Long id) {
        TipoMascota mostrar = tipoMascotaservicesImpl.buscarPorId(id);
        return mostrar;
    }

    @DeleteMapping("/tipoMascota/{id}")
    public String borrarPorId(@PathVariable Long id) {
        tipoMascotaservicesImpl.borrarPorId(id);
        return "El tipo de mascota ha sido borrrado";
    }

    @PutMapping("/tipoMisiones/{id}")
    public TipoMascota editarPorId(@PathVariable Long id, @RequestBody TipoMascota actualizado) {
        TipoMascota editado = tipoMascotaservicesImpl.editarPorId(id, actualizado);
        return editado;

    }
}
