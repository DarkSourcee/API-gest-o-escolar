package com.gerenciamento.gerenciamento.controller;

import com.gerenciamento.gerenciamento.service.AlunoService;
import com.gerenciamento.gerenciamento.entity.AlunoEntity;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    private AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    // criar um aluno
    @PostMapping
    List<AlunoEntity> create(@RequestBody AlunoEntity alunoEntity) {
        return alunoService.create(alunoEntity);
    }

    // listar todos os alunos com status ativo
    @GetMapping("/ativo")
    List<AlunoEntity> listStatusAtivo() {
        return alunoService.listStatusAtivo();
    }

    // // listar todos os alunos com status inativo
    @GetMapping("/inativo")
    List<AlunoEntity> listStatusInativo() {
        return alunoService.listStatusIntivo();
    }

    // listar todos os alunos
    @GetMapping
    List<AlunoEntity> listAll() {
        return alunoService.listAll();
    }

    // deletar todos os alunos
    @DeleteMapping
    List<AlunoEntity> deleteFindAll() {
        return alunoService.deleteFindAll();
    }

    // deletar um aluno especifico
    @DeleteMapping("/{id}")
    List<AlunoEntity> deleteFindById(@PathVariable("id") Long id) {
        return alunoService.deleteFindById(id);
    }

    // atualizar um aluno
    List<AlunoEntity> update(@RequestBody AlunoEntity alunoEntity) {
        return alunoService.update(alunoEntity);
    }
}
