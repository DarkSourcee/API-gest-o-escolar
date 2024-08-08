package com.gerenciamento.gerenciamento.DTO;

import com.gerenciamento.gerenciamento.enums.CursoEnum;
import com.gerenciamento.gerenciamento.enums.StatusEnum;
import com.gerenciamento.gerenciamento.enums.TurnoEnum;

public class AlunoDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String matricula;
    private CursoEnum curso;
    private StatusEnum status;
    private TurnoEnum turno;
    private Long turma_id;
    private TurmaDTO turmaDTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public TurnoEnum getTurno() {
        return turno;
    }

    public void setTurno(TurnoEnum turno) {
        this.turno = turno;
    }

    public Long getTurma_id() {
        return turma_id;
    }

    public void setTurma_id(Long turma_id) {
        this.turma_id = turma_id;
    }

    public TurmaDTO getTurmaDTO() {
        return turmaDTO;
    }

    public void setTurmaDTO(TurmaDTO turmaDTO) {
        this.turmaDTO = turmaDTO;
    }
}
