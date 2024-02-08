/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS TUF
 */
public class ModeloConductor extends Conductor {

    ConexionPg cone = new ConexionPg(); // Conectamos a la base

    public List<Ciudad> obtenerCiudades() {
        List<Ciudad> ciudades = new ArrayList<>();

        String query = "SELECT id_ciudad, nombre_ciud FROM Ciudad";

        try {
            ResultSet rs = cone.consultaDB(query); // Utilizar la instancia cone para llamar al método consultaDB

            while (rs.next()) {
                int idCiudad = rs.getInt("id_ciudad");
                String nombreCiudad = rs.getString("nombre_ciud");

                Ciudad ciudad = new Ciudad(idCiudad, nombreCiudad);
                ciudades.add(ciudad);
            }

            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
//            cone.cerrarConexion(); // Asegurarse de cerrar la conexión después de usarla
        }

        return ciudades;
    }

    public boolean InsertarPersona(String fechaNacimiento) {
        String sql = "INSERT INTO persona (cedula_usu, nombre_usu, apellido_usu, fechaNacimiento_usu, sexo_usu, tipoSangre_usu, correo_usu, celular_usu, ciudad_usu, direccion_usu, contrasenia_usu)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = cone.getCon().prepareStatement(sql);

            statement.setString(1, getCedula_usu());
            statement.setString(2, getNombre_usu());
            statement.setString(3, getApellido_usu());
            statement.setString(4, fechaNacimiento);
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

    public boolean InsertarConductor() {
        String sql = "INSERT INTO conductor (jornada_con, tipoLicencia_con, id_persona_con)"
                + " VALUES (?, ?, ?)";
        try {
            PreparedStatement statement = cone.getCon().prepareStatement(sql);
            statement.setString(1, getJornada_con());
            statement.setString(2, getTipoLicencia_con());
            statement.setInt(3, getId_persona_con());

            int rowsAffected = statement.executeUpdate();
            statement.close();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean actualizarConductor(ModeloConductor nuevoConductor) {
        String sqlActualizarPersona = "UPDATE persona SET nombre_usu=?, apellido_usu=?, fechaNacimiento_usu=?, sexo_usu=?, tipoSangre_usu=?, correo_usu=?, celular_usu=?, ciudad_usu=?, direccion_usu=?, contrasenia_usu=? WHERE cedula_usu=?";
        String sqlActualizarConductor = "UPDATE conductor SET jornada_con=?, tipoLicencia_con=? WHERE id_persona_con=(SELECT id_persona FROM persona WHERE cedula_usu=?)";

        try {
            // Convertir la fecha de nacimiento a java.sql.Date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaNacimiento = sdf.parse(nuevoConductor.getFechaNacimiento_usu());
            java.sql.Date fechaNacimientoSQL = new java.sql.Date(fechaNacimiento.getTime());

            // Actualizar en la tabla persona
            PreparedStatement statementPersona = cone.getCon().prepareStatement(sqlActualizarPersona);
            statementPersona.setString(1, nuevoConductor.getNombre_usu());
            statementPersona.setString(2, nuevoConductor.getApellido_usu());
            statementPersona.setDate(3, fechaNacimientoSQL);
            statementPersona.setString(4, nuevoConductor.getSexo_usu());
            statementPersona.setString(5, nuevoConductor.getTipoSangre_usu());
            statementPersona.setString(6, nuevoConductor.getCorreo_usu());
            statementPersona.setString(7, nuevoConductor.getCelular_usu());
            statementPersona.setString(8, nuevoConductor.getCiudad_usu());
            statementPersona.setString(9, nuevoConductor.getDireccion_usu());
            statementPersona.setString(10, nuevoConductor.getContraseña_usu());
            statementPersona.setString(11, nuevoConductor.getCedula_usu());

            int rowsAffectedPersona = statementPersona.executeUpdate();
            statementPersona.close();

            // Actualizar en la tabla conductor
            PreparedStatement statementConductor = cone.getCon().prepareStatement(sqlActualizarConductor);
            statementConductor.setString(1, nuevoConductor.getJornada_con());
            statementConductor.setString(2, nuevoConductor.getTipoLicencia_con());
            statementConductor.setString(3, nuevoConductor.getCedula_usu());

            int rowsAffectedConductor = statementConductor.executeUpdate();
            statementConductor.close();

            // Retornar true si se ha actualizado al menos una fila en ambas tablas
            return rowsAffectedPersona > 0 && rowsAffectedConductor > 0;
        } catch (ParseException | SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean verificarDuplicidadCedulaConductor(String cedula) {
        String sql = "SELECT COUNT(*) AS count FROM persona p JOIN conductor c ON p.id_persona = c.id_persona_con WHERE p.cedula_usu = ?";

        try {
            PreparedStatement statement = cone.getCon().prepareStatement(sql);
            statement.setString(1, cedula);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                return count > 0; // Si count > 0, significa que ya existe una persona con esa cédula y es conductor.
            }

            statement.close();
            resultSet.close();
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean buscarConductorPorCedula(String cedulaBuscada) {
        String sql = "SELECT p.*, c.jornada_con, c.tipoLicencia_con FROM persona p JOIN conductor c ON p.id_persona = c.id_persona_con WHERE p.cedula_usu = ?";
        try {
            PreparedStatement statement = cone.getCon().prepareStatement(sql);
            statement.setString(1, cedulaBuscada);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Se encontró el conductor, llenar todas las propiedades del modelo
                setId_persona_con(resultSet.getInt("id_persona"));
                setNombre_usu(resultSet.getString("nombre_usu"));
                setApellido_usu(resultSet.getString("apellido_usu"));
                setFechaNacimiento_usu(resultSet.getString("fechaNacimiento_usu"));
                setSexo_usu(resultSet.getString("sexo_usu"));
                setTipoSangre_usu(resultSet.getString("tipoSangre_usu"));
                setCorreo_usu(resultSet.getString("correo_usu"));
                setCelular_usu(resultSet.getString("celular_usu"));
                setCiudad_usu(resultSet.getString("ciudad_usu"));
                setDireccion_usu(resultSet.getString("direccion_usu"));
                setContraseña_usu(resultSet.getString("contrasenia_usu"));
                setJornada_con(resultSet.getString("jornada_con"));
                setTipoLicencia_con(resultSet.getString("tipoLicencia_con"));
                // Otros campos del conductor...

                statement.close();
                resultSet.close();

                return true;
            } else {
                // No se encontró el conductor
                statement.close();
                resultSet.close();
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean eliminarConductorPorCedula(String cedula) {
        ConexionPg cone = new ConexionPg();
        String sqlEliminarConductor = "DELETE FROM conductor WHERE id_persona_con IN (SELECT id_persona FROM persona WHERE cedula_usu = ?)";
        String sqlEliminarPersona = "DELETE FROM persona WHERE cedula_usu = ?";

        try {
            // Eliminar de la tabla conductor
            PreparedStatement statementConductor = cone.getCon().prepareStatement(sqlEliminarConductor);
            statementConductor.setString(1, cedula);
            int rowsAffectedConductor = statementConductor.executeUpdate();
            statementConductor.close();

            // Eliminar de la tabla persona
            PreparedStatement statementPersona = cone.getCon().prepareStatement(sqlEliminarPersona);
            statementPersona.setString(1, cedula);
            int rowsAffectedPersona = statementPersona.executeUpdate();
            statementPersona.close();

            // Retornar true si se ha eliminado al menos una fila en ambas tablas
            return rowsAffectedConductor > 0 && rowsAffectedPersona > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            cone.cerrarConexion();
        }
    }

    public List<Conductor> ListaConductor() {
        ConexionPg cone = new ConexionPg(); // Conectamos a la base
        String sql = "SELECT * FROM persona per JOIN conductor con ON per.id_persona = con.id_persona_con";
        ResultSet rs = cone.consultaDB(sql);
        List<Conductor> conductores = new ArrayList<>();

        try {
            while (rs.next()) {
                Conductor conductor = new Conductor();

                // Campos comunes a Usuario
                conductor.setCedula_usu(rs.getString("cedula_usu"));
                conductor.setNombre_usu(rs.getString("nombre_usu"));
                conductor.setApellido_usu(rs.getString("apellido_usu"));
                conductor.setSexo_usu(rs.getString("sexo_usu"));
                conductor.setFechaNacimiento_usu(rs.getString("fechaNacimiento_usu"));
                conductor.setTipoSangre_usu(rs.getString("tipoSangre_usu"));
                conductor.setCorreo_usu(rs.getString("correo_usu"));
                conductor.setCelular_usu(rs.getString("celular_usu"));
                conductor.setCiudad_usu(rs.getString("ciudad_usu"));
                conductor.setDireccion_usu(rs.getString("direccion_usu"));
                conductor.setContraseña_usu(rs.getString("contrasenia_usu"));

                // Campos específicos a Conductor
                conductor.setJornada_con(rs.getString("jornada_con"));
                conductor.setTipoLicencia_con(rs.getString("tipoLicencia_con"));

                conductores.add(conductor);
            }
            rs.close();
            System.out.println("Tamaño: " + conductores.size());
            return conductores;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ModeloConductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            return null;
        }
    }

}
