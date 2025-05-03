import controller.ClienteController;
import controller.ConsumoController;
import java.util.Scanner;
import model.Cliente;
import model.ConsumokWH;
import model.Registrador;
import view.ConsumoView;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClienteController clienteController = new ClienteController();
        ConsumoController consumoController = new ConsumoController();
        ConsumoView view = new ConsumoView();

        boolean salir = false;

        while (!salir) {
            System.out.println("\n===== MENÚ PRINCIPAL =====\n");

            System.out.println(" Gestión de Clientes:");
            System.out.println("  1. Crear cliente");
            System.out.println("  2. Editar cliente");
            
            System.out.println("\n Gestión de Registradores:");
            System.out.println("  3. Crear registrador para cliente");
            System.out.println("  4. Editar registrador de cliente");
            
            System.out.println("\n Gestión de Consumos:");
            System.out.println("  5. Cargar consumos de todos los clientes");
            System.out.println("  6. Cargar consumos de un cliente específico");
            System.out.println("  7. Imprimir matriz de consumos");
            System.out.println("  8. Cambiar consumo de una hora específica");
            
            System.out.println("\n Consultas de Consumo:");
            System.out.println("  9. Ver consumo mínimo");
            System.out.println(" 10. Ver consumo máximo");
            System.out.println(" 11. Ver consumo por franjas");
            System.out.println(" 12. Ver consumo por días");
            System.out.println(" 14. Ver valor total de la factura");
            
            System.out.println("\n Otras opciones:");
            System.out.println(" 13. Salir");
            
            System.out.print("\nSelecciona una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("ID del cliente: ");
                    String id = scanner.nextLine();
                    System.out.print("Tipo de identificación: ");
                    String tipoId = scanner.nextLine();
                    System.out.print("Correo: ");
                    String correo = scanner.nextLine();
                    System.out.print("Dirección: ");
                    String direccion = scanner.nextLine();
                    clienteController.crearCliente(id, tipoId, correo, direccion);
                    System.out.println("Cliente creado exitosamente.");
                    break;

                case 2: 
                    System.out.print("ID del cliente a editar: ");
                    String idEdit = scanner.nextLine();
                    System.out.print("Nuevo tipo de identificación: ");
                    String nuevoTipo = scanner.nextLine();
                    System.out.print("Nuevo correo: ");
                    String nuevoCorreo = scanner.nextLine();
                    System.out.print("Nueva dirección: ");
                    String nuevaDir = scanner.nextLine();
                    clienteController.editarCliente(idEdit, nuevoTipo, nuevoCorreo, nuevaDir);
                    System.out.println("Cliente editado exitosamente.");
                    break;

                case 3:
                    System.out.print("ID del cliente: ");
                    String idCliente = scanner.nextLine();
                    System.out.print("ID del registrador: ");
                    String idReg = scanner.nextLine();
                    System.out.print("Dirección del registrador: ");
                    String dirReg = scanner.nextLine();
                    System.out.print("Ciudad: ");
                    String ciudad = scanner.nextLine();
                    System.out.print("Cantidad de días del mes: ");
                    int dias = scanner.nextInt();
                    scanner.nextLine();
                    clienteController.agregarRegistradorACliente(idCliente, idReg, dirReg, ciudad, dias);
                    System.out.println("Registrador agregado al cliente.");
                    break;

                case 4:
                    System.out.print("ID del cliente: ");
                    String cliId = scanner.nextLine();
                    System.out.print("ID del registrador a editar: ");
                    String regId = scanner.nextLine();
                    System.out.print("Nueva dirección del registrador: ");
                    String nuevaDirReg = scanner.nextLine();
                    System.out.print("Nueva ciudad del registrador: ");
                    String nuevaCiudad = scanner.nextLine();
                    clienteController.editarRegistrador(cliId, regId, nuevaDirReg, nuevaCiudad);
                    System.out.println("Registrador editado correctamente.");
                    break;

                case 5:
                    System.out.print("Mes (1-12): ");
                    int mesTodos = scanner.nextInt();
                    clienteController.cargarConsumosDeTodosLosClientes(mesTodos);
                    System.out.println("Consumos de todos los clientes cargados correctamente.");
                    break;

                case 6:
                    System.out.print("ID del cliente: ");
                    String clienteId = scanner.nextLine();
                    System.out.print("Mes (1-12): ");
                    int mesCliente = scanner.nextInt();
                    clienteController.cargarConsumosDeUnCliente(clienteId, mesCliente);
                    System.out.println("Consumos del cliente cargados correctamente.");
                    break;

                case 7:
                    imprimirMatrizDesdeCliente(clienteController, scanner);
                    break;

                case 8:
                    System.out.print("ID del cliente: ");
                    String cId = scanner.nextLine();
                    System.out.print("ID del registrador: ");
                    String rId = scanner.nextLine();
                    Registrador reg = buscarRegistrador(clienteController, cId, rId);
                    if (reg != null) {
                        System.out.print("Día (1-n): ");
                        int d = scanner.nextInt() - 1;
                        System.out.print("Hora (0-23): ");
                        int h = scanner.nextInt();
                        System.out.print("Nuevo consumo (kWh): ");
                        double val = scanner.nextDouble();
                        consumoController.cambiarConsumoHora(reg.getConsumo(), d, h, val);
                        System.out.println("Consumo actualizado.");
                    } else {
                        System.out.println("Registrador no encontrado.");
                    }
                    break;

                case 9: case 10: case 11: case 12:
                    procesarConsultaConsumo(clienteController, consumoController, view, scanner, opcion);
                    break;

                case 13:
                    salir = true;
                    System.out.println("¡Hasta pronto!");
                    break;
                case 14:
                    System.out.print("ID del cliente: ");
                    String clId = scanner.nextLine();
                    System.out.print("ID del registrador: ");
                    String regIdFactura = scanner.nextLine();
                    Registrador r = buscarRegistrador(clienteController, clId, regIdFactura);
                    if (r != null) {
                        double totalFactura = consumoController.calcularValorFactura(r.getConsumo());
                        System.out.println("Valor total de la factura: " + totalFactura + " COP");
                    } else {
                        System.out.println("Registrador no encontrado.");
                    }
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }

        scanner.close();
    }


    private static void imprimirMatrizDesdeCliente(ClienteController clienteController, Scanner scanner) {
        System.out.print("ID del cliente: ");
        String cId = scanner.nextLine();
        System.out.print("ID del registrador: ");
        String rId = scanner.nextLine();

        clienteController.imprimirMatrizDeConsumos(cId, rId);
    }

    private static Registrador buscarRegistrador(ClienteController clienteController, String clienteId, String registradorId) {
        for (Cliente c : clienteController.getClientes()) {
            if (c.getId().equals(clienteId)) {
                for (Registrador r : c.getRegistradores()) {
                    if (r.getId().equals(registradorId)) {
                        return r;
                    }
                }
            }
        }
        return null;
    }

    private static void procesarConsultaConsumo(ClienteController clienteController, ConsumoController consumoController, ConsumoView view, Scanner scanner, int opcion) {
        System.out.print("ID del cliente: ");
        String cId = scanner.nextLine();
        System.out.print("ID del registrador: ");
        String rId = scanner.nextLine();
        Registrador reg = buscarRegistrador(clienteController, cId, rId);
        if (reg == null) {
            System.out.println("Registrador no encontrado.");
            return;
        }
        ConsumokWH consumo = reg.getConsumo();
        switch (opcion) {
            case 9:
                double consumoMinimo = consumoController.hallarConsumoMinimo(consumo);
                view.mostrarConsumoMinimo(consumoMinimo);
                break;
            case 10:
                double consumoMaximo = consumoController.hallarConsumoMaximo(consumo);
                view.mostrarConsumoMaximo(consumoMaximo);
                break;
            case 11:
                view.mostrarConsumoPorFranjas(consumoController.hallarConsumoPorFranjas(consumo));
                break;
            case 12:
                view.mostrarConsumoPorDias(consumoController.hallarConsumoPorDias(consumo));
                break;
        }
    }
}