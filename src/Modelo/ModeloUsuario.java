/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author USER
 */
public class ModeloUsuario extends Usuario {

    ConexionPg cone = new ConexionPg(); ////Conectamos a la base

    public ModeloUsuario() {
    }

    public boolean InsertarPersona(String fecha) {
        Date date = new Date();

        SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
        fecha = formatofecha.format(date);
        java.sql.Date fechasql = java.sql.Date.valueOf(fecha);
        String sql = "INSERT INTO persona (cedula_usu, nombre_usu, apellido_usu, fechaNacimiento_usu, sexo_usu, tipoSangre_usu, correo_usu, celular_usu, ciudad_usu, direccion_usu,contrasenia_usu)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
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
    
    public boolean modificarPersona(String fecha) {
        Date date = new Date();

        SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
        fecha = formatofecha.format(date);
        java.sql.Date fechasql = java.sql.Date.valueOf(fecha);
        try {
            String sqlPersona = "UPDATE persona SET nombre_usu=?, apellido_usu=?, fechaNacimiento_usu=?, sexo_usu=?, tipoSangre_usu=?, correo_usu=?, celular_usu=?, ciudad_usu=?,direccion_usu=?,contrasenia_usu=? WHERE cedula_usu=?";
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
            statementPersona.setString(11, getCedula_usu()); // Establecer el valor del parámetro faltante

            int rowsAffectedPersona = statementPersona.executeUpdate();
            statementPersona.close();

            return rowsAffectedPersona > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    // verificar que no se repita uuna llave primaria 
    public boolean verificarDuplicidadCedula(String cedulaAdmi) {
        String sql = "SELECT COUNT(*) AS count FROM persona WHERE cedula_usu = ?";
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
// metodo para sacar el id incremental para relacionar las tablas
    public int traerCodigoDePersonaCrear(String cedula) {
        int codigo = 0;
        try {
            String sql = "SELECT id_persona FROM persona WHERE cedula_usu = ?";

            PreparedStatement pstmt = cone.getCon().prepareStatement(sql);
            pstmt.setString(1, cedula);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                codigo = rs.getInt("id_persona");
            }

            pstmt.close();
            rs.close();
        } catch (SQLException ex) {
            // Manejo de la excepción
            ex.printStackTrace(); // Imprimir la traza de la excepción para depuración
        }
        return codigo;
    }

}
