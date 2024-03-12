public class ProductoEspecifico extends Producto { // extends implica que esta clase es hija de otra (prodcuto en este caso)
    private String categoria;
    private String marca;

    // constructor

    public ProductoEspecifico(int id, String nombre, double precio, String categoria, String marca) {
        super(id, nombre, precio); // en este super estan los datos heredados de otra clase. Estos tambien se ponen en la parte de arriba
        this.categoria = categoria;
        this.marca = marca;
    }


    // getter

    public String getCategoria() {
        return categoria;
    }

    public String getMarca() {
        return marca;
    }

    // setter

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    // to string


    @Override
    public String toString() {
        return super.toString() + // se pone el super para concatenar las caracteristas del padre
                "categoria='" + categoria + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }
}
