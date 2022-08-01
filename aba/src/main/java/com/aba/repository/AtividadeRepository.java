package com.aba.repository;

import com.aba.model.Atividade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Long>{
    Optional<Atividade> findByTitulo(String titulo);
}
