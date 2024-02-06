/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import com.sun.jdi.connect.spi.Connection;
import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS TUF
 */
public class ModeloCamion {

    ConexionPg cone = new ConexionPg();

    
 
 

    public List<Conductor> obtenerDetallesConductores() {
        String sql = "SELECT c.id_conductor, p.nombre_usu, p.apellido_usu FROM conductor c "
                + "JOIN persona p ON c.id_persona_con = p.id_persona";

        try ( PreparedStatement statement = cone.getCon().prepareStatement(sql);  ResultSet resultSet = statement.executeQuery()) {

            List<Conductor> conductores = new ArrayList<>();

            while (resultSet.next()) {
                Conductor conductor = new Conductor();
                conductor.setId_conductor(resultSet.getInt("id_conductor"));
                conductor.setNombre_usu(resultSet.getString("nombre_usu"));
                conductor.setApellido_usu(resultSet.getString("apellido_usu"));
                conductores.add(conductor);
            }

            return conductores;
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Manejo de errores
            return null;
        }
    }

    public void crearCamionSeleccionado(int idConductor, String marca, String color, String modelo, int pesoMax) {
        try {
            String sqlInsert = "INSERT INTO camion (marca_cam, color_cam, modelo_cam, peso_max_cam, id_conductor_cam) "
                    + "VALUES (?, ?, ?, ?, ?)";

            try ( PreparedStatement statement = cone.getCon().prepareStatement(sqlInsert)) {
                statement.setString(1, marca);
                statement.setString(2, color);
                statement.setString(3, modelo);
                statement.setInt(4, pesoMax);
                statement.setInt(5, idConductor);

                statement.executeUpdate();
            }

            // Puedes imprimir un mensaje o realizar alguna acción adicional si la inserción fue exitosa
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Manejo de errores
        }
    }

