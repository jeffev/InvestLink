package com.bezkoder.spring.jpa.postgresql.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "stocks")
public class Acao {
    @Id
    @Column(name = "ticker")
    private String ticker;

    @Column(name = "preco")
    private BigDecimal preco;

    @Column(name = "pl")
    private BigDecimal pl;

    @Column(name = "dy")
    private BigDecimal dy;

    @Column(name = "pvp")
    private BigDecimal pvp;

    @Column(name = "p_ebit")
    private BigDecimal pEbit;

    @Column(name = "p_ativos")
    private BigDecimal pAtivos;

    @Column(name = "ev_ebit")
    private BigDecimal evEbit;

    @Column(name = "margem_bruta")
    private BigDecimal margemBruta;

    @Column(name = "margem_ebit")
    private BigDecimal margemEbit;

    @Column(name = "margem_liquida")
    private BigDecimal margemLiquida;

    @Column(name = "p_cap_giro")
    private BigDecimal pCapGiro;

    @Column(name = "p_ativo_circ_liq")
    private BigDecimal pAtivoCircLiq;

    @Column(name = "liq_corrente")
    private BigDecimal liqCorrente;

    @Column(name = "roe")
    private BigDecimal roe;

    @Column(name = "roa")
    private BigDecimal roa;

    @Column(name = "roic")
    private BigDecimal roic;

    @Column(name = "divida_liquida_patri")
    private BigDecimal dividaLiquidaPatri;

    @Column(name = "psr")
    private BigDecimal psr;

    @Column(name = "divida_liquida_ebit")
    private BigDecimal dividaLiquidaEbit;

    @Column(name = "patrimonio_ativos")
    private BigDecimal patrimonioAtivos;

    @Column(name = "passivo_ativos")
    private BigDecimal passivoAtivos;

    @Column(name = "cagr_receita5anos")
    private BigDecimal cagrReceita5Anos;

    @Column(name = "cagr_lucros5anos")
    private BigDecimal cagrLucros5Anos;

    @Column(name = "giro_ativos")
    private BigDecimal giroAtivos;

    @Column(name = "liquidez")
    private BigDecimal liquidez;

    @Column(name = "peg_ratio")
    private BigDecimal pegRatio;

    @Column(name = "vpa")
    private BigDecimal vpa;

    @Column(name = "lpa")
    private BigDecimal lpa;

    @Column(name = "valor_mercado")
    private BigDecimal valorMercado;

    @Transient
    private int rankRoe;

    @Transient
    private int rankPl;

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getPl() {
        return pl;
    }

    public void setPl(BigDecimal pl) {
        this.pl = pl;
    }

    public BigDecimal getDy() {
        return dy;
    }

    public void setDy(BigDecimal dy) {
        this.dy = dy;
    }

    public BigDecimal getPvp() {
        return pvp;
    }

    public void setPvp(BigDecimal pvp) {
        this.pvp = pvp;
    }

    public BigDecimal getpEbit() {
        return pEbit;
    }

    public void setpEbit(BigDecimal pEbit) {
        this.pEbit = pEbit;
    }

    public BigDecimal getpAtivos() {
        return pAtivos;
    }

    public void setpAtivos(BigDecimal pAtivos) {
        this.pAtivos = pAtivos;
    }

    public BigDecimal getEvEbit() {
        return evEbit;
    }

    public void setEvEbit(BigDecimal evEbit) {
        this.evEbit = evEbit;
    }

    public BigDecimal getMargemBruta() {
        return margemBruta;
    }

    public void setMargemBruta(BigDecimal margemBruta) {
        this.margemBruta = margemBruta;
    }

    public BigDecimal getMargemEbit() {
        return margemEbit;
    }

    public void setMargemEbit(BigDecimal margemEbit) {
        this.margemEbit = margemEbit;
    }

    public BigDecimal getMargemLiquida() {
        return margemLiquida;
    }

    public void setMargemLiquida(BigDecimal margemLiquida) {
        this.margemLiquida = margemLiquida;
    }

    public BigDecimal getpCapGiro() {
        return pCapGiro;
    }

    public void setpCapGiro(BigDecimal pCapGiro) {
        this.pCapGiro = pCapGiro;
    }

    public BigDecimal getpAtivoCircLiq() {
        return pAtivoCircLiq;
    }

    public void setpAtivoCircLiq(BigDecimal pAtivoCircLiq) {
        this.pAtivoCircLiq = pAtivoCircLiq;
    }

    public BigDecimal getLiqCorrente() {
        return liqCorrente;
    }

    public void setLiqCorrente(BigDecimal liqCorrente) {
        this.liqCorrente = liqCorrente;
    }

    public BigDecimal getRoe() {
        return roe;
    }

    public void setRoe(BigDecimal roe) {
        this.roe = roe;
    }

    public BigDecimal getRoa() {
        return roa;
    }

    public void setRoa(BigDecimal roa) {
        this.roa = roa;
    }

    public BigDecimal getRoic() {
        return roic;
    }

    public void setRoic(BigDecimal roic) {
        this.roic = roic;
    }

    public BigDecimal getDividaLiquidaPatri() {
        return dividaLiquidaPatri;
    }

