import controller.AutorController;
import controller.LibroController;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        AutorController objControllerAutor = new AutorController();
        LibroController objControllerLibro = new LibroController();
        String option = "";

        do {
            option = JOptionPane.showInputDialog(null,"""
                    Selecciona los datos que deseas ver
                    1. Tabla de autores
                    2. Tabla de libros
                    3. Cerrar programa
                    Enter the table to select:
                    """);

            switch (option){
                case "1":
                    objControllerAutor.TableAuthor();
                    break;

                case "2":
                    objControllerLibro.TableBook();
                    break;

                case "3":
                    JOptionPane.showMessageDialog(null,"Saliendo del menu principal");
                    JOptionPane.showMessageDialog(null, " Menu Cerrado");
                    break;

            }

        } while (!option.equals("3"));


    }
}