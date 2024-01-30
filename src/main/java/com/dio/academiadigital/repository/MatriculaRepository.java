package com.dio.academiadigital.repository;

import com.dio.academiadigital.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {

    @Query("FROM Matricula m WHERE m.aluno.bairro = :bairro")
    public List<Matricula> matriculasPorBairro(String bairro);

}
