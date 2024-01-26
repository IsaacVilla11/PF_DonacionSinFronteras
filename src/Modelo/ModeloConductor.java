/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS TUF
 */
public class ModeloConductor extends Conductor {

    ConexionPg cone = new ConexionPg(); // Conectamos a la base

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

//    public boolean modificarConductor(String cedula, String nuevaJornada, String nuevoTipoLicencia,
//            String nuevoNombre, String nuevoApellido, String nuevoCelular,
//            String nuevoCorreo, String nuevaDireccion, String nuevoTipoSangre,
//            String nuevaCiudad, String nuevoSexo, Date nuevaFechaNacimiento,
//            String nuevaContraseña) {
//        String sql = "UPDATE conductor SET jornada_con = ?, tipoLicencia_con = ? WHERE id_persona_con = (SELECT id_persona FROM persona WHERE cedula_usu = ?)";
//        try {
//            PreparedStatement statement = cone.getCon().prepareStatement(sql);
//            statement.setString(1, nuevaJornada);
//            statement.setString(2, nuevoTipoLicencia);
//            statement.setString(3, cedula);
//
//            int rowsAffected = statement.executeUpdate();
//            statement.close();
//
//            if (rowsAffected > 0) {
//                // Actualizar otros campos en la tabla persona (si es necesario)
//                String updatePersonaSql = "UPDATE persona SET nombre_usu = ?, apellido_usu = ?, celular_usu = ?, "
//                        + "correo_usu = ?, direccion_usu = ?, tipoSangre_usu = ?, ciudad_usu = ?, "
//                        + "sexo_usu = ?, fechaNacimiento_usu = ?, contraseña_usu = ? WHERE cedula_usu = ?";
//
//                // Define fechaNacimientoSQL antes de su uso
//                java.sql.Date fechaNacimientoSQL = new java.sql.Date(nuevaFechaNacimiento.getTime());
//
//                PreparedStatement personaStatement = cone.getCon().prepareStatement(updatePersonaSql);
//                personaStatement.setString(1, nuevoNombre);
//                personaStatement.setString(2, nuevoApellido);
//
//                // Utiliza setObject para la fecha
//                personaStatement.setDate(3, nuevaFechaNacimiento);
//
//
//                personaStatement.setString(4, nuevoSexo);
//                personaStatement.setString(5, nuevoCorreo);
//                personaStatement.setString(6, nuevoTipoSangre);
//                personaStatement.setString(7, nuevoCelular);
//                personaStatement.setString(8, nuevaCiudad);
//                personaStatement.setString(9, nuevaDireccion);
//                personaStatement.setString(10, nuevaContraseña);
//                personaStatement.setString(11, cedula);
//
//                int personaRowsAffected = personaStatement.executeUpdate();
//                personaStatement.close();
//
//                return personaRowsAffected > 0;
//            }
//
//            return false;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            return false;
//        }
//    }

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
