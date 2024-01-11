package Modelo;

import java.util.Date;

public class Solicitante extends Usuario {

    private int id_solicitante;
    private int numSolicitud;
    private String cedula_usu_sol;

    public Solicitante() {
        super();
    }

    public Solicitante(int id_solicitante, int numSolicitud, String cedula_usu_sol, String cedula_usu, String nombre_usu, String apellido_usu, Date fechaNacimiento_usu, Character sexo_usu, String tipoSangre_usu, String correo_usu, String celular_usu, String ciudad_usu, String direccion_usu, String contraseña_usu) {
        super(cedula_usu, nombre_usu, apellido_usu, fechaNacimiento_usu, sexo_usu, tipoSangre_usu, correo_usu, celular_usu, ciudad_usu, direccion_usu, contraseña_usu);
        this.id_solicitante = id_solicitante;
        this.numSolicitud = numSolicitud;
        this.cedula_usu_sol = cedula_usu_sol;
    }

    public int getId_solicitante() {
        return id_solicitante;
    }

    public void setId_solicitante(int id_solicitante) {
        this.id_solicitante = id_solicitante;
    }

    public int getNumSolicitud() {
        return numSolicitud;
    }

    public void setNumSolicitud(int numSolicitud) {
        this.numSolicitud = numSolicitud;
    }

    public String getCedula_usu_sol() {
        return cedula_usu_sol;
    }

    public void setCedula_usu_sol(String cedula_usu_sol) {
        this.cedula_usu_sol = cedula_usu_sol;
    }

    @Override
    public String toString() {
        return "Solicitante{" + "id_solicitante=" + id_solicitante + ", numSolicitud=" + numSolicitud + ", cedula_usu_sol=" + cedula_usu_sol + '}';
    }

}
