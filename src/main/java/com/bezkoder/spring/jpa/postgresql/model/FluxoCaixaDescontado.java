package com.bezkoder.spring.jpa.postgresql.model;

public class FluxoCaixaDescontado {

    public static void main(String[] args) {
        double[] fluxosDeCaixa = {100, 110, 121, 2150};
        double wacc = 0.088;

        double fcd = calcularFCD(fluxosDeCaixa, wacc);
        System.out.println("O Fluxo de Caixa Descontado é: " + fcd);
    }

    /**
     * Calcula o Fluxo de Caixa Descontado (FCD) com base nos fluxos de caixa e no WACC fornecidos.
     *
     * @param fluxosDeCaixa  um array de double representando os fluxos de caixa para cada período
     * @param wacc           o Custo Médio Ponderado de Capital (WACC) como um valor decimal (por exemplo, 0,12 para 12%)
     * @return               o valor do Fluxo de Caixa Descontado
     */
    public static double calcularFCD(double[] fluxosDeCaixa, double wacc) {
        double fcd = 0;

        for (int i = 0; i < fluxosDeCaixa.length; i++) {
            double fluxoCaixaDescontado = fluxosDeCaixa[i] / Math.pow(1 + wacc, i + 1);
            fcd += fluxoCaixaDescontado;
        }

        return fcd;
    }
}


