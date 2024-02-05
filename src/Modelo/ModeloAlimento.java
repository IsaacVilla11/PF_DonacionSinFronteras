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
public class ModeloAlimento {

    public static int insertarAlimento(Alimentos alimento) {
        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement(
                        "INSERT INTO alimento (tipo_ali, id_donable_ali) VALUES (?, ?) RETURNING id_ali")) {

            // Verificar si el objeto Ropa no es nulo antes de acceder a sus propiedades
            if (alimento != null) {
                pst.setString(1, alimento.getTipo_ali());

                // Verificar si la propiedad id_vendible_rop no es nula antes de usarla
                if (alimento.getId_donable_ali() != 0) {
                    pst.setInt(2, alimento.getId_donable_ali());
                } else {
                    throw new IllegalArgumentException("id_donable_ali no puede ser nulo");
                    // O manejar de acuerdo a las necesidades de tu aplicación
                }

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    return rs.getInt(1); // Devolver el ID generado por la consulta RETURNING
                }
            } else {
                throw new IllegalArgumentException("El objeto alimento no puede ser nulo");
                // O manejar de acuerdo a las necesidades de tu aplicación
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al insertar alimento: " + ex.getMessage());
        }

        return -1; // En caso de error, devolver -1
    }

    public static List<Integer> obtenerIdsAlimentos() {
        List<Integer> idsAlimentos = new ArrayList<>();

        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement("SELECT id_ali FROM alimento");
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int idAlimento = rs.getInt("id_ali");
                idsAlimentos.add(idAlimento);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al obtener los IDs de alimentoa: " + ex.getMessage());
        }

        return idsAlimentos;
    }

    public static List<Alimentos> obtenerTodasLosAlimentos() {
        List<Alimentos> listaAlimentos = new ArrayList<>();

        try (Connection conexion = new ConexionPg().getCon();
                Statement stmt = conexion.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM alimento")) {

            while (rs.next()) {
                Alimentos alimento = new Alimentos();
                alimento.setId_ali(rs.getInt("id_ali"));
                alimento.setTipo_ali(rs.getString("tipo_ali"));
                alimento.setId_donable_ali(rs.getInt("id_donable_ali"));

                listaAlimentos.add(alimento);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al obtener los alimentos: " + ex.getMessage());
        }

        return listaAlimentos;
    }

    public static int obtenerUltimoIdAlimento() {
        int ultimoId = -1;

        try (Connection conexion = new ConexionPg().getCon();
                Statement stmt = conexion.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT MAX(id_ali) FROM alimento")) {

            if (rs.next()) {
                ultimoId = rs.getInt(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al obtener el último ID de alimento: " + ex.getMessage());
        }

        return ultimoId;
    }

    public static Alimentos obtenerAlimentoPorId(int idAli) {
        Alimentos alimento = null;

        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement("SELECT * FROM alimento WHERE id_ali = ?")) {

            pst.setInt(1, idAli);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    // Construir un objeto Ropa con los datos obtenidos de la consulta
                    alimento = new Alimentos();
                    alimento.setId_ali(rs.getInt("id_ali"));
                    alimento.setTipo_ali(rs.getString("tipo_ali"));
                    alimento.setId_donable_ali(rs.getInt("id_donable_ali"));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al obtener el alimento por ID: " + ex.getMessage());
        }

        return alimento;
    }

    public static boolean eliminarAlimento(int idAli) {
        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement("DELETE FROM alimento WHERE id_ali = ?")) {

            // Eliminar primero el registro de la tabla Ropa
            pst.setInt(1, idAli);
            int filasEliminadas = pst.executeUpdate();

            // Verificar si se eliminó correctamente antes de continuar con la cascada
            if (filasEliminadas > 0) {
                // Luego, eliminar el registro correspondiente en la tabla TipoVendible
                int idTipoDonable = obtenerIdTipoDonablePorIdAlimento(idAli);
                ModeloTipoDonable.eliminarTipoDonable(idTipoDonable);

                // Finalmente, eliminar el registro correspondiente en la tabla Producto
                int idProducto = ModeloTipoDonable.obtenerIdProductoPorIdTipoDonable(idTipoDonable);
                ModeloProducto.eliminarProducto(idProducto);

                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al eliminar el alimento: " + ex.getMessage());
        }

        return false;
    }

    public static int obtenerIdTipoDonablePorIdAlimento(int idAlimento) {
        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement("SELECT id_donable_ali FROM alimento WHERE id_ali = ?")) {

            pst.setInt(1, idAlimento);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getInt("id_donable_ali");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al obtener ID de IdDonable por ID de alimento: " + ex.getMessage());
        }

        return -1;
    }

    public static boolean modificarAlimento(Alimentos alimento) {
        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement(
                        "UPDATE alimento SET tipo_ali=? WHERE id_ali=?")) {

            pst.setString(1, alimento.getTipo_ali());
            pst.setInt(2, alimento.getId_ali());

            int filasActualizadas = pst.executeUpdate();

            return filasActualizadas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al modificar alimento: " + ex.getMessage());
        }

        return false;
    }

    public static List<Alimentos> obtenerDetallesAlimentos() {
        List<Alimentos> detalles = new ArrayList<>();

        // Establecer la conexión a la base de datos (deberías manejar las excepciones)
        try (Connection connection = new ConexionPg().getCon()) {
            // Consulta SQL para obtener los detalles de medicamento
            String sql = "SELECT "
                    + "alimento.id_ali, "
                    + "tipoDonable.nombre_dona, "
                    + "tipoDonable.fechaElaboracion, "
                    + "tipoDonable.fechaVencimiento, "
                    + "alimento.tipo_ali "
                    + "FROM producto "
                    + "JOIN tipoDonable ON tipoDonable.id_pro_dona = producto.id_producto "
                    + "JOIN alimento ON alimento.id_donable_ali = tipoDonable.id_donable";

            try (PreparedStatement statement = connection.prepareStatement(sql);
                    ResultSet resultSet = statement.executeQuery()) {
                // Iterar a través de los resultados y construir objetos RopaDetalle
                while (resultSet.next()) {
                    Alimentos detalle = new Alimentos();
                    detalle.setId_ali(resultSet.getInt("id_ali"));
                    detalle.setNombre_dona(resultSet.getString("nombre_dona"));
                    detalle.setFechaElaboracion(resultSet.getDate("fechaElaboracion"));
                    detalle.setFechaVencimiento(resultSet.getDate("fechaVencimiento"));
                    detalle.setTipo_ali(resultSet.getString("tipo_ali"));

                    detalles.add(detalle);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejar la excepción adecuadamente en tu aplicación
        }

        return detalles;
    }
}
