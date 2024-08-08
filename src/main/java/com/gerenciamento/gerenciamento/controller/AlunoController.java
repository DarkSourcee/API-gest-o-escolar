package com.gerenciamento.gerenciamento.controller;

import com.gerenciamento.gerenciamento.DTO.AlunoDTO;
import com.gerenciamento.gerenciamento.service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public ResponseEntity<AlunoDTO> create(@Validated @RequestBody AlunoDTO alunoDTO) {
        AlunoDTO createdAluno = alunoService.create(alunoDTO);
        return new ResponseEntity<>(createdAluno, HttpStatus.CREATED);
    }

    // Listar todos os alunos com status ativo
    @GetMapping("/ativo")
    public ResponseEntity<List<AlunoDTO>> listStatusAtivo() {
        List<AlunoDTO> alunosAtivos = alunoService.listStatusAtivo(); // Agora retorna uma lista de DTOs
        return ResponseEntity.ok(alunosAtivos);
    }

    @GetMapping("/inativo")
    public ResponseEntity<List<AlunoDTO>> listStatusInativo() {
        List<AlunoDTO> alunosInativos = alunoService.listStatusInativo();
        return ResponseEntity.ok(alunosInativos);
    }

    @GetMapping
    public ResponseEntity<List<AlunoDTO>> listAll() {
        List<AlunoDTO> alunos = alunoService.listAll();
        return ResponseEntity.ok(alunos);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteFindAll() {
        alunoService.deleteFindAll();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFindById(@PathVariable("id") Long id) {
        alunoService.deleteFindById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoDTO> update(@PathVariable("id") Long id, @RequestBody AlunoDTO alunoDTO) {
        AlunoDTO updatedAluno = alunoService.update(id, alunoDTO);
        return ResponseEntity.ok(updatedAluno);
    }
}
