package com.gerenciamento.gerenciamento.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gerenciamento.gerenciamento.DTO.CursoDTO;
import com.gerenciamento.gerenciamento.entity.CursoEntity;
import com.gerenciamento.gerenciamento.repository.CursoRepository;

@Service
public class CursoService {
    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public CursoDTO convertToDTO(CursoEntity cursoEntity) {
        CursoDTO dto = new CursoDTO();
        dto.setId(cursoEntity.getId());
        dto.setNome(cursoEntity.getNome());
        dto.setDescricao(cursoEntity.getDescricao());

        return dto;
    }

    // Criar um curso
    public CursoDTO create(CursoDTO cursoDTO) {
        // Verificar se curso já existe
        if (cursoRepository.existsByCurso(cursoDTO.getNome())) {
            throw new IllegalArgumentException("Curso já existe na base de dados.");
        }

        CursoEntity cursoEntity = new CursoEntity();
        cursoEntity.setId(cursoDTO.getId());
        cursoEntity.setNome(cursoDTO.getNome());
        cursoEntity.setDescricao(cursoDTO.getDescricao());

        cursoEntity = cursoRepository.save(cursoEntity);
        return convertToDTO(cursoEntity);
    }

    // Atualizar curso
    public CursoDTO update(Long id, CursoDTO cursoDTO) {
        // Verificar se curso já existe
        CursoEntity existingCurso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Já existe curso cadastrado."));

        // CursoEntity cursoEntity = new CursoEntity();
        existingCurso.setId(cursoDTO.getId());
        existingCurso.setNome(cursoDTO.getNome());
        existingCurso.setDescricao(cursoDTO.getDescricao());

        CursoEntity cursoEntity = cursoRepository.save(existingCurso);
        return convertToDTO(cursoEntity);
    }

    // Deletar todos os cursos
    public void deleteAll() {
        cursoRepository.deleteAll();
    }

    // Deletar um curso
    public void deleteById(Long id) {
        cursoRepository.deleteById(id);
    }

    // Listar todos os curso
    public List<CursoDTO> lsitAll() {
        return cursoRepository.findAll().stream()
                .map(this::convertToDTO)
                .toList();
    }
}
