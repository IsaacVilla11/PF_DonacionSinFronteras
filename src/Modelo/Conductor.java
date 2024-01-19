package Modelo;

import java.util.Date;

public class Conductor extends Usuario {

    private int id_conductor;
    private String jornada_con;
    private String tipoLicencia_con;
    private int id_persona_con;

    public Conductor() {
        super();
    }

    public Conductor(int id_conductor, String jornada_con, String tipoLicencia_con, int id_persona_con, int id_persona, String cedula_usu, String nombre_usu, String apellido_usu, String fechaNacimiento_usu, String sexo_usu, String tipoSangre_usu, String correo_usu, String celular_usu, String ciudad_usu, String direccion_usu, String contraseña_usu) {
        super(id_persona, cedula_usu, nombre_usu, apellido_usu, fechaNacimiento_usu, sexo_usu, tipoSangre_usu, correo_usu, celular_usu, ciudad_usu, direccion_usu, contraseña_usu);
        this.id_conductor = id_conductor;
        this.jornada_con = jornada_con;
        this.tipoLicencia_con = tipoLicencia_con;
        this.id_persona_con = id_persona_con;
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

    public int getId_persona_con() {
        return id_persona_con;
    }

    public void setId_persona_con(int id_persona_con) {
        this.id_persona_con = id_persona_con;
    }

    @Override
    public String toString() {
        return super.toString()+ "Conductor{" + "id_conductor=" + id_conductor + ", jornada_con=" + jornada_con + ", tipoLicencia_con=" + tipoLicencia_con + ", id_persona_con=" + id_persona_con + '}';
    }



   

}
