package com.apiposto.apiposto.service;

import com.apiposto.apiposto.infrastructure.entities.BombasDeCombustivel;
import com.apiposto.apiposto.infrastructure.repositories.BombaDeCombustivelRepostory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BombaDeCombustivelService {

    private final BombaDeCombustivelRepostory bombaDeCombustivelRepostory;

    // CRUD
    public void criar(BombasDeCombustivel bombaDeCombustivel){
        bombaDeCombustivelRepostory.save(bombaDeCombustivel);
    }

    public List<BombasDeCombustivel> buscarBombasDeCombustivel(){
        return bombaDeCombustivelRepostory.findAll();
    }

    public BombasDeCombustivel buscarBombaDeCombustivelPorId(Integer id){
        return bombaDeCombustivelRepostory.findById(id).orElseThrow(() -> new NullPointerException("Bomba de combustivel não encontrada pelo id " + id));
    }

    @Transactional
    public void deletarBombaDeCombustivel(Integer id){
        bombaDeCombustivelRepostory.deleteById(id);
    }

    public void alterarBombaDeCombustivel(Integer id, BombasDeCombustivel bombasDeCombustivel){
        BombasDeCombustivel bomba = buscarBombaDeCombustivelPorId(id);
        bombasDeCombustivel.setId(bomba.getId());
        bombaDeCombustivelRepostory.save(bombasDeCombustivel);
    }


}
