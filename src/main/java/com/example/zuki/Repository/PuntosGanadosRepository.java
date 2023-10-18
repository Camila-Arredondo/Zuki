package com.example.zuki.Repository;

import com.example.zuki.Entity.Mascota;
import com.example.zuki.Entity.PuntosGanados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PuntosGanadosRepository extends JpaRepository<PuntosGanados,Long> {

    List<PuntosGanados> findByMascota(Mascota mascota);
}
