package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author IV
 */
public class ModeloProducto {

    public static boolean insertarProducto(Producto producto) {
        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement(
                        "Insert into producto (tipo_pro, disponibilidad_pro, nombre_pro, imagen_pro)")) {

            pst.setString(1, producto.getTipo_pro());
            pst.setBoolean(2, producto.isDisponibilidad_pro());
            pst.setString(3, producto.getNombre_pro());
            pst.setBytes(4, producto.getImagen_pro());

            int filasInsertadas = pst.executeUpdate();
            return filasInsertadas > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
