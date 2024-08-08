package com.gerenciamento.gerenciamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gerenciamento.gerenciamento.entity.TurmaEntity;

@Repository
public interface TurmaRepository extends JpaRepository<TurmaEntity, Long> {
    // Verificar se já existe o curso
    @Query("select case when count(a) > 0 then true else false end from TurmaEntity a where a.nome = :nome and a.ano = :ano")
    public boolean existsByNomeAndAno(@Param("nome") String nome, @Param("ano") Integer ano);

    // Listar todas as turma de um determinado ano
    @Query("select a from TurmaEntity a where a.ano = :ano")
    public List<TurmaEntity> findByAno(@Param("ano") Integer ano);
}
