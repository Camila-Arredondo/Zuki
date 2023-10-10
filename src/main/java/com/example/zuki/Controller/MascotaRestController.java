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
    private MascotaServiceImpl mascotaServiceImpl;

    @GetMapping(value = "/mascota")
    public List<Mascota> lista() {
        return mascotaServiceImpl.listaDeMascota() ;
    }

    @PostMapping(value = "/nuevamascota")
    public String save(@RequestBody Mascota mascota) {
        mascotaServiceImpl.guardarMascota(mascota);
        return "Mascota Guardada";
    }
    @GetMapping("/mascota/{id}")
    public Mascota buscarPorId (@PathVariable Long id){
        Mascota mostrar = mascotaServiceImpl.buscarMascotaPorId(id);
        return mostrar;
    }

    @DeleteMapping("/borrarmascota/{id}")
    public String borrarPorId (@PathVariable Long id){
        mascotaServiceImpl.borrarMascota(id);
        return "El tipo de mascota ha sido borrrado";
    }

    @PutMapping("/editarmascota/{id}")
    public Mascota editarPorId (@PathVariable Long id, @RequestBody Mascota actualizado) {
        Mascota editado = mascotaServiceImpl.editarMascotaPorId(id, actualizado);
        return editado;

    }
}
