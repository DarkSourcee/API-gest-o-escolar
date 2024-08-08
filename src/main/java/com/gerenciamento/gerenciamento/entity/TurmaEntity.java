package com.gerenciamento.gerenciamento.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "turma")
public class TurmaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "ano")
    private Integer ano;

    @Column(name = "periodo")
    private String periodo;

    @OneToMany(mappedBy = "turma")
    private Set<AlunoEntity> alunos;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Set<AlunoEntity> getAlunos() {
        return alunos;
    }

    public void setAlunos(Set<AlunoEntity> alunos) {
        this.alunos = alunos;
    }
}
