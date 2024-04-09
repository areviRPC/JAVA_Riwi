package database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBvuelos {
    // La conexion empieza nula
    public static Connection objConnection = null;

    // Metodo para abrir la conexion
    public static Connection openConnection(){
        try{
            //Llamanos al driver virtual
            Class.forName("com.mysql.cj.jdbc.Driver");
            //creamos el url de la conexion
            String url = "jdbc:mysql://bez8b5mmr8sw5dt6smzx-mysql.services.clever-cloud.com:3306/bosuoyimg2jrjrtmdfa5";
            String user = "uvnllpdxwfb2ycc4";
            String password = "3TKK9cUneqkwKBDkQK8j";
            //Establecemos conexion
            objConnection = (Connection) DriverManager.getConnection(url,user,password);
            System.out.println("Ingreso Exitoso");

        } catch (ClassNotFoundException error){ // Definimos los diferentes tipos de errores
            JOptionPane.showMessageDialog(null,"ERROR >> El driver no instalado"+error.getMessage());
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"ERROR >> No se conecto a la base de datos"+e.getMessage());
        }
        return objConnection;
    }

    // Metodo para cerrar la conexion
    public static void closeConnection(){
        try {
            if (objConnection != null){
                objConnection.close();
                System.out.println("Conexion finalizada con exito");
            } else {
                System.out.println("No hay conexiones existentes");
            }
        } catch (SQLException error){
            System.out.println("Error"+ error.getMessage());
        }
    }
}
