package com.gerenciamento.gerenciamento.controller;

import com.gerenciamento.gerenciamento.DTO.TurmaDTO;
import com.gerenciamento.gerenciamento.service.TurmaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turma")
public class TurmaController {

    private final TurmaService turmaService;

    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    // Criar uma turma
    @PostMapping
    public ResponseEntity<TurmaDTO> create(@RequestBody TurmaDTO turmaDTO) {
        TurmaDTO createdTurma = turmaService.create(turmaDTO);
        return new ResponseEntity<>(createdTurma, HttpStatus.CREATED);
    }

    // Listar todas as turmas
    @GetMapping
    public ResponseEntity<List<TurmaDTO>> listAll() {
        List<TurmaDTO> turmas = turmaService.listAll();
        return ResponseEntity.ok(turmas);
    }

    // Listagem por ano
    @GetMapping("/porAno/{ano}")
    public ResponseEntity<List<TurmaDTO>> listagemPorAno(@PathVariable("ano") Integer ano) {
        List<TurmaDTO> turmasPorAno = turmaService.listagemPorAno(ano);
        return ResponseEntity.ok(turmasPorAno);
    }

    // Atualizar uma turma
    @PutMapping("/{id}")
    public ResponseEntity<TurmaDTO> update(@PathVariable("id") Long id, @RequestBody TurmaDTO turmaDTO) {
        TurmaDTO updatedTurma = turmaService.update(id, turmaDTO);
        return ResponseEntity.ok(updatedTurma);
    }

    // Deletar todas as turmas
    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        turmaService.deleteAll();
        return ResponseEntity.noContent().build();
    }

    // Deletar uma turma específica
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        turmaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
