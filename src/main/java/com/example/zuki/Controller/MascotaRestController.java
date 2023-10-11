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
    private MascotaServiceImpl mascotaService;

    @GetMapping("/mascota")
    public List<Mascota> lista(){
        List<Mascota> mostrar = mascotaService.lista();
        return mostrar;
    }

    @PostMapping(value = "/mascota")
    public String save(@RequestBody Mascota Mascota) {
        mascotaService.guardar(Mascota);
        return "Mascota guardada";
    }


    @GetMapping("/mascota/{id}")
    public Mascota buscarPorId(@PathVariable Long id) {
        Mascota mostrar = mascotaService.buscarPorId(id);
        return mostrar;
    }

    @DeleteMapping("/mascota/{id}")
    public String borrarPorId(@PathVariable Long id) {
        mascotaService.borrarPorId(id);
        return "La mascota ha sido borrrada";
    }

    @PutMapping("/mascota/{id}")
    public Mascota editarPorId(@PathVariable Long id, @RequestBody Mascota actualizado) {
        Mascota editado = mascotaService.editarPorId(id, actualizado);
        return editado;

    }
}
