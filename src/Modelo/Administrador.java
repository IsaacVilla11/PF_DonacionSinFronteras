package Modelo;

import java.util.Date;

public class Administrador extends Usuario {

    private int id_adm;
    private String cargo_adm;
    private String cedula_usu_adm;

    public Administrador() {
        super();
    }

    public Administrador(int id_adm, String cargo_adm, String cedula_usu_adm, String cedula_usu, String nombre_usu, String apellido_usu, Date fechaNacimiento_usu, Character sexo_usu, String tipoSangre_usu, String correo_usu, String celular_usu, Ciudad ciudad_usu, String direccion_usu, String contraseña_usu) {
        super(cedula_usu, nombre_usu, apellido_usu, fechaNacimiento_usu, sexo_usu, tipoSangre_usu, correo_usu, celular_usu, ciudad_usu, direccion_usu, contraseña_usu);
        this.id_adm = id_adm;
        this.cargo_adm = cargo_adm;
        this.cedula_usu_adm = cedula_usu_adm;
    }

    public int getId_adm() {
        return id_adm;
    }

    public void setId_adm(int id_adm) {
        this.id_adm = id_adm;
    }

    public String getCargo_adm() {
        return cargo_adm;
    }

    public void setCargo_adm(String cargo_adm) {
        this.cargo_adm = cargo_adm;
    }

    public String getCedula_usu_adm() {
        return cedula_usu_adm;
    }

    public void setCedula_usu_adm(String cedula_usu_adm) {
        this.cedula_usu_adm = cedula_usu_adm;
    }

    @Override
    public String toString() {
        return "Administrador{" + "id_adm=" + id_adm + ", cargo_adm=" + cargo_adm + ", cedula_usu_adm=" + cedula_usu_adm + '}';
    }

}
