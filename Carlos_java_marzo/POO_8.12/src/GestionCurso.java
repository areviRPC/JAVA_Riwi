import java.awt.image.CropImageFilter;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionCurso {
    private ArrayList<Curso> listaCursos; // clase controladora, aqui agregamos los metodos para la logica que queramos

    // constructor
    public GestionCurso() {
        this.listaCursos = new ArrayList<>();
    }

    // crear curso
    public void agregarCurso(Scanner objScan){ // metodo para crear curso
        System.out.println("ingresa el nombre del nuevo curso");
        String nombre = objScan.next();

        System.out.println("ingresa el codigo del nuevo curso");
        String codigo = objScan.next();

        if (this.buscarCursoPorCodigo(codigo) != null){
            System.out.println("\n Ya existe un curso con este codigo");

        } else {
            Curso objCurso = new Curso(codigo,nombre); // cuando hacemos la validacion de que el codigo no exista antes agregamos un nuevo Curso
            if (this.listaCursos.add(objCurso)){
                System.out.println("Curso agregado correcto");
            }else{
                System.out.println("No se pudo agregar el curso");
            }

        }
    }

    // buscar curso por codigo
    // al poner "curso" luego de public ordenamos que se retorne un objeto nuevo tipo curso
    public Curso buscarCursoPorCodigo (String codigoBuscar){ // codigoBuscar es un parametro que se pide al iniciar el metodo BuscarCursoPorCodigo
        for (Curso temporal: this.listaCursos){
            if (temporal.getCodigo().equalsIgnoreCase((codigoBuscar))){
                return temporal;
            }
        }
        return null; // como necesitamos retornar algo, en caso de que no haya coincidencia solo retorna null
    }

    // listar todos los cursos
    public void listarTodosLosCursos (){
        if(!this.listaCursos.isEmpty()){
            for(Curso temporal: this.listaCursos){ // temporal puede llamarse como sea
                System.out.println(temporal.toString());
            }
        }
    }
}
