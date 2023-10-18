package com.example.zuki.Repository;

import com.example.zuki.Entity.Misiones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
 public interface MisionesRepository extends JpaRepository<Misiones,Long> {
 @Query("SELECT m FROM Misiones m WHERE m.tipoMision = :tipomision AND m.misionID NOT IN :ids")
 List<Misiones> findMisionesByTipoAndNotInIds(
         @Param("tipomision") Long tipomision,
         @Param("ids") List<Long> ids
 );
}
