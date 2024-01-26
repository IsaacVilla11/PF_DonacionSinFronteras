package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IV
 */
public class ModeloRopa {

    public static int insertarRopa(Ropa ropa) {
        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement(
                        "INSERT INTO ropa (marca_rop, talla_rop, color_rop, id_vendible_rop) VALUES (?, ?, ?, ?) RETURNING id_rop")) {

            // Verificar si el objeto Ropa no es nulo antes de acceder a sus propiedades
            if (ropa != null) {
                pst.setString(1, ropa.getMarca_rop());
                pst.setString(2, ropa.getTalla_rop());
                pst.setString(3, ropa.getColor_rop());

                // Verificar si la propiedad id_vendible_rop no es nula antes de usarla
                if (ropa.getId_vendible_rop() != 0) {
                    pst.setInt(4, ropa.getId_vendible_rop());
                } else {
                    throw new IllegalArgumentException("id_vendible_rop no puede ser nulo");
                    // O manejar de acuerdo a las necesidades de tu aplicación
                }

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    return rs.getInt(1); // Devolver el ID generado por la consulta RETURNING
                }
            } else {
                throw new IllegalArgumentException("El objeto Ropa no puede ser nulo");
                // O manejar de acuerdo a las necesidades de tu aplicación
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al insertar ropa: " + ex.getMessage());
        }

        return -1; // En caso de error, devolver -1
    }

    public static List<Integer> obtenerIdsRopa() {
        List<Integer> idsRopa = new ArrayList<>();

        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement("SELECT id_rop FROM ropa");
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int idRopa = rs.getInt("id_rop");
                idsRopa.add(idRopa);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al obtener los IDs de ropa: " + ex.getMessage());
        }

        return idsRopa;
    }

    public static List<Ropa> obtenerTodasLasRopas() {
        List<Ropa> listaRopas = new ArrayList<>();

        try (Connection conexion = new ConexionPg().getCon();
                Statement stmt = conexion.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM ropa")) {

            while (rs.next()) {
                Ropa ropa = new Ropa();
                ropa.setId_rop(rs.getInt("id_rop"));
                ropa.setMarca_rop(rs.getString("marca_rop"));
                ropa.setTalla_rop(rs.getString("talla_rop"));
                ropa.setColor_rop(rs.getString("color_rop"));
                ropa.setId_vendible_rop(rs.getInt("id_vendible_rop"));

                listaRopas.add(ropa);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al obtener las ropas: " + ex.getMessage());
        }

        return listaRopas;
    }

    public static int obtenerUltimoIdRopa() {
        int ultimoId = -1;

        try (Connection conexion = new ConexionPg().getCon();
                Statement stmt = conexion.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT MAX(id_rop) FROM ropa")) {

            if (rs.next()) {
                ultimoId = rs.getInt(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al obtener el último ID de ropa: " + ex.getMessage());
        }

        return ultimoId;
    }

    public static Ropa obtenerRopaPorId(int idRopa) {
        Ropa ropa = null;

        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement("SELECT * FROM ropa WHERE id_rop = ?")) {

            pst.setInt(1, idRopa);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    // Construir un objeto Ropa con los datos obtenidos de la consulta
                    ropa = new Ropa();
                    ropa.setId_rop(rs.getInt("id_rop"));
                    ropa.setMarca_rop(rs.getString("marca_rop"));
                    ropa.setTalla_rop(rs.getString("talla_rop"));
                    ropa.setColor_rop(rs.getString("color_rop"));
                    ropa.setId_vendible_rop(rs.getInt("id_vendible_rop"));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al obtener la Ropa por ID: " + ex.getMessage());
        }

        return ropa;
    }
    public static boolean eliminarRopa(int idRopa) {
        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement("DELETE FROM ropa WHERE id_rop = ?")) {

            // Eliminar primero el registro de la tabla Ropa
            pst.setInt(1, idRopa);
            int filasEliminadas = pst.executeUpdate();

            // Verificar si se eliminó correctamente antes de continuar con la cascada
            if (filasEliminadas > 0) {
                // Luego, eliminar el registro correspondiente en la tabla TipoVendible
                int idTipoVendible = obtenerIdTipoVendiblePorIdRopa(idRopa);
                ModeloTipoVendible.eliminarTipoVendible(idTipoVendible);

                // Finalmente, eliminar el registro correspondiente en la tabla Producto
                int idProducto = ModeloTipoVendible.obtenerIdProductoPorIdTipoVendible(idTipoVendible);
                ModeloProducto.eliminarProducto(idProducto);

                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al eliminar la Ropa: " + ex.getMessage());
        }

        return false;
    }
    public static int obtenerIdTipoVendiblePorIdRopa(int idRopa) {
        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement("SELECT id_vendible_rop FROM ropa WHERE id_rop = ?")) {

            pst.setInt(1, idRopa);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getInt("id_vendible_rop");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al obtener ID de TipoVendible por ID de Ropa: " + ex.getMessage());
        }

        return -1;
    }
    public static boolean modificarRopa(Ropa ropa) {
        try (Connection conexion = new ConexionPg().getCon();
             PreparedStatement pst = conexion.prepareStatement(
                     "UPDATE ropa SET marca_rop=?, talla_rop=?, color_rop=? WHERE id_rop=?")) {

            pst.setString(1, ropa.getMarca_rop());
            pst.setString(2, ropa.getTalla_rop());
            pst.setString(3, ropa.getColor_rop());
            pst.setInt(4, ropa.getId_rop());

            int filasActualizadas = pst.executeUpdate();

            return filasActualizadas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al modificar ropa: " + ex.getMessage());
        }

        return false;
    }

}
