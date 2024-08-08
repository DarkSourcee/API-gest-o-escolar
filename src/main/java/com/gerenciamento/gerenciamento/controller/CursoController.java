package com.gerenciamento.gerenciamento.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciamento.gerenciamento.DTO.CursoDTO;
import com.gerenciamento.gerenciamento.service.CursoService;

@RestController
@RequestMapping("curso")
public class CursoController {
    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    // Criar uma turma
    @PostMapping
    public ResponseEntity<CursoDTO> create(@RequestBody CursoDTO cursoDTO) {
        CursoDTO created = cursoService.create(cursoDTO);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // Listar todas as turmas
    @GetMapping
    public ResponseEntity<List<CursoDTO>> listAll() {
        List<CursoDTO> cursos = cursoService.lsitAll();
        return ResponseEntity.ok(cursos);
    }

    // Atualizar uma turma
    @PutMapping("/{id}")
    public ResponseEntity<CursoDTO> update(@PathVariable("id") Long id, @RequestBody CursoDTO cursoDTO) {
        CursoDTO updated = cursoService.update(id, cursoDTO);
        return ResponseEntity.ok(updated);
    }

    // Deletar todas as turmas
    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        cursoService.deleteAll();
        return ResponseEntity.noContent().build();
    }

    // Deletar uma turma específica
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        cursoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
