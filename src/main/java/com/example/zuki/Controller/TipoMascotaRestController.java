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
    private TipoMascotaServiceImpl tipoMascotaserviceImpl;

    @GetMapping(value = "/listatipomascota")
    public List<TipoMascota> lista(){return tipoMascotaserviceImpl.ListaTipoMascota();}

    @PostMapping(value = "/nuevotipomascota")
    public String save(@RequestBody TipoMascota tipoMascota){
        tipoMascotaserviceImpl.guardarTipoMascota(tipoMascota);
        return "Tipo de masccota Guardado";
    }
    @GetMapping("/tipoMascota/{id}")
    public TipoMascota buscarPorId (@PathVariable Long id){
        TipoMascota mostrar = tipoMascotaserviceImpl.buscarTipoMascotaPorId(id);
        return mostrar;
    }

    @DeleteMapping("/tipoMascota/{id}")
    public String borrarPorId (@PathVariable Long id){
        tipoMascotaserviceImpl.borrarTipoMascota(id);
        return "El tipo de mascota ha sido borrrado";
    }

    @PutMapping("/tipoMisiones/{id}")
    public TipoMascota editarPorId (@PathVariable Long id, @RequestBody TipoMascota actualizado) {
        TipoMascota editado = tipoMascotaserviceImpl.editarTipoMascotaPorId(id, actualizado);
        return editado;

    }
}
