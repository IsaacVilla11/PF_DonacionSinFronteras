package Modelo;

import java.util.Date;

public class Conductor extends Usuario {

    private int id_conductor;
    private String jornada_con;
    private String tipoLicencia_con;
    private String cedula_usu_con;

    public Conductor() {
        super();
    }

    public Conductor(int id_conductor, String jornada_con, String tipoLicencia_con, String cedula_usu_con, String cedula_usu, String nombre_usu, String apellido_usu, Date fechaNacimiento_usu, Character sexo_usu, String tipoSangre_usu, String correo_usu, String celular_usu, Ciudad ciudad_usu, String direccion_usu, String contraseña_usu) {
        super(cedula_usu, nombre_usu, apellido_usu, fechaNacimiento_usu, sexo_usu, tipoSangre_usu, correo_usu, celular_usu, ciudad_usu, direccion_usu, contraseña_usu);
        this.id_conductor = id_conductor;
        this.jornada_con = jornada_con;
        this.tipoLicencia_con = tipoLicencia_con;
        this.cedula_usu_con = cedula_usu_con;
    }

    
    public int getId_conductor() {
        return id_conductor;
    }

    public void setId_conductor(int id_conductor) {
        this.id_conductor = id_conductor;
    }


    public String getJornada_con() {
        return jornada_con;
    }

    public void setJornada_con(String jornada_con) {
        this.jornada_con = jornada_con;
    }

    public String getTipoLicencia_con() {
        return tipoLicencia_con;
    }

    public void setTipoLicencia_con(String tipoLicencia_con) {
        this.tipoLicencia_con = tipoLicencia_con;
    }

    public String getCedula_usu_con() {
        return cedula_usu_con;
    }

    public void setCedula_usu_con(String cedula_usu_con) {
        this.cedula_usu_con = cedula_usu_con;
    }

    @Override
    public String toString() {
        return super.toString()+ "Conductor{" + "id_conductor=" + id_conductor + ", jornada_con=" + jornada_con + ", tipoLicencia_con=" + tipoLicencia_con + ", cedula_usu_con=" + cedula_usu_con + '}';
    }

   

}
