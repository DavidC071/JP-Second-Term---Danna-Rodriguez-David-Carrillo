package model;

public class Registrador {
    private String id;
    private String direccion;
    private String ciudad;
    private ConsumokWH consumo;

    public Registrador(String id, String direccion, String ciudad, int dias) {
        this.id = id;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.consumo = new ConsumokWH(dias);
    }

    public String getId() {
        return id;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public ConsumokWH getConsumo() {
        return consumo;
    }
}