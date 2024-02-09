/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

//import com.sun.jdi.connect.spi.Connection;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
        
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





/**
 *
 * @author USER
 */
public class ModeloAdministrador extends Administrador {

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

    public boolean InsertarAdministrador() {

        String sql = "INSERT INTO administrador (cargo_adm, id_persona_adm)"
                + " VALUES ( ?, ?)";
        try {
            PreparedStatement statement = cone.getCon().prepareStatement(sql);
            statement.setString(1, getCargo_adm());
            statement.setInt(2, getId_persona());

            int rowsAffected = statement.executeUpdate();
            statement.close();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

     public boolean actualizarAdministrador(ModeloAdministrador nuevoAdmin) {
        String sqlActualizarPersona = "UPDATE persona SET nombre_usu=?, apellido_usu=?, fechaNacimiento_usu=?, sexo_usu=?, tipoSangre_usu=?, correo_usu=?, celular_usu=?, ciudad_usu=?, direccion_usu=?, contrasenia_usu=? WHERE cedula_usu=?";
        String sqlActualizarAdmin = "UPDATE administrador SET cargo_adm=? WHERE id_persona_adm=(SELECT id_persona FROM persona WHERE cedula_usu=?)";

        try {
            // Convertir la fecha de nacimiento a java.sql.Date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaNacimiento = sdf.parse(nuevoAdmin.getFechaNacimiento_usu());
            java.sql.Date fechaNacimientoSQL = new java.sql.Date(fechaNacimiento.getTime());

            // Actualizar en la tabla persona
            PreparedStatement statementPersona = cone.getCon().prepareStatement(sqlActualizarPersona);
            statementPersona.setString(1, nuevoAdmin.getNombre_usu());
            statementPersona.setString(2, nuevoAdmin.getApellido_usu());
            statementPersona.setDate(3, fechaNacimientoSQL);
            statementPersona.setString(4, nuevoAdmin.getSexo_usu());
            statementPersona.setString(5, nuevoAdmin.getTipoSangre_usu());
            statementPersona.setString(6, nuevoAdmin.getCorreo_usu());
            statementPersona.setString(7, nuevoAdmin.getCelular_usu());
            statementPersona.setString(8, nuevoAdmin.getCiudad_usu());
            statementPersona.setString(9, nuevoAdmin.getDireccion_usu());
            statementPersona.setString(10, nuevoAdmin.getContraseña_usu());
            statementPersona.setString(11, nuevoAdmin.getCedula_usu());

            int rowsAffectedPersona = statementPersona.executeUpdate();
            statementPersona.close();

            // Actualizar en la tabla admin
            PreparedStatement statementAdmin = cone.getCon().prepareStatement(sqlActualizarAdmin);
            statementAdmin.setString(1, nuevoAdmin.getCargo_adm());
            statementAdmin.setString(2, nuevoAdmin.getCedula_usu());

            int rowsAffectedAdmin = statementAdmin.executeUpdate();
            statementAdmin.close();

            // Retornar true si se ha actualizado al menos una fila en ambas tablas
            return rowsAffectedPersona > 0 && rowsAffectedAdmin > 0;
        } catch (ParseException | SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    //eliminar
    public void eliminar_administrador(String cedula) throws SQLException {
        //  String sql = "DELETE FROM persona WHERE cedula_usu = ?";
        Connection conexion = null;
        PreparedStatement statement = null;

        try {

            // Buscar el ID de la persona basado en la cédula
            int idPersona = obtenerIdPersonaPorCedula(cedula);

            // Eliminar al administrador basado en el ID de la persona
            String deleteAdminSql = "DELETE FROM administrador WHERE id_persona_adm = ?";
            PreparedStatement statementAdmin = cone.getCon().prepareStatement(deleteAdminSql);
            statementAdmin.setInt(1, idPersona);
            statementAdmin.executeUpdate();

            // Luego de eliminar al administrador, se puede eliminar la persona
            String deletePersonaSql = "DELETE FROM persona WHERE id_persona = ?";
            PreparedStatement statementPersona = cone.getCon().prepareStatement(deletePersonaSql);
            statementPersona.setInt(1, idPersona);
            statementPersona.executeUpdate();

            System.out.println("El administrador y la persona asociada fueron eliminados exitosamente");
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (cone != null) {

            }
        }
    }
/// metodo para obtener el id de la persona Mediante la cedula
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

    public List<Administrador> ListaAdministrador() {
        ConexionPg cone = new ConexionPg();//Conectamos a la base
        String sqls = "SELECT * FROM persona per JOIN administrador admi ON per.id_persona  = admi.id_persona_adm";
        ResultSet rs = cone.consultaDB(sqls);
        List<Administrador> admin = new ArrayList<>();
        try {
            while (rs.next()) {
                Administrador mi_admin = new Administrador();

                mi_admin.setCargo_adm(rs.getString("cargo_adm"));
                mi_admin.setContraseña_usu(rs.getString("contrasenia_usu"));
                mi_admin.setCedula_usu(rs.getString("cedula_usu"));

                mi_admin.setNombre_usu(rs.getString("nombre_usu"));
                mi_admin.setApellido_usu(rs.getString("apellido_usu"));
                mi_admin.setCorreo_usu(rs.getString("correo_usu"));
                mi_admin.setSexo_usu(rs.getString("sexo_usu"));

                mi_admin.setFechaNacimiento_usu(rs.getString("fechaNacimiento_usu"));

                mi_admin.setDireccion_usu(rs.getString("direccion_usu"));
                mi_admin.setCiudad_usu(rs.getString("ciudad_usu"));
                mi_admin.setCelular_usu(rs.getString("celular_usu"));
                mi_admin.setTipoSangre_usu(rs.getString("tipoSangre_usu"));

                admin.add(mi_admin);
            }
            rs.close();
            System.out.println("Tamaño" + admin.size());
            return admin;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ModeloAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            return null;
        }
    }

    public Administrador buscarAdministrador(String cedula) throws SQLException {

        String sqlPersona = "SELECT * FROM persona WHERE cedula_usu = ?";
        String sqlAdministrador = "SELECT cargo_adm FROM administrador WHERE id_persona_adm = ?";

        PreparedStatement statementPersona = null;
        PreparedStatement statementAdministrador = null;
        ResultSet rsPersona = null;
        ResultSet rsAdministrador = null;
        ConexionPg conexion = new ConexionPg();

        try {
            statementPersona = conexion.getCon().prepareStatement(sqlPersona);
            statementPersona.setString(1, cedula);
            rsPersona = statementPersona.executeQuery();

            if (rsPersona.next()) {
                Administrador mi_admin = new Administrador();

                mi_admin.setCedula_usu(rsPersona.getString("cedula_usu"));
                mi_admin.setNombre_usu(rsPersona.getString("nombre_usu"));
                mi_admin.setApellido_usu(rsPersona.getString("apellido_usu"));
                mi_admin.setCorreo_usu(rsPersona.getString("correo_usu"));
                mi_admin.setSexo_usu(rsPersona.getString("sexo_usu"));
                mi_admin.setFechaNacimiento_usu(rsPersona.getString("fechaNacimiento_usu"));
                mi_admin.setDireccion_usu(rsPersona.getString("direccion_usu"));
                mi_admin.setCiudad_usu(rsPersona.getString("ciudad_usu"));
                mi_admin.setCelular_usu(rsPersona.getString("celular_usu"));
                mi_admin.setTipoSangre_usu(rsPersona.getString("tipoSangre_usu"));
                mi_admin.setContraseña_usu(rsPersona.getString("contrasenia_usu"));

                // Consulta para obtener el cargo del administrador
                statementAdministrador = conexion.getCon().prepareStatement(sqlAdministrador);
                statementAdministrador.setInt(1, rsPersona.getInt("id_persona"));
                rsAdministrador = statementAdministrador.executeQuery();
                if (rsAdministrador.next()) {
                    mi_admin.setCargo_adm(rsAdministrador.getString("cargo_adm"));
                }

                return mi_admin;
            } else {
                return null; // Retornar null si no se encuentra el administrador con la cédula
            }
        } finally {
            if (rsPersona != null) {
                rsPersona.close();
            }
            if (rsAdministrador != null) {
                rsAdministrador.close();
            }
            if (statementPersona != null) {
                statementPersona.close();
            }
            if (statementAdministrador != null) {
                statementAdministrador.close();
            }
            if (conexion.getCon() != null) {
                conexion.getCon().close();
            }
        }
    }

     // Método para consultar si las credenciales de un admin son correctas en el registro admini
    public boolean ConsultarAdministrador(String usuario, String contrasenia, List<Administrador> administradores) {
        for (Administrador admin : administradores) {
            if (admin.getCedula_usu().equals(usuario) && admin.getContraseña_usu().equals(contrasenia)) {
                return true;
            }
        }
        return false;
    }
    // verificar que no se repita uuna llave primaria 
    public boolean verificarDuplicidadCedula(String cedulaAdmi) {
        String sql = "SELECT COUNT(*) AS count FROM administrador WHERE cedula_usu = ?";
        try {
            PreparedStatement statement = cone.getCon().prepareStatement(sql);
            statement.setString(1, cedulaAdmi);
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
public List<Administrador> obtenerNombresApellidosDonantes(int id_administrador) {
        List<Administrador> donantes = new ArrayList<>();

        try {
            Connection conexion = new ConexionPg().getCon(); // Corregir llamada al método getCon()
            PreparedStatement pst = conexion.prepareStatement(
                     "SELECT a.id_adm, p.nombre_usu, p.apellido_usu " +
                             "FROM administrador a " +
                             "INNER JOIN persona p ON a.id_persona_adm = p.id_persona " +
                             "WHERE a.id_adm = ?");

            pst.setInt(1, id_administrador);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_adm");
                String nombre = rs.getString("nombre_usu");
                String apellido = rs.getString("apellido_usu");

                Administrador administrador = new Administrador
        (id, null,0,0,null,nombre, apellido,null, null, null, null, null, null, null, null);
                donantes.add(administrador);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return donantes;
    }
}


//Administrador donante = new Administrador
//        (id, null,0,0,null,nombre, apellido,null, null, null, null, null, null, null, null);