import controller.ConsumoController;
import java.util.Scanner;
import model.ConsumokWH;
import view.ConsumoView;

public class Main {
    public static void main(String[] args) {
        ConsumokWH consumo = new ConsumokWH(30);
        ConsumoController controller = new ConsumoController();
        ConsumoView view = new ConsumoView();
        Scanner scanner = new Scanner(System.in);

        for (int d = 0; d < 30; d++) {
            for (int h = 0; h < 23; h++) {
                consumo.setConsumo(d, h, Math.random() * 900);
            }
        }

        boolean salir = false;
        while (!salir) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Imprimir matriz de consumos");
            System.out.println("2. Cambiar consumo de una hora específica");
            System.out.println("3. Ver consumo mínimo");
            System.out.println("4. Ver consumo máximo");
            System.out.println("5. Ver consumo por franjas");
            System.out.println("6. Ver consumo por días");
            System.out.println("7. Salir");

            System.out.print("Opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    imprimirMatriz(consumo);
                    break;
                case 2:
                    System.out.print("Ingrese el día (1-3): ");
                    int dia = scanner.nextInt() - 1;
                    System.out.print("Ingrese la hora (0-23): ");
                    int hora = scanner.nextInt();
                    System.out.print("Ingrese el nuevo consumo (kWh): ");
                    double nuevoConsumo = scanner.nextDouble();
                    controller.cambiarConsumoHora(consumo, dia, hora, nuevoConsumo);
                    System.out.println("Consumo actualizado exitosamente.");
                    break;
                case 3:
                    double consumoMin = controller.hallarConsumoMinimo(consumo);
                    view.mostrarConsumoMinimo(consumoMin);
                    break;
                case 4:
                    double consumoMax = controller.hallarConsumoMaximo(consumo);
                    view.mostrarConsumoMaximo(consumoMax);
                    break;
                case 5:
                    double[] franjas = controller.hallarConsumoPorFranjas(consumo);
                    view.mostrarConsumoPorFranjas(franjas);
                    break;
                case 6:
                    double[] consumoDias = controller.hallarConsumoPorDias(consumo);
                    view.mostrarConsumoPorDias(consumoDias);
                    break;
                case 7:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    break;
            }
        }
    }

    public static void imprimirMatriz(ConsumokWH consumo) {
        System.out.println("\n Matriz De Consumos en kWh ");
        double[][] matriz = consumo.getConsumos();
        for (int d = 0; d < matriz.length; d++) {
            System.out.print("Día " + (d + 1) + ": ");
            for (int h = 0; h < 23; h++) {
                System.out.printf("%.2f ", matriz[d][h]);
            }
            System.out.println();
        }
    }
}