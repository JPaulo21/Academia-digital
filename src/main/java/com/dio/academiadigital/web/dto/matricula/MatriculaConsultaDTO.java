package com.dio.academiadigital.web.dto.matricula;

import com.dio.academiadigital.entity.Aluno;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record MatriculaConsultaDTO(
        Integer id,
        Aluno aluno,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime dataDaMatricula
) {
}
