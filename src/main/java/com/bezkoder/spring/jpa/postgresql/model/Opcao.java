package com.bezkoder.spring.jpa.postgresql.model;

import com.bezkoder.spring.jpa.postgresql.enums.TipoOpcao;
import com.bezkoder.spring.jpa.postgresql.enums.TipoOperacao;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "opcao")
public class Opcao {
    @Id
    private String ticker;

    private String tickerAcao;

    private Double precoPago;

    private Double strike;

    private Double precoAtual;

    private Date vencimento;

    @Enumerated(EnumType.ORDINAL)
    private TipoOpcao tipo;

    @Enumerated(EnumType.ORDINAL)
    private TipoOperacao operacao;

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getTickerAcao() {
        return tickerAcao;
    }

    public void setTickerAcao(String tickerAcao) {
        this.tickerAcao = tickerAcao;
    }

    public Double getPrecoPago() {
        return precoPago;
    }

    public void setPrecoPago(Double precoPago) {
        this.precoPago = precoPago;
    }

    public Double getStrike() {
        return strike;
    }

    public void setStrike(Double strike) {
        this.strike = strike;
    }

    public Double getPrecoAtual() {
        return precoAtual;
    }

    public void setPrecoAtual(Double precoAtual) {
        this.precoAtual = precoAtual;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public TipoOpcao getTipo() {
        return tipo;
    }

    public void setTipo(TipoOpcao tipo) {
        this.tipo = tipo;
    }

    public TipoOperacao getOperacao() {
        return operacao;
    }

    public void setOperacao(TipoOperacao operacao) {
        this.operacao = operacao;
    }

    public Double getQuantoFaltaStrinke () {
        if (this.tipo == TipoOpcao.PUTT) return (this.precoAtual - this.strike);
        else return (this.strike - this.precoAtual);
    }

    @Override
    public String toString() {
        return "Opcao{" +
                "ticker='" + ticker + '\'' +
                ", tickerAcao=" + tickerAcao +
                ", precoPago=" + precoPago +
                ", strike=" + strike +
                ", precoAtual=" + precoAtual +
                ", vencimento=" + vencimento +
                ", tipo=" + tipo +
                ", operacao=" + operacao +
                ", quantoFaltaStrike=" + getQuantoFaltaStrinke() +
                '}';
    }
}
