<<<<<<< HEAD
package model; 

import java.util.ArrayList;  

public class Cliente { //define la clase pública Cliente
    private String id; //almacena el ID del cliente
    private String tipoId; //""
    private String nombre; //""
    private String correo; //""
    private String direccion; //""
    private ArrayList<Registrador> registradores; //lista de registradores asociados al cliente

    public Cliente(String id, String tipoId, String nombre, String correo, String direccion) {
        this.id = id; //asigna el ID recibido
        this.tipoId = tipoId; //""
        this.nombre = nombre; //""
        this.correo = correo; //""
        this.direccion = direccion; //""
        this.registradores = new ArrayList<>(); //inicia la lista de registradores vacía
    }

    public String getId() {
        return id; //retorna el ID del cliente
    }

    public String getTipoId() {
        return tipoId; //""
    }

    public String getNombre() {
        return nombre; //""
    }

    public String getCorreo() {
        return correo; //""
    }

    public String getDireccion() {
        return direccion; //""
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId; //actualiza el tipo de identificación
    }

    public void setNombre(String nombre) {
        this.nombre = nombre; //""
    }

    public void setCorreo(String correo) {
        this.correo = correo; //""
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion; //""
    }

    public void mAgregarRegistrador(Registrador r) {
        registradores.add(r); //agrega un registrador a la lista
    }

    public ArrayList<Registrador> getRegistradores() {
        return registradores; //retorna la lista de registradores
    }

    public Registrador mBuscarRegistrador(String idRegistrador) {
        for (Registrador r : registradores) { //recorre cada registrador
            if (r.getId().equals(idRegistrador)) { //si el ID coincide
                return r; //retorna el registrador encontrado
            }
        }
        return null; //si no lo encuentra retorna null
=======
package model;


import java.util.ArrayList;

public class Cliente {
    private String id;
    private String tipoId;
    private String correo;
    private String direccion;
    private ArrayList<Registrador> registradores;

    public Cliente(String id, String tipoId, String correo, String direccion) {
        this.id = id;
        this.tipoId = tipoId;
        this.correo = correo;
        this.direccion = direccion;
        this.registradores = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getTipoId() {
        return tipoId;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void agregarRegistrador(Registrador r) {
        registradores.add(r);
    }

    public ArrayList<Registrador> getRegistradores() {
        return registradores;
    }

    public Registrador buscarRegistrador(String idRegistrador) {
      for (Registrador r : registradores) {
        if (r.getId().equals(idRegistrador)) {
            return r;
        }
      }
      return null;
>>>>>>> c1060346e87c1178b6be93aedabfa3900c02668c
    }
}