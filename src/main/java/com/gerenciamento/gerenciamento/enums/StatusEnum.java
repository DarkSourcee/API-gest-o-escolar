package com.gerenciamento.gerenciamento.enums;

public enum StatusEnum {
    ATIVO("ativo"),
    INATIVO("inativo");

    private String status;

    private StatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
