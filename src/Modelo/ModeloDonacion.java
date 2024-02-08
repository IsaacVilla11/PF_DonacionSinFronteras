/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import Modelo.ConexionPg;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.imageio.ImageIO;
import javax.lang.model.util.Types;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author jose
 */
public class ModeloDonacion {
    
    ConexionPg cone = new ConexionPg();
    
 public boolean insertarDonacion(Donacion donacion, int[] idsProductos, int[] idsDonantes) {
    ConexionPg conexion = new ConexionPg();

    try (Connection conn = conexion.getCon()) {
        conn.setAutoCommit(false);

        // Verificar la existencia de los IDs de productos y donantes en las tablas respectivas
        if (!verificarExistenciaIDs(Arrays.stream(idsProductos).boxed().collect(Collectors.toList()),
                Arrays.stream(idsDonantes).boxed().collect(Collectors.toList()))) {
            System.err.println("Uno o más IDs de productos o donantes no existen en las tablas correspondientes.");
            conn.rollback();
            return false;
        }

        // Insertar la donación en la tabla donacion
        String insertDonacionQuery = "INSERT INTO donacion (cantidad, fecha_donacion) VALUES (?, CURRENT_DATE) RETURNING id_donacion";
        int idDonacionInsertada;

        try (PreparedStatement psDonacion = conn.prepareStatement(insertDonacionQuery)) {
            psDonacion.setInt(1, donacion.getCantidad_pro());
            ResultSet rs = psDonacion.executeQuery();
            rs.next();
            idDonacionInsertada = rs.getInt(1);
        }

        // Insertar los registros en la tabla intermedia donacion_producto_donante
        String insertRelacionQuery = "INSERT INTO detalle_donacion (id_donacion, id_producto, id_donante) VALUES (?, ?, ?)";

        try (PreparedStatement psRelacion = conn.prepareStatement(insertRelacionQuery)) {
            for (int i = 0; i < idsProductos.length; i++) {
                psRelacion.setInt(1, idDonacionInsertada);
                psRelacion.setInt(2, idsProductos[i]);
                psRelacion.setInt(3, idsDonantes[i]);
                psRelacion.addBatch();
            }
            psRelacion.executeBatch();
        }

        conn.commit();
        return true;
    } catch (SQLException e) {
        System.err.println("Error al insertar donación: " + e.getMessage());
        try {
            if (conexion != null) {
                conexion.getCon().rollback();
                conexion.cerrarConexion();
            }
        } catch (SQLException ex) {
            System.err.println("Error al realizar rollback o cerrar la conexión: " + ex.getMessage());
        }
        return false;
    }
}
    public boolean existeProducto(int idProducto) throws SQLException {
        String sql = "SELECT COUNT(*) FROM producto WHERE id_producto = ?";
        try (PreparedStatement statement =  new ConexionPg().getCon().prepareStatement(sql)) {
            statement.setInt(1, idProducto);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        }
        return false;
    }

