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
public class ModeloMedicamento {

    public static int insertarMedicamento(Medicamentos medicamento) {
        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement(
                        "INSERT INTO medicamento (formaFarmaceutica_med, id_donable_med) VALUES (?, ?) RETURNING id_med")) {

            // Verificar si el objeto Ropa no es nulo antes de acceder a sus propiedades
            if (medicamento != null) {
                pst.setString(1, medicamento.getFormaFarmaceutica_med());

                // Verificar si la propiedad id_vendible_rop no es nula antes de usarla
                if (medicamento.getId_donable_med() != 0) {
                    pst.setInt(2, medicamento.getId_donable_med());
                } else {
                    throw new IllegalArgumentException("Id_donable_med no puede ser nulo");
                    // O manejar de acuerdo a las necesidades de tu aplicación
                }

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    return rs.getInt(1); // Devolver el ID generado por la consulta RETURNING
                }
            } else {
                throw new IllegalArgumentException("El objeto Medicamento no puede ser nulo");
                // O manejar de acuerdo a las necesidades de tu aplicación
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al insertar mueble: " + ex.getMessage());
        }

        return -1; // En caso de error, devolver -1
    }

    public static List<Integer> obtenerIdsMedicamentos() {
        List<Integer> idsMedicamentos = new ArrayList<>();

        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement("SELECT id_med FROM medicamento");
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int idMedicamento = rs.getInt("id_med");
                idsMedicamentos.add(idMedicamento);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al obtener los IDs de medicamento: " + ex.getMessage());
        }

        return idsMedicamentos;
    }

    public static List<Medicamentos> obtenerTodasLosMedicamentos() {
        List<Medicamentos> listaMedicamentos = new ArrayList<>();

        try (Connection conexion = new ConexionPg().getCon();
                Statement stmt = conexion.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM medicamento")) {

            while (rs.next()) {
                Medicamentos medicamento = new Medicamentos();
                medicamento.setId_med(rs.getInt("id_med"));
                medicamento.setFormaFarmaceutica_med(rs.getString("formaFarmaceutica_med"));
                medicamento.setId_donable_med(rs.getInt("id_donable_med"));

                listaMedicamentos.add(medicamento);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al obtener los medicamentos: " + ex.getMessage());
        }

        return listaMedicamentos;
    }

    public static int obtenerUltimoIdMedicamento() {
        int ultimoId = -1;

        try (Connection conexion = new ConexionPg().getCon();
                Statement stmt = conexion.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT MAX(id_med) FROM medicamento")) {

            if (rs.next()) {
                ultimoId = rs.getInt(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al obtener el último ID de medicamento: " + ex.getMessage());
        }

        return ultimoId;
    }

    public static Medicamentos obtenerMedicamentoPorId(int idMed) {
        Medicamentos medicamento = null;

        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement("SELECT * FROM medicamento WHERE id_med = ?")) {

            pst.setInt(1, idMed);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    // Construir un objeto Ropa con los datos obtenidos de la consulta
                    medicamento = new Medicamentos();
                    medicamento.setId_med(rs.getInt("id_med"));
                    medicamento.setFormaFarmaceutica_med(rs.getString("formaFarmaceutica_med"));
                    medicamento.setId_donable_med(rs.getInt("id_donable_med"));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al obtener el Medicamento por ID: " + ex.getMessage());
        }

        return medicamento;
    }

    public static boolean eliminarMedicamento(int idMed) {
        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement("DELETE FROM medicamento WHERE id_med = ?")) {

            // Eliminar primero el registro de la tabla Ropa
            pst.setInt(1, idMed);
            int filasEliminadas = pst.executeUpdate();

            // Verificar si se eliminó correctamente antes de continuar con la cascada
            if (filasEliminadas > 0) {
                // Luego, eliminar el registro correspondiente en la tabla TipoVendible
                int idTipoDonable = obtenerIdTipoDonablePorIdMedicamento(idMed);
                ModeloTipoDonable.eliminarTipoDonable(idTipoDonable);

                // Finalmente, eliminar el registro correspondiente en la tabla Producto
                int idProducto = ModeloTipoDonable.obtenerIdProductoPorIdTipoDonable(idTipoDonable);
                ModeloProducto.eliminarProducto(idProducto);

                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al eliminar el medicamento: " + ex.getMessage());
        }

        return false;
    }

    public static int obtenerIdTipoDonablePorIdMedicamento(int idMedicamento) {
        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement("SELECT id_donable_med FROM medicamento WHERE id_med = ?")) {

            pst.setInt(1, idMedicamento);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getInt("id_donable_med");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al obtener ID de IdDonable por ID de medicamento: " + ex.getMessage());
        }

        return -1;
    }

    public static boolean modificarMedicamento(Medicamentos medicamento) {
        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement(
                        "UPDATE medicamento SET formaFarmaceutica_med=? WHERE id_med=?")) {

            pst.setString(1, medicamento.getFormaFarmaceutica_med());
            pst.setInt(2, medicamento.getId_med());

            int filasActualizadas = pst.executeUpdate();

            return filasActualizadas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al modificar medicamento: " + ex.getMessage());
        }

        return false;
    }

    public static List<Medicamentos> obtenerDetallesMedicamento() {
        List<Medicamentos> detalles = new ArrayList<>();

        // Establecer la conexión a la base de datos (deberías manejar las excepciones)
        try (Connection connection = new ConexionPg().getCon()) {
            // Consulta SQL para obtener los detalles de medicamento
            String sql = "SELECT "
                    + "medicamento.id_med, "
                    + "tipoDonable.nombre_dona, "
                    + "tipoDonable.fechaElaboracion, "
                    + "tipoDonable.fechaVencimiento, "
                    + "medicamento.formaFarmaceutica_med "
                    + "FROM producto "
                    + "JOIN tipoDonable ON tipoDonable.id_pro_dona = producto.id_producto "
                    + "JOIN medicamento ON medicamento.id_donable_med = tipoDonable.id_donable";

            try (PreparedStatement statement = connection.prepareStatement(sql);
                    ResultSet resultSet = statement.executeQuery()) {
                // Iterar a través de los resultados y construir objetos RopaDetalle
                while (resultSet.next()) {
                    Medicamentos detalle = new Medicamentos();
                    detalle.setId_med(resultSet.getInt("id_med"));
                    detalle.setNombre_dona(resultSet.getString("nombre_dona"));
                    detalle.setFechaElaboracion(resultSet.getDate("fechaElaboracion"));
                    detalle.setFechaVencimiento(resultSet.getDate("fechaVencimiento"));
                    detalle.setFormaFarmaceutica_med(resultSet.getString("formaFarmaceutica_med"));

                    detalles.add(detalle);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejar la excepción adecuadamente en tu aplicación
        }

        return detalles;
    }
}
