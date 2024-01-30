package com.dio.academiadigital.web.dto.aluno;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record AlunoUpdateDTO(
        @NotBlank
        @Size(min = 10, max = 100, message = "Campo deve possuir entre 10 a 50 caracteres")
        String nome,

        @NotEmpty(message = "Preencha o campo corretamente.")
        String bairro,

        @NotNull
        LocalDate dataDeNascimento
) {
}
