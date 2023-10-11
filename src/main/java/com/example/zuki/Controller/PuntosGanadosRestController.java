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
    private PuntosGanadosServiceImpl puntosGanadosServices;



    @GetMapping("/puntosGanados")
    public List<PuntosGanados> lista(){
        List<PuntosGanados> mostrar = puntosGanadosServices.lista();
        return mostrar;
    }

    @PostMapping(value = "/puntosGanados")
    public String save(@RequestBody PuntosGanados puntosGanados) {
        puntosGanadosServices.guardar(puntosGanados);
        return "Tipo de masccota Guardado";
    }


    @GetMapping("/puntosGanados/{id}")
    public PuntosGanados buscarPorId(@PathVariable Long id) {
        PuntosGanados mostrar = puntosGanadosServices.buscarPorId(id);
        return mostrar;
    }

    @DeleteMapping("/puntosGanados/{id}")
    public String borrarPorId(@PathVariable Long id) {
        puntosGanadosServices.borrarPorId(id);
        return "El tipo de mascota ha sido borrrado";
    }

    @PutMapping("/puntosGanados/{id}")
    public PuntosGanados editarPorId(@PathVariable Long id, @RequestBody PuntosGanados actualizado) {
        PuntosGanados editado = puntosGanadosServices.editarPorId(id, actualizado);
        return editado;

    }


}
