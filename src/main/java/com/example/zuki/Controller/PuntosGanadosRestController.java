package com.example.zuki.Controller;

import com.example.zuki.Entity.PuntosGanados;
import com.example.zuki.ServiceImplement.PuntosGanadosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")

public class PuntosGanadosRestController {
    @Autowired
    private PuntosGanadosServiceImpl puntosGanadosService;

    @GetMapping("/puntosGanados")
    public List<PuntosGanados> lista(){
        List<PuntosGanados> mostrar = puntosGanadosService.lista();
        return mostrar;
    }

    @PostMapping(value = "/puntosGanados")
    public String save(@RequestBody PuntosGanados puntosGanados) {
        puntosGanadosService.guardar(puntosGanados);
        return "Tipo de masccota Guardado";
    }


    @GetMapping("/puntosGanados/{id}")
    public PuntosGanados buscarPorId(@PathVariable Long id) {
        PuntosGanados mostrar = puntosGanadosService.buscarPorId(id);
        return mostrar;
    }

    @DeleteMapping("/puntosGanados/{id}")
    public String borrarPorId(@PathVariable Long id) {
        puntosGanadosService.borrarPorId(id);
        return "Puntos ganados ha sido borrrado";
    }

    @PutMapping("/puntosGanados/{id}")
    public PuntosGanados editarPorId(@PathVariable Long id, @RequestBody PuntosGanados actualizado) {
        PuntosGanados editado = puntosGanadosService.editarPorId(id, actualizado);
        return editado;

    }


}
