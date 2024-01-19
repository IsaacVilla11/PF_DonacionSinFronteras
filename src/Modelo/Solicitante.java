package Modelo;

import java.util.Date;

public class Solicitante extends Usuario {

    private int id_solicitante;
    private int numSolicitud;
    private int id_persona_soli;

    public Solicitante() {
        super();
    }

    public Solicitante(int id_solicitante, int numSolicitud, int id_persona_soli, int id_persona, String cedula_usu, String nombre_usu, String apellido_usu, String fechaNacimiento_usu, String sexo_usu, String tipoSangre_usu, String correo_usu, String celular_usu, String ciudad_usu, String direccion_usu, String contraseña_usu) {
        super(id_persona, cedula_usu, nombre_usu, apellido_usu, fechaNacimiento_usu, sexo_usu, tipoSangre_usu, correo_usu, celular_usu, ciudad_usu, direccion_usu, contraseña_usu);
        this.id_solicitante = id_solicitante;
        this.numSolicitud = numSolicitud;
        this.id_persona_soli = id_persona_soli;
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

    public int getId_persona_soli() {
        return id_persona_soli;
    }

    public void setId_persona_soli(int id_persona_soli) {
        this.id_persona_soli = id_persona_soli;
    }

    @Override
    public String toString() {
        return super.toString()+ "Solicitante{" + "id_solicitante=" + id_solicitante + ", numSolicitud=" + numSolicitud + ", id_persona_soli=" + id_persona_soli + '}';
    }


}
