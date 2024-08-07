package com.gerenciamento.gerenciamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciamento.gerenciamento.entity.TurmaEntity;

@Repository
public interface TurmaRepository extends JpaRepository<TurmaEntity, Long> {

}
