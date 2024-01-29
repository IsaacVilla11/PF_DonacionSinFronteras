package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IV
 */
public class ModeloTipoVendible {

    public static int insertarTipoVendible(TipoVendible tipoVendible) {
        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement(
                        "INSERT INTO tipoVendible (precio, tipo, estado, id_producto_ven) VALUES (?, ?, ?, ?) RETURNING id_vendible")) {

            pst.setDouble(1, tipoVendible.getPrecio());
            pst.setString(2, tipoVendible.getTipo());
            pst.setString(3, tipoVendible.getEstado());
            pst.setInt(4, tipoVendible.getId_pro_ven());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getInt(1); // Devolver el ID generado por la consulta RETURNING
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al insertar tipo vendible: " + ex.getMessage());
        }

        return -1; // En caso de error, devolver -1
    }

    public static List<TipoVendible> obtenerTodosLosTipoVendible() {
        List<TipoVendible> listaTipoVendible = new ArrayList<>();

        try (Connection conexion = new ConexionPg().getCon();
                Statement stmt = conexion.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM tipoVendible")) {

            while (rs.next()) {
                TipoVendible tipoVendible = new TipoVendible();
                tipoVendible.setId_vendible(rs.getInt("id_vendible"));
                tipoVendible.setPrecio(rs.getDouble("precio"));
                tipoVendible.setTipo(rs.getString("tipo"));
                tipoVendible.setEstado(rs.getString("estado"));
                tipoVendible.setId_pro_ven(rs.getInt("id_producto_ven"));

                listaTipoVendible.add(tipoVendible);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al obtener los tipoVendible: " + ex.getMessage());
        }

        return listaTipoVendible;
    }

    public static int obtenerUltimoIdTipoVendible() {
        int ultimoId = -1;

        try (Connection conexion = new ConexionPg().getCon();
                Statement stmt = conexion.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT MAX(id_vendible) FROM tipoVendible")) {

            if (rs.next()) {
                ultimoId = rs.getInt(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al obtener el último ID de tipoVendible: " + ex.getMessage());
        }

        return ultimoId;
    }

    public static TipoVendible obtenerTipoVendiblePorId(int idTipoVendible) {
        TipoVendible tipoVendible = null;

        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement("SELECT * FROM tipoVendible WHERE id_vendible = ?")) {

            pst.setInt(1, idTipoVendible);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    // Construir un objeto TipoVendible con los datos obtenidos de la consulta
                    tipoVendible = new TipoVendible();
                    tipoVendible.setId_vendible(rs.getInt("id_vendible"));
                    tipoVendible.setPrecio(rs.getDouble("precio"));
                    tipoVendible.setTipo(rs.getString("tipo"));
                    tipoVendible.setEstado(rs.getString("estado"));
                    tipoVendible.setId_pro_ven(rs.getInt("id_producto_ven"));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al obtener el TipoVendible por ID: " + ex.getMessage());
        }

        return tipoVendible;
    }

    public static boolean eliminarTipoVendible(int idTipoVendible) {
        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement("DELETE FROM tipoVendible WHERE id_vendible = ?")) {

            // Eliminar primero el registro de la tabla TipoVendible
            pst.setInt(1, idTipoVendible);
            int filasEliminadas = pst.executeUpdate();

            // Verificar si se eliminó correctamente antes de continuar con la cascada
            if (filasEliminadas > 0) {
                // Luego, eliminar el registro correspondiente en la tabla Producto
                int idProducto = obtenerIdProductoPorIdTipoVendible(idTipoVendible);
                ModeloProducto.eliminarProducto(idProducto);

                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al eliminar el TipoVendible: " + ex.getMessage());
        }

        return false;
    }

    public static int obtenerIdProductoPorIdTipoVendible(int idTipoVendible) {
        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement("SELECT id_producto_ven FROM tipoVendible WHERE id_vendible = ?")) {

            pst.setInt(1, idTipoVendible);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getInt("id_producto_ven");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al obtener ID de Producto por ID de TipoVendible: " + ex.getMessage());
        }

        return -1;
    }

    public static boolean modificarTipoVendible(TipoVendible tipoVendible) {
        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement(
                        "UPDATE tipoVendible SET precio=?, tipo=?, estado=? WHERE id_vendible=?")) {

            pst.setDouble(1, tipoVendible.getPrecio());
            pst.setString(2, tipoVendible.getTipo());
            pst.setString(3, tipoVendible.getEstado());
            pst.setInt(4, tipoVendible.getId_vendible());

            int filasActualizadas = pst.executeUpdate();

            return filasActualizadas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al modificar tipo vendible: " + ex.getMessage());
        }

        return false;
    }

}
