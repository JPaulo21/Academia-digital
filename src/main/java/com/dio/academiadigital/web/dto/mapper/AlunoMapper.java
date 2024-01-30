package com.dio.academiadigital.web.dto.mapper;

import com.dio.academiadigital.entity.Aluno;
import com.dio.academiadigital.entity.AvaliacaoFisica;
import com.dio.academiadigital.web.dto.aluno.AlunoDTO;
import com.dio.academiadigital.web.dto.avaliacao.AvaliacaoAlunoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AlunoMapper {

    AlunoMapper INSTANCE = Mappers.getMapper(AlunoMapper.class);

    AlunoDTO toAlunoDTO(Aluno aluno);

    Aluno toAluno(AlunoDTO dto);

    List<AlunoDTO> toListAlunoDTO(List<Aluno> alunos);

}
