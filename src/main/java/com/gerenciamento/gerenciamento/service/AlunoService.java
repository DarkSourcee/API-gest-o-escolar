package com.gerenciamento.gerenciamento.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.gerenciamento.gerenciamento.DTO.AlunoDTO;
import com.gerenciamento.gerenciamento.DTO.CursoDTO;
import com.gerenciamento.gerenciamento.DTO.TurmaDTO;
import com.gerenciamento.gerenciamento.entity.AlunoEntity;
import com.gerenciamento.gerenciamento.entity.CursoEntity;
import com.gerenciamento.gerenciamento.entity.TurmaEntity;
import com.gerenciamento.gerenciamento.repository.AlunoRepository;
import com.gerenciamento.gerenciamento.repository.CursoRepository;
import com.gerenciamento.gerenciamento.repository.TurmaRepository;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final TurmaRepository turmaRepository;
    private final CursoRepository cursoRepository;

    public AlunoService(AlunoRepository alunoRepository, TurmaRepository turmaRepository,
            CursoRepository cursoRepository) {
        this.alunoRepository = alunoRepository;
        this.turmaRepository = turmaRepository;
        this.cursoRepository = cursoRepository;
    }

    public AlunoDTO convertToDTO(AlunoEntity alunoEntity) {
        AlunoDTO dto = new AlunoDTO();
        dto.setId(alunoEntity.getId());
        dto.setNome(alunoEntity.getNome());
        dto.setCpf(alunoEntity.getCpf());
        dto.setMatricula(alunoEntity.getMatricula());
        dto.setStatus(alunoEntity.getStatus());
        dto.setTurno(alunoEntity.getTurno());
        if (alunoEntity.getTurma() != null) {
            dto.setTurma_id(alunoEntity.getTurma().getId());
        }
        if (alunoEntity.getCurso() != null) {
            dto.setCurso_id(alunoEntity.getCurso().getId());
        }

        // Preenchendo dados da turma
        if (alunoEntity.getTurma() != null) {
            TurmaDTO turmaDTO = new TurmaDTO();
            turmaDTO.setId(alunoEntity.getTurma().getId());
            turmaDTO.setNome(alunoEntity.getTurma().getNome());
            dto.setTurmaDTO(turmaDTO);
        }

        // Preenchendo o curso
        if (alunoEntity.getCurso() != null) {
            CursoDTO cursoDTO = new CursoDTO();
            cursoDTO.setId(alunoEntity.getCurso().getId());
            cursoDTO.setNome(alunoEntity.getCurso().getNome());
            dto.setCursoDTO(cursoDTO);
        }

        return dto;
    }

    public AlunoDTO create(AlunoDTO alunoDTO) {
        // verificar se aluno já existe na base
        if (alunoRepository.existsByCpf(alunoDTO.getCpf())) {
            throw new IllegalArgumentException("Aluno com CPF já existente");
        }

        if (alunoDTO.getTurma_id() == null) {
            throw new IllegalArgumentException("Turma deve ser informada.");
        }

        if (alunoDTO.getCurso_id() == null) {
            throw new IllegalArgumentException("Curso deve ser informado.");
        }

        TurmaEntity turma = turmaRepository.findById(alunoDTO.getTurma_id())
                .orElseThrow(() -> new IllegalArgumentException("Turma não encontrada"));

        CursoEntity curso = cursoRepository.findById(alunoDTO.getCurso_id())
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrada"));

        AlunoEntity alunoEntity = new AlunoEntity();
        alunoEntity.setNome(alunoDTO.getNome());
        alunoEntity.setCpf(alunoDTO.getCpf());
        alunoEntity.setMatricula(alunoDTO.getMatricula());
        alunoEntity.setStatus(alunoDTO.getStatus());
        alunoEntity.setTurno(alunoDTO.getTurno());
        alunoEntity.setTurma(turma);
        alunoEntity.setCurso(curso);

        alunoEntity = alunoRepository.save(alunoEntity);
        return convertToDTO(alunoEntity);
    }

    public List<AlunoDTO> listStatusAtivo() {
        // Obtendo a lista de entidades com status ATIVO
        List<AlunoEntity> alunosAtivos = alunoRepository.listStatusAtivo();

        // Convertendo as entidades para DTOs
        return alunosAtivos.stream()
                .map(this::convertToDTO) // Usando o método convertToDTO para incluir os dados da turma
                .collect(Collectors.toList());
    }

    public List<AlunoDTO> listStatusInativo() {
        return alunoRepository.listStatusInativo()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<AlunoDTO> listAll() {
        // Obtendo todos os alunos
        List<AlunoEntity> todosAlunos = alunoRepository.findAll();

        // Convertendo as entidades para DTOs
        return todosAlunos.stream()
                .map(this::convertToDTO) // Converte AlunoEntity para AlunoDTO
                .collect(Collectors.toList());
    }

    public void deleteFindAll() {
        alunoRepository.deleteAll();
    }

    public void deleteFindById(Long id) {
        alunoRepository.deleteById(id);
    }

    public AlunoDTO update(Long id, AlunoDTO alunoDTO) {
        AlunoEntity alunoEntity = alunoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado"));

        alunoEntity.setNome(alunoDTO.getNome());
        alunoEntity.setCpf(alunoDTO.getCpf());
        alunoEntity.setMatricula(alunoDTO.getMatricula());
        alunoEntity.setStatus(alunoDTO.getStatus());
        alunoEntity.setTurno(alunoDTO.getTurno());

        if (alunoDTO.getTurma_id() != null) {
            TurmaEntity turma = turmaRepository.findById(alunoDTO.getTurma_id())
                    .orElseThrow(() -> new IllegalArgumentException("Turma não encontrada"));
            alunoEntity.setTurma(turma);
        }

        alunoEntity = alunoRepository.save(alunoEntity);
        return convertToDTO(alunoEntity);
    }
}
