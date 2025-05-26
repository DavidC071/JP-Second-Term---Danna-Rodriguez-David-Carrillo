<<<<<<< HEAD
package model;  

public class Registrador { 
    private String id; //almacena el ID del registrador
    private String direccion; //""
    private String ciudad; //""
    private ConsumokWH consumo;  //objeto que guarda los consumos en kwh

    public Registrador(String id, String direccion, String ciudad, int diasDelMes) {
        this.id = id;  // asigna el ID recibido al atributo
        this.direccion = direccion; //""
        this.ciudad = ciudad; //""
        this.consumo = new ConsumokWH(diasDelMes); //crea un objeto de consumo para los dias del mes
        this.consumo.mGenerarConsumosAleatorios(); //genera consumos aleatorios para el mes
    }

    public String getId() { //devuelve el ID del registrador
        return id;
    }

    public String getDireccion() { //""
        return direccion;
    }

    public String getCiudad() { //""
        return ciudad;
    }

    public ConsumokWH getConsumo() { //""
        return consumo;
    }

    public void setDireccion(String direccion) { //actualiza la direccion del registrador
        this.direccion = direccion;
    }

    public void setCiudad(String ciudad) { //""
=======
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
>>>>>>> c1060346e87c1178b6be93aedabfa3900c02668c
        this.ciudad = ciudad;
    }
}