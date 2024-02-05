package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IV
 */
public class ModeloTipoDonable {

    public static int insertarTipoDonable(TipoDonable tipoDonable) {
        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement(
                        "INSERT INTO tipoDonable (nombre_dona, fechaElaboracion, fechaVencimiento, id_pro_dona) VALUES (?, ?, ?, ?) RETURNING id_donable")) {

            pst.setString(1, tipoDonable.getNombre_dona());
            pst.setDate(2, new java.sql.Date(tipoDonable.getFechaElaboracion().getTime()));

            pst.setDate(3, new java.sql.Date(tipoDonable.getFechaVencimiento().getTime()));
            pst.setInt(4, tipoDonable.getId_pro_dona());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getInt(1); // Devolver el ID generado por la consulta RETURNING
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al insertar tipo donable: " + ex.getMessage());
        }

        return -1; // En caso de error, devolver -1
    }

    public static List<TipoDonable> obtenerTodosLosTipoDonables() {
        List<TipoDonable> listaTipoDonables = new ArrayList<>();

        try (Connection conexion = new ConexionPg().getCon();
                Statement stmt = conexion.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM tipoDonable")) {

            while (rs.next()) {
                TipoDonable tipoDonable = new TipoDonable();
                tipoDonable.setId_donable(rs.getInt("id_donable"));
                tipoDonable.setNombre_dona(rs.getString("nombre_dona"));
                tipoDonable.setFechaElaboracion(rs.getDate("fechaElaboracion"));
                tipoDonable.setFechaVencimiento(rs.getDate("fechaVencimiento"));
                tipoDonable.setId_pro_dona(rs.getInt("id_pro_dona"));

                listaTipoDonables.add(tipoDonable);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al obtener los tipoDonable: " + ex.getMessage());
        }

        return listaTipoDonables;
    }

    public static int obtenerUltimoIdTipoDonable() {
        int ultimoId = -1;

        try (Connection conexion = new ConexionPg().getCon();
                Statement stmt = conexion.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT MAX(id_donable) FROM tipoDonable")) {

            if (rs.next()) {
                ultimoId = rs.getInt(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al obtener el último ID de tipoDonable: " + ex.getMessage());
        }

        return ultimoId;
    }

    public static TipoDonable obtenerTipoDonablePorId(int idTipoDonable) {
        TipoDonable tipoDonable = null;

        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement("SELECT * FROM tipoDonable WHERE id_donable = ?")) {

            pst.setInt(1, idTipoDonable);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    // Construir un objeto TipoDonable con los datos obtenidos de la consulta
                    tipoDonable = new TipoDonable();
                    tipoDonable.setId_donable(rs.getInt("id_donable"));
                    tipoDonable.setNombre_dona(rs.getString("nombre_dona"));
                    tipoDonable.setFechaElaboracion(rs.getDate("fechaElaboracion"));
                    tipoDonable.setFechaVencimiento(rs.getDate("fechaVencimiento"));
                    tipoDonable.setId_pro_dona(rs.getInt("id_pro_dona"));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al obtener el TipoVendible por ID: " + ex.getMessage());
        }

        return tipoDonable;
    }

    public static boolean eliminarTipoDonable(int idTipoDonable) {
        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement("DELETE FROM tipoDonable WHERE id_donable = ?")) {

            // Eliminar primero el registro de la tabla TipoVendible
            pst.setInt(1, idTipoDonable);
            int filasEliminadas = pst.executeUpdate();

            // Verificar si se eliminó correctamente antes de continuar con la cascada
            if (filasEliminadas > 0) {
                // Luego, eliminar el registro correspondiente en la tabla Producto
                int idProducto = obtenerIdProductoPorIdTipoDonable(idTipoDonable);
                ModeloProducto.eliminarProducto(idProducto);

                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al eliminar el TipoDonable: " + ex.getMessage());
        }

        return false;
    }

    public static int obtenerIdProductoPorIdTipoDonable(int idTipoDonable) {
        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement("SELECT id_pro_dona FROM tipoDonable WHERE id_donable = ?")) {

            pst.setInt(1, idTipoDonable);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getInt("id_pro_dona");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al obtener ID de Producto por ID de TipoDonable: " + ex.getMessage());
        }

        return -1;
    }

    public static boolean modificarTipoDonable(TipoDonable tipoDonable) {
        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement(
                        "UPDATE tipoDonable SET nombre_dona=?, fechaElaboracion=?, fechaVencimiento=? WHERE id_donable=?")) {

            pst.setString(1, tipoDonable.getNombre_dona());
            pst.setDate(2, new java.sql.Date(tipoDonable.getFechaElaboracion().getTime()));
            pst.setDate(3, new java.sql.Date(tipoDonable.getFechaVencimiento().getTime()));
            pst.setInt(4, tipoDonable.getId_donable());

            int filasActualizadas = pst.executeUpdate();

            return filasActualizadas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al modificar tipo donable: " + ex.getMessage());
        }

        return false;
    }
}