    public boolean conductorAsignadoACamion(int idConductor) {
        String sql = "SELECT COUNT(*) FROM camion WHERE id_conductor_cam = ?";

        try ( PreparedStatement statement = cone.getCon().prepareStatement(sql)) {
            statement.setInt(1, idConductor);

            try ( ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0; // Devuelve true si el conductor ya está asignado a al menos un camión
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Manejo de errores
        }

        return false; // En caso de error, se asume que el conductor no está asignado a ningún camión
    }

    public List<Camion> obtenerDetallesCamiones() {
        String sql = "SELECT c.id_cam, c.marca_cam, c.color_cam, c.modelo_cam, c.peso_max_cam, "
                + "con.id_conductor AS id_conductor, p.nombre_usu, p.apellido_usu "
                + "FROM camion c "
                + "JOIN conductor con ON c.id_conductor_cam = con.id_conductor "
                + "JOIN persona p ON con.id_persona_con = p.id_persona";

        try ( PreparedStatement statement = cone.getCon().prepareStatement(sql);  ResultSet resultSet = statement.executeQuery()) {

            List<Camion> camiones = new ArrayList<>();

            while (resultSet.next()) {
                Camion camion = new Camion();
                camion.setId_cam(resultSet.getInt("id_cam"));
                camion.setMarca_cam(resultSet.getString("marca_cam"));
                camion.setColor_cam(resultSet.getString("color_cam"));
                camion.setModelo_cam(resultSet.getString("modelo_cam"));
                camion.setPeso_max_cam(resultSet.getInt("peso_max_cam"));
                camion.setId_conductor_cam(resultSet.getInt("id_conductor"));

                // Concatena solo el ID del conductor y su nombre y apellido en una sola cadena
                String nombreCompletoConductor = resultSet.getInt("id_conductor") + " - "
                        + resultSet.getString("nombre_usu") + " "
                        + resultSet.getString("apellido_usu");

                camion.setNombre_usu(nombreCompletoConductor);

                camiones.add(camion);
            }

            return camiones;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean eliminarCamion(int idCamion) {
        String sql = "DELETE FROM camion WHERE id_cam = ?";

        try ( PreparedStatement statement = cone.getCon().prepareStatement(sql)) {
            statement.setInt(1, idCamion);

            int filasAfectadas = statement.executeUpdate();

            // Verifica si la eliminación tuvo éxito (se afectó al menos una fila)
            return filasAfectadas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Manejo de errores
            return false;
        }
    }

    public Camion obtenerDetallesCamionPorId(int idCamion) {
        String sql = "SELECT c.id_cam, c.marca_cam, c.color_cam, c.modelo_cam, c.peso_max_cam, "
                + "con.id_conductor AS id_conductor, p.nombre_usu, p.apellido_usu "
                + "FROM camion c "
                + "JOIN conductor con ON c.id_conductor_cam = con.id_conductor "
                + "JOIN persona p ON con.id_persona_con = p.id_persona "
                + "WHERE c.id_cam = ?";

        try ( PreparedStatement statement = cone.getCon().prepareStatement(sql)) {
            statement.setInt(1, idCamion);

            try ( ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Camion camion = new Camion();
                    camion.setId_cam(resultSet.getInt("id_cam"));
                    camion.setMarca_cam(resultSet.getString("marca_cam"));
                    camion.setColor_cam(resultSet.getString("color_cam"));
                    camion.setModelo_cam(resultSet.getString("modelo_cam"));
                    camion.setPeso_max_cam(resultSet.getInt("peso_max_cam"));
                    camion.setId_conductor_cam(resultSet.getInt("id_conductor"));

                    // Concatena solo el ID del conductor y su nombre y apellido en una sola cadena
                    String nombreCompletoConductor = resultSet.getInt("id_conductor") + " - "
                            + resultSet.getString("nombre_usu") + " "
                            + resultSet.getString("apellido_usu");

                    camion.setNombre_usu(nombreCompletoConductor);

                    return camion;
                } else {
                    // Si no se encuentra el camión con el ID proporcionado, retorna null
                    return null;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public boolean modificarCamion(int idCamion, int idNuevoConductor, String marca, String color, String modelo, int pesoMax) {
    try {
        // Verificar si el nuevo conductor ya está asignado a otro camión
        if (conductorAsignadoACamion(idNuevoConductor) && idNuevoConductor != obtenerDetallesCamionPorId(idCamion).getId_conductor_cam()) {
            JOptionPane.showMessageDialog(null, "El nuevo conductor ya está asignado a otro camión.");
            return false;
        }

        // Actualizar la información del camión
        String sqlUpdate = "UPDATE camion SET marca_cam = ?, color_cam = ?, modelo_cam = ?, peso_max_cam = ?, id_conductor_cam = ? WHERE id_cam = ?";
        try (PreparedStatement statement = cone.getCon().prepareStatement(sqlUpdate)) {
            statement.setString(1, marca);
            statement.setString(2, color);
            statement.setString(3, modelo);
            statement.setInt(4, pesoMax);
            statement.setInt(5, idNuevoConductor);
            statement.setInt(6, idCamion);

            int filasAfectadas = statement.executeUpdate();

            return filasAfectadas > 0;
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al guardar los cambios del camión.");
        return false;
    }
}

//       public void modificarCamion(int idCamion, int idNuevoConductor, String marca, String color, String modelo, int pesoMax) {
//        try {
//            // Verificar si el nuevo conductor ya está asignado a otro camión
//            if (conductorAsignadoACamion(idNuevoConductor) && idNuevoConductor != obtenerDetallesCamionPorId(idCamion).getId_conductor_cam()) {
//                JOptionPane.showMessageDialog(null, "El nuevo conductor ya está asignado a otro camión.");
//                return;
//            }
//
//            // Actualizar la información del camión
//            String sqlUpdate = "UPDATE camion SET marca_cam = ?, color_cam = ?, modelo_cam = ?, peso_max_cam = ?, id_conductor_cam = ? WHERE id_cam = ?";
//            try ( PreparedStatement statement = cone.getCon().prepareStatement(sqlUpdate)) {
//                statement.setString(1, marca);
//                statement.setString(2, color);
//                statement.setString(3, modelo);
//                statement.setInt(4, pesoMax);
//                statement.setInt(5, idNuevoConductor);
//                statement.setInt(6, idCamion);
//
//                int filasAfectadas = statement.executeUpdate();
//
//                if (filasAfectadas > 0) {
//                   
//                } else {
//                    JOptionPane.showMessageDialog(null, "No se realizaron cambios.");
//                }
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Error al guardar los cambios del camión.");
//        }
//    }

    public Conductor obtenerDetallesConductorPorId(int idConductor) {
        String sql = "SELECT id_conductor, nombre_usu, apellido_usu FROM conductor WHERE id_conductor = ?";

        try ( PreparedStatement statement = cone.getCon().prepareStatement(sql)) {
            statement.setInt(1, idConductor);

            try ( ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Conductor conductor = new Conductor();
                    conductor.setId_conductor(resultSet.getInt("id_conductor"));
                    conductor.setNombre_usu(resultSet.getString("nombre_usu"));
                    conductor.setApellido_usu(resultSet.getString("apellido_usu"));
                    return conductor;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

}
