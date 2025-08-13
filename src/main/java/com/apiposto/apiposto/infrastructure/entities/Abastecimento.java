package com.apiposto.apiposto.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "abastecimento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Abastecimento {

    @id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // relacionamento um para um
    @OneToOne
    @JoinColumn(name = "bomba_combustivel_id")
    private BombasDeCombustivel bombasDeCombustivel;

    @Column(name = "data_abastecimento")
    private LocalDate dataAbastecimento;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @Column(name = "quantidade_litros")
    private Long quantidadeLitros;

}
