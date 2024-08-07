package com.gerenciamento.gerenciamento.service;

import com.gerenciamento.gerenciamento.entity.TurmaEntity;
import com.gerenciamento.gerenciamento.repository.TurmaRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TurmaService {
    private final TurmaRepository turmaRepository;

    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    // Criar uma turma
    public List<TurmaEntity> create(TurmaEntity turmaEntity) {
        turmaRepository.save(turmaEntity);
        return listAll();
    }

    // Editar uma turma
    public List<TurmaEntity> update(TurmaEntity turmaEntity) {
        turmaRepository.save(turmaEntity);
        return listAll();
    }

    // Deletar todas as tarefas
    public List<TurmaEntity> deleteFindAll() {
        turmaRepository.deleteAll();
        return listAll();
    }

    // Deletar uma tarefa
    public List<TurmaEntity> deleteFindById(Long id) {
        turmaRepository.deleteById(id);
        return listAll();
    }

    // Listar todos as turmar
    public List<TurmaEntity> listAll() {
        return turmaRepository.findAll();
    }
}
