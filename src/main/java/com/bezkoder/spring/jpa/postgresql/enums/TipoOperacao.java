package com.bezkoder.spring.jpa.postgresql.enums;

public enum TipoOperacao {
    COMPRA("compra"),
    VENDA("venda");

    private String descricao;

    TipoOperacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
