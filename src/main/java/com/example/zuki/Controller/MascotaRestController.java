package com.example.zuki.Controller;

import com.example.zuki.Entity.Mascota;
import com.example.zuki.ServiceImplement.MascotaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MascotaRestController {

    @Autowired
    private MascotaServiceImpl mascotaservicesImpl;

    @GetMapping(value = "/tipomascota")
    public String TipoMascota() {
        return "Tipos de mascotas";
    }

    @GetMapping("/tipoMisiones")
    public List<Mascota> lista(){
        List<Mascota> mostrar = mascotaservicesImpl.lista();
        return mostrar;
    }

    @PostMapping(value = "/nuevotipomascota")
    public String save(@RequestBody Mascota Mascota) {
        mascotaservicesImpl.guardar(Mascota);
        return "Tipo de masccota Guardado";
    }


    @GetMapping("/tipoMascota/{id}")
    public Mascota buscarPorId(@PathVariable Long id) {
        Mascota mostrar = mascotaservicesImpl.buscarPorId(id);
        return mostrar;
    }

    @DeleteMapping("/tipoMascota/{id}")
    public String borrarPorId(@PathVariable Long id) {
        mascotaservicesImpl.borrarPorId(id);
        return "El tipo de mascota ha sido borrrado";
    }

    @PutMapping("/tipoMisiones/{id}")
    public Mascota editarPorId(@PathVariable Long id, @RequestBody Mascota actualizado) {
        Mascota editado = mascotaservicesImpl.editarPorId(id, actualizado);
        return editado;

    }
}
