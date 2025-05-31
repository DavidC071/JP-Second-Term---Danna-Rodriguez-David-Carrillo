import controller.ClienteController;
import controller.ConsumoController;
import java.util.Scanner;
import model.Registrador;
import view.View;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //lector para entrada por consola
        ClienteController clienteController = new ClienteController(); //controlador de clientes
        ConsumoController consumoController = new ConsumoController(); //controlador de consumos
        View view = new View(); //vista para mostrar datos

        boolean salir = false; //bandera para controlar cuando salir del menu

        while (!salir) { //bucle principal del menu
            view.mMostrarMenuPrincipalCompleto(); //muestra el menu principal

            System.out.print("\nSelecciona una opción: ");
            int opcion = scanner.nextInt(); //leer opcion elegida
            scanner.nextLine(); //limpiar la memoria temporal

            switch (opcion) {
                case 1: //crear cliente
                    System.out.print("ID del cliente: ");
                    String id = scanner.nextLine();
                    System.out.print("Tipo de identificación: ");
                    String tipoId = scanner.nextLine();
                    System.out.print("Nombre del cliente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Correo: ");
                    String correo = scanner.nextLine();
                    System.out.print("Dirección: ");
                    String direccion = scanner.nextLine();
                    clienteController.mCrearCliente(id, tipoId, nombre, correo, direccion);
                    view.mClienteCreado(); //muestra confirmacion de creacion de cliente
                    break;

                case 2: //editar cliente
                    System.out.print("ID del cliente a editar: ");
                    String idEdit = scanner.nextLine();
                    System.out.print("Nuevo tipo de identificación: ");
                    String nuevoTipo = scanner.nextLine();
                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Nuevo correo: ");
                    String nuevoCorreo = scanner.nextLine();
                    System.out.print("Nueva dirección: ");
                    String nuevaDir = scanner.nextLine();
                    clienteController.mEditarCliente(idEdit, nuevoTipo, nuevoNombre, nuevoCorreo, nuevaDir);
                    view.mClienteEditado(); //muestra confirmacion de edicion de cliente
                    break;

                case 3: //agregar registrador
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
                    clienteController.mAgregarRegistradorACliente(idCliente, idReg, dirReg, ciudad, dias);
                    view.mRegistradorAgregado(); //mensaje confirmacion
                    break;

                case 4: //editar registrador
                    System.out.print("ID del cliente: ");
                    String cliId = scanner.nextLine();
                    System.out.print("ID del registrador a editar: ");
                    String regId = scanner.nextLine();
                    System.out.print("Nueva dirección del registrador: ");
                    String nuevaDirReg = scanner.nextLine();
                    System.out.print("Nueva ciudad del registrador: ");
                    String nuevaCiudad = scanner.nextLine();
                    clienteController.mEditarRegistrador(cliId, regId, nuevaDirReg, nuevaCiudad);
                    System.out.println("Registrador editado correctamente.");
                    break;

                case 5: //mostrar consumos todos los clientes
                    System.out.print("Mes (1-12): ");
                    int mesTodos = scanner.nextInt();
                    clienteController.mCargarConsumosDeTodosLosClientes(mesTodos);
                    view.mConsumosCargadosTodos(); //mensaje confirmacion
                    break;

                case 6: //cargar consumos cliente específico
                    System.out.print("ID del cliente: ");
                    String clienteId = scanner.nextLine();
                    System.out.print("Mes (1-12): ");
                    int mesCliente = scanner.nextInt();
                    clienteController.mCargarConsumosDeUnCliente(clienteId, mesCliente);
                    view.mConsumosCargadosCliente(); //mensaje confirmacion
                    break;

                case 7: //imprimir matriz consumos
                    view.mImprimirMatrizDesdeCliente(clienteController, scanner);
                    break;

                case 8: //cambiar consumo hora especifica
                    System.out.print("ID del cliente: ");
                    String cId = scanner.nextLine();
                    System.out.print("ID del registrador: ");
                    String rId = scanner.nextLine();
                    Registrador reg = clienteController.mBuscarRegistrador(cId, rId);
                    if (reg != null) {
                        System.out.print("Día (1-n): ");
                        int d = scanner.nextInt() - 1;
                        System.out.print("Hora (0-23): ");
                        int h = scanner.nextInt();
                        System.out.print("Nuevo consumo (kWh): ");
                        double val = scanner.nextDouble();
                        consumoController.mCambiarConsumoHora(reg.getConsumo(), d, h, val);
                        view.mConsumoActualizado(); //mensaje de exito
                    } else {
                        view.mRegistradorNoEncontrado(); //error
                    }
                    break;

                case 9: case 10: case 11: case 12: //consultas de consumo
                    view.mProcesarConsultaConsumo(clienteController, consumoController, scanner, opcion);
                    break;

                case 13: //salir
                    salir = true;
                    System.out.println("¡Hasta pronto!");
                    break;

                case 14: //calcular valor factura
                    System.out.print("ID del cliente: ");
                    String clId = scanner.nextLine();
                    System.out.print("ID del registrador: ");
                    String regIdFactura = scanner.nextLine();
                    Registrador r = clienteController.mBuscarRegistrador(clId, regIdFactura);
                    if (r != null) {
                        double[] resultados = consumoController.mCalcularValorFactura(r.getConsumo());
                        double totalFactura = resultados[0];
                        double totalKWh = resultados[1];
                        view.mMostrarValorFactura(totalFactura, totalKWh);

                    } else {
                        view.mRegistradorNoEncontrado();
                    }
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }

        scanner.close(); //cerrar el lector
    }
}