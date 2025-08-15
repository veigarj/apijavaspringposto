package com.apiposto.apiposto.service;

import com.apiposto.apiposto.infrastructure.entities.Abastecimento;
import com.apiposto.apiposto.infrastructure.entities.BombasDeCombustivel;
import com.apiposto.apiposto.infrastructure.repositories.AbastecimentoRepostory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AbastecimentoService {

    private final AbastecimentoRepostory abastecimentoRepostory;
    private final BombaDeCombustivelService bombaDeCombustivelService;

    public void abastecer(Integer idBomba, Long litros){
        BombasDeCombustivel bomba = bombaDeCombustivelService.buscarBombaDeCombustivelPorId(idBomba);
        BigDecimal valorTotal = bomba.getTiposDeCombustivel().getPrecoPorLitro().multiply(BigDecimal.valueOf(litros));

        Abastecimento abastecimento = Abastecimento.builder()
                .dataAbastecimento(LocalDate.now())
                .bombasDeCombustivel(bomba)
                .valorTotal(valorTotal)
                .quantidadeLitros(litros)
                .build();

        abastecimentoRepostory.save(abastecimento);

    }

    public List<Abastecimento> buscarAbastecimentos(){
        return abastecimentoRepostory.findAll();
    }
}
