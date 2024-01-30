package com.dio.academiadigital.web.dto.avaliacao;

import com.dio.academiadigital.web.dto.aluno.AlunoDTO;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record AvaliacaoFisicaConsultaDTO(

        Integer id,
        AlunoDTO aluno,
        double peso,
        double altura
) {
}
