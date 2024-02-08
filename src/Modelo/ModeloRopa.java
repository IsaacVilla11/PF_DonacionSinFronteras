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
                        "INSERT INTO ropa (talla_rop, id_vendible_rop) VALUES (?, ?) RETURNING id_rop")) {

            // Verificar si el objeto Ropa no es nulo antes de acceder a sus propiedades
            if (ropa != null) {
                pst.setString(1, ropa.getTalla_rop());

                // Verificar si la propiedad id_vendible_rop no es nula antes de usarla
                if (ropa.getId_vendible_rop() != 0) {
                    pst.setInt(2, ropa.getId_vendible_rop());
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
                ropa.setTalla_rop(rs.getString("talla_rop"));
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
                    ropa.setTalla_rop(rs.getString("talla_rop"));
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
                        "UPDATE ropa SET talla_rop=? WHERE id_rop=?")) {

            pst.setString(1, ropa.getTalla_rop());
            pst.setInt(2, ropa.getId_rop());

            int filasActualizadas = pst.executeUpdate();

            return filasActualizadas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al modificar ropa: " + ex.getMessage());
        }

        return false;
    }

    public static List<Ropa> obtenerDetallesRopa() {
        List<Ropa> detalles = new ArrayList<>();

        // Establecer la conexión a la base de datos (deberías manejar las excepciones)
        try (Connection connection = new ConexionPg().getCon()) {
            // Consulta SQL para obtener los detalles de la ropa
            String sql = "SELECT "
                    + "ropa.id_rop, "
                    + "tipoVendible.tipo, "
                    + "tipoVendible.estado, "
                    + "ropa.talla_rop, "
                    + "tipoVendible.precio "
                    + "FROM producto "
                    + "JOIN tipoVendible ON tipoVendible.id_producto_ven = producto.id_producto "
                    + "JOIN ropa ON ropa.id_vendible_rop = tipoVendible.id_vendible";

            try (PreparedStatement statement = connection.prepareStatement(sql);
                    ResultSet resultSet = statement.executeQuery()) {
                // Iterar a través de los resultados y construir objetos RopaDetalle
                while (resultSet.next()) {
                    Ropa detalle = new Ropa();
                    detalle.setId_rop(resultSet.getInt("id_rop"));
                    detalle.setTipo(resultSet.getString("tipo"));
                    detalle.setEstado(resultSet.getString("estado"));
                    detalle.setTalla_rop(resultSet.getString("talla_rop"));
                    detalle.setPrecio(resultSet.getDouble("precio"));

                    detalles.add(detalle);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejar la excepción adecuadamente en tu aplicación
        }

        return detalles;
    }

    public static List<Ropa> buscarRopaPorId(int id) {
        Connection conexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Ropa> resultados = new ArrayList<>();

        try {
            conexion = new ConexionPg().getCon();

            // Construir la consulta SQL
            String consultaSQL = "SELECT * FROM ropa r JOIN tipoVendible tv ON r.id_vendible_rop = tv.id_vendible WHERE r.id_rop = ?";

            preparedStatement = conexion.prepareStatement(consultaSQL);
            preparedStatement.setInt(1, id);

            // Ejecutar la consulta
            resultSet = preparedStatement.executeQuery();

            // Procesar los resultados
            while (resultSet.next()) {
                // Construir objetos Ropa según los resultados y agregarlos a la lista
                Ropa ropa = new Ropa();
                // Setear atributos de la ropa con resultSet.getString("nombre_del_campo")
                // ...
                ropa.setId_rop(resultSet.getInt("id_rop"));
                ropa.setTipo(resultSet.getString("tipo"));
                ropa.setEstado(resultSet.getString("estado"));
                ropa.setTalla_rop(resultSet.getString("talla_rop"));
                ropa.setPrecio(resultSet.getDouble("precio"));

                resultados.add(ropa);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Cerrar recursos (ResultSet, PreparedStatement, Connection)
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return resultados;
    }
    public static List<Ropa> buscarRopaPorTipo(String tipo) {
        Connection conexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Ropa> resultados = new ArrayList<>();

        try {
            conexion = new ConexionPg().getCon();

            // Construir la consulta SQL
            String consultaSQL = "SELECT * FROM ropa r JOIN tipoVendible tv ON r.id_vendible_rop = tv.id_vendible WHERE tv.tipo = ?";

            preparedStatement = conexion.prepareStatement(consultaSQL);
            preparedStatement.setString(1, tipo);

            // Ejecutar la consulta
            resultSet = preparedStatement.executeQuery();

            // Procesar los resultados
            while (resultSet.next()) {
                // Construir objetos Ropa según los resultados y agregarlos a la lista
                Ropa ropa = new Ropa();
                // Setear atributos de la ropa con resultSet.getString("nombre_del_campo")
                // ...
                ropa.setId_rop(resultSet.getInt("id_rop"));
                ropa.setTipo(resultSet.getString("tipo"));
                ropa.setEstado(resultSet.getString("estado"));
                ropa.setTalla_rop(resultSet.getString("talla_rop"));
                ropa.setPrecio(resultSet.getDouble("precio"));

                resultados.add(ropa);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Cerrar recursos (ResultSet, PreparedStatement, Connection)
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return resultados;
    }
    public static List<Ropa> buscarRopaPorEstado(String estado) {
        Connection conexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Ropa> resultados = new ArrayList<>();

        try {
            conexion = new ConexionPg().getCon();

            // Construir la consulta SQL
            String consultaSQL = "SELECT * FROM ropa r JOIN tipoVendible tv ON r.id_vendible_rop = tv.id_vendible WHERE tv.estado = ?";

            preparedStatement = conexion.prepareStatement(consultaSQL);
            preparedStatement.setString(1, estado);

            // Ejecutar la consulta
            resultSet = preparedStatement.executeQuery();

            // Procesar los resultados
            while (resultSet.next()) {
                // Construir objetos Ropa según los resultados y agregarlos a la lista
                Ropa ropa = new Ropa();
                // Setear atributos de la ropa con resultSet.getString("nombre_del_campo")
                // ...
                ropa.setId_rop(resultSet.getInt("id_rop"));
                ropa.setTipo(resultSet.getString("tipo"));
                ropa.setEstado(resultSet.getString("estado"));
                ropa.setTalla_rop(resultSet.getString("talla_rop"));
                ropa.setPrecio(resultSet.getDouble("precio"));

                resultados.add(ropa);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Cerrar recursos (ResultSet, PreparedStatement, Connection)
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return resultados;
    }
    public static List<Ropa> buscarRopaPorTalla(String talla) {
        Connection conexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Ropa> resultados = new ArrayList<>();

        try {
            conexion = new ConexionPg().getCon();

            // Construir la consulta SQL
            String consultaSQL = "SELECT * FROM ropa r JOIN tipoVendible tv ON r.id_vendible_rop = tv.id_vendible WHERE r.talla_rop = ?";

            preparedStatement = conexion.prepareStatement(consultaSQL);
            preparedStatement.setString(1, talla);

            // Ejecutar la consulta
            resultSet = preparedStatement.executeQuery();

            // Procesar los resultados
            while (resultSet.next()) {
                // Construir objetos Ropa según los resultados y agregarlos a la lista
                Ropa ropa = new Ropa();
                // Setear atributos de la ropa con resultSet.getString("nombre_del_campo")
                // ...
                ropa.setId_rop(resultSet.getInt("id_rop"));
                ropa.setTipo(resultSet.getString("tipo"));
                ropa.setEstado(resultSet.getString("estado"));
                ropa.setTalla_rop(resultSet.getString("talla_rop"));
                ropa.setPrecio(resultSet.getDouble("precio"));

                resultados.add(ropa);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Cerrar recursos (ResultSet, PreparedStatement, Connection)
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return resultados;
    }

}
