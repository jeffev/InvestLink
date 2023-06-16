package com.bezkoder.spring.jpa.postgresql.model;

import javax.persistence.*;

@Entity
@Table(name = "fiis")
public class FundoImobiliario {
    private int companyid;
    private String companyname;

    @Id
    private String ticker;
    private double price;
    private int sectorid;
    private String sectorname;
    private int subsectorid;
    private String subsectorname;
    private String segment;
    private int segmentid;
    private int gestao;
    private String gestao_f;
    private double dy;
    private double p_vp;
    private double valorpatrimonialcota;
    private double liquidezmediadiaria;
    private double percentualcaixa;
    private double dividend_cagr;
    private double cota_cagr;
    private int numerocotistas;
    private int numerocotas;
    private double patrimonio;
    private double lastdividend;

    public int getCompanyid() {
        return companyid;
    }

    public void setCompanyid(int companyid) {
        this.companyid = companyid;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSectorid() {
        return sectorid;
    }

    public void setSectorid(int sectorid) {
        this.sectorid = sectorid;
    }

    public String getSectorname() {
        return sectorname;
    }

    public void setSectorname(String sectorname) {
        this.sectorname = sectorname;
    }

    public int getSubsectorid() {
        return subsectorid;
    }

    public void setSubsectorid(int subsectorid) {
        this.subsectorid = subsectorid;
    }

    public String getSubsectorname() {
        return subsectorname;
    }

    public void setSubsectorname(String subsectorname) {
        this.subsectorname = subsectorname;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public int getSegmentid() {
        return segmentid;
    }

    public void setSegmentid(int segmentid) {
        this.segmentid = segmentid;
    }

    public int getGestao() {
        return gestao;
    }

    public void setGestao(int gestao) {
        this.gestao = gestao;
    }

    public String getGestao_f() {
        return gestao_f;
    }

    public void setGestao_f(String gestao_f) {
        this.gestao_f = gestao_f;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public double getP_vp() {
        return p_vp;
    }

    public void setP_vp(double p_vp) {
        this.p_vp = p_vp;
    }

    public double getValorpatrimonialcota() {
        return valorpatrimonialcota;
    }

    public void setValorpatrimonialcota(double valorpatrimonialcota) {
        this.valorpatrimonialcota = valorpatrimonialcota;
    }

    public double getLiquidezmediadiaria() {
        return liquidezmediadiaria;
    }

    public void setLiquidezmediadiaria(double liquidezmediadiaria) {
        this.liquidezmediadiaria = liquidezmediadiaria;
    }

    public double getPercentualcaixa() {
        return percentualcaixa;
    }

    public void setPercentualcaixa(double percentualcaixa) {
        this.percentualcaixa = percentualcaixa;
    }

    public double getDividend_cagr() {
        return dividend_cagr;
    }

    public void setDividend_cagr(double dividend_cagr) {
        this.dividend_cagr = dividend_cagr;
    }

    public double getCota_cagr() {
        return cota_cagr;
    }

    public void setCota_cagr(double cota_cagr) {
        this.cota_cagr = cota_cagr;
    }

    public int getNumerocotistas() {
        return numerocotistas;
    }

    public void setNumerocotistas(int numerocotistas) {
        this.numerocotistas = numerocotistas;
    }

    public int getNumerocotas() {
        return numerocotas;
    }

    public void setNumerocotas(int numerocotas) {
        this.numerocotas = numerocotas;
    }

    public double getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(double patrimonio) {
        this.patrimonio = patrimonio;
    }

    public double getLastdividend() {
        return lastdividend;
    }

    public void setLastdividend(double lastdividend) {
        this.lastdividend = lastdividend;
    }

    @Override
    public String toString() {
        return "Fii{" +
                "companyid=" + companyid +
                ", companyname='" + companyname + '\'' +
                ", ticker='" + ticker + '\'' +
                ", price=" + price +
                ", sectorid=" + sectorid +
                ", sectorname='" + sectorname + '\'' +
                ", subsectorid=" + subsectorid +
                ", subsectorname='" + subsectorname + '\'' +
                ", segment='" + segment + '\'' +
                ", segmentid=" + segmentid +
                ", gestao=" + gestao +
                ", gestao_f='" + gestao_f + '\'' +
                ", dy=" + dy +
                ", p_vp=" + p_vp +
                ", valorpatrimonialcota=" + valorpatrimonialcota +
                ", liquidezmediadiaria=" + liquidezmediadiaria +
                ", percentualcaixa=" + percentualcaixa +
                ", dividend_cagr=" + dividend_cagr +
                ", cota_cagr=" + cota_cagr +
                ", numerocotistas=" + numerocotistas +
                ", numerocotas=" + numerocotas +
                ", patrimonio=" + patrimonio +
                ", lastdividend=" + lastdividend +
                '}';
    }
}
