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
    }
}