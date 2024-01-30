package com.dio.academiadigital.web.controller;

import com.dio.academiadigital.service.AvaliacaoFisicaService;
import com.dio.academiadigital.web.dto.avaliacao.AvaliacaoFisicaConsultaDTO;
import com.dio.academiadigital.web.dto.avaliacao.AvaliacaoFisicaDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/avaliacoes")
public class AvaliacaoFisicaController {

    private final AvaliacaoFisicaService avaliacaoFisicaService;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid AvaliacaoFisicaDTO avaliacaoFisicaDTO, UriComponentsBuilder ucb){
        var avaliacao = avaliacaoFisicaService.cadastrar(avaliacaoFisicaDTO);
        URI location = ucb
                .path("/api/v1/avaliacoes/{id}")
                .buildAndExpand(avaliacao.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<AvaliacaoFisicaDTO>> listarAvaliacoes(){
        List<AvaliacaoFisicaDTO> avaliacoesDTO = avaliacaoFisicaService.listarAvaliacoes();
        return ResponseEntity.ok(avaliacoesDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvaliacaoFisicaConsultaDTO> buscarAvaliacaoPorId(@PathVariable Integer id){
        AvaliacaoFisicaConsultaDTO avaliacao = avaliacaoFisicaService.buscarAvaliacaoPorId(id);
        return ResponseEntity.ok(avaliacao);
    }

}
