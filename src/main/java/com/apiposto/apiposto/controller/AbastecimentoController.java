package com.apiposto.apiposto.controller;

import com.apiposto.apiposto.infrastructure.entities.Abastecimento;
import com.apiposto.apiposto.service.AbastecimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/abastecimento")
public class AbastecimentoController {

    private final AbastecimentoService abastecimentoService;

    @PostMapping
    public ResponseEntity<Void> abastecer(@RequestParam("quantidadeEmLitros") Long litros, @RequestParam("idBomba") Integer idBomba) {
        abastecimentoService.abastecer(idBomba, litros);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<Abastecimento>> buscarAbastecimentos() {
        return ResponseEntity.ok(abastecimentoService.buscarAbastecimentos());
    }
}
