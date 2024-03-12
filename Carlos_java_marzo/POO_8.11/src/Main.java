
//Taller POO segunda parte ejercicio 1. Encapsulamiento y herencia.
public class Main {
    public static void main(String[] args){

        // listamos los productos y vemos que inmediatamente admite los puntos atributos de la clase padre
        ProductoEspecifico objProducto1 = new ProductoEspecifico(1,"lapiz",2000,"papeleria","Big");

        ProductoEspecifico objProdcuto2 = new ProductoEspecifico(2,"cuaderno",6000,"Cuaderno","norma");

        Inventario objInventario = new Inventario();
        objInventario.agregarProducto(objProducto1);
        objInventario.agregarProducto(objProdcuto2);

        objInventario.listarProductos(); // listar productos

        objInventario.eliminarProdcutos(2);
        System.out.println("Despues de eliminar");
        objInventario.listarProductos();

        System.out.println(objInventario.buscarPorNombre("lapiz"));
    }
}
