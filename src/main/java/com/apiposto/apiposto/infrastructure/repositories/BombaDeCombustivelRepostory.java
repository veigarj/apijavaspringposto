package com.apiposto.apiposto.infrastructure.repositories;

import com.apiposto.apiposto.infrastructure.entities.BombasDeCombustivel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BombaDeCombustivelRepostory extends JpaRepository<BombasDeCombustivel, Integer> {
}
