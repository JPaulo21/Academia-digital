package com.dio.academiadigital.service;

import com.dio.academiadigital.entity.Matricula;
import com.dio.academiadigital.repository.MatriculaRepository;
import com.dio.academiadigital.web.dto.matricula.MatriculaDTO;
import com.dio.academiadigital.web.dto.mapper.MatriculaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MatriculaService {

    private final MatriculaMapper mapper;

    private final MatriculaRepository matriculaRepository;

    public Matricula cadastrar(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    public List<Matricula> listarMatriculas(){
        return matriculaRepository.findAll();
    }

    public Matricula encontrarPorId(Integer id){
        Optional<Matricula> optionalMatricula = matriculaRepository.findById(id);
        return optionalMatricula.orElseThrow(() -> {
            throw new RuntimeException("Não encontrada a matricula");
        });
    }

    public List<Matricula> matriculasPorBairro(String bairro){
        return matriculaRepository.matriculasPorBairro(bairro);
    }
}
