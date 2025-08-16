package com.apiposto.apiposto.controller;

import com.apiposto.apiposto.infrastructure.entities.BombasDeCombustivel;
import com.apiposto.apiposto.service.BombaDeCombustivelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bombasDeCombustivel")
public class BombasDeCombustivelController {

    private final BombaDeCombustivelService bombaDeCombustivelService;

    @PostMapping
    public ResponseEntity<Void> criar(@RequestBody BombasDeCombustivel bombasDeCombustivel) {
        bombaDeCombustivelService.criar(bombasDeCombustivel);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<BombasDeCombustivel>> buscarBombasDeCombustivel(){
        return ResponseEntity.ok(bombaDeCombustivelService.buscarBombasDeCombustivel());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BombasDeCombustivel> buscarBombasDeCombustivelPorId(@PathVariable(name = "id") Integer id){
        return ResponseEntity.ok(bombaDeCombustivelService.buscarBombaDeCombustivelPorId(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarBombasDeCombustivelPorId(@PathVariable(name = "id") Integer id){
        bombaDeCombustivelService.deletarBombaDeCombustivel(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> alterarBombaDeCombustivel(@PathVariable(name = "id") Integer id, @RequestBody BombasDeCombustivel bombasDeCombustivel){
    bombaDeCombustivelService.alterarBombaDeCombustivel(id,bombasDeCombustivel);
    return ResponseEntity.ok().build();
    }


}
