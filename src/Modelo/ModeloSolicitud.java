package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class ModeloSolicitud extends Solicitud{
    ConexionPg cone = new ConexionPg();
    
    public boolean insertarSolicitud(int idSolicitante) {
        String sql = "INSERT INTO solicitud (razon_soli, fecha_soli, id_solicitante_soli) VALUES (?, ?, ?)";
        try {
            PreparedStatement statement = cone.getCon().prepareStatement(sql);

            // Setear los parametros
            statement.setString(1, getRazon_soli());
            statement.setDate(2, (Date) getFecha_soli());
            statement.setInt(3, idSolicitante);

            int rowsAffected = statement.executeUpdate();
            statement.close();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public int obtenerUltimoIdSolicitud() {
        int ultimoId = -1;

        try (Connection conexion = new ConexionPg().getCon();
                Statement stmt = conexion.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT MAX(id_soli) FROM solicitud")) {

            if (rs.next()) {
                ultimoId = rs.getInt(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al obtener el último ID de solicitud: " + ex.getMessage());
        }

        return ultimoId;
    }
    
    public int traerCodigoDePersona(String cedula) {
        int codigo = 0;
        try {
            String sql = "SELECT id_solicitante FROM solicitante WHERE id_persona_soli = (SELECT id_persona FROM persona WHERE cedula_usu = ?)";

            PreparedStatement pstmt = cone.getCon().prepareStatement(sql);
            pstmt.setString(1, cedula);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                codigo = rs.getInt("id_solicitante");
            }

            pstmt.close();
            rs.close();
        } catch (SQLException ex) {
            // Manejo de la excepción
            ex.printStackTrace(); // Imprimir la traza de la excepción para depuración
        }
        return codigo;
    }
}
