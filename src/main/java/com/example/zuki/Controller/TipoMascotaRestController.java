package com.example.zuki.Controller;

import com.example.zuki.Entity.TipoMascota;
import com.example.zuki.ServiceImplement.TipoMascotaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*") // Permitir cualquier origen solo para este método

@RequestMapping("/api")
public class TipoMascotaRestController {
    @Autowired
    private TipoMascotaServiceImpl tipoMascotaService;


    @GetMapping("/tipoMascota")
    public ResponseEntity<?> lista(){
        List<TipoMascota> mostrar = tipoMascotaService.lista();
        return ResponseEntity.ok(mostrar);
    }

    @PostMapping(value = "/tipoMascota")
    public String save(@RequestBody TipoMascota tipoMascota) {
        tipoMascotaService.guardar(tipoMascota);
        return "Tipo de masccota Guardado";
    }


    @GetMapping("/tipoMascota/{id}")
    public TipoMascota buscarPorId(@PathVariable Long id) {
        TipoMascota mostrar = tipoMascotaService.buscarPorId(id);
        return mostrar;
    }

    @DeleteMapping("/tipoMascota/{id}")
    public String borrarPorId(@PathVariable Long id) {
        tipoMascotaService.borrarPorId(id);
        return "El tipo de mascota ha sido borrrado";
    }

    @PutMapping("/tipoMascota/{id}")
    public TipoMascota editarPorId(@PathVariable Long id, @RequestBody TipoMascota actualizado) {
        TipoMascota editado = tipoMascotaService.editarPorId(id, actualizado);
        return editado;

    }
}
