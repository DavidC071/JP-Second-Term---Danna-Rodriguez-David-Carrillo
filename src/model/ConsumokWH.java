package model;

public class ConsumokWH {
    private double[][] consumos;

    public ConsumokWH(int dias) {
        consumos = new double[dias][23];
    }

    public void setConsumo(int dia, int hora, double valor) {
        consumos[dia][hora] = valor;
    }

    public double getConsumo(int dia, int hora) {
        return consumos[dia][hora];
    }

    public double[][] getConsumos() {
        return consumos;
    }

    public int getTotalDias() {
        return consumos.length;
    }
}