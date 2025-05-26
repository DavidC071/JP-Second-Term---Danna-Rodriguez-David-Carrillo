import controller.ClienteController;
import controller.ConsumoController;
import java.util.Scanner;
import model.Cliente;
import model.ConsumokWH;
import model.Registrador;
import view.ConsumoView;

public class Main {
    public static void main(String[] args) {
<<<<<<< HEAD
        Scanner scanner = new Scanner(System.in); //lector para entrada por consola
        ClienteController clienteController = new ClienteController(); //controlador de clientes
        ConsumoController consumoController = new ConsumoController(); //controlador de consumos
        ConsumoView view = new ConsumoView(); //vista para mostrar datos

        boolean salir = false; //bandera para controlar cuándo salir del menu

        while (!salir) { //bucle principal del menu
            System.out.println("\n===== MENÚ PRINCIPAL =====\n"); //mostrar opciones principales en pantalla
            System.out.println(" Gestión de Clientes:");
            System.out.println("  1. Crear cliente");
            System.out.println("  2. Editar cliente");
            System.out.println("\n Gestión de Registradores:");
            System.out.println("  3. Crear registrador para cliente");
            System.out.println("  4. Editar registrador de cliente");
=======
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
            
>>>>>>> c1060346e87c1178b6be93aedabfa3900c02668c
            System.out.println("\n Gestión de Consumos:");
            System.out.println("  5. Cargar consumos de todos los clientes");
            System.out.println("  6. Cargar consumos de un cliente específico");
            System.out.println("  7. Imprimir matriz de consumos");
            System.out.println("  8. Cambiar consumo de una hora específica");
<<<<<<< HEAD
=======
            
>>>>>>> c1060346e87c1178b6be93aedabfa3900c02668c
            System.out.println("\n Consultas de Consumo:");
            System.out.println("  9. Ver consumo mínimo");
            System.out.println(" 10. Ver consumo máximo");
            System.out.println(" 11. Ver consumo por franjas");
            System.out.println(" 12. Ver consumo por días");
            System.out.println(" 14. Ver valor total de la factura");
<<<<<<< HEAD
            System.out.println("\n Otras opciones:");
            System.out.println(" 13. Salir");

            System.out.print("\nSelecciona una opción: ");
            int opcion = scanner.nextInt(); //leer opcion elegida
            scanner.nextLine(); //limpiar la memoria temporal

            switch (opcion) {
                case 1: //crear cliente
=======
            
            System.out.println("\n Otras opciones:");
            System.out.println(" 13. Salir");
            
            System.out.print("\nSelecciona una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
>>>>>>> c1060346e87c1178b6be93aedabfa3900c02668c
                    System.out.print("ID del cliente: ");
                    String id = scanner.nextLine();
                    System.out.print("Tipo de identificación: ");
                    String tipoId = scanner.nextLine();
<<<<<<< HEAD
                    System.out.print("Nombre del cliente: ");
                    String nombre = scanner.nextLine();
=======
>>>>>>> c1060346e87c1178b6be93aedabfa3900c02668c
                    System.out.print("Correo: ");
                    String correo = scanner.nextLine();
                    System.out.print("Dirección: ");
                    String direccion = scanner.nextLine();
<<<<<<< HEAD
                    clienteController.mCrearCliente(id, tipoId, nombre, correo, direccion);
                    System.out.println("Cliente creado exitosamente.");
                    break;

                case 2: //editar cliente
=======
                    clienteController.crearCliente(id, tipoId, correo, direccion);
                    System.out.println("Cliente creado exitosamente.");
                    break;

                case 2: 
>>>>>>> c1060346e87c1178b6be93aedabfa3900c02668c
                    System.out.print("ID del cliente a editar: ");
                    String idEdit = scanner.nextLine();
                    System.out.print("Nuevo tipo de identificación: ");
                    String nuevoTipo = scanner.nextLine();
<<<<<<< HEAD
                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();
=======
>>>>>>> c1060346e87c1178b6be93aedabfa3900c02668c
                    System.out.print("Nuevo correo: ");
                    String nuevoCorreo = scanner.nextLine();
                    System.out.print("Nueva dirección: ");
                    String nuevaDir = scanner.nextLine();
<<<<<<< HEAD
                    clienteController.mEditarCliente(idEdit, nuevoTipo, nuevoNombre, nuevoCorreo, nuevaDir);
                    System.out.println("Cliente editado exitosamente.");
                    break;

                case 3: //agregar registrador
=======
                    clienteController.editarCliente(idEdit, nuevoTipo, nuevoCorreo, nuevaDir);
                    System.out.println("Cliente editado exitosamente.");
                    break;

                case 3:
>>>>>>> c1060346e87c1178b6be93aedabfa3900c02668c
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
<<<<<<< HEAD
                    clienteController.mAgregarRegistradorACliente(idCliente, idReg, dirReg, ciudad, dias);
                    System.out.println("Registrador agregado al cliente.");
                    break;

                case 4: //editar registrador
=======
                    clienteController.agregarRegistradorACliente(idCliente, idReg, dirReg, ciudad, dias);
                    System.out.println("Registrador agregado al cliente.");
                    break;

                case 4:
>>>>>>> c1060346e87c1178b6be93aedabfa3900c02668c
                    System.out.print("ID del cliente: ");
                    String cliId = scanner.nextLine();
                    System.out.print("ID del registrador a editar: ");
                    String regId = scanner.nextLine();
                    System.out.print("Nueva dirección del registrador: ");
                    String nuevaDirReg = scanner.nextLine();
                    System.out.print("Nueva ciudad del registrador: ");
                    String nuevaCiudad = scanner.nextLine();
<<<<<<< HEAD
                    clienteController.mEditarRegistrador(cliId, regId, nuevaDirReg, nuevaCiudad);
                    System.out.println("Registrador editado correctamente.");
                    break;

                case 5: //cargar consumos para todos los clientes
                    System.out.print("Mes (1-12): ");
                    int mesTodos = scanner.nextInt();
                    clienteController.mCargarConsumosDeTodosLosClientes(mesTodos);
                    System.out.println("Consumos de todos los clientes cargados correctamente.");
                    break;

                case 6: //cargar consumos para un cliente específico
=======
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
>>>>>>> c1060346e87c1178b6be93aedabfa3900c02668c
                    System.out.print("ID del cliente: ");
                    String clienteId = scanner.nextLine();
                    System.out.print("Mes (1-12): ");
                    int mesCliente = scanner.nextInt();
<<<<<<< HEAD
                    clienteController.mCargarConsumosDeUnCliente(clienteId, mesCliente);
                    System.out.println("Consumos del cliente cargados correctamente.");
                    break;

                case 7: //imprimir matriz de consumos
                    mImprimirMatrizDesdeCliente(clienteController, scanner);
                    break;

                case 8: //cambiar consumo de una hora especifica
=======
                    clienteController.cargarConsumosDeUnCliente(clienteId, mesCliente);
                    System.out.println("Consumos del cliente cargados correctamente.");
                    break;

                case 7:
                    imprimirMatrizDesdeCliente(clienteController, scanner);
                    break;

                case 8:
>>>>>>> c1060346e87c1178b6be93aedabfa3900c02668c
                    System.out.print("ID del cliente: ");
                    String cId = scanner.nextLine();
                    System.out.print("ID del registrador: ");
                    String rId = scanner.nextLine();
<<<<<<< HEAD
                    Registrador reg = mBuscarRegistrador(clienteController, cId, rId);
                    if (reg != null) {
                        System.out.print("Día (1-n): ");
                        int d = scanner.nextInt() - 1;  //ajusta al indice 0
=======
                    Registrador reg = buscarRegistrador(clienteController, cId, rId);
                    if (reg != null) {
                        System.out.print("Día (1-n): ");
                        int d = scanner.nextInt() - 1;
>>>>>>> c1060346e87c1178b6be93aedabfa3900c02668c
                        System.out.print("Hora (0-23): ");
                        int h = scanner.nextInt();
                        System.out.print("Nuevo consumo (kWh): ");
                        double val = scanner.nextDouble();
<<<<<<< HEAD
                        consumoController.mCambiarConsumoHora(reg.getConsumo(), d, h, val);
=======
                        consumoController.cambiarConsumoHora(reg.getConsumo(), d, h, val);
>>>>>>> c1060346e87c1178b6be93aedabfa3900c02668c
                        System.out.println("Consumo actualizado.");
                    } else {
                        System.out.println("Registrador no encontrado.");
                    }
                    break;

<<<<<<< HEAD
                case 9: case 10: case 11: case 12: //consultas generales
                    mProcesarConsultaConsumo(clienteController, consumoController, view, scanner, opcion);
                    break;

                case 13: //salir del programa
                    salir = true;
                    System.out.println("¡Hasta pronto!");
                    break;

                case 14: //calcular valor total de la factura
=======
                case 9: case 10: case 11: case 12:
                    procesarConsultaConsumo(clienteController, consumoController, view, scanner, opcion);
                    break;

                case 13:
                    salir = true;
                    System.out.println("¡Hasta pronto!");
                    break;
                case 14:
>>>>>>> c1060346e87c1178b6be93aedabfa3900c02668c
                    System.out.print("ID del cliente: ");
                    String clId = scanner.nextLine();
                    System.out.print("ID del registrador: ");
                    String regIdFactura = scanner.nextLine();
<<<<<<< HEAD
                    Registrador r = mBuscarRegistrador(clienteController, clId, regIdFactura);
                    if (r != null) {
                        double totalFactura = consumoController.mCalcularValorFactura(r.getConsumo());
=======
                    Registrador r = buscarRegistrador(clienteController, clId, regIdFactura);
                    if (r != null) {
                        double totalFactura = consumoController.calcularValorFactura(r.getConsumo());
>>>>>>> c1060346e87c1178b6be93aedabfa3900c02668c
                        System.out.println("Valor total de la factura: " + totalFactura + " COP");
                    } else {
                        System.out.println("Registrador no encontrado.");
                    }
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }

<<<<<<< HEAD
        scanner.close(); //cerrar el lector al final
    }

    private static void mImprimirMatrizDesdeCliente(ClienteController clienteController, Scanner scanner) { //imprime matriz de consumos para un cliente especifico
=======
        scanner.close();
    }


    private static void imprimirMatrizDesdeCliente(ClienteController clienteController, Scanner scanner) {
>>>>>>> c1060346e87c1178b6be93aedabfa3900c02668c
        System.out.print("ID del cliente: ");
        String cId = scanner.nextLine();
        System.out.print("ID del registrador: ");
        String rId = scanner.nextLine();
<<<<<<< HEAD
        clienteController.mImprimirMatrizDeConsumos(cId, rId);
    }

    private static Registrador mBuscarRegistrador(ClienteController clienteController, String clienteId, String registradorId) { //busca un registrador por ID dentro de un cliente
=======

        clienteController.imprimirMatrizDeConsumos(cId, rId);
    }

    private static Registrador buscarRegistrador(ClienteController clienteController, String clienteId, String registradorId) {
>>>>>>> c1060346e87c1178b6be93aedabfa3900c02668c
        for (Cliente c : clienteController.getClientes()) {
            if (c.getId().equals(clienteId)) {
                for (Registrador r : c.getRegistradores()) {
                    if (r.getId().equals(registradorId)) {
                        return r;
                    }
                }
            }
        }
<<<<<<< HEAD
        return null; //si no se encuentra
    }

    private static void mProcesarConsultaConsumo(ClienteController clienteController, ConsumoController consumoController, ConsumoView view, Scanner scanner, int opcion) { //procesa las consultas de consumo segun la opcion elegida
=======
        return null;
    }

    private static void procesarConsultaConsumo(ClienteController clienteController, ConsumoController consumoController, ConsumoView view, Scanner scanner, int opcion) {
>>>>>>> c1060346e87c1178b6be93aedabfa3900c02668c
        System.out.print("ID del cliente: ");
        String cId = scanner.nextLine();
        System.out.print("ID del registrador: ");
        String rId = scanner.nextLine();
<<<<<<< HEAD
        Registrador reg = mBuscarRegistrador(clienteController, cId, rId);
=======
        Registrador reg = buscarRegistrador(clienteController, cId, rId);
>>>>>>> c1060346e87c1178b6be93aedabfa3900c02668c
        if (reg == null) {
            System.out.println("Registrador no encontrado.");
            return;
        }
        ConsumokWH consumo = reg.getConsumo();
        switch (opcion) {
            case 9:
<<<<<<< HEAD
                double consumoMinimo = consumoController.mHallarConsumoMinimo(consumo);
                view.mMostrarConsumoMinimo(consumoMinimo);
                break;
            case 10:
                double consumoMaximo = consumoController.mHallarConsumoMaximo(consumo);
                view.mMostrarConsumoMaximo(consumoMaximo);
                break;
            case 11:
                view.mMostrarConsumoPorFranjas(consumoController.mHallarConsumoPorFranjas(consumo));
                break;
            case 12:
                view.mMostrarConsumoPorDias(consumoController.mHallarConsumoPorDias(consumo));
=======
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
>>>>>>> c1060346e87c1178b6be93aedabfa3900c02668c
                break;
        }
    }
}