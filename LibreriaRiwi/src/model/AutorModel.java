package model;

import database.CRUD;
import database.ConfigDb;
import entity.Autor;
import entity.Libro;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutorModel implements CRUD {
    @Override
    public Object insert(Object obj) {

        //Abrimos la conexión
        Connection objConnection = ConfigDb.openConnection();
        //Convertir el objeto que llega a autor
        Autor objAutor = (Autor) obj;

        try{
            // query
            String sql = "INSERT INTO autores (nombre,nacionalidad) VALUE (?,?);";

            // preparamos el statement
            PreparedStatement objPrepare =objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1,objAutor.getNombre());
            objPrepare.setString(2,objAutor.getNacionalidad());

            //Ejecutamos el Query
            objPrepare.execute();

            //Recibimos el resultado con las llaves generadas
            ResultSet objResult = objPrepare.getGeneratedKeys();

            // recorremos los autores
            while (objResult.next()){
                objAutor.setId(objResult.getInt(1));
            }

            JOptionPane.showMessageDialog(null,"Autor insertion was successful");

        } catch (SQLException error){
            JOptionPane.showMessageDialog(null,"ERROR" + error.getMessage());
        }
        ConfigDb.closeConnection();
        return objAutor;
    }

    @Override
    public List<Object> findAll() {
        List<Object> listAutores = new ArrayList<>();

        Connection objConnection = ConfigDb.openConnection();

        try{
            String sql = "SELECT * FROM autores;";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()){
                Autor objAutor = new Autor();

                objAutor.setId(objResult.getInt("id"));
                objAutor.setNombre(objResult.getString("nombre"));
                objAutor.setNacionalidad(objResult.getString("nacionalidad"));

                listAutores.add(objAutor);
            }

        } catch (SQLException error){
            JOptionPane.showMessageDialog(null,"ERROR" + error.getMessage());
        }
        ConfigDb.closeConnection();
        return listAutores;
    }

    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDb.openConnection();

        Autor objAutor = (Autor) obj;
        boolean isUpdate = false;
        try {
            String sql = "UPDATE autores SET nombre = ?, nacionalidad = ? WHERE id = ?;";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1,objAutor.getNombre());
            objPrepare.setString(2,objAutor.getNacionalidad());
            objPrepare.setInt(3,objAutor.getId());

            int totalRowAffected = objPrepare.executeUpdate();

            if (totalRowAffected>0){
                isUpdate = true;
                JOptionPane.showMessageDialog(null,"The update was successful");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        } finally {
            ConfigDb.closeConnection();
        }
        return isUpdate;
    }

    @Override
    public boolean delete(Object obj) {

        Connection objConnection = ConfigDb.openConnection();

        Autor objAutor = (Autor) obj;

        boolean isDeleted = false;

        try {
            String sql = "SELECT FROM autores WHERE id = ?";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1,objAutor.getId());

            int totalAffectedRow = objPrepare.executeUpdate();

            if (totalAffectedRow>0){
                isDeleted = true;
                JOptionPane.showMessageDialog(null,"El autor "+objAutor.toString()+" Fue borrado");
            }
        } catch (SQLException error){
            JOptionPane.showMessageDialog(null, "ERROR" + error.getMessage());
        } finally {
            ConfigDb.closeConnection();
        }
        return isDeleted;
    }

    public Autor SearchById(int id){
        //1. Abrimos la conexión
        Connection objConnection = ConfigDb.openConnection();
        //2. Crear el coder que vamos a retornar
        Autor objAutor = null;

        try {
            //3. Sentencia SQL
            String sql = "SELECT * FROM autores WHERE id = ?;";

            //4. Preparamos el statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            //5. Darle valor al parametro de query
            objPrepare.setInt(1,id);

            //6. Ejecutamos el Query
            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {
                objAutor = new Autor();
                objAutor.setId(objResult.getInt("id"));
                objAutor.setNombre(objResult.getString("nombre"));
                objAutor.setNacionalidad(objResult.getString("nacionalidad"));
            }
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null,"ERROE" + error.getMessage());
        }
        //7. Cerrar la conexión
        ConfigDb.closeConnection();
        return objAutor;
    }

    public List<Libro> SearchAdvance(String name){
        Connection objLibreria = ConfigDb.openConnection();
        List<Libro> listResul = new ArrayList<>();
        try {
            String sql ="SELECT libros.titulo, libros.anio_public, libros.precio, autor.nombre FROM libros INNER JOIN autor\n" +
                    " WHERE autor.nombre LIKE ? AND libros.id_autor = autor.id;";
            PreparedStatement objPrepared = objLibreria.prepareStatement(sql);

            objPrepared.setString(1,"%"+name+"%");
            ResultSet objResul = objPrepared.executeQuery();
            while (objResul.next()) {
                Libro ObjLibro = new Libro();

                ObjLibro.setTitulo(objResul.getNString("titulo"));
                ObjLibro.setAnio_public(objResul.getNString("anio_public"));
                ObjLibro.setPrecio(objResul.getDouble("precio"));
                ObjLibro.setAutor(objResul.getNString("nombre"));
                listResul.add(ObjLibro);

            }
        }catch (Exception error){
            JOptionPane.showMessageDialog(null,"ERROR: "+error.getMessage());
        }

        ConfigDb.closeConnection();
        return listResul;
    }
}
