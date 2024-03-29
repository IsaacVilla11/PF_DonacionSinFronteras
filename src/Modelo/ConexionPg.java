package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionPg {

    String cadenaConexion = "jdbc:postgresql://localhost:5432/PF_DonacionSinFronteras"; // NOmbre de la base en postgres
    String userPG = "postgres";
    String passPG = "1234"; //Cada uno pone su Contraseña 

    Connection con;

    public ConexionPg() {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionPg.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            con = DriverManager.getConnection(cadenaConexion, userPG, passPG);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionPg.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ResultSet consultaDB(String query) {
        //Ejecutar query que devuelvan datos.
        try {
            Statement st = con.createStatement();
            return st.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionPg.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public SQLException accionBD(String sql) {
        // boolean resultado=false;
        try {
            Statement st = con.createStatement();
            st.execute(sql);//True si devuelve objeto y F sino se hizo
            st.close();//CERRAMOS CON.
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionPg.class.getName()).log(Level.SEVERE, null, ex);
            return ex;
        }

    }

    public Connection getCon() {
        return con;
    }

    public void cerrarConexion() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Manejar la excepción, por ejemplo, imprimir un mensaje de error
        }
    }
    public void rollback() {
    try {
        if (con != null) {
            con.rollback();
            System.out.println("Rollback realizado con éxito.");
        }
    } catch (SQLException ex) {
        System.err.println("Error al realizar rollback: " + ex.getMessage());
    }
}
}
