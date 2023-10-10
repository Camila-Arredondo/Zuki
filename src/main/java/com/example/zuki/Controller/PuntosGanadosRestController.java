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
    private PuntosGanadosServiceImpl puntosganadosImpl;


    @GetMapping(value = "/listapuntosganados")
    public List<PuntosGanados> Lista(){return puntosganadosImpl.listaDePuntosGanados();}

    @PostMapping(value = "/guardarpuntosganados")
    public String saves(@RequestBody PuntosGanados puntosGanados){
        puntosganadosImpl.guardarPuntosGanados(puntosGanados);
        return "Puntos Guardados";
    }

    @GetMapping("/puntosganados/{id}")
    public PuntosGanados buscarPorId (@PathVariable Long id){
        PuntosGanados mostrar = puntosganadosImpl.buscarPuntosGanadosPorId(id);
        return mostrar;
    }

    @DeleteMapping("/tipoMascota/{id}")
    public String borrarPorId (@PathVariable Long id){
        puntosganadosImpl.borrarPuntosGanadosNuevo(id);
        return "El tipo de mascota ha sido borrrado";
    }

    @PutMapping("/tipoMisiones/{id}")
    public PuntosGanados editarPorId (@PathVariable Long id, @RequestBody PuntosGanados actualizado) {
        PuntosGanados editado = puntosganadosImpl.editarPuntosGanados(id, actualizado);
        return editado;

    }
}
