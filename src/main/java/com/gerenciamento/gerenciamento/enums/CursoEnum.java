package com.gerenciamento.gerenciamento.enums;

public enum CursoEnum {
    ADMINISTRACAO("administracao"),
    TECNOLOGIA("tecnologia"),
    RH("rh"),
    DIREITO("direito"),
    ENFERMAGEM("enfermagem"),
    CONTABILIDADE("contabilidade");

    private String curso;

    private CursoEnum(String curso) {
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
