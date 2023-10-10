package com.example.zuki.Repository;

import com.example.zuki.Entity.TipoMision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoMisionRepository extends JpaRepository<TipoMision, Long> {
}
