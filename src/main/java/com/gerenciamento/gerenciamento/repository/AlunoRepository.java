package com.gerenciamento.gerenciamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.gerenciamento.gerenciamento.entity.AlunoEntity;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoEntity, Long> {
    // filtrar status ativo
    @Query("select a from AlunoEntity a where a.status = 'ATIVO'")
    public List<AlunoEntity> listStatusAtivo();

    // filtrar status inativo
    @Query("select a from AlunoEntity a where a.status = 'INATIVO'")
    public List<AlunoEntity> listStatusInativo();

    @Query("select case when count(a) > 0 then true else false end from AlunoEntity a where a.cpf = :cpf")
    public boolean existsByCpf(@Param("cpf") String cpf);
}
