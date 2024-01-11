package Modelo;

import java.util.Date;

public class Donante extends Usuario{
    private int id_donante;
    private String motivo_dont;
    private String entidad_dont;
    private String proyecto_dont;
    private String cedula_usu_dont;

    public Donante() {
        super();
    }

    public Donante(int id_donante, String motivo_dont, String entidad_dont, String proyecto_dont, String cedula_usu_dont, String cedula_usu, String nombre_usu, String apellido_usu, Date fechaNacimiento_usu, Character sexo_usu, String tipoSangre_usu, String correo_usu, String celular_usu, Ciudad ciudad_usu, String direccion_usu, String contraseña_usu) {
        super(cedula_usu, nombre_usu, apellido_usu, fechaNacimiento_usu, sexo_usu, tipoSangre_usu, correo_usu, celular_usu, ciudad_usu, direccion_usu, contraseña_usu);
        this.id_donante = id_donante;
        this.motivo_dont = motivo_dont;
        this.entidad_dont = entidad_dont;
        this.proyecto_dont = proyecto_dont;
        this.cedula_usu_dont = cedula_usu_dont;
    }

    

    public int getId_donante() {
        return id_donante;
    }

    public void setId_donante(int id_donante) {
        this.id_donante = id_donante;
    }

    public String getMotivo_dont() {
        return motivo_dont;
    }

    public void setMotivo_dont(String motivo_dont) {
        this.motivo_dont = motivo_dont;
    }

    public String getEntidad_dont() {
        return entidad_dont;
    }

    public void setEntidad_dont(String entidad_dont) {
        this.entidad_dont = entidad_dont;
    }

    public String getProyecto_dont() {
        return proyecto_dont;
    }

    public void setProyecto_dont(String proyecto_dont) {
        this.proyecto_dont = proyecto_dont;
    }

    public String getCedula_usu_dont() {
        return cedula_usu_dont;
    }

    public void setCedula_usu_dont(String cedula_usu_dont) {
        this.cedula_usu_dont = cedula_usu_dont;
    }

    @Override
    public String toString() {
        return "Donante{" + "id_donante=" + id_donante + ", motivo_dont=" + motivo_dont + ", entidad_dont=" + entidad_dont + ", proyecto_dont=" + proyecto_dont + ", cedula_usu_dont=" + cedula_usu_dont + '}';
    }
    
}
