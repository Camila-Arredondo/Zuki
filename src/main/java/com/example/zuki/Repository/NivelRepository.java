package com.example.zuki.Repository;

import com.example.zuki.Entity.Nivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NivelRepository extends JpaRepository<Nivel,Long> {

    @Query(value = "SELECT * FROM nivel WHERE experiencia < :experienciaActual ORDER BY experiencia DESC LIMIT 1", nativeQuery = true)
    Nivel encontrarNivel(@Param("experienciaActual") Integer experienciaActual);
    @Query(value = "select * from nivel where nivel = :nivelActual + 1 limit 1", nativeQuery = true)
    Nivel sigNivel(@Param("nivelActual") Integer nivelActual);

}
