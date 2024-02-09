package Modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

public class ModeloEstadoSolicitud extends AprobacionSolicitud{
    
    ConexionPg cone = new ConexionPg();
    
    public boolean insertaEstadoSoliciud(int idAdmin) {
        String sql = "INSERT INTO aprobacionsolicitud (fechaAprobacion, aprueba, id_adm_apso, id_soli_apso) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement statement = cone.getCon().prepareStatement(sql);

            // Setear los parámetros
            statement.setDate(1, (Date) getFechaAprobacion());
            statement.setBoolean(2, isAprueba());
            statement.setInt(3, idAdmin);
            statement.setInt(4, getId_soli_apso());

            int rowsAffected = statement.executeUpdate();
            statement.close();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public int traerCodigoDePersonaCrear(String cedula) {
        int codigo = 0;
        try {
            String sql = "SELECT id_adm FROM administrador WHERE id_persona_adm = (SELECT id_persona FROM persona WHERE cedula_usu = ?)";

            PreparedStatement pstmt = cone.getCon().prepareStatement(sql);
            pstmt.setString(1, cedula);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                codigo = rs.getInt("id_adm");
            }

            pstmt.close();
            rs.close();
        } catch (SQLException ex) {
            // Manejo de la excepción
            ex.printStackTrace(); // Imprimir la traza de la excepción para depuración
        }
        return codigo;
    }
    
    public List<String> obtenerSolicitudes() {
        List<String> solicitudes = new ArrayList<>();

        try (Connection connection = new ConexionPg().getCon()) {
            String sql = "SELECT id_soli FROM solicitud";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    int idSolicitud = resultSet.getInt("id_soli");

                    String solicitudFormato = idSolicitud + " ";
                    solicitudes.add(solicitudFormato);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Manejar la excepción según tus necesidades
        }

        return solicitudes;
    }
    
//    public  List<Solicitud> consultarSolictd() {//metodo para cargar todos los registros en el table
//        List<Solicitud> listaSlds = new ArrayList<>();
//
//        try( 
//            Connection conexion = new ConexionPg().getCon();
//                PreparedStatement pst = conexion.prepareStatement("SELECT * FROM solicitud");
//                ResultSet rs = pst.executeQuery()) {
//
//            while (rs.next()) {
//                int id_soli = rs.getInt("id_soli");
//                String razon_soli =rs.getString("razon_soli");
//                Date fecha_soli = rs.getDate("fecha_soli");
//                int id_solicitante_soli = rs.getInt("id_lug");
//
//                              
//                Solicitud c = new Solicitud(id_soli,razon_soli,fecha_soli,id_solicitante_soli);
//                listaSlds.add(c);
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return listaSlds;
//    }   
    
}
