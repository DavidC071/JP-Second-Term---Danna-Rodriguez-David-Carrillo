package controller;

import model.ConsumokWH;

public class ConsumoController { //define la clase publica consumocontroller

    public void mCambiarConsumoHora(ConsumokWH consumo, int dia, int hora, double nuevoConsumo) { //cambia el consumo en una hora y dia especificos
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
                    franjas[2] += valor; //acumula el consumo de la franja 2
                }
            }
        }

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
    
    public double[] mCalcularValorFactura(ConsumokWH consumo) { //metodo que calcula el valor total de la factura y el total de kWh consumidos
    if (consumo == null) return new double[]{0, 0}; //si el objeto de consumo es nulo retorna cero tanto para el valor como para el consumo
    double total = 0; //inicia el total a pagar y el total de kWh consumidos
    double totalKWh = 0;
    double precioPorKWh = 1.073; //precio por cada kWh

    for (int d = 0; d < consumo.getTotalDias(); d++) { //recorre todos los dias del mes
        for (int h = 0; h < 24; h++) { //recorre las 24 horas de cada dia
            double valor = consumo.getConsumo(d, h); //obtiene el consumo en kWh para ese dia y hora
            totalKWh += valor; //suma el total de kWh consumidos
           //horario: 00:00 - 06:59,consumo entre 100 y 300 kWh -> tarifa doble (tarifas difentes)
            if (h >= 0 && h <= 6 && valor >= 100 && valor <= 300) {
                total += valor * precioPorKWh * 2;
            }
            //horario: 07:00 - 17:59,consumo entre 301 y 600 kWh -> tarifa triple
            else if (h >= 7 && h <= 17 && valor > 300 && valor <= 600) {
                total += valor * precioPorKWh * 3;
            }
            //horario: 18:00 - 23:59,consumo entre 601 y 999 kWh -> tarifa quintuple
            else if (h >= 18 && h <= 23 && valor > 600 && valor < 1000) {
                total += valor * precioPorKWh * 5;
            }
        }
    }

    return new double[]{total, totalKWh}; //devuelve un arreglo con el total a pagar y el total de kWh consumidos
}


    public double[] mHallarConsumoMinimoConPosicion(ConsumokWH consumo) { //retorna el consumo minimo y su ubicación (dia y hora)
        double min = Double.MAX_VALUE; //valor minimo inicial muy alto
        int diaMin = -1; //posición del dia
        int horaMin = -1; //posición de la hora

        for (int dia = 0; dia < consumo.getConsumos().length; dia++) { //recorre matriz
            for (int hora = 0; hora < consumo.getConsumos()[dia].length; hora++) {
                if (consumo.getConsumos()[dia][hora] < min) {
                    min = consumo.getConsumos()[dia][hora]; //actualiza valor minimo
                    diaMin = dia; //guarda día
                    horaMin = hora; //guarda hora
                }
            }
        }

        return new double[]{min, diaMin + 1, horaMin}; //retorna valores ajustando el dia
    }

    public double[] mHallarConsumoMaximoConPosicion(ConsumokWH consumo) { //retorna el consumo maximo y su ubicación (dia y hora)
        double max = Double.MIN_VALUE; //valor maximo inicial muy bajo
        int diaMax = -1; //posición del dia
        int horaMax = -1; //posicion de la hora

        for (int dia = 0; dia < consumo.getConsumos().length; dia++) { //recorre matriz
            for (int hora = 0; hora < consumo.getConsumos()[dia].length; hora++) {
                if (consumo.getConsumos()[dia][hora] > max) {
                    max = consumo.getConsumos()[dia][hora]; //actualiza valor maximo
                    diaMax = dia; //guarda dia
                    horaMax = hora; //guarda hora
                }
            }
        }

        return new double[]{max, diaMax + 1, horaMax}; //retorna valores ajustando el dia
    }
}