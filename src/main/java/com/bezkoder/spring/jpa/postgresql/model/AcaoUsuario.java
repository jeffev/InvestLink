package com.bezkoder.spring.jpa.postgresql.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AcaoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String ticker;
    private String login;
    private double precoMedio;

    private int quantidade;

    private double precoAlvo;

    private double precoTeto;

    private double percentualDesejado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public double getPrecoMedio() {
        return precoMedio;
    }

    public void setPrecoMedio(double precoMedio) {
        this.precoMedio = precoMedio;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoAlvo() {
        return precoAlvo;
    }

    public void setPrecoAlvo(double precoAlvo) {
        this.precoAlvo = precoAlvo;
    }

    public double getPrecoTeto() {
        return precoTeto;
    }

    public void setPrecoTeto(double precoTeto) {
        this.precoTeto = precoTeto;
    }

    public double getPercentualDesejado() {
        return percentualDesejado;
    }

    public void setPercentualDesejado(double percentualDesejado) {
        this.percentualDesejado = percentualDesejado;
    }

    public double getValorTotal() {
        return (precoMedio * quantidade);
    }

    @Override
    public String toString() {
        return "AcaoUsuario{" +
                "id=" + id +
                ", ticker='" + ticker + '\'' +
                ", login='" + login + '\'' +
                ", precoMedio=" + precoMedio +
                ", quantidade=" + quantidade +
                ", precoAlvo=" + precoAlvo +
                ", precoTeto=" + precoTeto +
                ", percentualDesejado=" + percentualDesejado +
                ", valorTotal=" + (precoMedio * quantidade) +
                '}';
    }
}
