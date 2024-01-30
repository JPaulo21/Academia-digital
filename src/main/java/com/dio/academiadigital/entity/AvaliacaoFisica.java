package com.dio.academiadigital.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import com.dio.academiadigital.entity.Aluno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "AVALIACAO_FISICA")
public class AvaliacaoFisica {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false) //
    private Aluno aluno;

    @Column(name = "data_da_avaliacao", nullable = false)
    private LocalDateTime dataDaAvaliacao;

    private double peso;

    private double altura;
}
