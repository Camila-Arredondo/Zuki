package com.example.zuki.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="nivel")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Nivel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nivelId;

    @NotNull
    private Integer nivel;

    @NotNull
    private Integer experiencia;
}
