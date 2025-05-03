package model;

public class Registrador {
    private String id;
    private String direccion;
    private String ciudad;
    private ConsumokWH consumo;

    public Registrador(String id, String direccion, String ciudad, int diasDelMes) {
        this.id = id;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.consumo = new ConsumokWH(diasDelMes);
        this.consumo.generarConsumosAleatorios();
    
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

    public ConsumokWH getConsumo() {
        return consumo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}