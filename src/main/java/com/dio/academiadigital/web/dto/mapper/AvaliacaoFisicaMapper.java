package com.dio.academiadigital.web.dto.mapper;

import com.dio.academiadigital.entity.Aluno;
import com.dio.academiadigital.entity.AvaliacaoFisica;
import com.dio.academiadigital.service.AlunoService;
import com.dio.academiadigital.web.dto.aluno.AlunoDTO;
import com.dio.academiadigital.web.dto.avaliacao.AvaliacaoAlunoDTO;
import com.dio.academiadigital.web.dto.avaliacao.AvaliacaoFisicaConsultaDTO;
import com.dio.academiadigital.web.dto.avaliacao.AvaliacaoFisicaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AlunoService.class})
public interface AvaliacaoFisicaMapper {

    @Mapping(target = "alunoId", source = "aluno.id")
    AvaliacaoFisicaDTO toAvaliacaoFisicaDTO(AvaliacaoFisica avaliacaoFisica);

    @Mapping(target = "aluno", source = "alunoId")
    @Mapping(target = "dataDaAvaliacao", source = "dataDaAvaliacao")
    AvaliacaoFisica toAvaliacaoFisica(AvaliacaoFisicaDTO dto);

    @Mapping(target = "aluno", source = "aluno")
    AvaliacaoFisicaConsultaDTO toAvaliacaoFisicaConsultaDTO(AvaliacaoFisica avaliacaoFisica);

    List<AvaliacaoFisicaDTO> toListAvaliacoesDTO(List<AvaliacaoFisica> avaliacoes);

    List<AvaliacaoAlunoDTO> toListAvaliacaoAlunoDTO(List<AvaliacaoFisica> avaliacoes);

    default Aluno mapAlunoIdToAluno(Integer alunoId, AlunoService alunoService){
        return alunoService.encontrarPorId(alunoId);
    }

    default Aluno mapAlunoToAluno(Integer alunoId, AlunoService alunoService){
        return alunoService.encontrarPorId(alunoId);
    }

}
