package entity;

public class Avion {
    private int id_avion;

    private String modelo;

    private int capacidad;

    // constructor vacio
    public Avion() {
    }

    // setters
    public void setId_avion(int id_avion) {
        this.id_avion = id_avion;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    //getters
    public int getId_avion() {
        return id_avion;
    }
    public String getModelo() {
        return modelo;
    }
    public int getCapacidad() {
        return capacidad;
    }

    // constructor
    public Avion(int id_avion, String modelo, int capacidad) {
        this.id_avion = id_avion;
        this.modelo = modelo;
        this.capacidad = capacidad;
    }

    // toString

    @Override
    public String toString() {
        return "Avion{" +
                "id_avion=" + id_avion +
                ", modelo='" + modelo + '\'' +
                ", capacidad=" + capacidad +
                '}';
    }
}
