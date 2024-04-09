import controller.AvionController;
import model.AvionModel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Paso 1: Crear las tablas en la base de datos
        // Nombre de la base: Librería.

        // Paso 2: Implementar Operaciones CRUD para Autores.
        AvionController objControllerAutor = new AvionController();
        String option = "";
        do {
            option = JOptionPane.showInputDialog(null, """
                    Seleccione la tabla de su preferencia:
                    1). Menu de Avion.
                    2). Table of books.
                    3). Exit of the select
                    Enter the table to select:
                    """);
            switch (option) {
                case "1":
                    objControllerAutor.MenuAvion();
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null,"Saliendo del menu...");
                    JOptionPane.showMessageDialog(null, """
                            Menu Closed.
                            Good Bye...
                            """);
                    break;
            }
        }while (!option.equals("3"));

    }


}

