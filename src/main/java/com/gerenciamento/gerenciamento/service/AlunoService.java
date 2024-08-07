package com.gerenciamento.gerenciamento.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gerenciamento.gerenciamento.entity.AlunoEntity;
import com.gerenciamento.gerenciamento.repository.AlunoRepository;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    // Criar aluno
    public List<AlunoEntity> create(AlunoEntity alunoEntity) {
        // verificar se aluno já existe na base
        if (alunoRepository.existsByCpf(alunoEntity.getCpf())) {
            throw new RuntimeException("Aluno com CPF já existente");
        }

        alunoRepository.save(alunoEntity);
        return listAll();
    }

    // Listar somente alunos ativos
    public List<AlunoEntity> listStatusAtivo() {
        return alunoRepository.listStatusAtivo();
    }

    // // Listar somente alunos inativos
    public List<AlunoEntity> listStatusIntivo() {
        return alunoRepository.listStatusInativo();
    }

    // Listar todos os alunos
    public List<AlunoEntity> listAll() {
        return alunoRepository.findAll();
    }

    // deletar todos os alunos
    public List<AlunoEntity> deleteFindAll() {
        alunoRepository.deleteAll();
        return listAll();
    }

    // deletar um aluno especifico
    public List<AlunoEntity> deleteFindById(Long id) {
        alunoRepository.deleteById(id);
        return listAll();
    }

    // editar dados dos alunos
    public List<AlunoEntity> update(AlunoEntity alunoEntity) {
        alunoRepository.save(alunoEntity);
        return listAll();
    }
}
