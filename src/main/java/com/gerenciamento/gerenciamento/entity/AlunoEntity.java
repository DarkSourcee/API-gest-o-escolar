package com.gerenciamento.gerenciamento.entity;

import com.gerenciamento.gerenciamento.enums.CursoEnum;
import com.gerenciamento.gerenciamento.enums.StatusEnum;
import com.gerenciamento.gerenciamento.enums.TurnoEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "aluno")
public class AlunoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "matricula")
    private String matricula;

    @Column(name = "curso")
    @Enumerated(EnumType.STRING)
    private CursoEnum curso;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @Column(name = "turno")
    @Enumerated(EnumType.STRING)
    private TurnoEnum turno;

    /* getters e setters */
    public void setId(long id) {
        Id = id;
    }

    public long getId() {
        return Id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public CursoEnum getCurso() {
        return curso;
    }

    public void setCurso(CursoEnum curso) {
        this.curso = curso;
    }

    public TurnoEnum getTurno() {
        return turno;
    }

    public void setTurno(TurnoEnum turno) {
        this.turno = turno;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

}
