package com.apiposto.apiposto.service;

import com.apiposto.apiposto.infrastructure.entities.BombasDeCombustivel;
import com.apiposto.apiposto.infrastructure.entities.TiposDeCombustivel;
import com.apiposto.apiposto.infrastructure.repositories.TipoDeCombustivelRepostory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TiposDeCombustivelService {

    private final TipoDeCombustivelRepostory tipoDeCombustivelRepostory;

    public void criar(TiposDeCombustivel tiposDeCombustivel){
        tipoDeCombustivelRepostory.save(tiposDeCombustivel);
    }

    public TiposDeCombustivel buscarTipoDeCombustivelPorId(Integer id){
        return tipoDeCombustivelRepostory.findById(id).orElseThrow(() -> new NullPointerException("Tipo de combustivel não encontrado pelo id " + id));
    }

    public List<TiposDeCombustivel> buscarTiposDeCombustivel(){
        return tipoDeCombustivelRepostory.findAll();
    }

    @Transactional
    public void deletarTipoDeCombustivel(Integer id){
        tipoDeCombustivelRepostory.deleteById(id);
    }

    public void alterarTipoDeCombustivel(Integer id, TiposDeCombustivel tiposDeCombustivel){
        TiposDeCombustivel tipoCombustivel = buscarTipoDeCombustivelPorId(id);
        tiposDeCombustivel.setId(tipoCombustivel.getId());
        tipoDeCombustivelRepostory.save(tiposDeCombustivel);
    }
}
