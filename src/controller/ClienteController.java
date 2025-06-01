package controller;

import java.util.ArrayList;
import java.util.List; //importa clases para listas dinamicas (permiten almacenar elementos de manera flexible)
import model.Cliente;
import model.Registrador;
import view.View;

public class ClienteController { //define la clase controladora de clientes
    private List<Cliente> clientes; //lista para guardar objetos cliente
    private View view; //referencia a la vista para mostrar mensajes o interactuar con el usuario

    public ClienteController(View view) { //constructor que recibe la vista como parametro
        this.clientes = new ArrayList<>(); //inicializa la lista de clientes vacía
        this.view = view; //asigna la vista recibida al atributo interno de la clase
    }



    public void mCrearCliente(String id, String tipoId, String nombre, String correo, String direccion) {
        clientes.add(new Cliente(id, tipoId, nombre, correo, direccion)); //crea un nuevo cliente y lo agrega a la lista
    }

    public boolean mEditarCliente(String id, String nuevoTipoId, String nuevoNombre, String nuevoCorreo, String nuevaDireccion) {
        Cliente cliente = mBuscarCliente(id); //busca cliente por ID
        if (cliente == null) { //si no se encuentra al cliente
            view.mClienteNoEncontrado(); //muestra mensaje
            return false; //retorna false
            
        } else {
            cliente.setTipoId(nuevoTipoId); //actualiza el tipo de ID
            cliente.setNombre(nuevoNombre); //""
            cliente.setCorreo(nuevoCorreo); //""
            cliente.setDireccion(nuevaDireccion); //""
            return true; //indica que la edicion fue exitosa

        }
    }

    public void mAgregarRegistradorACliente(String idCliente, String idRegistrador, String direccion, String ciudad, int diasDelMes) {
        Cliente cliente = mBuscarCliente(idCliente); //busca cliente por ID
        if (cliente != null) { //verifica si el cliente fue encontrado
            if (cliente.mBuscarRegistrador(idRegistrador) != null) { //verifica si ya existe un registrador con ese ID en el cliente
                   System.out.println("Ya existe un registrador con ese ID para este cliente."); //mensaje de error si el ID del registrador ya está en uso
        }   else {
            cliente.mAgregarRegistrador(new Registrador(idRegistrador, direccion, ciudad, diasDelMes)); //crea y agrega un nuevo registrador al cliente
            view.mRegistradorAgregado(); //mensaje de exito
        }
    } else {
        view.mClienteNoEncontrado(); //mensaje si no se encuentra el cliente con el ID proporcionado
    }
}

   public boolean mEditarRegistrador(String idCliente, String idRegistrador, String nuevaDireccion, String nuevaCiudad) {
    Cliente cliente = mBuscarCliente(idCliente); //busca cliente por ID
    if (cliente == null) { //si no se encuentra el cliente
        view.mClienteNoEncontrado(); //muestra mensaje
        return false; //retorna false porque no se puede continuar
    }
       Registrador registrador = cliente.mBuscarRegistrador(idRegistrador); //busca registrador por ID dentro del cliente

    if (registrador == null) {
        view.mRegistradorNoEncontrado(); //mensaje de error si no existe el registrador
        return false;
    }
    registrador.setDireccion(nuevaDireccion); //actualiza la dirección del registrador
    registrador.setCiudad(nuevaCiudad); //""
    return true; //indica que la edición fue exitosa
}


    
    public void mCargarConsumosDeTodosLosClientes(int mes) { //metodo para cargar consumos de todos los clientes en un mes especifico
    
    if (clientes.isEmpty()) { //verifica si no hay clientes registrados
        System.out.println("No hay clientes registrados.");
        return; //sale del metodo si no hay clientes
    }

    for (Cliente cliente : clientes) { //recorre la lista de clientes
        System.out.println("\nCliente: " + cliente.getNombre() + " (ID: " + cliente.getId() + ")"); //imprime informacion basica del cliente
        ArrayList<Registrador> registradores = cliente.getRegistradores(); //obtiene la lista de registradores del cliente
        if (registradores.isEmpty()) { //verifica si el cliente no tiene registradores
            System.out.println("  No tiene registradores.");
        } else {
            for (Registrador r : registradores) { //recorre todos los registradores del cliente
                r.getConsumo().mGenerarConsumosAleatorios(mes, r.getId()); //genera consumos aleatorios para el mes especificado en este registrador
                System.out.println("  Registrador ID: " + r.getId()); //imprime el ID del registrador

                double[][] matriz = r.getConsumo().getConsumos(); //obtiene la matriz de consumos (dias x horas)
                for (int dia = 0; dia < matriz.length; dia++) { //recorre la matriz por dias
                    System.out.print("  Día " + (dia + 1) + ": "); //imprime el numero del dia (empezando desde 1)
                    
                    for (int hora = 0; hora < 24; hora++) { //recorre las 24 horas del dia y muestra el consumo
                        System.out.printf("%4.0f", matriz[dia][hora]); //imprime el consumo de forma formateada (sin decimales)
                    }

                    System.out.println(); //salta a la siguiente linea despues de imprimir las 24 horas
                }

                System.out.println(); //linea en blanco para separar registradores
            }
        }
    }
}
    public void mCargarConsumosDeUnCliente(String idCliente, int mes) {
    Cliente cliente = mBuscarCliente(idCliente); //busca el cliente con el id proporcionado
    if (cliente != null) { //verifica si el cliente fue encontrado
        for (Registrador registrador : cliente.getRegistradores()) { //recorre todos los registradores del cliente
            registrador.getConsumo().mGenerarConsumosAleatorios(mes, registrador.getId()); //genera consumos aleatorios para ese registrador en el mes dado
        }
    } else {
        view.mClienteNoEncontrado(); //muestra un mensaje si el cliente no existe
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

    public void mMostraMatrizConsumosDeRegistrador(String idCliente, String idRegistrador) {
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
                    System.out.println(); //salto de linea despues de cada dia
                    System.out.println(); //linea en blanco entre dias
                }
            } else {
                view.mRegistradorNoEncontrado(); //mensaje si no encuentra registrador
            }
        } else {
             view.mClienteNoEncontrado(); //mensaje si no encuentra cliente
        }
    }

   public Registrador mBuscarRegistrador(String clienteId, String registradorId) {
    for (Cliente c : clientes) { //recorre todos los clientes disponibles
        if (c.getId().equals(clienteId)) { //verifica si el ID del cliente coincide
            for (Registrador r : c.getRegistradores()) { //recorre los registradores del cliente encontrado
                if (r.getId().equals(registradorId)) { //verifica si el ID del registrador coincide
                    return r; //retorna el registrador encontrado
                }
            }
        }
    }
    return null; //si no se encuentra el registrador, retorna null
  }
}