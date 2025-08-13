package com.apiposto.apiposto.infrastructure.repositories;

import com.apiposto.apiposto.infrastructure.entities.TiposDeCombustivel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoDeCombustivelRepostory extends JpaRepository<TiposDeCombustivel, Integer> {
}
