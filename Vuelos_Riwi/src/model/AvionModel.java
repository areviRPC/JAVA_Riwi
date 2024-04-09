package model;

import database.CRUD;
import database.DBvuelos;
import entity.Avion;
import entity.Vuelo;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AvionModel implements CRUD{
    @Override
    public Object insert(Object obj){
        // establecemos la conexion
        Connection objConnection = DBvuelos.openConnection();

        // definimos el tipo de objeto que retornara
        Avion objAvion = (Avion) obj;

        try{
            // definimos la sentencia SQL
            String sql = "INSERT INTO vuelo (modelo,capacidad) VALUES(?,?);";

            // preparamos el statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            // Asignamos valores a los ??
            objPrepare.setString(1, objAvion.getModelo());
            objPrepare.setInt(2, objAvion.getCapacidad());

            // ejecutamos la Query
            objPrepare.execute();

            ResultSet objRest = objPrepare.getGeneratedKeys();

            //

            while (objRest.next()){
                objAvion.setId_avion(objRest.getInt(1));
            }
            JOptionPane.showMessageDialog(null,"Avion ingresado exitosamente");


        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, "Error" + error.getMessage());
        }
        // cerramos conexion
        DBvuelos.closeConnection();
        // retornamos el vuelo original
        return objAvion;
    }

    @Override
    public List<Object> findAll(){
        // definimos el tipo de objeto a retornar
        List<Object> listAvion = new ArrayList<>();

        // abrimos conexion
        Connection objConnection = DBvuelos.openConnection();

        try{
            // declamaron la sentencia SQL
            String sql = "SELECT * FROM avion;";

            // preparamos como el statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();

            // Guardamos en el objeto definido inicialmente
            while (objResult.next()){
                // definimos que el objeto sera de tipo avion
                Avion objAvion = new Avion();

                // definimos los atributos que seran leidos
                objAvion.setId_avion(objResult.getInt("id"));
                objAvion.setModelo(objResult.getString("modelo"));
                objAvion.setCapacidad(objResult.getInt("capacidad"));

                // añadimos los atributos al objeto
                listAvion.add(objAvion);


            }
        }catch (SQLException error){
            JOptionPane.showMessageDialog(null,"Error" + error.getMessage());
        }
        // cerramos conexion
        DBvuelos.closeConnection();

        // retornamos la lista de aviones
        return listAvion;
    }

    @Override
    public boolean update (Object obj){
        // Abrimos conexion
        Connection objConnection = DBvuelos.openConnection();

        // Definimos el tipo de objeto que se borrara
        Avion objAvion = (Avion) obj;

        // iniciamos el resultado en falso
        boolean update = false;

        try {
            // definimos la sentencia SQL
            String sql = "UPDATE avion SET modelo = ? , capacidad = ? WHERE id_avion = ?;";

            // preparamos el statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            // asignamos valores a los ?
            objPrepare.setString(1,objAvion.getModelo());
            objPrepare.setInt(2,objAvion.getCapacidad());
            objPrepare.setInt(3,objAvion.getId_avion());

            // contamos las lineas afectadas
            int totalRowAffec = objPrepare.executeUpdate();
            if (totalRowAffec>0){
                update = true;
                JOptionPane.showMessageDialog(null,"actualizacion exitosa");
            }
            // cerramos conexion
            DBvuelos.closeConnection();
            // retornamos con exito la actualizacion
            return update;

        }catch (SQLException error){
            JOptionPane.showMessageDialog(null,"Error" + error.getMessage());
        }

        return true;
    }

    @Override
    public boolean delete (Object obj){
        // definimos el objeto a borrar de tipo Avion
        Avion objAvion = (Avion) obj;

        // abrimos conexion
        Connection objConnection = DBvuelos.openConnection();

        // Empezamos el metodo como falso;
        boolean delete = false;

        try {
            // definimos la sentencia SQL que borrara segun el ID que elijamos
            String sql = "DELETE FROM avion WHERE id_avion = ?;";

            // preáramos el statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            // asignamos valor al ? equivalente al id
            objPrepare.setInt(1,objAvion.getId_avion());

            // contamos las lineas afectadas, si es mas de 1
            int totalAffected = objPrepare.executeUpdate();

            if (totalAffected>0){
                delete = true;
                JOptionPane.showMessageDialog(null,"eliminacion exitosa");
            }

        }catch (SQLException error){
            JOptionPane.showMessageDialog(null,"Error" + error.getMessage());
        }
        // cerramos conexion
        DBvuelos.closeConnection();
        return delete;
    }

    @Override
    public Object buscar_por_id (int id){
        // abrimos conexion
        Connection objConnection = DBvuelos.openConnection();

        // definimos un objeto vacio donde ira el Avion a buscar
        Avion objAvion = null;

        try {
            // definimos la sentencia SQL para buscar por id
            String sql = "SELECT * FROM avion WHERE id_avion = ?;";

            // preparamos el statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()){
                // definimos un nuevo objeto con el resultado que encontramos
                objAvion = new Avion();

                objAvion.setId_avion(objResult.getInt("id"));
                objAvion.setModelo(objResult.getString("modelo"));
                objAvion.setCapacidad(objResult.getInt("capacidad"));

            }


        }catch (SQLException error){
            JOptionPane.showMessageDialog(null,"Error"+error.getMessage());
        }
        // cerramos conexion
        DBvuelos.closeConnection();
        // retornamos el objeto en donde guardamos los datos del avion
        return objAvion;
    }

}
