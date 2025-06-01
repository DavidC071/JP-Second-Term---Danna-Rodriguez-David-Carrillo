package model; 

import java.util.Random; //importa la clase random para generar numeros aleatorios

public class ConsumokWH { //define la clase publica consumokwh
    private double[][] consumos; //matriz para almacenar consumos por dia y hora

    public ConsumokWH(int diasDelMes) {
        consumos = new double[diasDelMes][24]; //inicia la matriz filas=dias, columnas=24 horas
    }

    public void mGenerarConsumosAleatorios() {
        Random rand = new Random(); //crea un objeto random para generar aleatorios
        for (int dia = 0; dia < consumos.length; dia++) { //recorre cada dia
            for (int hora = 0; hora < 24; hora++) { //recorre cada hora
                consumos[dia][hora] = rand.nextInt(901) + 100; //genera enteros entre 100 y 1000
            }
        }
    }

    public void mGenerarConsumosAleatorios(int mes, String idRegistrador) { //metodo que genera consumos aleatorios para un registrador en un mes determinado
    //calcula una semilla unica usando el mes y el hash del ID del registrador (numero entero unico a partir del contenido de un objeto)
    long semilla = mes * 1000L + idRegistrador.hashCode(); //esto garantiza que para un mismo mes e ID se generen siempre los mismos datos aleatorios

    Random random = new Random(semilla); //crea una instancia de random con esa semilla

    for (int i = 0; i < consumos.length; i++) { //recorre la matriz de consumos (dias x horas)
        for (int j = 0; j < consumos[i].length; j++) { //genera un valor aleatorio entre 100 y 1000 
            consumos[i][j] = random.nextInt(901) + 100; //esto simula el consumo en kWh para una hora especifica
        }
    }
}

    public double[][] getConsumos() {
        return consumos; //retorna la matriz completa de consumos
    }

    public int getTotalDias() {
        return consumos.length; //retorna el numero total de dias (filas)
    }

    public double getConsumo(int dia, int hora) {
        if (dia >= 0 && dia < consumos.length && hora >= 0 && hora < 24) { //verifica que el dia y la hora esten en rango valido
            return consumos[dia][hora]; //retorna el consumo en ese dia y hora
        }
        return 0.0; //si esta fuera de rango retorna 0
    }

   public void setConsumo(int dia, int hora, double valor) {
    if (dia >= 0 && dia < consumos.length && hora >= 0 && hora < 24 && valor >= 0) { //verifica que el dia y la hora estén en rango valido y que el valor no sea negativo
        consumos[dia][hora] = valor; //asigna un nuevo valor al consumo en ese dia y hora
    }
  }
}