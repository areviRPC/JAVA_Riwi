import java.util.ArrayList;
import java.util.Scanner;

public class Curso {
    private String codigo;
    private String nombre;
    private ArrayList<Estudiante> listaEstudiantes; // Esta lista va a recibir a su vez a lo estudiantes

    private static int index = 1; // este metodo se puede invocar sin instanciarlo (metodo estatico)

    public Curso(String codigo,String nombre){
        this.nombre = nombre;
        this.codigo = codigo;
        this.listaEstudiantes = new ArrayList<>(); // forma de inicializar un arraylist en el constructor
    }

    // metodo para agregar estudiantes a un curso

    public void agregarEstudiante(Scanner objScan){
        objScan.nextLine(); // se limpia la entrada de texto
        System.out.println("ingresa el nombre del nuevo estudiante");
        String nombre = objScan.nextLine();

        objScan.nextLine();
        System.out.println("ingresa el email del estudiante");
        String email = objScan.next();

        Estudiante objEstudiante = new Estudiante(index,nombre,email);
        index++; // usamos este

        this.listaEstudiantes.add(objEstudiante);
        System.out.println("estudiante agregado correctamente");
    }

    // listar todos los estudiantes
    public void listarEstudiantes(){
        if (this.listaEstudiantes.isEmpty()){
            System.out.println("No hay estudiantes en el curso".concat(this.nombre));
        }else{
            System.out.println("lista de estudiantes del curso".concat(this.nombre));
            for (Estudiante temporal : this.listaEstudiantes){
                System.out.println(temporal.toString());
            }
        }
    }

    // Eliminar estudiantes

    public void eliminarEstudiante (Scanner objScan){
        this.listarEstudiantes();

        System.out.println("ingree el id del estudiante a eliminar");
        int idEliminar = objScan.nextInt(); // se pide el ID del estudiante y se elimina si coincide

        boolean eliminado = this.listaEstudiantes.removeIf(estudiante -> estudiante.getId() == idEliminar); //

        System.out.println(!eliminado
            ?"No se pudo eliminar el estudiante"
            : "Estudiante eliminado correctamente");
    }



    // getter


    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    // setter


    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    // to String


    @Override
    public String toString() {
        return "Curso{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", listaEstudiantes=" + listaEstudiantes +
                '}';
    }
}
