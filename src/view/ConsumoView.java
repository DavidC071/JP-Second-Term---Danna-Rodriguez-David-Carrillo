package view;  

public class ConsumoView { //define la clase publica consumoview

    public void mMostrarMatrizDeConsumos(double[][] matriz) { //muestra la matriz de consumos dia por dia y hora por hora
        for (int dia = 0; dia < matriz.length; dia++) { //recorre los dias
            System.out.print("Día " + (dia + 1) + ": "); //imprime el número de dia
            for (int hora = 0; hora < 24; hora++) { //recorre las 24 horas
                System.out.printf("%4.0f ", matriz[dia][hora]); //imprime el consumo
            }
            System.out.println(); //salto de linea al final de cada dia
        }
    }

    public void mMostrarConsumoMinimo(double minimo) { //muestra el consumo minimo encontrado
        System.out.println("Consumo mínimo: " + minimo + " kWh");
    }

    public void mMostrarConsumoMaximo(double maximo) { //muestra el consumo maximo encontrado
        System.out.println("Consumo máximo: " + maximo + " kWh");
    }

    public void mMostrarConsumoPorFranjas(double[] franjas) { //muestra el consumo total por cada franja horaria
        System.out.println("Consumo franja 1 (00:00-06:00): " + franjas[0] + " kWh");
        System.out.println("Consumo franja 2 (07:00-17:00): " + franjas[1] + " kWh");
        System.out.println("Consumo franja 3 (18:00-23:00): " + franjas[2] + " kWh");
    }

    public void mMostrarConsumoPorDias(double[] consumoDias) { // muestra el consumo total por cada dia del mes
        for (int i = 0; i < consumoDias.length; i++) {  // recorre los dias
            System.out.println("Día " + (i + 1) + ": " + consumoDias[i] + " kWh");
        }
    }
}