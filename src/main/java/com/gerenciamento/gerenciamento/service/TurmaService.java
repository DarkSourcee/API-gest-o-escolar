package com.gerenciamento.gerenciamento.service;

import com.gerenciamento.gerenciamento.DTO.TurmaDTO;
import com.gerenciamento.gerenciamento.entity.TurmaEntity;
import com.gerenciamento.gerenciamento.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {
    private final TurmaRepository turmaRepository;

    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    // Verificar se a turma existe na base de dados
    private boolean existeTurmaBase(String nome, Integer ano) {
        return turmaRepository.existsByNomeAndAno(nome, ano); // Método ajustado para verificar a existência
    }

    public TurmaDTO convertToDTO(TurmaEntity turmaEntity) {
        TurmaDTO turmaDTO = new TurmaDTO();
        turmaDTO.setId(turmaEntity.getId());
        turmaDTO.setNome(turmaEntity.getNome());
        turmaDTO.setAno(turmaEntity.getAno());
        turmaDTO.setPeriodo(turmaEntity.getPeriodo());
        return turmaDTO;
    }

    // Criar uma turma
    public TurmaDTO create(TurmaDTO turmaDTO) {
        if (existeTurmaBase(turmaDTO.getNome(), turmaDTO.getAno())) {
            throw new RuntimeException("Turma já existe na base de dados");
        }

        TurmaEntity turmaEntity = new TurmaEntity();
        turmaEntity.setNome(turmaDTO.getNome());
        turmaEntity.setAno(turmaDTO.getAno());
        turmaEntity.setPeriodo(turmaDTO.getPeriodo());

        turmaEntity = turmaRepository.save(turmaEntity);
        return convertToDTO(turmaEntity);
    }

    // Atualizar uma turma
    public TurmaDTO update(Long id, TurmaDTO turmaDTO) {
        TurmaEntity existingTurma = turmaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));

        existingTurma.setNome(turmaDTO.getNome());
        existingTurma.setAno(turmaDTO.getAno());
        existingTurma.setPeriodo(turmaDTO.getPeriodo());

        TurmaEntity updatedTurma = turmaRepository.save(existingTurma);
        return convertToDTO(updatedTurma);
    }

    // Deletar todas as turmas
    public void deleteAll() {
        turmaRepository.deleteAll();
    }

    // Deletar uma turma específica
    public void deleteById(Long id) {
        turmaRepository.deleteById(id);
    }

    // Listar todas as turmas
    public List<TurmaDTO> listAll() {
        return turmaRepository.findAll().stream()
                .map(this::convertToDTO)
                .toList();
    }

    // Listar todas as turmas de um determinado ano
    public List<TurmaDTO> listagemPorAno(Integer ano) {
        return turmaRepository.findByAno(ano).stream()
                .map(this::convertToDTO)
                .toList();
    }
}
