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
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
