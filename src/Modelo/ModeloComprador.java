package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ModeloComprador extends Comprador {

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

    public boolean InsertarComprador() {

        String sql = "INSERT INTO comprador (metodoPago_com, estadoCivil_com, id_persona_com)"
                + " VALUES ( ?,?, ?)";
        try {
            PreparedStatement statement = cone.getCon().prepareStatement(sql);
            statement.setString(1, getMetodoPago_com());
            statement.setString(2, getEstadoCivil_com());
            statement.setInt(3, getId_persona());

            int rowsAffected = statement.executeUpdate();
            statement.close();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public List<Comprador> ListaComprador() {
        ConexionPg cone = new ConexionPg();//Conectamos a la base
        String sqls = "SELECT * FROM persona per JOIN comprador compra ON per.id_persona  = compra.id_persona_com";
        ResultSet rs = cone.consultaDB(sqls);
        List<Comprador> compra = new ArrayList<>();
        try {
            while (rs.next()) {
                Comprador mi_compra = new Comprador();

                mi_compra.setMetodoPago_com(rs.getString("metodoPago_com"));
                mi_compra.setEstadoCivil_com(rs.getString("estadoCivil_com"));
                mi_compra.setContraseña_usu(rs.getString("contrasenia_usu"));
                mi_compra.setCedula_usu(rs.getString("cedula_usu"));

                mi_compra.setNombre_usu(rs.getString("nombre_usu"));
                mi_compra.setApellido_usu(rs.getString("apellido_usu"));
                mi_compra.setCorreo_usu(rs.getString("correo_usu"));
                mi_compra.setSexo_usu(rs.getString("sexo_usu"));

                mi_compra.setFechaNacimiento_usu(rs.getString("fechaNacimiento_usu"));

                mi_compra.setDireccion_usu(rs.getString("direccion_usu"));
                mi_compra.setCiudad_usu(rs.getString("ciudad_usu"));
                mi_compra.setCelular_usu(rs.getString("celular_usu"));
                mi_compra.setTipoSangre_usu(rs.getString("tipoSangre_usu"));

                compra.add(mi_compra);
            }
            rs.close();
            System.out.println("Tamaño" + compra.size());
            return compra;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ModeloComprador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            return null;
        }
    }

    // Método para consultar si las credenciales de un comprador son correctas en el registro comprador
    public boolean ConsultarComprador(String usuario, String contrasenia, List<Comprador> compradores) {
        for (Comprador admin : compradores) {
            if (admin.getCedula_usu().equals(usuario) && admin.getContraseña_usu().equals(contrasenia)) {
                return true;
            }
        }
        return false;
    }

    // verificar que no se repita uuna llave primaria 
    public boolean verificarDuplicidadCedula(String cedulaCompra) {
        String sql = "SELECT COUNT(*) AS count FROM comprador WHERE cedula_usu = ?";
        try {
            PreparedStatement statement = cone.getCon().prepareStatement(sql);
            statement.setString(1, cedulaCompra);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("count");
                return count > 0; // Si count > 0, significa que ya existe un registro con ese código
            }
            rs.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
