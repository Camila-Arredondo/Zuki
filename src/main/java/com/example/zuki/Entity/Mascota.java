package com.example.zuki.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="mascota")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long mascotaId;

    public String nombre;

}
