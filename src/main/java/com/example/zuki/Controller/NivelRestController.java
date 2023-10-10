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
    NivelServiceImpl nivelService;

    @GetMapping("/nivelLista")
    public List<Nivel> listaDeNiveles() {
        List<Nivel> listaMostrar = nivelService.listaDeNiveles();
        return listaMostrar;
    }

    @GetMapping("/nivelBuscar/{id}")
    public Nivel buscarPorId (@PathVariable Long id){
        Nivel mostrar = nivelService.buscarPorId(id);
        return mostrar;
    }

    @PostMapping("/nuevo")
    public Nivel crearNivel(@RequestBody Nivel nivelNuevo) {
        return nivelService.guardarNivel(nivelNuevo);
    }

    @PutMapping("/nivelEditar/{id}")
    public Nivel editarUsuarioPorId(@RequestParam Long id, @RequestBody Nivel nivelActualizado) {
        Nivel nivelEditado = nivelService.editarNivel(id, nivelActualizado);
        return nivelEditado;
    }

    @DeleteMapping("/nivelBorrar/{id}")
    public String borrarNivelPorId(@RequestParam Long id) {
        nivelService.borrarNivel(id);
        return "El usuario ha sido borrado.";
    }

}
