package view;

import controller.ClienteController;
import controller.ConsumoController;
import java.util.Scanner;
import model.ConsumokWH;
import model.Registrador;

public class View {

    public void mMostrarMenuPrincipalCompleto() { //muestra el menú principal
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
    }

    public void mClienteCreado() { //mensaje de cliente creado
        System.out.println("Cliente creado exitosamente.");
    }

    public void mClienteEditado() { //mensaje de cliente editado
        System.out.println("Cliente editado exitosamente.");
    }

    public void mRegistradorAgregado() { //mensaje de registrador agregado
        System.out.println("Registrador agregado al cliente.");
    }

    public void mConsumosCargadosTodos() { //mensaje cuando se cargan consumos de todos los clientes
        System.out.println("Consumos de todos los clientes cargados correctamente.");
    }

    public void mConsumosCargadosCliente() { //mensaje cuando se cargan consumos de un cliente específico
        System.out.println("Consumos del cliente cargados correctamente.");
    }

    public void mConsumoActualizado() { //mensaje cuando se actualiza un consumo
        System.out.println("Consumo actualizado.");
    }

    public void mRegistradorNoEncontrado() { //mensaje cuando no se encuentra un registrador
        System.out.println("Registrador no encontrado.");
    }

    public void mMostrarValorFactura(double totalFactura) { //muestra el valor total de la factura
        System.out.println("Valor total de la factura: " + totalFactura + " COP");
    }

    public void mMostrarConsumoMinimo(double valor, int dia, int hora) {
        System.out.println("Consumo mínimo: " + valor + " kWh"); //muestra valor
        System.out.println("Registrado el día " + dia + " a las " + hora + ":00 horas."); //muestra posición
    }

    public void mMostrarConsumoMaximo(double valor, int dia, int hora) {
        System.out.println("Consumo máximo: " + valor + " kWh"); //muestra valor
        System.out.println("Registrado el día " + dia + " a las " + hora + ":00 horas."); //muestra posición
    }

    public void mMostrarConsumoPorFranjas(double[] franjas) { //muestra el consumo por franjas
        System.out.println("Consumo por franjas horarias:");
        for (int i = 0; i < franjas.length; i++) {
            System.out.println("  Franja " + (i + 1) + ": " + franjas[i] + " kWh");
        }
    }

    public void mMostrarConsumoPorDias(double[] dias) { //muestra el consumo por días
        System.out.println("Consumo por días:");
        for (int i = 0; i < dias.length; i++) {
            System.out.println("  Día " + (i + 1) + ": " + dias[i] + " kWh");
        }
    }

    public void mImprimirMatrizDesdeCliente(ClienteController clienteController, Scanner scanner) {
        System.out.print("ID del cliente: "); //pide al usuario el ID del cliente
        String cId = scanner.nextLine(); //lee el ID del cliente ingresado
        System.out.print("ID del registrador: "); //pide al usuario el ID del registrador
        String rId = scanner.nextLine(); //lee el ID del registrador ingresado
        clienteController.mImprimirMatrizDeConsumos(cId, rId); //llama al controlador para imprimir la matriz de consumos
    }

    public void mProcesarConsultaConsumo(ClienteController clienteController, ConsumoController consumoController, Scanner scanner, int opcion) {
        System.out.print("ID del cliente: "); //pide al usuario el ID del cliente
        String cId = scanner.nextLine(); //lee el ID del cliente ingresado
        System.out.print("ID del registrador: "); //pide al usuario el ID del registrador
        String rId = scanner.nextLine(); //lee el ID del registrador ingresado
        Registrador reg = clienteController.mBuscarRegistrador(cId, rId); //busca el registrador correspondiente al cliente

        if (reg == null) { //verifica si el registrador no fue encontrado
            mRegistradorNoEncontrado(); //muestra mensaje si no se encuentra el registrador
            return; //sale del método si no hay registrador
        }

        ConsumokWH consumo = reg.getConsumo(); //obtiene el objeto de consumo del registrador

        switch (opcion) { //evalúa la opción seleccionada por el usuario
            case 9: //consumo mínimo
                double[] datosMin = consumoController.mHallarConsumoMinimoConPosicion(consumo); //obtiene valores
                mMostrarConsumoMinimo(datosMin[0], (int) datosMin[1], (int) datosMin[2]); //muestra
                break;
            case 10: //consumo máximo
                double[] datosMax = consumoController.mHallarConsumoMaximoConPosicion(consumo); //obtiene valores
                mMostrarConsumoMaximo(datosMax[0], (int) datosMax[1], (int) datosMax[2]); //muestra
                break;
            case 11:
                mMostrarConsumoPorFranjas(consumoController.mHallarConsumoPorFranjas(consumo));
                break;
            case 12:
                mMostrarConsumoPorDias(consumoController.mHallarConsumoPorDias(consumo));
                break;
        }
    }
}