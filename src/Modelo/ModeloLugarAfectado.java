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
public class ModeloLugarAfectado {
    
    ConexionPg cone = new ConexionPg();
    
    public  boolean insertarLugarAF(LugarAfectado lugarafectado) {
       try (Connection conexion = new ConexionPg().getCon();
         Statement stmt = conexion.createStatement()) {
        // Obtener el próximo valor de la secuencia para id_lug
        ResultSet resultIdLug = stmt.executeQuery("SELECT nextval('lugar_id_lug_seq')");
        resultIdLug.next();
        int nextIdLug = resultIdLug.getInt(1);

        // Obtener el próximo valor de la secuencia para ruc_ca
        ResultSet resultid_lugarAF = stmt.executeQuery("SELECT nextval('lugarAfectado_id_lugaraf_seq')");
        resultid_lugarAF.next();
        int nextIDLA= resultid_lugarAF.getInt(1);

        // Insertar centroAcopio con los próximos ID de las secuencias
        try (PreparedStatement pst = conexion.prepareStatement(
                "INSERT INTO lugarafectado (id_lugaraf, situacion_luaf,estado_luaf, id_lug, nombre_lug, direccion_lug, id_ciudad) VALUES (?, ?, ?, ?, ?, ?,?)")) {
            pst.setInt(1, nextIDLA);
            pst.setString(2, lugarafectado.getSituacion_luaf());
            pst.setString(3, lugarafectado.getEstado_luaf());
            pst.setInt(4, nextIdLug);
            pst.setString(5, lugarafectado.getNombre_lug());
            pst.setString(6, lugarafectado.getDireccion_lug());
            pst.setInt(7, lugarafectado.getId_ciudad());

            int filasInsertadas = pst.executeUpdate();

            return filasInsertadas > 0;
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        return false;
    }
    }    
    
    public boolean eliminarLugarAf(int id_lugar) {
    ConexionPg cpg = new ConexionPg();
    String sqlCheckTable = "SELECT EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'registroTransporte')";
    String sqlCheckRelations = "SELECT 1 FROM registroTransporte WHERE id_lug = ?";
    String sqlDeleteLugarAf= "DELETE FROM lugarafectado WHERE id_lug = ?";

    try {
        // Verificar si existe la tabla "lugar"
        PreparedStatement pstmtCheckTable = cpg.getCon().prepareStatement(sqlCheckTable);
        ResultSet rsTable = pstmtCheckTable.executeQuery();
        rsTable.next();
        boolean tableExists = rsTable.getBoolean(1);

        if (!tableExists) {
            // Si no existe la tabla "lugar", proceder con la eliminación de la ciudad
            PreparedStatement pstmtDeleteCA = cpg.getCon().prepareStatement(sqlDeleteLugarAf);
            pstmtDeleteCA.setInt(1, id_lugar);
            System.out.println("Se eliminó el lugar afectado (la tabla 'registroTransporte' no existe).");
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
        PreparedStatement pstmtDeleteCa = cpg.getCon().prepareStatement(sqlDeleteLugarAf);
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
    public  boolean modificarLugarAF( String nuevoSituaicion,String nuevoEstado, int id_lugar,String nuevoNombre,String nuevaDire,int nuevaCiuad ) {
    ConexionPg cpg = new ConexionPg();
    String sql = "UPDATE lugarafectado SET situacion_luaf = ?,estado_luaf = ?, nombre_lug = ?, direccion_lug = ?, id_ciudad = ? WHERE id_lug = ?";

    try {
        PreparedStatement pstmt = cpg.getCon().prepareStatement(sql);
        pstmt.setString(1, nuevoSituaicion);
        pstmt.setString(2, nuevoEstado);
        pstmt.setString(3, nuevoNombre);
        pstmt.setString(4, nuevaDire);
        pstmt.setInt(5, nuevaCiuad);
        pstmt.setInt(6, id_lugar);


        return pstmt.executeUpdate() > 0;
    } catch (SQLException ex) {
        ex.printStackTrace();
        return false;
    } finally {
        cpg.cerrarConexion();
    }
}
    public  LugarAfectado obtenerDetallesLugarAf(int id_lug) {
        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement("SELECT * FROM lugarafectado WHERE id_lug = ?")) {

            pst.setInt(1, id_lug);  // Establecer el valor del parámetro

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    int id_lugAf = rs.getInt("id_lugaraf");
                    String  situacion= rs.getString("situacion_luaf");
                    String  estado= rs.getString("estado_luaf");
                    int id_luga=rs.getInt("id_lug");
                    String nombreCa = rs.getString("nombre_lug");
                    String dir =rs.getString("direccion_lug");
                    int id_ciudad =rs.getInt("id_ciudad");

                    return new LugarAfectado(id_lugAf,situacion,estado,id_luga,nombreCa,dir,id_ciudad);
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
    public  List<LugarAfectado> consultarLA() {//metodo para cargar todos los registros en el table
        List<LugarAfectado> listaCA = new ArrayList<>();

        try( 
            Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement("SELECT * FROM lugarafectado");
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int id_luaf = rs.getInt("id_lugaraf");
                String situacion =rs.getString("situacion_luaf");
                String estado = rs.getString("estado_luaf");
                int id_lug = rs.getInt("id_lug");
                String nombre_lug =rs.getString("nombre_lug");
                String direccion =rs.getString("direccion_lug");
                int id_ciudad = rs.getInt("id_ciudad");
                              
                LugarAfectado c = new LugarAfectado(id_luaf,situacion,estado,id_lug,nombre_lug,direccion,id_ciudad);
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
