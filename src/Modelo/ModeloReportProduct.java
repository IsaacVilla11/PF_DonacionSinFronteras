/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class ModeloReportProduct {

    public List<EncabezadoFactura> obtenerReport() {
        List<EncabezadoFactura> detalles = new ArrayList<>();

        try ( Connection connection = new ConexionPg().getCon()) {
            String sql = "SELECT id_encabezadofact, fecha_fact, total FROM encabezadofactura";

            try ( PreparedStatement statement = connection.prepareStatement(sql);  ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    EncabezadoFactura enca = new EncabezadoFactura();
                    enca.setId_encabezadoFact(resultSet.getInt("id_encabezadofact"));
                    enca.setFecha_fact(resultSet.getDate("fecha_fact"));
                    enca.setTotal(resultSet.getDouble("total"));

                    detalles.add(enca);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejar la excepción adecuadamente en tu aplicación
        }

        return detalles;
    }
}
