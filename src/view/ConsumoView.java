package view;

public class ConsumoView {

    public void mostrarMatrizDeConsumos(double[][] matriz) {
        for (int dia = 0; dia < matriz.length; dia++) {
            System.out.print("Día " + (dia + 1) + ": ");
            for (int hora = 0; hora < 24; hora++) {
                System.out.printf("%.2f ", matriz[dia][hora]);
            }
            System.out.println();
        }
    }
    public void mostrarConsumoMinimo(double minimo) {
        System.out.println("Consumo mínimo: " + minimo + " kWh");
    }

    public void mostrarConsumoMaximo(double maximo) {
        System.out.println("Consumo máximo: " + maximo + " kWh");
    }

    public void mostrarConsumoPorFranjas(double[] franjas) {
        System.out.println("Consumo franja 1 (00:00-06:00): " + franjas[0] + " kWh");
        System.out.println("Consumo franja 2 (07:00-17:00): " + franjas[1] + " kWh");
        System.out.println("Consumo franja 3 (18:00-23:00): " + franjas[2] + " kWh");
    }

    public void mostrarConsumoPorDias(double[] consumoDias) {
        for (int i = 0; i < consumoDias.length; i++) {
            System.out.println("Día " + (i + 1) + ": " + consumoDias[i] + " kWh");
        }
    }
}