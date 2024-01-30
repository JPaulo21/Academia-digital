package com.dio.academiadigital.web.controller;

import com.dio.academiadigital.service.MatriculaService;
import com.dio.academiadigital.web.dto.mapper.MatriculaMapper;
import com.dio.academiadigital.web.dto.matricula.MatriculaConsultaDTO;
import com.dio.academiadigital.web.dto.matricula.MatriculaDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/matriculas")
public class MatriculaController {

    private final MatriculaService matriculaService;
    private final MatriculaMapper mapper;

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid MatriculaDTO matriculaDTO, UriComponentsBuilder ucb){
        var matricula = matriculaService.cadastrar(mapper.toMatricula(matriculaDTO));
        URI location = ucb
                .path("/api/v1/matriculas/{id}")
                .buildAndExpand(matricula.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<MatriculaConsultaDTO>> listarTodasAsMatriculas(){
        List<MatriculaConsultaDTO> matriculas = mapper.toListMatriculaDTO(matriculaService.listarMatriculas());
        return ResponseEntity.ok(matriculas);
    }

    @GetMapping("buscar")
    public ResponseEntity<List<MatriculaConsultaDTO>> matriculasPorBairro(@RequestParam(value = "bairro", required = false)
                                                                          String bairro){
        List<MatriculaConsultaDTO> matriculas = mapper.toListMatriculaDTO(matriculaService.matriculasPorBairro(bairro));
        return ResponseEntity.ok(matriculas);
    }

}
