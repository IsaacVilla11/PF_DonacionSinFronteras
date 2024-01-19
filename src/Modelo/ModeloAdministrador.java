/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.sun.jdi.connect.spi.Connection;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

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

    public boolean modificarPersona(String fecha) {
        Date date = new Date();

        SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
        fecha = formatofecha.format(date);
        java.sql.Date fechasql = java.sql.Date.valueOf(fecha);
        try {
            String sqlPersona = "UPDATE persona SET nombre_usu=?, apellido_usu=?, fechaNacimiento_usu=?, sexo_usu=?, tipoSangre_usu=?, correo_usu=?, celular_usu=?, ciudad_usu=?,direccion_usu=?,contrasenia_usu=? WHERE id_persona_adm=?";
            PreparedStatement statementPersona = cone.getCon().prepareStatement(sqlPersona);

            statementPersona.setString(1, getNombre_usu());
            statementPersona.setString(2, getApellido_usu());
            statementPersona.setDate(3, fechasql); // Utilizar la fecha proporcionada como argumento
            statementPersona.setString(4, getSexo_usu());
            statementPersona.setString(5, getTipoSangre_usu());
            statementPersona.setString(6, getCorreo_usu());
            statementPersona.setString(7, getCelular_usu());
            statementPersona.setString(8, getCiudad_usu());
            statementPersona.setString(9, getDireccion_usu());
            statementPersona.setString(10, getContraseña_usu());
            statementPersona.setInt(11, getId_persona()); // Establecer el valor del parámetro faltante

            int rowsAffectedPersona = statementPersona.executeUpdate();
            statementPersona.close();

            return rowsAffectedPersona > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean modificarAdministrador() {
        try {
            String sqlAdmin = "UPDATE administrador SET cargo_adm=? WHERE id_persona_adm=?";
            PreparedStatement statementAdmin = cone.getCon().prepareStatement(sqlAdmin);
            statementAdmin.setString(1, getCargo_adm());
            statementAdmin.setInt(2, getId_persona());

            int rowsAffectedAdmin = statementAdmin.executeUpdate();
            statementAdmin.close();

            return rowsAffectedAdmin > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    //eliminar
 public void eliminar_administrador(String cedula) {
   
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
}
