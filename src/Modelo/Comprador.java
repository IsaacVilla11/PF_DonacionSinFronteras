package Modelo;

import java.util.Date;

public class Comprador extends Usuario {

    private int id_comprador;
    private int numCompras_com;
    private String cedula_usu_com;

    public Comprador() {
        super();
    }

    public Comprador(int id_comprador, int numCompras_com, String cedula_usu_com, String cedula_usu, String nombre_usu, String apellido_usu, Date fechaNacimiento_usu, Character sexo_usu, String tipoSangre_usu, String correo_usu, String celular_usu, Ciudad ciudad_usu, String direccion_usu, String contraseña_usu) {
        super(cedula_usu, nombre_usu, apellido_usu, fechaNacimiento_usu, sexo_usu, tipoSangre_usu, correo_usu, celular_usu, ciudad_usu, direccion_usu, contraseña_usu);
        this.id_comprador = id_comprador;
        this.numCompras_com = numCompras_com;
        this.cedula_usu_com = cedula_usu_com;
    }

    

    public int getId_comprador() {
        return id_comprador;
    }

    public void setId_comprador(int id_comprador) {
        this.id_comprador = id_comprador;
    }

    public int getNumCompras_com() {
        return numCompras_com;
    }

    public void setNumCompras_com(int numCompras_com) {
        this.numCompras_com = numCompras_com;
    }

    public String getCedula_usu_com() {
        return cedula_usu_com;
    }

    public void setCedula_usu_com(String cedula_usu_com) {
        this.cedula_usu_com = cedula_usu_com;
    }

    @Override
    public String toString() {
        return "Comprador{" + "id_comprador=" + id_comprador + ", numCompras_com=" + numCompras_com + ", cedula_usu_com=" + cedula_usu_com + '}';
    }

}
