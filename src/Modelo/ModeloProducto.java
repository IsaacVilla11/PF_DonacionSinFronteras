package Modelo;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IV
 */
public class ModeloProducto {

    public static int insertarProducto(Producto producto) {
        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement(
                        "INSERT INTO producto (tipo_pro, imagen_pro) VALUES (?, ?) RETURNING id_producto")) {

            pst.setString(1, producto.getTipo_pro());
            pst.setBytes(2, producto.getImagen_pro());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getInt(1); // Devolver el ID generado por la consulta RETURNING
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al insertar producto: " + ex.getMessage());
        }

        return -1; // En caso de error, devolver -1
    }

    public static List<Producto> obtenerTodosLosProductos() {
        List<Producto> listaProductos = new ArrayList<>();

        try (Connection conexion = new ConexionPg().getCon();
                Statement stmt = conexion.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM producto")) {

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId_producto(rs.getInt("id_producto"));
                producto.setTipo_pro(rs.getString("tipo_pro"));
                // Puedes optar por no recuperar la imagen aquí para mejorar el rendimiento

                listaProductos.add(producto);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al obtener los productos: " + ex.getMessage());
        }

        return listaProductos;
    }

    public static int obtenerUltimoIdProducto() {
        int ultimoId = -1;

        try (Connection conexion = new ConexionPg().getCon();
                Statement stmt = conexion.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT MAX(id_producto) FROM producto")) {

            if (rs.next()) {
                ultimoId = rs.getInt(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al obtener el último ID de producto: " + ex.getMessage());
        }

        return ultimoId;
    }

    public static Producto obtenerProductoPorId(int idProducto) {
        Producto producto = null;

        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement("SELECT * FROM producto WHERE id_producto = ?")) {

            pst.setInt(1, idProducto);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    // Construir un objeto Producto con los datos obtenidos de la consulta
                    producto = new Producto();
                    producto.setId_producto(rs.getInt("id_producto"));
                    producto.setTipo_pro(rs.getString("tipo_pro"));
                    producto.setImagen_pro(rs.getBytes("imagen_pro"));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al obtener el Producto por ID: " + ex.getMessage());
        }

        return producto;
    }

    public static boolean eliminarProducto(int idProducto) {
        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement("DELETE FROM producto WHERE id_producto = ?")) {

            // Eliminar el registro de la tabla Producto
            pst.setInt(1, idProducto);
            int filasEliminadas = pst.executeUpdate();

            // Verificar si se eliminó correctamente
            return filasEliminadas > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al eliminar el Producto: " + ex.getMessage());
        }

        return false;
    }

    public static boolean modificarProducto(Producto producto) {
        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement(
                        "UPDATE producto SET tipo_pro=?, imagen_pro=? WHERE id_producto=?")) {

            pst.setString(1, producto.getTipo_pro());
            pst.setBytes(2, producto.getImagen_pro());
            pst.setInt(3, producto.getId_producto());

            int filasActualizadas = pst.executeUpdate();

            return filasActualizadas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al modificar producto: " + ex.getMessage());
        }

        return false;
    }

}
