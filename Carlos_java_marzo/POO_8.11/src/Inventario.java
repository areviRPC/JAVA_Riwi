import java.util.ArrayList;

// en esta clase se crea un arraylist que ocntenga los demas productos
public class Inventario {
    private ArrayList<ProductoEspecifico> listaProductos; // el arraylist puede recibir objetos completos

    // constructor para inicializar la variable
    public Inventario(){
        this.listaProductos = new ArrayList<>(); // palabra reservada new para instanciar a productos
    }

    // metodo para agregar
    public void agregarProducto(ProductoEspecifico producto){ // todas las clases se combierten en objetos y en un tipo de datos
        this.listaProductos.add(producto); // agregamos el nuevo producto garantizando que tenga todas las propiedades de un ProductoEspecifico
    }

    // metodo para eliminar
    public boolean eliminarProdcutos(int id){ // se debe poner booleano porque
        return this.listaProductos.removeIf(producto -> producto.getId() == id);
    }

    // para listar porductos
    public void listarProductos (){ // se lee la lista y se imprime lo que exista
        for (ProductoEspecifico iterador : this.listaProductos){ // El objeto producto especifico como iterador
            System.out.println(iterador.toString()); // invocamos el toString de la clase Producto especifico
        }
    }

    // para buscar por nombre
    public ProductoEspecifico buscarPorNombre(String nombreBuscar){
        for (ProductoEspecifico iterador : this.listaProductos){
            if(iterador.getNombre().equalsIgnoreCase(nombreBuscar)){
                return iterador;
            } // to ignore case para ignorar mayusculas o minusculas
        }
        return null;
    }

    public ProductoEspecifico buscarPorMarca(String marcaBuscar){
        for (ProductoEspecifico iterador : this.listaProductos){
            if(iterador.getMarca().equalsIgnoreCase(marcaBuscar)){
                return iterador;
            } // to ignore case para ignorar mayusculas o minusculas
        }
        return null;
    }
}
