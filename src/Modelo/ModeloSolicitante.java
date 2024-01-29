package Modelo;

import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ModeloSolicitante extends Solicitante{
    ConexionPg cone = new ConexionPg(); ////Conectamos a la base
    
    public boolean InsertarPersona(String fecha) {
        Date date = new Date();

        SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
        fecha = formatofecha.format(date);
        java.sql.Date fechasql = java.sql.Date.valueOf(fecha);
        String sql = "INSERT INTO persona (cedula_usu, nombre_usu, apellido_usu, fechaNacimiento_usu, sexo_usu, tipoSangre_usu, correo_usu, celular_usu, ciudad_usu, direccion_usu,contrasenia_usu)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = cone.getCon().prepareStatement(sql);

            statement.setString(1, getCedula_usu());
            statement.setString(2, getNombre_usu());
            statement.setString(3, getApellido_usu());
            statement.setDate(4, fechasql);
            statement.setString(5, getSexo_usu());
            statement.setString(6, getTipoSangre_usu());
            statement.setString(7, getCorreo_usu());
            statement.setString(8, getCelular_usu());
            statement.setString(9, getCiudad_usu());
            statement.setString(10, getDireccion_usu());
            statement.setString(11, getContraseña_usu());

            int rowsAffected = statement.executeUpdate();
            statement.close();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean InsertarSolicitante() {

        String sql = "INSERT INTO solicitante (id_persona_soli)"
                + " VALUES ( ?)";
        try {
            PreparedStatement statement = cone.getCon().prepareStatement(sql);
            statement.setInt(1, getId_persona());

            int rowsAffected = statement.executeUpdate();
            statement.close();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public List<Solicitante> ListaSolicitante() {
        ConexionPg cone = new ConexionPg();//Conectamos a la base
        String sqls = "SELECT * FROM persona per JOIN solicitante soli ON per.id_persona  = soli.id_persona_soli";
        ResultSet rs = cone.consultaDB(sqls);
        List<Solicitante> solic = new ArrayList<>();
        try {
            while (rs.next()) {
                Solicitante mi_solic = new Solicitante();
                
                mi_solic.setContraseña_usu(rs.getString("contrasenia_usu"));
                mi_solic.setCedula_usu(rs.getString("cedula_usu"));

                mi_solic.setNombre_usu(rs.getString("nombre_usu"));
                mi_solic.setApellido_usu(rs.getString("apellido_usu"));
                mi_solic.setCorreo_usu(rs.getString("correo_usu"));
                mi_solic.setSexo_usu(rs.getString("sexo_usu"));

                mi_solic.setFechaNacimiento_usu(rs.getString("fechaNacimiento_usu"));

                mi_solic.setDireccion_usu(rs.getString("direccion_usu"));
                mi_solic.setCiudad_usu(rs.getString("ciudad_usu"));
                mi_solic.setCelular_usu(rs.getString("celular_usu"));
                mi_solic.setTipoSangre_usu(rs.getString("tipoSangre_usu"));

                solic.add(mi_solic);
            }
            rs.close();
            System.out.println("Tamaño" + solic.size());
            return solic;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ModeloSolicitante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void eliminar_solicitante(String cedula) throws SQLException {
        //  String sql = "DELETE FROM persona WHERE cedula_usu = ?";
        Connection conexion = null;
        PreparedStatement statement = null;

        try {

            // Buscar el ID de la persona basado en la cédula
            int idPersona = obtenerIdPersonaPorCedula(cedula);

            // Eliminar al solicitante basado en el ID de la persona
            String deleteSoliSql = "DELETE FROM solicitante WHERE id_persona_soli = ?";
            PreparedStatement statementSoli = cone.getCon().prepareStatement(deleteSoliSql);
            statementSoli.setInt(1, idPersona);
            statementSoli.executeUpdate();

            // Luego de eliminar al administrador, se puede eliminar la persona
            String deletePersonaSql = "DELETE FROM persona WHERE id_persona = ?";
            PreparedStatement statementPersona = cone.getCon().prepareStatement(deletePersonaSql);
            statementPersona.setInt(1, idPersona);
            statementPersona.executeUpdate();

            System.out.println("El solicitante y la persona asociada fueron eliminados exitosamente");
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (cone != null) {

            }
        }
    }
    
    private int obtenerIdPersonaPorCedula(String cedula) throws SQLException {
        int idPersona = -1;
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            String selectSql = "SELECT id_persona FROM persona WHERE cedula_usu = ?";
            statement = cone.getCon().prepareStatement(selectSql);
            statement.setString(1, cedula);
            rs = statement.executeQuery();

            if (rs.next()) {
                idPersona = rs.getInt("id_persona");
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (statement != null) {
                statement.close();
            }
        }

        return idPersona;
    }
    
    // verificar que no se repita uuna llave primaria 
    public boolean verificarDuplicidadCedula(String cedulaSoli) {
        String sql = "SELECT COUNT(*) AS count FROM solicitante WHERE cedula_usu = ?";
        try {
            PreparedStatement statement = cone.getCon().prepareStatement(sql);
            statement.setString(1, cedulaSoli);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("count");
                return count > 0; // Si count > 0, significa que ya existe un registro con ese código
            }
            rs.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public Solicitante buscarSolicitante(String cedula) throws SQLException {

        String sqlPersona = "SELECT * FROM persona WHERE cedula_usu = ?";

        PreparedStatement statementPersona = null;
        PreparedStatement statementSolicitante = null;
        ResultSet rsPersona = null;
        ResultSet rsSolicitante = null;
        ConexionPg conexion = new ConexionPg();

        try {
            statementPersona = conexion.getCon().prepareStatement(sqlPersona);
            statementPersona.setString(1, cedula);
            rsPersona = statementPersona.executeQuery();

            if (rsPersona.next()) {
                Solicitante mi_solic = new Solicitante();

                mi_solic.setCedula_usu(rsPersona.getString("cedula_usu"));
                mi_solic.setNombre_usu(rsPersona.getString("nombre_usu"));
                mi_solic.setApellido_usu(rsPersona.getString("apellido_usu"));
                mi_solic.setCorreo_usu(rsPersona.getString("correo_usu"));
                mi_solic.setSexo_usu(rsPersona.getString("sexo_usu"));
                mi_solic.setFechaNacimiento_usu(rsPersona.getString("fechaNacimiento_usu"));
                mi_solic.setDireccion_usu(rsPersona.getString("direccion_usu"));
                mi_solic.setCiudad_usu(rsPersona.getString("ciudad_usu"));
                mi_solic.setCelular_usu(rsPersona.getString("celular_usu"));
                mi_solic.setTipoSangre_usu(rsPersona.getString("tipoSangre_usu"));
                mi_solic.setContraseña_usu(rsPersona.getString("contrasenia_usu"));

                // Consulta para obtener el cargo del administrador
//                statementAdministrador = conexion.getCon().prepareStatement(sqlAdministrador);
//                statementAdministrador.setInt(1, rsPersona.getInt("id_persona"));
//                rsAdministrador = statementAdministrador.executeQuery();
//                if (rsAdministrador.next()) {
//                    mi_solic.setCargo_adm(rsAdministrador.getString("cargo_adm"));
//                }

                return mi_solic;
            } else {
                return null; // Retornar null si no se encuentra el solicitante con la cédula
            }
        } finally {
            if (rsPersona != null) {
                rsPersona.close();
            }
            if (rsSolicitante != null) {
                rsSolicitante.close();
            }
            if (statementPersona != null) {
                statementPersona.close();
            }
            if (statementSolicitante != null) {
                statementSolicitante.close();
            }
            if (conexion.getCon() != null) {
                conexion.getCon().close();
            }
        }
    }
    
    public boolean ConsultarSolicitante(String usuario, String contrasenia, List<Solicitante> solicitantes) {
        for (Solicitante solici : solicitantes) {
            if (solici.getCedula_usu().equals(usuario) && solici.getContraseña_usu().equals(contrasenia)) {
                return true;
            }
        }
        return false;
    }
}
