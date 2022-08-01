package com.aba.repository;

import com.aba.model.Turma;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long>{
    Optional<Turma> findByNomeTurma(String nomeTurma);
}
