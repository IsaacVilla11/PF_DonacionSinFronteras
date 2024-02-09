package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModeloReportSolicitudes {
    
    public List<Solicitud> obtenerReport() {
    List<Solicitud> detalles = new ArrayList<>();

    try (Connection connection = new ConexionPg().getCon()) {
        // Corrige la sintaxis en la cláusula WHERE
        String sql = "SELECT id_solicitante_soli, id_soli, fecha_soli, razon_soli FROM solicitud";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            // Asigna el valor del parámetro idPersona al PreparedStatement
            //statement.setInt(1, idPersona);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Solicitud soli = new Solicitud();
                    
                    soli.setId_solicitante_soli(resultSet.getInt("id_solicitante_soli"));
                    soli.setId_soli(resultSet.getInt("id_soli"));                  
                    soli.setFecha_soli(resultSet.getDate("fecha_soli"));
                    soli.setRazon_soli(resultSet.getString("razon_soli"));
                    
                    detalles.add(soli);
                }
            }
        } 
    } catch (SQLException e) {
        e.printStackTrace(); // Manejar la excepción adecuadamente en tu aplicación
    }

    return detalles;
}
    
}
