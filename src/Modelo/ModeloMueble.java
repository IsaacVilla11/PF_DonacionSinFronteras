package Modelo;

import java.sql.Connection;
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
public class ModeloMueble {

    public static int insertarMueble(Mueble mueble) {
        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement(
                        "INSERT INTO mueble (material_mue, tamaño_mue, id_vendible_mue) VALUES (?, ?, ?) RETURNING id_mueb")) {

            // Verificar si el objeto Ropa no es nulo antes de acceder a sus propiedades
            if (mueble != null) {
                pst.setString(1, mueble.getMaterial_mue());
                pst.setString(2, mueble.getTamaño_mue());

                // Verificar si la propiedad id_vendible_rop no es nula antes de usarla
                if (mueble.getId_vendible_mue() != 0) {
                    pst.setInt(3, mueble.getId_vendible_mue());
                } else {
                    throw new IllegalArgumentException("id_mueble_rop no puede ser nulo");
                    // O manejar de acuerdo a las necesidades de tu aplicación
                }

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    return rs.getInt(1); // Devolver el ID generado por la consulta RETURNING
                }
            } else {
                throw new IllegalArgumentException("El objeto Mueble no puede ser nulo");
                // O manejar de acuerdo a las necesidades de tu aplicación
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al insertar mueble: " + ex.getMessage());
        }

        return -1; // En caso de error, devolver -1
    }

    public static List<Integer> obtenerIdsMueble() {
        List<Integer> idsMueble = new ArrayList<>();

        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement("SELECT id_mueb FROM mueble");
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int idMueble = rs.getInt("id_mueb");
                idsMueble.add(idMueble);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al obtener los IDs de mueble: " + ex.getMessage());
        }

        return idsMueble;
    }

    public static List<Mueble> obtenerTodasLosMubles() {
        List<Mueble> listaMuebles = new ArrayList<>();

        try (Connection conexion = new ConexionPg().getCon();
                Statement stmt = conexion.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM mueble")) {

            while (rs.next()) {
                Mueble mueble = new Mueble();
                mueble.setId_mueb(rs.getInt("id_mueb"));
                mueble.setMaterial_mue(rs.getString("material_mue"));
                mueble.setTamaño_mue(rs.getString("tamaño_mue"));
                mueble.setId_vendible_mue(rs.getInt("id_vendible_mue"));

                listaMuebles.add(mueble);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al obtener las ropas: " + ex.getMessage());
        }

        return listaMuebles;
    }

    public static int obtenerUltimoIdMueble() {
        int ultimoId = -1;

        try (Connection conexion = new ConexionPg().getCon();
                Statement stmt = conexion.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT MAX(id_mueb) FROM mueble")) {

            if (rs.next()) {
                ultimoId = rs.getInt(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al obtener el último ID de mueble: " + ex.getMessage());
        }

        return ultimoId;
    }

    public static Mueble obtenerMueblePorId(int idMueb) {
        Mueble mueble = null;

        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement("SELECT * FROM mueble WHERE id_mueb = ?")) {

            pst.setInt(1, idMueb);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    // Construir un objeto Ropa con los datos obtenidos de la consulta
                    mueble = new Mueble();
                    mueble.setId_mueb(rs.getInt("id_mueb"));
                    mueble.setMaterial_mue(rs.getString("material_mue"));
                    mueble.setTamaño_mue(rs.getString("tamaño_mue"));
                    mueble.setId_vendible_mue(rs.getInt("id_vendible_mue"));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al obtener el Mueble por ID: " + ex.getMessage());
        }

        return mueble;
    }

    public static boolean eliminarMueble(int idMueb) {
        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement("DELETE FROM mueble WHERE id_mueb = ?")) {

            // Eliminar primero el registro de la tabla Ropa
            pst.setInt(1, idMueb);
            int filasEliminadas = pst.executeUpdate();

            // Verificar si se eliminó correctamente antes de continuar con la cascada
            if (filasEliminadas > 0) {
                // Luego, eliminar el registro correspondiente en la tabla TipoVendible
                int idTipoVendible = obtenerIdTipoVendiblePorIdMueble(idMueb);
                ModeloTipoVendible.eliminarTipoVendible(idTipoVendible);

                // Finalmente, eliminar el registro correspondiente en la tabla Producto
                int idProducto = ModeloTipoVendible.obtenerIdProductoPorIdTipoVendible(idTipoVendible);
                ModeloProducto.eliminarProducto(idProducto);

                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al eliminar el mueble: " + ex.getMessage());
        }

        return false;
    }

    public static int obtenerIdTipoVendiblePorIdMueble(int idMueble) {
        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement("SELECT id_vendible_mue FROM mueble WHERE id_mueb = ?")) {

            pst.setInt(1, idMueble);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getInt("id_vendible_mue");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al obtener ID de TipoVendible por ID de Mueble: " + ex.getMessage());
        }

        return -1;
    }

    public static boolean modificarMueble(Mueble mueble) {
        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement(
                        "UPDATE mueble SET material_mue=?, tamaño_mue=? WHERE id_mueb=?")) {

            pst.setString(1, mueble.getMaterial_mue());
            pst.setString(2, mueble.getTamaño_mue());
            pst.setInt(3, mueble.getId_mueb());

            int filasActualizadas = pst.executeUpdate();

            return filasActualizadas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al modificar mueble: " + ex.getMessage());
        }

        return false;
    }

    public static List<Mueble> obtenerDetallesMueble() {
        List<Mueble> detalles = new ArrayList<>();

        // Establecer la conexión a la base de datos (deberías manejar las excepciones)
        try (Connection connection = new ConexionPg().getCon()) {
            // Consulta SQL para obtener los detalles de la ropa
            String sql = "SELECT "
                    + "mueble.id_mueb, "
                    + "tipoVendible.tipo, "
                    + "tipoVendible.estado, "
                    + "mueble.material_mue, "
                    + "mueble.tamaño_mue, "
                    + "tipoVendible.precio "
                    + "FROM producto "
                    + "JOIN tipoVendible ON tipoVendible.id_producto_ven = producto.id_producto "
                    + "JOIN mueble ON mueble.id_vendible_mue = tipoVendible.id_vendible";

            try (PreparedStatement statement = connection.prepareStatement(sql);
                    ResultSet resultSet = statement.executeQuery()) {
                // Iterar a través de los resultados y construir objetos RopaDetalle
                while (resultSet.next()) {
                    Mueble detalle = new Mueble();
                    detalle.setId_mueb(resultSet.getInt("id_mueb"));
                    detalle.setTipo(resultSet.getString("tipo"));
                    detalle.setEstado(resultSet.getString("estado"));
                    detalle.setMaterial_mue(resultSet.getString("material_mue"));
                    detalle.setTamaño_mue(resultSet.getString("tamaño_mue"));
                    detalle.setPrecio(resultSet.getDouble("precio"));

                    detalles.add(detalle);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejar la excepción adecuadamente en tu aplicación
        }

        return detalles;
    }
}
