package com.example.zuki.Repository;

import com.example.zuki.Entity.Misiones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
 public interface MisionesRepository extends JpaRepository<Misiones,Long> {
}
