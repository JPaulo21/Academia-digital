package com.dio.academiadigital.service;

import com.dio.academiadigital.entity.AvaliacaoFisica;
import com.dio.academiadigital.repository.AlunoRepository;
import com.dio.academiadigital.repository.AvaliacaoFisicaRepository;
import com.dio.academiadigital.web.dto.avaliacao.AvaliacaoFisicaConsultaDTO;
import com.dio.academiadigital.web.dto.avaliacao.AvaliacaoFisicaDTO;
import com.dio.academiadigital.web.dto.mapper.AvaliacaoFisicaMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AvaliacaoFisicaService {

    private final AvaliacaoFisicaMapper mapper;
    private final AvaliacaoFisicaRepository avaliacaoFisicaRepository;
    private final AlunoRepository alunoRepository;

    public AvaliacaoFisica cadastrar(AvaliacaoFisicaDTO avaliacaoFisicaDTO){
        AvaliacaoFisica avaliacaoFisica = mapper.toAvaliacaoFisica(avaliacaoFisicaDTO);
        if(avaliacaoFisica.getDataDaAvaliacao() == null)
            avaliacaoFisica.setDataDaAvaliacao(LocalDateTime.now());

        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }


    public List<AvaliacaoFisicaDTO> listarAvaliacoes() {
        return mapper.toListAvaliacoesDTO(avaliacaoFisicaRepository.findAll());
    }

    public AvaliacaoFisicaConsultaDTO buscarAvaliacaoPorId(Integer id) {
        AvaliacaoFisica avaliacao = avaliacaoFisicaRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Avaliação não encontrada");
        });
        return mapper.toAvaliacaoFisicaConsultaDTO(avaliacao);
    }
}
