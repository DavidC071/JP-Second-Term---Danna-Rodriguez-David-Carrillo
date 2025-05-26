package controller;

import model.ConsumokWH;

<<<<<<< HEAD
public class ConsumoController { //define la clase publica consumocontroller

    public void mCambiarConsumoHora(ConsumokWH consumo, int dia, int hora, double nuevoConsumo) {
        consumo.setConsumo(dia, hora, nuevoConsumo); //cambia el consumo en una hora y dia especificos
    }

    public double mHallarConsumoMinimo(ConsumokWH consumo) {
        double min = Double.MAX_VALUE; //inicia el valor al minimo posible
        for (int d = 0; d < consumo.getTotalDias(); d++) { //recorre los dias
            for (int h = 0; h < 24; h++) { //recorre las 24 horas
                double valor = consumo.getConsumo(d, h); //obtiene el consumo para ese dia y hora
                if (valor < min) { //si el consumo es menor que el minimo actual
                    min = valor; //actualiza el valor minimo
                }
            }
        }
        return min; //retorna al consumo minimo encontrado
    }

    public double mHallarConsumoMaximo(ConsumokWH consumo) {
        double max = Double.MIN_VALUE; //inicia el valor al maximo posible
        for (int d = 0; d < consumo.getTotalDias(); d++) { //recorre los dias
            for (int h = 0; h < 24; h++) { //recorre las 24 horas
                double valor = consumo.getConsumo(d, h); //obtiene el consumo para ese dia y hora
                if (valor > max) { //si el consumo es mayor que el maximo actual
                    max = valor; //actualiza el valor maximo
                }
            }
        }
        return max; //retorna el consumo maximo encontrado
    }

    public double[] mHallarConsumoPorFranjas(ConsumokWH consumo) {
        double[] franjas = new double[3]; //inicia arreglo para las 3 franjas horarias

        for (int d = 0; d < consumo.getTotalDias(); d++) { //recorre los dias
            for (int h = 0; h < 24; h++) { //recorre las 24 horas del dia
                double valor = consumo.getConsumo(d, h); //obtiene el consumo para ese dia y hora 
                if (h >= 0 && h <= 6) { //franja de 0 a 6
                    franjas[0] += valor; //acumula el consumo en la franja 0
                } else if (h >= 7 && h <= 17) { //franja de 7 a 17
                    franjas[1] += valor; //acumula el consumo en la franja 1
                } else { //franja de 18 a 23
                    franjas[2] += valor; // acumula el consumo de la franja 2
=======
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
>>>>>>> c1060346e87c1178b6be93aedabfa3900c02668c
                }
            }
        }

<<<<<<< HEAD
        return franjas; //retorna el consumo total por franja horaria
    }

    public double[] mHallarConsumoPorDias(ConsumokWH consumo) {
        double[] consumoDias = new double[consumo.getTotalDias()]; //arreglo para almacenar el consumo total diario

        for (int d = 0; d < consumo.getTotalDias(); d++) { //recorre los dias 
            for (int h = 0; h < 24; h++) { //recorre las horas
                consumoDias[d] += consumo.getConsumo(d, h); //suma el consumo horario al total diario
            }
        }

        return consumoDias; //retorna el consumo total por dia
    }

    public double mCalcularValorFactura(ConsumokWH consumo) {
        double total = 0; //incia el total de la factura

        if (consumo == null) return 0; //si el objeto total es nulo retorna 0

        for (int d = 0; d < consumo.getTotalDias(); d++) { //recorre los dias
            for (int h = 0; h < 24; h++) { //recorre las horas
                double valor = consumo.getConsumo(d, h); //obtiene el consumo por hora

                if (h >= 0 && h <= 6 && valor >= 100 && valor <= 300) { //solo si está entre 100–300 kW/h
                    total += valor * 200; //suma al total con precio 200 COP/kW
                } else if (h >= 7 && h <= 17 && valor > 300 && valor <= 600) { //solo si está entre 300–600 kW/h
                    total += valor * 300; //suma al total con precio 300 COP/kW
                } else if (h >= 18 && h <= 23 && valor > 600 && valor < 1000) { //solo si está entre 600–1000 kW/h
                    total += valor * 500; //suma al total con precio 500 COP/kW
                } 
            }
        }

        return total; //retorna el valor final de la factura
=======
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
>>>>>>> c1060346e87c1178b6be93aedabfa3900c02668c
    }
}