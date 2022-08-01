package com.aba.repository;

import com.aba.model.PlanoObjetivos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoObjetivosRepository extends JpaRepository<PlanoObjetivos, Long> {
}
