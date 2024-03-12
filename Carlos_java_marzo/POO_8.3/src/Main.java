public class Main {
    public static void main(String[] args) {

//        Libro objLibro = new Libro("cien años de soledad","Gabriel garcia","01-05-1967",true);
//
//        System.out.println(objLibro.getTitulo()); // metodo para obtener la informacion
//
//        objLibro.setTitulo("el rastro de tu sangre en la nieve"); // set para cambiar los datos del objeto
//
//        System.out.println(objLibro.getTitulo());
//
//        System.out.println(objLibro.toString());
//
//        objLibro.cambiarEstado();
//
//        System.out.println(objLibro.toString());

        Empleado objEmpleado = new Empleado("juan","jefe",200,10);

        System.out.println(objEmpleado.toString());

        objEmpleado.cambiarSalario(10);

        System.out.println(objEmpleado.toString());
    }
}