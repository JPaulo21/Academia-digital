package com.dio.academiadigital.web.dto.mapper;

import com.dio.academiadigital.entity.Aluno;
import com.dio.academiadigital.entity.Matricula;
import com.dio.academiadigital.service.AlunoService;
import com.dio.academiadigital.web.dto.matricula.MatriculaConsultaDTO;
import com.dio.academiadigital.web.dto.matricula.MatriculaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AlunoService.class})
public interface MatriculaMapper {

    @Mapping(target = "aluno", source = "alunoId")
    Matricula toMatricula(MatriculaDTO dto);

    List<MatriculaConsultaDTO> toListMatriculaDTO(List<Matricula> matriculas);

    default Aluno mapAlunoIdToAluno(Integer alunoId, AlunoService alunoService){
        return alunoService.encontrarPorId(alunoId);
    }

}
