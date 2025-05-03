package model;

import java.util.Random;

public class ConsumokWH {
    private double[][] consumos;

    public ConsumokWH(int diasDelMes) {
        consumos = new double[diasDelMes][24]; 
    }

    public void generarConsumosAleatorios() {
        Random rand = new Random();
        for (int dia = 0; dia < consumos.length; dia++) {
            for (int hora = 0; hora < 24; hora++) {
                consumos[dia][hora] = 0.1 + (rand.nextDouble() * 1.1); // generar consumos aleatorios de kWh
            }
        }
    }

    public double[][] getConsumos() {
        return consumos;
    }

    public int getTotalDias(){
        return consumos.length;
    }

    public double getConsumo(int dia, int hora) {
        if (dia >= 0 && dia < consumos.length && hora >= 0 && hora < 24) {
            return consumos[dia][hora];
        }
        return 0.0;
    }

    public void setConsumo(int dia, int hora, double valor) {
        if (dia >= 0 && dia < consumos.length && hora >= 0 && hora < 24) {
            consumos[dia][hora] = valor;
        }
    }
}