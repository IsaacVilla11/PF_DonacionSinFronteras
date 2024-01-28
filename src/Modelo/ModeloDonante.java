/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ModeloDonante extends Donante{
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
    
    public boolean insertarDonante(){
        String sql = "INSERT INTO donante (motivo_dont, entidad_dont, proyecto_dont, id_persona_dont)"
                + " VALUES ( ?, ?, ?, ?)";
        try {
            PreparedStatement statement = cone.getCon().prepareStatement(sql);
            statement.setString(1, getMotivo_dont());
            statement.setString(2, getEntidad_dont());
            statement.setString(3, getProyecto_dont());
            statement.setInt(4, getId_persona());

            int rowsAffected = statement.executeUpdate();
            statement.close();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public Donante buscarDonante(String cedula) throws SQLException {

        String sqlPersona = "SELECT * FROM persona WHERE cedula_usu = ?";
        String sqlDonante = "SELECT motivo_dont,entidad_dont, proyecto_dont FROM donante WHERE id_persona_dont = ?";

        PreparedStatement statementPersona = null;
        PreparedStatement statementDonante = null;
        ResultSet rsPersona = null;
        ResultSet rsDonante = null;
        ConexionPg conexion = new ConexionPg();

        try {
            statementPersona = conexion.getCon().prepareStatement(sqlPersona);
            statementPersona.setString(1, cedula);
            rsPersona = statementPersona.executeQuery();

            if (rsPersona.next()) {
                Donante mi_donan = new Donante();

                mi_donan.setCedula_usu(rsPersona.getString("cedula_usu"));
                mi_donan.setNombre_usu(rsPersona.getString("nombre_usu"));
                mi_donan.setApellido_usu(rsPersona.getString("apellido_usu"));
                mi_donan.setCorreo_usu(rsPersona.getString("correo_usu"));
                mi_donan.setSexo_usu(rsPersona.getString("sexo_usu"));
                mi_donan.setFechaNacimiento_usu(rsPersona.getString("fechaNacimiento_usu"));
                mi_donan.setDireccion_usu(rsPersona.getString("direccion_usu"));
                mi_donan.setCiudad_usu(rsPersona.getString("ciudad_usu"));
                mi_donan.setCelular_usu(rsPersona.getString("celular_usu"));
                mi_donan.setTipoSangre_usu(rsPersona.getString("tipoSangre_usu"));
                mi_donan.setContraseña_usu(rsPersona.getString("contrasenia_usu"));

                // Consulta para obtener el cargo del donante
                statementDonante = conexion.getCon().prepareStatement(sqlDonante);
                statementDonante.setInt(1, rsPersona.getInt("id_persona"));
                rsDonante = statementDonante.executeQuery();
                if (rsDonante.next()) {
                    mi_donan.setMotivo_dont(rsDonante.getString("motivo_dont"));
                    mi_donan.setEntidad_dont(rsDonante.getString("entidad_dont"));
                    mi_donan.setProyecto_dont(rsDonante.getString("proyecto_dont"));
                }

                return mi_donan;
            } else {
                return null; // Retornar null si no se encuentra el donante con la cédula
            }
        } finally {
            if (rsPersona != null) {
                rsPersona.close();
            }
            if (rsDonante != null) {
                rsDonante.close();
            }
            if (statementPersona != null) {
                statementPersona.close();
            }
            if (statementDonante != null) {
                statementDonante.close();
            }
            if (conexion.getCon() != null) {
                conexion.getCon().close();
            }
        }
    }
    
    //eliminar
    public void eliminar_Donante(String cedula) throws SQLException {
        //  String sql = "DELETE FROM persona WHERE cedula_usu = ?";
        Connection conexion = null;
        PreparedStatement statement = null;

        try {

            // Buscar el ID de la persona basado en la cédula
            int idPersona = obtenerIdPersonaPorCedula(cedula);

            // Eliminar al donante basado en el ID de la persona
            String deleteDonanteSql = "DELETE FROM donante WHERE id_persona_dont = ?";
            PreparedStatement statementDonante = cone.getCon().prepareStatement(deleteDonanteSql);
            statementDonante.setInt(1, idPersona);
            statementDonante.executeUpdate();

            // Luego de eliminar al administrador, se puede eliminar la persona
            String deletePersonaSql = "DELETE FROM persona WHERE id_persona = ?";
            PreparedStatement statementPersona = cone.getCon().prepareStatement(deletePersonaSql);
            statementPersona.setInt(1, idPersona);
            statementPersona.executeUpdate();

            System.out.println("El Donante y la persona asociada fueron eliminados exitosamente");
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
    
    public List<Donante> ListaDonante() {
        ConexionPg cone = new ConexionPg();//Conectamos a la base
        String sqls = "SELECT * FROM persona per JOIN donante donant ON per.id_persona  = donant.id_persona_dont";
        ResultSet rs = cone.consultaDB(sqls);
        List<Donante> donante = new ArrayList<>();
        try {
            while (rs.next()) {
                Donante mi_dona = new Donante();
                mi_dona.setId_donante(rs.getInt("id_donante"));
                mi_dona.setMotivo_dont(rs.getString("motivo_dont"));
                mi_dona.setEntidad_dont(rs.getString("entidad_dont"));
                mi_dona.setProyecto_dont(rs.getString("proyecto_dont"));
                mi_dona.setContraseña_usu(rs.getString("contrasenia_usu"));
                mi_dona.setCedula_usu(rs.getString("cedula_usu"));

                mi_dona.setNombre_usu(rs.getString("nombre_usu"));
                mi_dona.setApellido_usu(rs.getString("apellido_usu"));
                mi_dona.setCorreo_usu(rs.getString("correo_usu"));
                mi_dona.setSexo_usu(rs.getString("sexo_usu"));

                mi_dona.setFechaNacimiento_usu(rs.getString("fechaNacimiento_usu"));

                mi_dona.setDireccion_usu(rs.getString("direccion_usu"));
                mi_dona.setCiudad_usu(rs.getString("ciudad_usu"));
                mi_dona.setCelular_usu(rs.getString("celular_usu"));
                mi_dona.setTipoSangre_usu(rs.getString("tipoSangre_usu"));

                donante.add(mi_dona);
            }
            rs.close();
            System.out.println("Tamaño" + donante.size());
            return donante;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ModeloComprador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            return null;
        }
    }
}
