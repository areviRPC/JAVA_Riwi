// Taller POO segunda parte ejercicio 3. Estudiantes Encapsulamiento y herencia.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    // instancias (se debe usar la clase para poder acceder a sus metodos
        Scanner objScan = new Scanner(System.in);
        GestionCurso objGestion = new GestionCurso();

        int option = 0;
        do {
            System.out.println("""
                    Menu de Opciones
                    1. Administrar estudiantes
                    2. Administrar cursos
                    3. Salir 
                    
                    Ingrese su opcion:
                    """);

            option = objScan.nextInt();

            switch (option){

                case 1:
                    int option3 = 0;
                    do{
                        System.out.println("""
                                Menu Estudiantes
                                1. Agregar estudiante a un curso
                                2. Listar estudiantes de un curso
                                3. Eliminar estudiantes de un curso
                                4. Salir
                                """);

                    option3 = objScan.nextInt();
                    switch (option3){
                        case 1: // se deben listar los cursos, preguntar el id del curso y luego agregar
                            objGestion.listarTodosLosCursos(); // se llama el metodo que lista los cursos
                            System.out.println("ingresa el codigo del curso donde se agregara el nuevo estudiante");

                            String codigo = objScan.next(); // se ingresa el codigo que se quiere buscar

                            Curso objCurso = objGestion.buscarCursoPorCodigo(codigo); // codigo que identifica al curso y se guarda en objCurso

                            if(objCurso == null){ // si el curso no existe sale esto
                                System.out.println("El codigo ingresado no es valido");
                            }else {
                                objCurso.agregarEstudiante(objScan);
                            }

                            break;
                        case 2: // se deben listar los cursos, preguntar el id del curso y luego agregar
                            objGestion.listarTodosLosCursos(); // se llama el metodo que lista los cursos
                            System.out.println("ingresa el codigo del curso en el que desea listar los estudiantes");

                            codigo = objScan.next(); // se ingresa el codigo que se quiere buscar

                            objCurso = objGestion.buscarCursoPorCodigo(codigo); // codigo que identifica al curso y se guarda en objCurso

                            if(objCurso == null){ // si el curso no existe sale esto
                                System.out.println("El codigo ingresado no es valido");
                            }else {
                                objCurso.listarEstudiantes();
                            }

                            break;
                    }

                    }while(option3 != 4);

                    break;
                case 2:
                    int option2 =0; // se debe iniciar otro option para garantizar que no se salga del menu por presionar 5
                    do{
                        System.out.println("""
                                Menu de Cursos
                                1. Agregar curso
                                2. Listar cursos
                                3. Buscar por codigo
                                4. Salir
                                
                                Ingrese una opcion
                                """);

                        option2 = objScan.nextInt();
                        switch (option2){
                            case 1:
                                objGestion.agregarCurso(objScan); // este obj scan es el que se encuntra en la clase gestion curso
                                break;

                            case 2:
                                objGestion.listarTodosLosCursos();
                                break;

                            case 3:
                                System.out.println("Ingresa el codigo del curso a buscar");
                                String codigo = objScan.next(); // este es el codigo que usamos en eñ objeto Gestion curso

                                Curso objCurso = objGestion.buscarCursoPorCodigo(codigo);
                                if (objCurso == null){
                                    System.out.println("No existe ningun curso con ese codigo");
                                }else{
                                    System.out.println(objCurso.toString());
                                }

                        }


                    }while (option2 != 4);
                    break;
            }

        } while(option != 3);


    }
}