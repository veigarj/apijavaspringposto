package com.apiposto.apiposto.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "bombas_de_combustivel")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BombasDeCombustivel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    // relacionamento muitos para um
    @ManyToOne
    @JoinColumn(name = "combustivel_id")
    private TiposDeCombustivel tiposDeCombustivel;
}
