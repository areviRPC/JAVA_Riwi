public class Empleado {

    private String nombre;
    private String posicion;
    private int salario;
    private int id;

    // metodo

    public Empleado(String nombre, String posicion, int salario, int id) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.salario = salario;
        this.id = id;
    }


    // get


    public String getNombre() {
        return this.nombre;
    }

    public String getPosicion() {
        return this.posicion;
    }

    public int getSalario() {
        return this.salario;
    }

    public int getId() {
        return this.id;
    }

    // set


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void cambiarSalario(int porcentaje){ // este metodo tiene como parametro el entero porcentaje que se ingresa en el main

        this.salario = salario + ((salario/100)*porcentaje);
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", posicion='" + posicion + '\'' +
                ", salario=" + salario +
                ", id=" + id +
                '}';
    }
}
