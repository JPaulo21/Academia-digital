package com.dio.academiadigital.web.controller;

import com.dio.academiadigital.entity.Aluno;
import com.dio.academiadigital.service.AlunoService;
import com.dio.academiadigital.web.dto.aluno.AlunoDTO;
import com.dio.academiadigital.web.dto.avaliacao.AvaliacaoAlunoDTO;
import com.dio.academiadigital.web.dto.mapper.AlunoMapper;
import com.dio.academiadigital.web.dto.mapper.AvaliacaoFisicaMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/alunos")
public class AlunoController {

    private final AlunoService alunoService;
    private final AvaliacaoFisicaMapper mapper;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid AlunoDTO alunoDTO, UriComponentsBuilder ucb){
        var aluno = alunoService.cadastrar(alunoDTO);
        URI location = ucb
                .path("/api/v1/alunos/{id}")
                .buildAndExpand(aluno.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<AlunoDTO>> listarAlunos(){
        List<AlunoDTO> alunosDTO = alunoService.listarAlunos();
        return ResponseEntity.ok(alunosDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDTO> alunoPorId(@PathVariable Integer id){
        return ResponseEntity.ok(AlunoMapper.INSTANCE.toAlunoDTO(alunoService.encontrarPorId(id)));
    }

    @GetMapping("/avaliacoes/{id}")
    public ResponseEntity<List<AvaliacaoAlunoDTO>> avaliacoesPorAluno(@PathVariable Integer id){
        List<AvaliacaoAlunoDTO> avaliacoes = mapper.toListAvaliacaoAlunoDTO(alunoService.avaliacoesPorIdAluno(id));
        return ResponseEntity.ok(avaliacoes);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<AlunoDTO>> listarAlunosPorDataDeNascimento(@RequestParam(value = "dataDeNascimento", required = false)
                                                                          String dataDeNascimento){
        return ResponseEntity.ok(AlunoMapper.INSTANCE.toListAlunoDTO(alunoService.listarAlunosDataDeNascimento(dataDeNascimento)));
    }
}
