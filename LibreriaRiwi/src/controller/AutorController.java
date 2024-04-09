package controller;

import entity.Autor;
import entity.Libro;
import model.AutorModel;

import javax.swing.*;
import java.security.PublicKey;

public class AutorController {

    public static void getAll(){
        AutorModel objAutorModel = new AutorModel();
        String listAuthors = "Lista de autores\n";
        for (Object iterator : objAutorModel.findAll()){
            Autor objAutor = (Autor) iterator;
            listAuthors += objAutor.toString()+"\n";
        }
        JOptionPane.showMessageDialog(null,listAuthors);
    }

    public  static String getAllString(){
        AutorModel objAutorModel = new AutorModel();
        String listAuthors = "Lista de autores\n";
        for (Object iterator : objAutorModel.findAll()){
            Autor objAutor = (Autor) iterator;
            listAuthors += objAutor.toString()+"\n";
        }
        return listAuthors;
    }

    public static void create(){
        AutorModel objAutorModel = new AutorModel();

        String nombre = JOptionPane.showInputDialog(null,"inserte el nombre");
        String nacionalidad = JOptionPane.showInputDialog(null,"Inserte la nacionalidad del autor");

        Autor objAutor = new Autor();

        objAutor.setNombre(nombre);
        objAutor.setNacionalidad(nacionalidad);

        objAutor = (Autor) objAutorModel.insert(objAutor);
        JOptionPane.showMessageDialog(null,objAutor.toString());
    }

    public static void delete() {
        String listAuthors = getAllString();
        AutorModel objAutorModel = new AutorModel();

        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(listAuthors+"\n escribra el id del autor para borrarlo"));

        Autor objAutor = objAutorModel.SearchById(idDelete);
        int confirm = 1;
        if (objAutor == null) {
            JOptionPane.showMessageDialog(null,"Autor no encontrado");
        } else {
            confirm = JOptionPane.showConfirmDialog(null,"Confirmas que quieres borrar este autor?");
            if (confirm == 0) {
                objAutorModel.delete(objAutor);
            }
        }
    }

    public static void update(){
        AutorModel objAutorModel = new AutorModel();

        String listAuthors = getAllString();

        int idUpdate = Integer.parseInt(JOptionPane.showInputDialog(listAuthors+"\n ingrese el id del autor a borrar"));
        Autor objAutor = objAutorModel.SearchById(idUpdate);

        if (objAutor == null) {
           JOptionPane.showMessageDialog(null,"Autor no encontrado");
        } else {
            String nombre = JOptionPane.showInputDialog(null,"ingrese el nuevo nombre",objAutor.getNombre());
            String nacionalidad = JOptionPane.showInputDialog(null,"Ingrese la nueva nacionalidad",objAutor.getNacionalidad());

            objAutor.setNombre(nombre);
            objAutor.setNacionalidad(nacionalidad);

            objAutorModel.update(objAutor);
        }
    }



    public void TableAuthor() {

        String aOption = "";
        AutorModel objmodel = new AutorModel();
        do {
            aOption = JOptionPane.showInputDialog(null, """
                    Seleccione una opcion:
                    1). Lista de autor.
                    2). Insertar nuevo autor.
                    3). Actualizar un autor.
                    4). Borrar un autor.
                    5). Buscar autor por ID.
                    6). Busqueda avanzada.
                    7). Volver al menu principal
                                                    
                    Por favor elija una opcion:
                    """);
            switch (aOption) {
                case "1":
                    getAll();
                    break;
                case "2":
                    create();
                    break;
                case "3":
                    update();
                    break;
                case "4":
                    delete();
                    break;
                case "5":

                    int id = Integer.parseInt(JOptionPane.showInputDialog(null, " Ingrese el id del autor a buscar"));
                    Autor objAutor = objmodel.SearchById(id);
                    JOptionPane.showMessageDialog(null, objAutor.toString());
                    break;
                case "6":
                    SearchAuthorAdvance();
                    break;
                case "7":
                    JOptionPane.showMessageDialog(null, "Volver al menu principal");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Option no valida..");
                    break;
            }

        } while (!aOption.equals("7"));
    }

    public static void SearchAuthorAdvance(){
            AutorModel objAuthorModel = new AutorModel();
            String name = JOptionPane.showInputDialog(null,"Inserte el nombre del autor a buscar:");
            String listAutores = "Resultado de la busqueda: \n ";
            for (Object i : objAuthorModel.SearchAdvance(name)){
                Libro objAutor = (Libro) i;
                listAutores += objAutor.toStringAdvance()+"\n";

            }
            JOptionPane.showMessageDialog(null,listAutores);

    }

}

























