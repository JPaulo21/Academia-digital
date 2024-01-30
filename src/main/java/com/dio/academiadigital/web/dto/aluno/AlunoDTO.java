package com.dio.academiadigital.web.dto.aluno;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record AlunoDTO(
        @NotBlank
        @Size(min = 4, max = 100, message = "Campo deve possuir entre 10 a 50 caracteres")
        String nome,

        @CPF(message = "CPF inválido")
        String cpf,

        @NotBlank(message = "Preencha o campo corretamente.")
        String bairro,

        @NotNull(message = "")
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataDeNascimento) {
}
