package com.dio.academiadigital.service;

import com.dio.academiadigital.entity.Aluno;
import com.dio.academiadigital.entity.AvaliacaoFisica;
import com.dio.academiadigital.exception.AlunoNotFoundException;
import com.dio.academiadigital.repository.AlunoRepository;
import com.dio.academiadigital.web.dto.aluno.AlunoDTO;
import com.dio.academiadigital.web.dto.mapper.AlunoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public Aluno cadastrar(AlunoDTO alunoDTO) {
        Aluno aluno = AlunoMapper.INSTANCE.toAluno(alunoDTO);
        return alunoRepository.save(aluno);
    }

    public List<AlunoDTO> listarAlunos() {
        return AlunoMapper.INSTANCE.toListAlunoDTO(alunoRepository.findAll());
    }

    public Aluno encontrarPorId(Integer id){
        Optional<Aluno> aluno = alunoRepository.findById(id);
        return aluno.orElseThrow(() -> {
            throw new AlunoNotFoundException("Aluno não encontrado");
        });
    }

    public List<AvaliacaoFisica> avaliacoesPorIdAluno(Integer id) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Aluno não encontrado");
        });

        return aluno.getAvaliacoes();
    }

    public List<Aluno> listarAlunosDataDeNascimento(String dataDeNascimento) {
        if(dataDeNascimento == null){

        }
        LocalDate localDate = LocalDate.parse(dataDeNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return alunoRepository.findByDataDeNascimento(localDate);
    }
}
