<<<<<<< HEAD
package model; 

import java.util.Random; //importa la clase random para generar numeros aleatorios

public class ConsumokWH { //define la clase publica consumokwh
    private double[][] consumos; //matriz para almacenar consumos por dia y hora

    public ConsumokWH(int diasDelMes) {
        consumos = new double[diasDelMes][24]; //inicia la matriz filas =dias, columnas =24 horas
    }

    public void mGenerarConsumosAleatorios() {
        Random rand = new Random(); //crea un objeto random para generar aleatorios
        for (int dia = 0; dia < consumos.length; dia++) { //recorre cada dia
            for (int hora = 0; hora < 24; hora++) { //recorre cada hora
                consumos[dia][hora] = rand.nextInt(901) + 100; //genera enteros entre 100 y 1000
=======
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
>>>>>>> c1060346e87c1178b6be93aedabfa3900c02668c
            }
        }
    }

    public double[][] getConsumos() {
<<<<<<< HEAD
        return consumos; //retorna la matriz completa de consumos
    }

    public int getTotalDias() {
        return consumos.length; //retorna el número total de días (filas)
    }

    public double getConsumo(int dia, int hora) {
        if (dia >= 0 && dia < consumos.length && hora >= 0 && hora < 24) { // verifica que el dia y la hora estén en rango valido
            return consumos[dia][hora]; //retorna el consumo en ese dia y hora
        }
        return 0.0; //si está fuera de rango retorna 0
    }

    public void setConsumo(int dia, int hora, double valor) {
        if (dia >= 0 && dia < consumos.length && hora >= 0 && hora < 24) { //verifica que el dia y la hora estén en rango valido
            consumos[dia][hora] = valor; //asigna un nuevo valor al consumo en ese día y hora
        }
    }
=======
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
>>>>>>> c1060346e87c1178b6be93aedabfa3900c02668c
