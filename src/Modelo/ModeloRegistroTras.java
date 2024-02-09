/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import Modelo.Lugar;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ASUS TUF
 */
public class ModeloRegistroTras {

    ConexionPg cone = new ConexionPg();

    public List<String> listarNombresLugaresConId() {
        String sql = "SELECT id_lug, nombre_lug FROM lugar";
        ResultSet rs = cone.consultaDB(sql);
        List<String> lugares = new ArrayList<>();

        try {
            while (rs.next()) {
                int idLugar = rs.getInt("id_lug");
                String nombreLugar = rs.getString("nombre_lug");
                String idNombreLugar = idLugar + " - " + nombreLugar;
                lugares.add(idNombreLugar);
            }
            rs.close();
            return lugares;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<String> obtenerIdMarcaCamiones() {
        String sql = "SELECT id_cam, marca_cam FROM camion";
        ResultSet rs = cone.consultaDB(sql);
        List<String> idMarcaCamiones = new ArrayList<>();

        try {
            while (rs.next()) {
                String idMarcaCamion = rs.getInt("id_cam") + " - " + rs.getString("marca_cam");
                idMarcaCamiones.add(idMarcaCamion);
            }
            rs.close();
            return idMarcaCamiones;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

   public List<Long> obtenerIdDonacionesSinRegistroTransporte() {
    String sql = "SELECT id_donacion FROM donacion WHERE NOT EXISTS (SELECT 1 FROM registro_transporte WHERE registro_transporte.id_donacion = donacion.id_donacion)";
    ResultSet rs = cone.consultaDB(sql);
    List<Long> idDonaciones = new ArrayList<>();

    try {
        while (rs.next()) {
            long idDonacion = rs.getLong("id_donacion");
            idDonaciones.add(idDonacion);
        }
        rs.close();
        return idDonaciones;
    } catch (SQLException ex) {
        ex.printStackTrace();
        return null;
    }
}

   public boolean insertarRegistroTransporte(RegistroTransporte registro) {
    String sql = "INSERT INTO registro_transporte (fecha_llegada, id_cam_retr, id_lugar, id_donacion) VALUES (?, ?, ?, ?)";

    ConexionPg cone = new ConexionPg();
    Connection connection = null;
    PreparedStatement statement = null;

    try {
        connection = cone.getCon();
        statement = connection.prepareStatement(sql);

        // Obtener el ID del lugar
        int idLugar = obtenerIdLugar(registro.getId_lugar());

        statement.setDate(1, new java.sql.Date(registro.getFecha_llegada().getTime()));
        statement.setInt(2, registro.getId_cam_retr());
        statement.setInt(3, idLugar); // Usar el ID del lugar obtenido
        statement.setInt(4, registro.getId_donacion());

        int filasAfectadas = statement.executeUpdate();

        // Si se insertó al menos una fila, retornamos true
        return filasAfectadas > 0;
    } catch (SQLException e) {
        System.err.println("Error al insertar registro de transporte: " + e.getMessage());
        e.printStackTrace();  // Puedes ajustar esto según tus necesidades

        return false;
    } finally {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

private int obtenerIdLugarPorNombre(Connection connection, String nombreLugar) throws SQLException {
    String sql = "SELECT id_lug FROM lugar WHERE nombre_lug = ?";
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    try {
        statement = connection.prepareStatement(sql);
        statement.setString(1, nombreLugar);
        resultSet = statement.executeQuery();

        if (resultSet.next()) {
            return resultSet.getInt("id_lug");
        } else {
            // Si no se encuentra el lugar en la tabla lugar, buscar en la tabla centroAcopio
            return obtenerIdLugarCentroAcopioPorNombre(connection, nombreLugar);
        }
    } finally {
        // Cerrar recursos
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
    }
}

private int obtenerIdLugarCentroAcopioPorNombre(Connection connection, String nombreLugar) throws SQLException {
    String sql = "SELECT id_lug FROM centroAcopio WHERE nombre_lug = ?";
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    try {
        statement = connection.prepareStatement(sql);
        statement.setString(1, nombreLugar);
        resultSet = statement.executeQuery();

        if (resultSet.next()) {
            return resultSet.getInt("id_lug");
        } else {
            // Si no se encuentra el lugar en la tabla centroAcopio, retornar un valor predeterminado o lanzar una excepción según lo deseado
            return -1; // Valor predeterminado o lanzar excepción
        }
    } finally {
        // Cerrar recursos
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
    }
}

    private int obtenerIdLugar(int idLugar) {
    ConexionPg cone = new ConexionPg();
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    int idLugarPadre = idLugar; // Por defecto, asumimos que el ID recibido es el ID de la tabla lugar

    try {
        connection = cone.getCon();
        String sql = "SELECT id_lug FROM lugar WHERE id_lug = ?";
        statement = connection.prepareStatement(sql);
        statement.setInt(1, idLugar);

        resultSet = statement.executeQuery();

        // Si el ID recibido no corresponde a la tabla lugar, buscamos su ID padre en la jerarquía de herencia
        if (!resultSet.next()) {
            // Si el ID no está en la tabla lugar, buscamos en las tablas hijas (centroAcopio y lugarAfectado)
            sql = "SELECT id_lug FROM centroacopio WHERE id_lug = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, idLugar);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                idLugarPadre = resultSet.getInt("id_lug"); // El ID recibido pertenece a la tabla centroAcopio
            } else {
                sql = "SELECT id_lug FROM lugarafectado WHERE id_lug = ?";
                statement = connection.prepareStatement(sql);
                statement.setInt(1, idLugar);

                resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    idLugarPadre = resultSet.getInt("id_lug"); // El ID recibido pertenece a la tabla lugarAfectado
                } else {
                    // Si el ID no está en ninguna tabla de la jerarquía de herencia, no se encontró el ID padre
                    throw new IllegalArgumentException("El ID recibido no corresponde a ninguna tabla de la jerarquía de herencia.");
                }
            }
        }
    } catch (SQLException e) {
        // Manejar la excepción según sea necesario
        e.printStackTrace();
    } finally {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException ex) {
            // Manejar la excepción según sea necesario
            ex.printStackTrace();
        }
    }

    return idLugarPadre;
}
    
    public List<RegistroTransporte> obtenerRegistrosConDatosCompletos() {
        List<RegistroTransporte> registros = new ArrayList<>();
        String sql = "SELECT rt.id_reg_trans, rt.fecha_salida, rt.fecha_llegada, "
                + "rt.id_cam_retr, c.id_cam, c.marca_cam, "
                + "l.id_lug, l.nombre_lug, "
                + "rt.id_donacion FROM registro_transporte rt "
                + "JOIN camion c ON rt.id_cam_retr = c.id_cam "
                + "JOIN lugar l ON rt.id_lugar = l.id_lug "
                + "JOIN donacion d ON rt.id_donacion = d.id_donacion";

        ResultSet rs = cone.consultaDB(sql);

        try {
            while (rs.next()) {
                RegistroTransporte registro = new RegistroTransporte();
                registro.setId_reg_trans(rs.getInt("id_reg_trans"));
                registro.setFecha_salida(rs.getDate("fecha_salida"));
                registro.setFecha_llegada(rs.getDate("fecha_llegada"));
                registro.setId_cam_retr(rs.getInt("id_cam_retr"));
                registro.setId_cam(rs.getInt("id_cam"));
                registro.setMarca_cam(rs.getString("marca_cam"));
                registro.setId_lugar(rs.getInt("id_lug"));

                // Crear un nuevo objeto Lugar y asignar el nombre
                Lugar lugar = new Lugar();
                lugar.setId_lug(rs.getInt("id_lug"));
                lugar.setNombre_lug(rs.getString("nombre_lug"));

                // Asignar el objeto Lugar al registro
                registro.setLugar(lugar);

                registro.setId_donacion(rs.getInt("id_donacion"));
                registros.add(registro);
            }
            rs.close();
            return registros;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    //buscar 
    public boolean existeRegistroTransporteConID(int idRegistro) {
        boolean existe = false;
        try {
            // Crear la conexión a la base de datos
            Connection conexion = cone.getCon();

            String consulta = "SELECT * FROM registro_transporte WHERE id_reg_trans = ?";

            try ( PreparedStatement pst = conexion.prepareStatement(consulta)) {

                pst.setInt(1, idRegistro);

                try ( ResultSet rs = pst.executeQuery()) {
                    existe = rs.next();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return existe;
    }

    public RegistroTransporte obtenerRegistroConDatosCompletosPorID(int idRegistro) {
        RegistroTransporte registro = null;
        try {

            Connection conexion = cone.getCon();

            String consulta = "SELECT * FROM registro_transporte WHERE id_reg_trans = ?";

            try ( PreparedStatement pst = conexion.prepareStatement(consulta)) {
                // Establecer el ID como parámetro en la consulta
                pst.setInt(1, idRegistro);

                // Ejecutar la consulta y obtener el resultado
                try ( ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        // Crear un objeto RegistroTransporte con los datos obtenidos
                        registro = new RegistroTransporte();
                        registro.setId_reg_trans(rs.getInt("id_reg_trans"));
                        registro.setFecha_salida(rs.getDate("fecha_salida"));
                        registro.setFecha_llegada(rs.getDate("fecha_llegada"));
                        registro.setId_cam_retr(rs.getInt("id_cam_retr"));
                        registro.setId_lugar(rs.getInt("id_lugar"));
                        registro.setId_donacion(rs.getInt("id_donacion"));

                        // Obtener información de lugar
                        Lugar lugar = obtenerLugarPorID(rs.getInt("id_lugar"));
                        registro.setLugar(lugar);

                        Camion camion = obtenerCamionPorID(rs.getInt("id_cam_retr"));
                        registro.setMarca_cam(camion.getMarca_cam());

                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registro;
    }

// Método para obtener información de lugar por ID
    private Lugar obtenerLugarPorID(int idLugar) {
        Lugar lugar = null;
        try {
            Connection conexion = cone.getCon();
            String consulta = "SELECT * FROM lugar WHERE id_lug = ?";
            try ( PreparedStatement pst = conexion.prepareStatement(consulta)) {
                pst.setInt(1, idLugar);
                try ( ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        lugar = new Lugar();
                        lugar.setId_lug(rs.getInt("id_lug"));
                        lugar.setNombre_lug(rs.getString("nombre_lug"));
                        // Puedes agregar más campos según la estructura de tu base de datos
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lugar;
    }

// Método para obtener información de camión por ID
    private Camion obtenerCamionPorID(int idCamion) {
        Camion camion = null;
        try {
            Connection conexion = cone.getCon();
            String consulta = "SELECT * FROM camion WHERE id_cam = ?";
            try ( PreparedStatement pst = conexion.prepareStatement(consulta)) {
                pst.setInt(1, idCamion);
                try ( ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        camion = new Camion();
                        camion.setId_cam(rs.getInt("id_cam"));
                        camion.setMarca_cam(rs.getString("marca_cam"));
                        // Puedes agregar más campos según la estructura de tu base de datos
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return camion;
    }
public boolean existeRegistroTransporteParaDonacion(int idDonacion) {
    ConexionPg cone = new ConexionPg();
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    boolean existeRegistro = false;

    try {
        connection = cone.getCon();
        String sql = "SELECT id_reg_trans FROM registro_transporte WHERE id_donacion = ?";
        statement = connection.prepareStatement(sql);
        statement.setInt(1, idDonacion);
        resultSet = statement.executeQuery();

        // Si hay resultados, significa que hay al menos un registro de transporte asociado a la donación
        if (resultSet.next()) {
            existeRegistro = true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    return existeRegistro;
}
    //gurdar cambios
    public boolean actualizarRegistroTransporte(RegistroTransporte registro) {
        String sql = "UPDATE registro_transporte SET fecha_llegada = ?, id_cam_retr = ?, id_lugar = ?, id_donacion = ? WHERE id_reg_trans = ?";

        ConexionPg cone = new ConexionPg();
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = cone.getCon();
            statement = connection.prepareStatement(sql);

            statement.setDate(1, new java.sql.Date(registro.getFecha_llegada().getTime()));
            statement.setInt(2, registro.getId_cam_retr());
            statement.setInt(3, registro.getId_lugar());
            statement.setInt(4, registro.getId_donacion());
            statement.setInt(5, registro.getId_reg_trans());

            int filasAfectadas = statement.executeUpdate();

            // Si se actualizó al menos una fila, retornamos true
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar registro de transporte: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public boolean eliminarRegistroPorId(int idRegistro) {
        Connection conexion = null;
        PreparedStatement statement = null;

        try {
            conexion = cone.getCon();
            statement = conexion.prepareStatement("DELETE FROM registro_transporte WHERE id_reg_trans = ?");

            statement.setInt(1, idRegistro);

            int filasAfectadas = statement.executeUpdate();

            // Verificar si se eliminó correctamente
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción según tus necesidades
            return false;
        } finally {
          
        }
    }

}