    public boolean existeDonante(int idDonante) throws SQLException {
        String sql = "SELECT COUNT(*) FROM donante WHERE id_donante = ?";
        try (PreparedStatement statement = new ConexionPg().getCon().prepareStatement(sql)) {
            statement.setInt(1, idDonante);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        }
        return false;
    }
    public boolean verificarExistenciaIDs(List<Integer> idProductos, List<Integer> idDonantes) {
        try {
            // Verificar la existencia de los ID de productos en la tabla 'producto'
            for (Integer idProducto : idProductos) {
                if (!existeProducto(idProducto)) {
                    return false;
                }
            }

            // Verificar la existencia de los ID de donantes en la tabla 'donante'
            for (Integer idDonante : idDonantes) {
                if (!existeDonante(idDonante)) {
                    return false;
                }
            }

            return true; // Todos los IDs existen en las tablas 'producto' y 'donante'
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean actualizarEstadoProducto(int idProducto, boolean disponible) {
        try (Connection conexion = new ConexionPg().getCon()) {
            // Actualizar el estado del producto en la base de datos
            String query = "UPDATE producto SET disponible = ? WHERE id_producto = ?";
            try (PreparedStatement pst = conexion.prepareStatement(query)) {
                pst.setBoolean(1, disponible);
                pst.setInt(2, idProducto);
                int filasActualizadas = pst.executeUpdate();
                return filasActualizadas > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
   public boolean eliminarDonacion(int id_donacion) {
    ConexionPg cpg = new ConexionPg();
    String sqlEliminarDonacion = "DELETE FROM donacion WHERE id_donacion = ? " +
                                  "AND NOT EXISTS (SELECT 1 FROM detalle_donacion WHERE id_donacion = ?) " +
                                  "AND NOT EXISTS (SELECT 1 FROM donante WHERE id_donante_don = ?) " +
                                  "AND id_donacion NOT IN (SELECT id_donacion FROM detalle_donacion)";

    try (Connection conexion = cpg.getCon();
         PreparedStatement pstmtEliminarDonacion = conexion.prepareStatement(sqlEliminarDonacion)) {

        pstmtEliminarDonacion.setInt(1, id_donacion);
        pstmtEliminarDonacion.setInt(2, id_donacion);
        pstmtEliminarDonacion.setInt(3, id_donacion);

        int rowsAffected = pstmtEliminarDonacion.executeUpdate();
        return rowsAffected > 0;

    } catch (SQLException ex) {
        ex.printStackTrace();
        return false;
    }
}
   public void llenarComboBoxProductos(JComboBox<String> cbProducto) {
    try (Connection con = new ConexionPg().getCon();
         Statement stmt = con.createStatement()) {
        // Consulta SQL para seleccionar los productos que no están relacionados con ninguna donación
       String sql = "SELECT id_producto, tipo_pro FROM producto " +
             "WHERE id_producto NOT IN (SELECT DISTINCT id_producto FROM detalle_donacion)";

        ResultSet rs = stmt.executeQuery(sql);
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        while (rs.next()) {
            int idProducto = rs.getInt("id_producto");
            String tipoProducto = rs.getString("tipo_pro");
            model.addElement(idProducto + ": " + tipoProducto);
        }
        cbProducto.setModel(model);
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
    public boolean liberarProducto(int idProducto, int idDonacion) {
    ConexionPg conexion = new ConexionPg();

    try (Connection conn = conexion.getCon()) {
        conn.setAutoCommit(false);

        // Eliminar la relación entre el producto y la donación en la tabla donacion_producto
        String deleteRelacionQuery = "DELETE FROM detalle_donacion  WHERE id_producto = ? AND id_donacion = ?";

        try (PreparedStatement psDeleteRelacion = conn.prepareStatement(deleteRelacionQuery)) {
            psDeleteRelacion.setInt(1, idProducto);
            psDeleteRelacion.setInt(2, idDonacion);

            int filasAfectadas = psDeleteRelacion.executeUpdate();

            if (filasAfectadas > 0) {
                // Si se eliminó la relación, eliminar la donación asociada si ya no está relacionada con otros productos
                String deleteDonacionQuery = "DELETE FROM donacion WHERE id_donacion = ? " +
                                             "AND NOT EXISTS (SELECT 1 FROM detalle_donacion  WHERE id_donacion = ?)";

                try (PreparedStatement psDeleteDonacion = conn.prepareStatement(deleteDonacionQuery)) {
                    psDeleteDonacion.setInt(1, idDonacion);
                    psDeleteDonacion.setInt(2, idDonacion);

                    psDeleteDonacion.executeUpdate();
                }

                conn.commit();
                return true; // La relación y, opcionalmente, la donación asociada fueron eliminadas con éxito
            } else {
                conn.rollback();
                return false; // No se encontró la relación para eliminar
            }
        }
    } catch (SQLException e) {
        System.err.println("Error al liberar producto: " + e.getMessage());
        return false;
    }
}

    // Método para mostrar la foto del producto seleccionado en el JLabel
    public void mostrarFotoProductoSeleccionado(int idProducto, JLabel lblFoto) throws IOException {
        try (Connection con = new ConexionPg().getCon();
             PreparedStatement pstmt = con.prepareStatement("SELECT imagen_pro FROM producto WHERE id_producto = ?")) {
            pstmt.setInt(1, idProducto);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                byte[] imgBytes = rs.getBytes("imagen_pro");
                if (imgBytes != null) {
                    try (ByteArrayInputStream bis = new ByteArrayInputStream(imgBytes)) {
                        Image img = ImageIO.read(bis);
                if (img != null) {
                     img = img.getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH);
                     System.out.println("Se encontró una foto.");
                 } else {
                     System.out.println("No se encontró ninguna foto.");
                     // Si img es null, puedes manejar este caso según tus necesidades.
                     // Por ejemplo, puedes asignar una imagen predeterminada o mostrar un mensaje de error.
                 }
                       lblFoto.setIcon(new ImageIcon(img));
                    }
                } else {
                    lblFoto.setIcon(null);
                }
            }
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }
    }    
    // Método para llenar el ComboBox de donantes
   public void llenarComboBoxDonantes(JComboBox<String> cbDonante) {
    try (Connection con = new ConexionPg().getCon();
         Statement stmt = con.createStatement()) {
        String sql = "SELECT d.id_donante, p.nombre_usu, p.apellido_usu " +
                     "FROM donante d " +
                     "INNER JOIN persona p ON d.id_persona_dont = p.id_persona";
        ResultSet rs = stmt.executeQuery(sql);
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        while (rs.next()) {
            int idDonante = rs.getInt("id_donante");
            String nombre = rs.getString("nombre_usu");
            String apellido = rs.getString("apellido_usu");
            model.addElement(idDonante + ": " + nombre + " " + apellido);
        }
        cbDonante.setModel(model);
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
public  LugarAfectado obtenerDetallesLugarAf(int id_lug) {
        try (Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement("SELECT * FROM lugarafectado WHERE id_lug = ?")) {

            pst.setInt(1, id_lug);  // Establecer el valor del parámetro

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    int id_lugAf = rs.getInt("id_lugaraf");
                    String  situacion= rs.getString("situacion_luaf");
                    String  estado= rs.getString("estado_luaf");
                    int id_luga=rs.getInt("id_lug");
                    String nombreCa = rs.getString("nombre_lug");
                    String dir =rs.getString("direccion_lug");
                    int id_ciudad =rs.getInt("id_ciudad");

                    return new LugarAfectado(id_lugAf,situacion,estado,id_luga,nombreCa,dir,id_ciudad);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }
   
public int obtenerIdProductoExistente(int idProducto) {
        try (Connection con = new ConexionPg().getCon();
             PreparedStatement pstmt = con.prepareStatement("SELECT id_producto FROM producto WHERE id_producto = ?")) {
            pstmt.setInt(1, idProducto);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id_producto");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1; // Retorna -1 si el ID de producto no existe
    }
public List<Detalle_donacion> obtenerDetallesDonacion(int idDonacion) {
    List<Detalle_donacion> detallesDonacion = new ArrayList<>();

    try (Connection conexion = new ConexionPg().getCon();
         PreparedStatement pst = conexion.prepareStatement("SELECT * FROM detalle_donacion WHERE id_donacion = ?")) {
        pst.setInt(1, idDonacion);
        try (ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                int idProducto = rs.getInt("id_producto");
                int idDonante = rs.getInt("id_donante");
                // Aquí puedes obtener otros detalles de producto y donante si es necesario

                Detalle_donacion detalle = new Detalle_donacion(idDonacion, idProducto, idDonante);
                detallesDonacion.add(detalle);
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return detallesDonacion;
}
  public  List<Donacion> consultarDonacion() {//metodo para cargar todos los registros en el table
        List<Donacion> listaCA = new ArrayList<>();

        try( 
            Connection conexion = new ConexionPg().getCon();
                PreparedStatement pst = conexion.prepareStatement("SELECT * FROM donacion");
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int id_donacion = rs.getInt("id_donacion");
                int Cantidad =rs.getInt("cantidad");
               // Obtener la fecha de la columna "fecha_donacion" como un objeto Timestamp
                Date fecha_donacion = rs.getDate("fecha_donacion");               
                Donacion c = new Donacion(id_donacion,Cantidad,fecha_donacion,0,0);
                listaCA.add(c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaCA;
    }   
    // Otros métodos de la clase
public List<Donante> obtenerNombresApellidosDonantes(int idDonante) {
    List<Donante> donantes = new ArrayList<>();

    try (Connection conexion = new ConexionPg().getCon();
         PreparedStatement pst = conexion.prepareStatement(
                 "SELECT p.nombre_usu, p.apellido_usu " +
                         "FROM donante d " +
                         "INNER JOIN persona p ON d.id_persona_dont = p.id_persona " +
                         "WHERE d.id_donante = ?")) {

        pst.setInt(1, idDonante);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            String nombre = rs.getString("nombre_usu");
            String apellido = rs.getString("apellido_usu");

            Donante donante = new Donante(idDonante, null, null, null, 0, 0, null, nombre, apellido, null, null, null, null, null, null, null, null);
            donantes.add(donante);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return donantes;
}
    
 public boolean eliminarDetalle(int id_producto) {
    ConexionPg cpg = new ConexionPg();
    String sqlEliminarDetalle = "DELETE FROM detalle_donacion WHERE id_producto = ?";
    String sqlActualizarCantidad = "UPDATE donacion SET cantidad = cantidad - 1 WHERE id_donacion IN (SELECT id_donacion FROM detalle_donacion WHERE id_producto = ?)";

    try {
        Connection conexion = cpg.getCon();
        
        // Iniciar la transacción
        conexion.setAutoCommit(false);
        
        // Eliminar detalle de donación
        try (PreparedStatement pstmtEliminarDetalle = conexion.prepareStatement(sqlEliminarDetalle);
             PreparedStatement pstmtActualizarCantidad = conexion.prepareStatement(sqlActualizarCantidad)) {
            
            pstmtEliminarDetalle.setInt(1, id_producto);
            int rowsAffectedDetalle = pstmtEliminarDetalle.executeUpdate();

            pstmtActualizarCantidad.setInt(1, id_producto);
            int rowsAffectedCantidad = pstmtActualizarCantidad.executeUpdate();

            // Confirmar la transacción
            conexion.commit();

            // Verificar si se afectaron filas en ambas operaciones
            return rowsAffectedDetalle > 0 && rowsAffectedCantidad > 0;
        }
    } catch (SQLException ex) {
        ex.printStackTrace();

        return false;
    } finally {
        // Restaurar el modo de autocommit y cerrar la conexión

        
    }
}

}
   

  