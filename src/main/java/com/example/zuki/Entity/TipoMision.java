package com.example.zuki.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="tipoMision")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoMision {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long tipoMisionID;

    @Column(name="tipoMision")
    @NotNull
    private String tipoMision;


    @OneToMany(mappedBy = "tipoMision")
    private List<Misiones> misiones;
}
