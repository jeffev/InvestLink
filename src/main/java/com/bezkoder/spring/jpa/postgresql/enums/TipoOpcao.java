package com.bezkoder.spring.jpa.postgresql.enums;

public enum TipoOpcao {
    PUTT("putt"),
    CALL("call");

    private String descricao;

    TipoOpcao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