    public void setDividaLiquidaPatri(BigDecimal dividaLiquidaPatri) {
        this.dividaLiquidaPatri = dividaLiquidaPatri;
    }

    public BigDecimal getPsr() {
        return psr;
    }

    public void setPsr(BigDecimal psr) {
        this.psr = psr;
    }

    public BigDecimal getDividaLiquidaEbit() {
        return dividaLiquidaEbit;
    }

    public void setDividaLiquidaEbit(BigDecimal dividaLiquidaEbit) {
        this.dividaLiquidaEbit = dividaLiquidaEbit;
    }

    public BigDecimal getPatrimonioAtivos() {
        return patrimonioAtivos;
    }

    public void setPatrimonioAtivos(BigDecimal patrimonioAtivos) {
        this.patrimonioAtivos = patrimonioAtivos;
    }

    public BigDecimal getPassivoAtivos() {
        return passivoAtivos;
    }

    public void setPassivoAtivos(BigDecimal passivoAtivos) {
        this.passivoAtivos = passivoAtivos;
    }

    public BigDecimal getCagrReceita5Anos() {
        return cagrReceita5Anos;
    }

    public void setCagrReceita5Anos(BigDecimal cagrReceita5Anos) {
        this.cagrReceita5Anos = cagrReceita5Anos;
    }

    public BigDecimal getCagrLucros5Anos() {
        return cagrLucros5Anos;
    }

    public void setCagrLucros5Anos(BigDecimal cagrLucros5Anos) {
        this.cagrLucros5Anos = cagrLucros5Anos;
    }

    public BigDecimal getGiroAtivos() {
        return giroAtivos;
    }

    public void setGiroAtivos(BigDecimal giroAtivos) {
        this.giroAtivos = giroAtivos;
    }

    public BigDecimal getLiquidez() {
        return liquidez;
    }

    public void setLiquidez(BigDecimal liquidez) {
        this.liquidez = liquidez;
    }

    public BigDecimal getPegRatio() {
        return pegRatio;
    }

    public void setPegRatio(BigDecimal pegRatio) {
        this.pegRatio = pegRatio;
    }

    public BigDecimal getVpa() {
        return vpa;
    }

    public void setVpa(BigDecimal vpa) {
        this.vpa = vpa;
    }

    public BigDecimal getLpa() {
        return lpa;
    }

    public void setLpa(BigDecimal lpa) {
        this.lpa = lpa;
    }

    public BigDecimal getValorMercado() {
        return valorMercado;
    }

    public void setValorMercado(BigDecimal valorMercado) {
        this.valorMercado = valorMercado;
    }

    public double getValorFormulaGrham () {
        return Math.round(Math.sqrt(22.5 * getLpa().doubleValue() * getVpa().doubleValue()) * 100.0) / 100.0;
    }

    public double getDescontoFormulaGrham () {
        if (getValorFormulaGrham() < 0.1) return -999;
        return Math.round((100-(preco.doubleValue()/getValorFormulaGrham()*100)) * 100.0) / 100.0 ;
    }

    public int getSomaFormula () {
        return (rankRoe+rankPl);
    }

    public int getRankRoe() {
        return rankRoe;
    }

    public void setRankRoe(int rankRoe) {
        this.rankRoe = rankRoe;
    }

    public int getRankPl() {
        return rankPl;
    }

    public void setRankPl(int rankPl) {
        this.rankPl = rankPl;
    }

    @Override
    public String toString() {
        return "Acao{" +
                "ticker='" + ticker + '\'' +
                ", preco=" + preco +
                ", pl=" + pl +
                ", dy=" + dy +
                ", pvp=" + pvp +
                ", pEbit=" + pEbit +
                ", pAtivos=" + pAtivos +
                ", evEbit=" + evEbit +
                ", margemBruta=" + margemBruta +
                ", margemEbit=" + margemEbit +
                ", margemLiquida=" + margemLiquida +
                ", pCapGiro=" + pCapGiro +
                ", pAtivoCircLiq=" + pAtivoCircLiq +
                ", liqCorrente=" + liqCorrente +
                ", roe=" + roe +
                ", roa=" + roa +
                ", roic=" + roic +
                ", dividaLiquidaPatri=" + dividaLiquidaPatri +
                ", psr=" + psr +
                ", dividaLiquidaEbit=" + dividaLiquidaEbit +
                ", patrimonioAtivos=" + patrimonioAtivos +
                ", passivoAtivos=" + passivoAtivos +
                ", cagrReceita5Anos=" + cagrReceita5Anos +
                ", cagrLucros5Anos=" + cagrLucros5Anos +
                ", giroAtivos=" + giroAtivos +
                ", liquidez=" + liquidez +
                ", pegRatio=" + pegRatio +
                ", vpa=" + vpa +
                ", lpa=" + lpa +
                ", valorMercado=" + valorMercado +
                ", valorFormulaGrham=" + getValorFormulaGrham () +
                ", descontoFormulaGrham=" + getDescontoFormulaGrham () +
                ", rank1=" + rankRoe +
                ", rank2=" + rankPl +
                ", somaFormula=" + getSomaFormula () +
                '}';
    }
}
