package controller;

import entity.Avion;
import model.AvionModel;

import javax.swing.*;

public class AvionController {

    public static void getAll(){
        // definimos el tipo de objeto que vamos a mostrar
        AvionModel objAvionModel = new AvionModel();

        String listAviones = "lista de aviones\n";

        for (Object i : objAvionModel.findAll()){
            Avion objAvion = (Avion) i;

            listAviones += objAvion.toString()+"\n";
        }
        JOptionPane.showMessageDialog(null,listAviones);
    }

    public static void create(){
        AvionModel objAvionModel = new AvionModel();

        int capacidad = Integer.parseInt( JOptionPane.showInputDialog(null,"Inserta la capacidad del avion"));
        String modelo = JOptionPane.showInputDialog(null,"ingrese el modelo del avion");

        Avion objAvion = new Avion();

        objAvion.setCapacidad(capacidad);
        objAvion.setModelo(modelo);

        objAvion = (Avion) objAvionModel.insert(objAvion);

        JOptionPane.showMessageDialog(null,objAvion.toString());
    }

    public static void delete(){
        AvionModel objAvionModel = new AvionModel();

        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(null,"ingresa el ID del avion a borrar"));

        Avion objAvion = (Avion) objAvionModel.buscar_por_id(idDelete);

        int eliminados = 1;
        if (objAvion == null){
            JOptionPane.showMessageDialog(null,"no se borro ningun elemento");
        }else {
            eliminados = JOptionPane.showConfirmDialog(null,"Estas seguro que quieres eliminar este avion?\n" + objAvion.toString());
            if (eliminados == 0){
                objAvionModel.delete(objAvion);
            }
        }

    }

    public static void update(){
    AvionModel objModel = new AvionModel();

    int id = Integer.parseInt(JOptionPane.showInputDialog(null,"ingrese el id a borrar"));

    Avion objAvion = (Avion) objModel.buscar_por_id(id);

    if(objAvion == null){
        JOptionPane.showMessageDialog(null,"no se encontraron resultados");
    }else {
        String modelo = JOptionPane.showInputDialog(null,"ingrese el nuevo modelo del avion",objAvion.getModelo());
        int capacidad = Integer.parseInt(JOptionPane.showInputDialog(null,"ingrese la nueva capacidad del avion",objAvion.getCapacidad()));
        objAvion.setModelo(modelo);
        objAvion.setCapacidad(capacidad);

        objModel.update(objAvion);

    }


    }

    public void MenuAvion(){

        String aOption="";
        AvionModel objmodel = new AvionModel();
        do {
            aOption=JOptionPane.showInputDialog(null, """
                                Seleccione una opcion:
                                
                                1). Listar los aviones.
                                2). Crear nuevo avion.
                                3). Actualizar datos de un avion.
                                4). Borrar un avion.
                                5). Salir del menu del avion
    
                                
                               :
                                """);
            switch (aOption){
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
                    JOptionPane.showMessageDialog(null,"has salido del menu");
                    break;

            }
        }while (aOption != "5");
    }
}