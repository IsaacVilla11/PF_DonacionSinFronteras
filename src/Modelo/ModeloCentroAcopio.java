/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
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
public class ModeloCentroAcopio {
    
    ConexionPg cone = new ConexionPg();
    
    
    public  boolean insertarCentroAcopio(CentroAcopio centroacopio) {
       try (Connection conexion = new ConexionPg().getCon();
         Statement stmt = conexion.createStatement()) {
        // Obtener el próximo valor de la secuencia para id_lug
        ResultSet resultIdLug = stmt.executeQuery("SELECT nextval('lugar_id_lug_seq')");
        resultIdLug.next();
        int nextIdLug = resultIdLug.getInt(1);

        // Obtener el próximo valor de la secuencia para ruc_ca
        ResultSet resultRucCa = stmt.executeQuery("SELECT nextval('centroAcopio_ruc_ca_seq')");
        resultRucCa.next();
        int nextRucCa = resultRucCa.getInt(1);

        // Insertar centroAcopio con los próximos ID de las secuencias
        try (PreparedStatement pst = conexion.prepareStatement(
                "INSERT INTO centroAcopio (ruc_ca, capacidad_ca, id_lug, nombre_lug, direccion_lug, id_ciudad) VALUES (?, ?, ?, ?, ?, ?)")) {
            pst.setInt(1, nextRucCa);
            pst.setInt(2, centroacopio.getCapacidad_ca());
            pst.setInt(3, nextIdLug);
            pst.setString(4, centroacopio.getNombre_lug());
            pst.setString(5, centroacopio.getDireccion_lug());
            pst.setInt(6, centroacopio.getId_ciudad());

            int filasInsertadas = pst.executeUpdate();

            return filasInsertadas > 0;
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        return false;
    }}
    
    public boolean eliminarCA(int id_lugar) {
    ConexionPg cpg = new ConexionPg();
    String sqlCheckTable = "SELECT EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'registroTransporte')";
    String sqlCheckRelations = "SELECT 1 FROM registroTransporte WHERE id_lug = ?";
    String sqlDeleteCentroAcopio = "DELETE FROM centroacopio WHERE id_lug = ?";

    try {
        // Verificar si existe la tabla "lugar"
        PreparedStatement pstmtCheckTable = cpg.getCon().prepareStatement(sqlCheckTable);
        ResultSet rsTable = pstmtCheckTable.executeQuery();
        rsTable.next();
        boolean tableExists = rsTable.getBoolean(1);

        if (!tableExists) {
            // Si no existe la tabla "lugar", proceder con la eliminación de la ciudad
            PreparedStatement pstmtDeleteCA = cpg.getCon().prepareStatement(sqlDeleteCentroAcopio);
            pstmtDeleteCA.setInt(1, id_lugar);
            System.out.println("Se eliminó el centroAcopio (la tabla 'registroTransporte' no existe).");
            return pstmtDeleteCA.executeUpdate() > 0;
        }

        // Verificar relaciones en la tabla "lugar"
        PreparedStatement pstmtCheckRelations = cpg.getCon().prepareStatement(sqlCheckRelations);
        pstmtCheckRelations.setInt(1, id_lugar);
        ResultSet rs = pstmtCheckRelations.executeQuery();

        // Si hay relaciones en la tabla "lugar", no eliminar la ciudad
        if (rs.next()) {
            System.out.println("No se puede eliminar la tabla porque tiene relaciones con la tabla 'lugar'.");
            return false;
        }

        // Si no hay relaciones, proceder con la eliminación de la ciudad
        PreparedStatement pstmtDeleteCa = cpg.getCon().prepareStatement(sqlDeleteCentroAcopio);
        pstmtDeleteCa.setInt(1, id_lugar);
        System.out.println("Se eliminó el Centro Acopio.");
        return pstmtDeleteCa.executeUpdate() > 0;
    } catch (SQLException ex) {
        ex.printStackTrace();
        return false;
    } finally {
        cpg.getCon();
    }
}
    public  boolean modificarCentroAcopio( int nuevaCapacidad, int id_lugar,String nuevoNombre,String nuevaDire,int nuevaCiuad ) {
    ConexionPg cpg = new ConexionPg();
    String sql = "UPDATE centroacopio SET capacidad_ca = ?, nombre_lug = ?, direccion_lug = ?, id_ciudad = ? WHERE id_lug = ?";

    try {
        PreparedStatement pstmt = cpg.getCon().prepareStatement(sql);
        pstmt.setInt(1, nuevaCapacidad);
        pstmt.setString(2, nuevoNombre);
        pstmt.setString(3, nuevaDire);
        pstmt.setInt(4, nuevaCiuad);
        pstmt.setInt(5, id_lugar);


        return pstmt.executeUpdate() > 0;
    } catch (SQLException ex) {
        ex.printStackTrace();
        return false;
    } finally {
        cpg.cerrarConexion();
    }
}
    public  CentroAcopio obtenerDetallesCA(int id_lug) {
        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement("SELECT * FROM centroacopio WHERE id_lug = ?")) {

            pst.setInt(1, id_lug);  // Establecer el valor del parámetro

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    int ruc_ca = rs.getInt("ruc_ca");
                    int  capacidad= rs.getInt("capacidad_ca");
                    int  id_luga= rs.getInt("id_lug");
                    String nombreCa = rs.getString("nombre_lug");
                    String dir =rs.getString("direccion_lug");
                    int id_ciudad =rs.getInt("id_ciudad");

                    return new CentroAcopio(ruc_ca,capacidad,id_luga,nombreCa,dir,id_ciudad);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    
    public List<String> obtenerCiudades() {//metodo para mostrarr las ciudades en el combobox
        List<String> ciudadesFormato = new ArrayList<>();

        try (Connection connection = new ConexionPg().getCon()) {
            String sql = "SELECT id_ciudad, nombre_ciud FROM ciudad";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    int idCiudad = resultSet.getInt("id_ciudad");
                    String nombreCiudad = resultSet.getString("nombre_ciud");

                    String ciudadFormato = idCiudad + ":" + nombreCiudad;
                    ciudadesFormato.add(ciudadFormato);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Manejar la excepción según tus necesidades
        }

        return ciudadesFormato;
    }
    
    public  List<CentroAcopio> consultarCA() {//metodo para cargar todos los registros en el table
        List<CentroAcopio> listaCA = new ArrayList<>();

        try( 
            Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement("SELECT * FROM centroacopio");
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int ruc = rs.getInt("ruc_ca");
                int capacidad = rs.getInt("capacidad_ca");
                int id_lug = rs.getInt("id_lug");
                String nombre_lug =rs.getString("nombre_lug");
                String direccion =rs.getString("direccion_lug");
                int id_ciudad = rs.getInt("id_ciudad");
                              
                CentroAcopio c = new CentroAcopio(ruc,capacidad,id_lug,nombre_lug,direccion,id_ciudad);
                listaCA.add(c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaCA;
    }   
    public String obtenerNombreCiudad(int idCiudad) {//metodo para cargar el nombre de ciudad en el jtable
    String nombreCiudad = "";

    try (Connection connection = new ConexionPg().getCon()) {
        String sql = "SELECT nombre_ciud FROM ciudad WHERE id_ciudad = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, idCiudad);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    nombreCiudad = resultSet.getString("nombre_ciud");
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();  // Manejar la excepción según tus necesidades
    }

    return nombreCiudad;
}
    
    
}
