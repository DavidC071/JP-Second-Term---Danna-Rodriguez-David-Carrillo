package controller;

import java.util.ArrayList;
import java.util.List; //importa clases para listas dinamicas (permiten almacenar elementos de manera flexible)
import model.Cliente;
import model.Registrador;

public class ClienteController { //define la clase controladora de clientes
    private List<Cliente> clientes; //lista para guardar objetos cliente

    public ClienteController() {
        clientes = new ArrayList<>(); //constructor inicia la lista vacia
    }

    public void mCrearCliente(String id, String tipoId, String nombre, String correo, String direccion) {
        clientes.add(new Cliente(id, tipoId, nombre, correo, direccion)); //crea un nuevo cliente y lo agrega a la lista
    }

    public void mEditarCliente(String id, String nuevoTipoId, String nuevoNombre, String nuevoCorreo, String nuevaDireccion) {
        Cliente cliente = mBuscarCliente(id); //busca cliente por ID
        if (cliente != null) {
            cliente.setTipoId(nuevoTipoId); //actualiza el tipo de ID
            cliente.setNombre(nuevoNombre); //""
            cliente.setCorreo(nuevoCorreo); // ""
            cliente.setDireccion(nuevaDireccion); // ""
        }
    }

    public void mAgregarRegistradorACliente(String idCliente, String idRegistrador, String direccion, String ciudad, int diasDelMes) {
        Cliente cliente = mBuscarCliente(idCliente); //busca cliente por ID
        if (cliente != null) {
            cliente.mAgregarRegistrador(new Registrador(idRegistrador, direccion, ciudad, diasDelMes));
        } //crea y agrega un registrador al cliente
    }

    public void mEditarRegistrador(String idCliente, String idRegistrador, String nuevaDireccion, String nuevaCiudad) {
        Cliente cliente = mBuscarCliente(idCliente); //busca cliente por ID
        if (cliente != null) {
            Registrador registrador = cliente.mBuscarRegistrador(idRegistrador); //busca registrador por ID dentro del cliente
            if (registrador != null) {
                registrador.setDireccion(nuevaDireccion); //actualiza direccion del registrador
                registrador.setCiudad(nuevaCiudad); // ""
            }
        }
    }

    public void mCargarConsumosDeTodosLosClientes(int mes) {
        for (Cliente cliente : clientes) { //recorre todos los clientes
            for (Registrador registrador : cliente.getRegistradores()) { //recorre todos los registradores del cliente
                registrador.getConsumo().mGenerarConsumosAleatorios(); //genera consumos aleatorios
            }
        }
    }

    public void mCargarConsumosDeUnCliente(String idCliente, int mes) {
        Cliente cliente = mBuscarCliente(idCliente); //busca cliente por ID
        if (cliente != null) {
            for (Registrador registrador : cliente.getRegistradores()) { //recorre los registradores del cliente
                registrador.getConsumo().mGenerarConsumosAleatorios(); //genera consumos aleatorios
            }
        }
    }

    public List<Cliente> getClientes() {
        return clientes; //devuelve la lista de clientes
    }

    private Cliente mBuscarCliente(String id) {
        for (Cliente cliente : clientes) { //recorre los clientes
            if (cliente.getId().equals(id)) { //si encuentra coincidencia de ID
                return cliente; //devuelve el cliente encontrado
            }
        }
        return null; //si no lo encuentra devuelve null
    }

    public void mImprimirMatrizDeConsumos(String idCliente, String idRegistrador) {
        Cliente cliente = mBuscarCliente(idCliente); //busca cliente por ID
        if (cliente != null) {
            Registrador registrador = cliente.mBuscarRegistrador(idRegistrador); //busca registrador por ID
            if (registrador != null) {
                double[][] matriz = registrador.getConsumo().getConsumos(); //obtiene la matriz de consumos

                System.out.println("Matriz de consumos del registrador " + idRegistrador + " para el cliente " + idCliente + ":");
                for (int dia = 0; dia < matriz.length; dia++) { //recorre dias
                    System.out.print("Día " + (dia + 1) + ": "); //imprime número de dia
                    for (int hora = 0; hora < 24; hora++) { //recorre horas
                        System.out.printf("%4.0f", matriz[dia][hora]); //imprime consumo
                    }
                    System.out.println(); //salto de linea después de cada dia
                    System.out.println(); //linea en blanco entre dias
                }
            } else {
                System.out.println("Registrador no encontrado."); //mensaje si no encuentra registrador
            }
        } else {
            System.out.println("Cliente no encontrado."); //mensaje si no encuentra cliente
        }
    }