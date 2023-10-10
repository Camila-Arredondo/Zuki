package com.example.zuki.Repository;

import com.example.zuki.Entity.PuntosGanados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PuntosGanadosRepository extends JpaRepository<PuntosGanados,Long> {
}
