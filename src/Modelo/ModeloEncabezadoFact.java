/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.sun.jdi.connect.spi.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModeloEncabezadoFact extends EncabezadoFactura{

    ConexionPg cone = new ConexionPg(); ////Conectamos a la base
    ModeloComprador comprador=new ModeloComprador();
   
    public boolean insertaEncabezadoFact(int idComprador) {
    String sql = "INSERT INTO encabezadofactura (fecha_fact, total, id_comprador_fact) VALUES (?, ?, ?)";
    try {
        PreparedStatement statement = cone.getCon().prepareStatement(sql);

        // Setear los parámetros
        statement.setDate(1, (Date) getFecha_fact());
        statement.setDouble(2, getTotal());
        statement.setInt(3, idComprador);

        int rowsAffected = statement.executeUpdate();
        statement.close();

        return rowsAffected > 0;
    } catch (SQLException ex) {
        ex.printStackTrace();
        return false;
    }
}

    public int obtenerUltimoIdEncabezado() {
        int ultimoId = -1;

        try (java.sql.Connection conexion = new ConexionPg().getCon();
                Statement stmt = conexion.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT MAX(id_encabezadoFact) FROM encabezadofactura")) {

            if (rs.next()) {
                ultimoId = rs.getInt(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error al obtener el último ID de encabezadofactura: " + ex.getMessage());
        }

        return ultimoId;
    }
    
// metodo para sacar el id incremental para relacionar las tablas
    public int traerCodigoDePersonaCrear(String cedula) {
        int codigo = 0;
        try {
            String sql = "SELECT id_comprador FROM comprador WHERE id_persona_com = (SELECT id_persona FROM persona WHERE cedula_usu = ?)";

            PreparedStatement pstmt = cone.getCon().prepareStatement(sql);
            pstmt.setString(1, cedula);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                codigo = rs.getInt("id_comprador");
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

