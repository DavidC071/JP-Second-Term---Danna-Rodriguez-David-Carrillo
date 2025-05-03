package controller;

import model.ConsumokWH;

public class ConsumoController {

    public void cambiarConsumoHora(ConsumokWH consumo, int dia, int hora, double nuevoConsumo) {
        consumo.setConsumo(dia, hora, nuevoConsumo);
    }

    public double hallarConsumoMinimo(ConsumokWH consumo) {
        double min = Double.MAX_VALUE;
        for (int d = 0; d < consumo.getTotalDias(); d++) {
            for (int h = 0; h < 24; h++) {
                double valor = consumo.getConsumo(d, h);
                if (valor < min) {
                    min = valor;
                }
            }
        }
        return min;
    }

    public double hallarConsumoMaximo(ConsumokWH consumo) {
        double max = Double.MIN_VALUE;
        for (int d = 0; d < consumo.getTotalDias(); d++) {
            for (int h = 0; h < 24; h++) {
                double valor = consumo.getConsumo(d, h);
                if (valor > max) {
                    max = valor;
                }
            }
        }
        return max;
    }

    public double[] hallarConsumoPorFranjas(ConsumokWH consumo) {
        double[] franjas = new double[3]; // [0-6], [7-17], [18-23]

        for (int d = 0; d < consumo.getTotalDias(); d++) {
            for (int h = 0; h < 24; h++) {
                double valor = consumo.getConsumo(d, h);
                if (h >= 0 && h <= 6) {
                    franjas[0] += valor;
                } else if (h >= 7 && h <= 17) {
                    franjas[1] += valor;
                } else {
                    franjas[2] += valor;
                }
            }
        }

        return franjas;
    }

    public double[] hallarConsumoPorDias(ConsumokWH consumo) {
        double[] consumoDias = new double[consumo.getTotalDias()];

        for (int d = 0; d < consumo.getTotalDias(); d++) {
            for (int h = 0; h < 24; h++) {
                consumoDias[d] += consumo.getConsumo(d, h);
            }
        }

        return consumoDias;
    }

    public double calcularValorFactura(ConsumokWH consumo) {
        double total = 0;

        if (consumo == null) return 0;

        for (int d = 0; d < consumo.getTotalDias(); d++) {
            for (int h = 0; h < 24; h++) {
                double valor = consumo.getConsumo(d, h);

                if (h >= 0 && h <= 6) {
                    total += valor * 200;
                } else if (h >= 7 && h <= 17) {
                    total += valor * 300;
                } else if (h >= 18 && h <= 23) {
                    total += valor * 500;
                }
            }
        }

        return total;
    }
}