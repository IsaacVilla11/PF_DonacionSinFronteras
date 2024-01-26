/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Modelo.Ciudad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Modelo.ConexionPg;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author jose
 */
public class ModeloCiudad extends Ciudad {

        ConexionPg cone = new ConexionPg(); ////Conectamos a la base

    public boolean InsertarCiudad(Ciudad ciudad) {
    try (Connection conexion = new ConexionPg().getCon();
         Statement stmt = conexion.createStatement()) {
        // Obtener el próximo valor de la secuencia
        ResultSet result = stmt.executeQuery("SELECT nextval('ciudad_id_ciudad_seq')");
        result.next();
        int nextId = result.getInt(1);

        // Insertar la ciudad con el próximo ID de la secuencia
        try (PreparedStatement pst = conexion.prepareStatement(
                "INSERT INTO ciudad (id_ciudad, nombre_ciud) VALUES (?, ?)")) {
            pst.setInt(1, nextId);
            pst.setString(2, ciudad.getNombre_ciud());
            int filasInsertadas = pst.executeUpdate();

            return filasInsertadas > 0;
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        return false;
    }
}
    
    public  List<Ciudad> consultarCiudad() {
        List<Ciudad> listaCiudades = new ArrayList<>();

        try( 
            Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement("SELECT * FROM ciudad");
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int id_ciudad = rs.getInt("id_ciudad");
                String nombre_c = rs.getString("nombre_ciud");

                

                Ciudad c = new Ciudad(id_ciudad,nombre_c);
                listaCiudades.add(c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaCiudades;
    }
    
    public boolean eliminarCiudad(int id_ciudad) {
    ConexionPg cpg = new ConexionPg();
    String sqlCheckTable = "SELECT EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'lugar')";
    String sqlCheckRelations = "SELECT 1 FROM lugar WHERE id_ciudad = ?";
    String sqlDeleteCiudad = "DELETE FROM ciudad WHERE id_ciudad = ?";

    try {
        // Verificar si existe la tabla "lugar"
        PreparedStatement pstmtCheckTable = cpg.getCon().prepareStatement(sqlCheckTable);
        ResultSet rsTable = pstmtCheckTable.executeQuery();
        rsTable.next();
        boolean tableExists = rsTable.getBoolean(1);

        if (!tableExists) {
            // Si no existe la tabla "lugar", proceder con la eliminación de la ciudad
            PreparedStatement pstmtDeleteCiudad = cpg.getCon().prepareStatement(sqlDeleteCiudad);
            pstmtDeleteCiudad.setInt(1, id_ciudad);
            System.out.println("Se eliminó la ciudad (la tabla 'lugar' no existe).");
            return pstmtDeleteCiudad.executeUpdate() > 0;
        }

        // Verificar relaciones en la tabla "lugar"
        PreparedStatement pstmtCheckRelations = cpg.getCon().prepareStatement(sqlCheckRelations);
        pstmtCheckRelations.setInt(1, id_ciudad);
        ResultSet rs = pstmtCheckRelations.executeQuery();

        // Si hay relaciones en la tabla "lugar", no eliminar la ciudad
        if (rs.next()) {
            System.out.println("No se puede eliminar la ciudad porque tiene relaciones con la tabla 'lugar'.");
            return false;
        }

        // Si no hay relaciones, proceder con la eliminación de la ciudad
        PreparedStatement pstmtDeleteCiudad = cpg.getCon().prepareStatement(sqlDeleteCiudad);
        pstmtDeleteCiudad.setInt(1, id_ciudad);
        System.out.println("Se eliminó la ciudad.");
        return pstmtDeleteCiudad.executeUpdate() > 0;
    } catch (SQLException ex) {
        ex.printStackTrace();
        return false;
    } finally {
        cpg.cerrarConexion();
    }
}

    public  boolean modificarCiudad(int id_ciudad, String nuevoNombre) {
    ConexionPg cpg = new ConexionPg();
    String sql = "UPDATE ciudad SET nombre_ciud = ? WHERE id_ciudad = ?";

    try {
        PreparedStatement pstmt = cpg.getCon().prepareStatement(sql);
        pstmt.setString(1, nuevoNombre);
        pstmt.setInt(2, id_ciudad);


        return pstmt.executeUpdate() > 0;
    } catch (SQLException ex) {
        ex.printStackTrace();
        return false;
    } finally {
        cpg.cerrarConexion();
    }
}
    
    public  Ciudad obtenerDetallesCiudad(int id_ciudad) {
        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement("SELECT * FROM ciudad WHERE id_ciudad = ?")) {

            pst.setInt(1, id_ciudad);  // Establecer el valor del parámetro

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    int id_ciud = rs.getInt("id_ciudad");
                    String nombrC= rs.getString("nombre_ciud");


                    return new Ciudad(id_ciud,nombrC);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    
}
