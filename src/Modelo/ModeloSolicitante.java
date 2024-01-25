package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ModeloSolicitante extends Solicitante{
    ConexionPg cone = new ConexionPg(); ////Conectamos a la base
    
    public boolean InsertarPersona(String fecha) {
        Date date = new Date();

        SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
        fecha = formatofecha.format(date);
        java.sql.Date fechasql = java.sql.Date.valueOf(fecha);
        String sql = "INSERT INTO persona (cedula_usu, nombre_usu, apellido_usu, fechaNacimiento_usu, sexo_usu, tipoSangre_usu, correo_usu, celular_usu, ciudad_usu, direccion_usu,contrasenia_usu)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = cone.getCon().prepareStatement(sql);

            statement.setString(1, getCedula_usu());
            statement.setString(2, getNombre_usu());
            statement.setString(3, getApellido_usu());
            statement.setDate(4, fechasql);
            statement.setString(5, getSexo_usu());
            statement.setString(6, getTipoSangre_usu());
            statement.setString(7, getCorreo_usu());
            statement.setString(8, getCelular_usu());
            statement.setString(9, getCiudad_usu());
            statement.setString(10, getDireccion_usu());
            statement.setString(11, getContraseña_usu());

            int rowsAffected = statement.executeUpdate();
            statement.close();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean InsertarSolicitante() {

        String sql = "INSERT INTO solicitante (id_persona_soli)"
                + " VALUES ( ?)";
        try {
            PreparedStatement statement = cone.getCon().prepareStatement(sql);
            statement.setInt(1, getId_persona());

            int rowsAffected = statement.executeUpdate();
            statement.close();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public List<Solicitante> ListaSolicitante() {
        ConexionPg cone = new ConexionPg();//Conectamos a la base
        String sqls = "SELECT * FROM persona per JOIN solicitante soli ON per.id_persona  = soli.id_persona_soli";
        ResultSet rs = cone.consultaDB(sqls);
        List<Solicitante> solic = new ArrayList<>();
        try {
            while (rs.next()) {
                Solicitante mi_solic = new Solicitante();
                
                mi_solic.setContraseña_usu(rs.getString("contrasenia_usu"));
                mi_solic.setCedula_usu(rs.getString("cedula_usu"));

                mi_solic.setNombre_usu(rs.getString("nombre_usu"));
                mi_solic.setApellido_usu(rs.getString("apellido_usu"));
                mi_solic.setCorreo_usu(rs.getString("correo_usu"));
                mi_solic.setSexo_usu(rs.getString("sexo_usu"));

                mi_solic.setFechaNacimiento_usu(rs.getString("fechaNacimiento_usu"));

                mi_solic.setDireccion_usu(rs.getString("direccion_usu"));
                mi_solic.setCiudad_usu(rs.getString("ciudad_usu"));
                mi_solic.setCelular_usu(rs.getString("celular_usu"));
                mi_solic.setTipoSangre_usu(rs.getString("tipoSangre_usu"));

                solic.add(mi_solic);
            }
            rs.close();
            System.out.println("Tamaño" + solic.size());
            return solic;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ModeloSolicitante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
