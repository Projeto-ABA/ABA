package com.aba.repository;

import com.aba.model.Instrutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstrutorRepository extends JpaRepository<Instrutor, Long>{
    Optional<Instrutor> findByEmail(String email);
}
