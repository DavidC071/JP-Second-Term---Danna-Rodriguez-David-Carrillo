package controller;

import model.Cliente;
import model.Registrador;

import java.util.ArrayList;

public class ClienteController {
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public void crearCliente(String id, String tipoId, String correo, String direccion) {
        clientes.add(new Cliente(id, tipoId, correo, direccion));
    }

    public void editarCliente(String id, String nuevoTipoId, String nuevoCorreo, String nuevaDireccion) {
        for (Cliente c : clientes) {
            if (c.getId().equals(id)) {
                c.setTipoId(nuevoTipoId);
                c.setCorreo(nuevoCorreo);
                c.setDireccion(nuevaDireccion);
                break;
            }
        }
    }

    public void agregarRegistradorACliente(String clienteId, String regId, String direccion, String ciudad, int dias) {
        for (Cliente c : clientes) {
            if (c.getId().equals(clienteId)) {
                c.agregarRegistrador(new Registrador(regId, direccion, ciudad, dias));
                break;
            }
        }
    }

    public void editarRegistrador(String clienteId, String regId, String nuevaDireccion, String nuevaCiudad) {
        for (Cliente c : clientes) {
            if (c.getId().equals(clienteId)) {
                for (Registrador r : c.getRegistradores()) {
                    if (r.getId().equals(regId)) {
                        r.setDireccion(nuevaDireccion);
                        r.setCiudad(nuevaCiudad);
                        break;
                    }
                }
            }
        }
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
}