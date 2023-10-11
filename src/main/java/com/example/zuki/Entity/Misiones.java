package com.example.zuki.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="misiones")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Misiones {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long misionID;

    @Column(name="tituloMision")
    @NotNull
    private String tituloMision;

    @Column(name="descipcionMision")
    @NotNull
    private String descipcionMision;

    @Column(name="experienciaMision")
    @NotNull
    private Integer experienciaMision;

    @Column(name="ubicaciónMision")
    @NotNull
    private String ubicaciónMision;

    @Column(name="qrMision")
    @NotNull
    private String qrMision;

    @Column(name = "fotoMision")
    @NotNull
    private String fotoMision;


    @ManyToOne
    @JoinColumn(name = "tipomision_id")
    private TipoMision tipoMision;


    @OneToMany(mappedBy = "misiones")
    private List<PuntosGanados> puntosGanados;

}
