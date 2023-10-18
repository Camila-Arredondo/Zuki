package com.example.zuki.Repository;

import com.example.zuki.Entity.Mascota;
import com.example.zuki.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {
    Mascota findByUsuario(Usuario usuario);
}
