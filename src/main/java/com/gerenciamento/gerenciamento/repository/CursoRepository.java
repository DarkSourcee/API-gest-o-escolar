package com.gerenciamento.gerenciamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gerenciamento.gerenciamento.entity.CursoEntity;

@Repository
public interface CursoRepository extends JpaRepository<CursoEntity, Long> {
    @Query("select case when count(a) > 0 then true else false end from CursoEntity a where a.nome = :nome")
    public boolean existsByCurso(@Param("nome") String nome);
}
