package com.example.zuki.Repository;

import com.example.zuki.Entity.Nivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NivelRepository extends JpaRepository<Nivel,Long> {
}
