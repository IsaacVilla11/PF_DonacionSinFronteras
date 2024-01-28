/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModeloDetalleFactura extends DetalleFactura{
    ConexionPg cone = new ConexionPg(); ////Conectamos a la base
    EncabezadoFactura encabezado=new EncabezadoFactura();
    public boolean insertaDetalleFact( ) {
        String sql = "INSERT INTO detallefactura (cant_produ_det, subtotal_det, id_pro_det,id_encabezadoFact_det) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement statement = cone.getCon().prepareStatement(sql);

            // Setear los parámetros
            statement.setInt(1, getCant_produ_det());
            statement.setDouble(2, getSubtotal_det());
            statement.setInt(3, getId_pro_det());
            statement.setInt(4, getId_encabezadoFact_det());

            int rowsAffected = statement.executeUpdate();
            statement.close();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
