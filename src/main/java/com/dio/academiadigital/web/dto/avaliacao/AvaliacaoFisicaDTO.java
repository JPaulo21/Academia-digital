package com.dio.academiadigital.web.dto.avaliacao;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record AvaliacaoFisicaDTO(

        @NotNull(message = "Preencha o campo com o código o aluno.")
        @Positive(message = "O Id do aluno precisa ser positivo.")
        Integer alunoId,

        @NotNull(message = "Preencha o campo peso.")
        @Positive(message = "O peso precisa ser positivo.")
        double peso,

        @NotNull(message = "Preencha o campo altura.")
        @Positive(message = "A altura precisa ser positivo.")
        double altura,

        @PastOrPresent
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime dataDaAvaliacao) {
}
