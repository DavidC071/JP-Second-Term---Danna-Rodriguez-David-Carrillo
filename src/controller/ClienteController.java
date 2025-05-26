package controller;

import java.util.ArrayList;
<<<<<<< HEAD
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
=======
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
>>>>>>> c1060346e87c1178b6be93aedabfa3900c02668c
            }
        }
    }

<<<<<<< HEAD
    public void mCargarConsumosDeTodosLosClientes(int mes) {
        for (Cliente cliente : clientes) { //recorre todos los clientes
            for (Registrador registrador : cliente.getRegistradores()) { //recorre todos los registradores del cliente
                registrador.getConsumo().mGenerarConsumosAleatorios(); //genera consumos aleatorios
=======
    public void cargarConsumosDeTodosLosClientes(int mes) {
        for (Cliente cliente : clientes) {
            for (Registrador registrador : cliente.getRegistradores()) {
                registrador.getConsumo().generarConsumosAleatorios(); 
>>>>>>> c1060346e87c1178b6be93aedabfa3900c02668c
            }
        }
    }

<<<<<<< HEAD
    public void mCargarConsumosDeUnCliente(String idCliente, int mes) {
        Cliente cliente = mBuscarCliente(idCliente); //busca cliente por ID
        if (cliente != null) {
            for (Registrador registrador : cliente.getRegistradores()) { //recorre los registradores del cliente
                registrador.getConsumo().mGenerarConsumosAleatorios(); //genera consumos aleatorios
=======
    public void cargarConsumosDeUnCliente(String idCliente, int mes) {
        Cliente cliente = buscarCliente(idCliente);
        if (cliente != null) {
            for (Registrador registrador : cliente.getRegistradores()) {
                registrador.getConsumo().generarConsumosAleatorios(); 
>>>>>>> c1060346e87c1178b6be93aedabfa3900c02668c
            }
        }
    }

    public List<Cliente> getClientes() {
<<<<<<< HEAD
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
            System.out.println("Cliente no encontrado.");//mensaje si no encuentra client
        }
    }
=======
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
>>>>>>> c1060346e87c1178b6be93aedabfa3900c02668c
