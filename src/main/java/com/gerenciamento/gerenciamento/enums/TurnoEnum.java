package com.gerenciamento.gerenciamento.enums;

public enum TurnoEnum {
    MATITUNO("matituno"),
    NOTURNO("noturno");

    private String turno;

    private TurnoEnum(String turno) {
        this.turno = turno;
    }

    public String getTurno() {
        return turno;
    }

    @Override
    public String toString() {
        return turno;
    }
}
