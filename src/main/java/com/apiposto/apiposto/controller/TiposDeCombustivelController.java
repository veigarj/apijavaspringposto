package com.apiposto.apiposto.controller;

import com.apiposto.apiposto.infrastructure.entities.Abastecimento;
import com.apiposto.apiposto.infrastructure.entities.TiposDeCombustivel;
import com.apiposto.apiposto.service.TiposDeCombustivelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("tiposDeCombustivel")
public class TiposDeCombustivelController {

    private final TiposDeCombustivelService tiposDeCombustivelService;

    @PostMapping
    public ResponseEntity<Void> criar(@RequestBody TiposDeCombustivel tiposDeCombustivel){
        tiposDeCombustivelService.criar(tiposDeCombustivel);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<TiposDeCombustivel>> buscarAbastecimentos(){
        return ResponseEntity.ok(tiposDeCombustivelService.buscarTiposDeCombustivel());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TiposDeCombustivel> buscarTiposDeCombustivelPorId(@PathVariable(name = "id") Integer id){
        return ResponseEntity.ok(tiposDeCombustivelService.buscarTipoDeCombustivelPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTipoDeCombustivelPorId(@PathVariable(name = "id") Integer id){
        tiposDeCombustivelService.deletarTipoDeCombustivel(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> alterarTipoDeCombustivel(@RequestParam(name = "id") Integer id, @RequestBody TiposDeCombustivel tiposDeCombustivel){
        tiposDeCombustivelService.alterarTipoDeCombustivel(id, tiposDeCombustivel);
        return ResponseEntity.ok().build();
    }



}
