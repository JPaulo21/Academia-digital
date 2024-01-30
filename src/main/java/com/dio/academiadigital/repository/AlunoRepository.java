package com.dio.academiadigital.repository;

import com.dio.academiadigital.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    /**
     *
     * @param dataDeNascimento: data de nascimento dos alunos
     * @return lista todos os alunos com a data de nascimento passada como parâmetro da função
     *
     */
    List<Aluno> findByDataDeNascimento(LocalDate dataDeNascimento);
}
