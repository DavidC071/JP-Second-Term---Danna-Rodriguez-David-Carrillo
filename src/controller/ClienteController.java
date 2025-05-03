package controller;

import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Registrador;

public class ClienteController {
    private List<Cliente> clientes;

    public ClienteController() {
        clientes = new ArrayList<>();
    }

    public void crearCliente(String id, String tipoId, String correo, String direccion) {
        clientes.add(new Cliente(id, tipoId, correo, direccion));
    }

    public void editarCliente(String id, String nuevoTipoId, String nuevoCorreo, String nuevaDireccion) {
        Cliente cliente = buscarCliente(id);
        if (cliente != null) {
            cliente.setTipoId(nuevoTipoId);
            cliente.setCorreo(nuevoCorreo);
            cliente.setDireccion(nuevaDireccion);
        }
    }

    public void agregarRegistradorACliente(String idCliente, String idRegistrador, String direccion, String ciudad, int diasDelMes) {
        Cliente cliente = buscarCliente(idCliente);
        if (cliente != null) {
            cliente.agregarRegistrador(new Registrador(idRegistrador, direccion, ciudad, diasDelMes));
        }
    }

    public void editarRegistrador(String idCliente, String idRegistrador, String nuevaDireccion, String nuevaCiudad) {
        Cliente cliente = buscarCliente(idCliente);
        if (cliente != null) {
            Registrador registrador = cliente.buscarRegistrador(idRegistrador);
            if (registrador != null) {
                registrador.setDireccion(nuevaDireccion);
                registrador.setCiudad(nuevaCiudad);
            }
        }
    }

    public void cargarConsumosDeTodosLosClientes(int mes) {
        for (Cliente cliente : clientes) {
            for (Registrador registrador : cliente.getRegistradores()) {
                registrador.getConsumo().generarConsumosAleatorios(); 
            }
        }
    }

    public void cargarConsumosDeUnCliente(String idCliente, int mes) {
        Cliente cliente = buscarCliente(idCliente);
        if (cliente != null) {
            for (Registrador registrador : cliente.getRegistradores()) {
                registrador.getConsumo().generarConsumosAleatorios(); 
            }
        }
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    private Cliente buscarCliente(String id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }

    public void imprimirMatrizDeConsumos(String idCliente, String idRegistrador) {
        Cliente cliente = buscarCliente(idCliente);
        if (cliente != null) {
            Registrador registrador = cliente.buscarRegistrador(idRegistrador);
            if (registrador != null) {
                double[][] matriz = registrador.getConsumo().getConsumos();

                System.out.println("Matriz de consumos del registrador " + idRegistrador + " para el cliente " + idCliente + ":");
                for (int dia = 0; dia < matriz.length; dia++) {
                    System.out.print("Día " + (dia + 1) + ": ");
                    for (int hora = 0; hora < 24; hora++) {
                        System.out.printf("%.2f ", matriz[dia][hora]);
                    }
                    System.out.println();
                    System.out.println();
                }
            } else {
                System.out.println("Registrador no encontrado.");
            }
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }
}