package Modelo;

import java.util.Date;

public class Usuario {
    private int id_persona;
    private String cedula_usu;
    private String nombre_usu;
    private String apellido_usu;
    private String fechaNacimiento_usu;
    private String sexo_usu;
    private String tipoSangre_usu;
    private String correo_usu;
    private String celular_usu;
    private String ciudad_usu;
    private String direccion_usu;
    private String contraseña_usu;

    public Usuario() {
    }

    public Usuario(int id_persona, String cedula_usu, String nombre_usu, String apellido_usu, String fechaNacimiento_usu, String sexo_usu, String tipoSangre_usu, String correo_usu, String celular_usu, String ciudad_usu, String direccion_usu, String contraseña_usu) {
        this.id_persona = id_persona;
        this.cedula_usu = cedula_usu;
        this.nombre_usu = nombre_usu;
        this.apellido_usu = apellido_usu;
        this.fechaNacimiento_usu = fechaNacimiento_usu;
        this.sexo_usu = sexo_usu;
        this.tipoSangre_usu = tipoSangre_usu;
        this.correo_usu = correo_usu;
        this.celular_usu = celular_usu;
        this.ciudad_usu = ciudad_usu;
        this.direccion_usu = direccion_usu;
        this.contraseña_usu = contraseña_usu;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    

    public String getCedula_usu() {
        return cedula_usu;
    }

    public void setCedula_usu(String cedula_usu) {
        this.cedula_usu = cedula_usu;
    }

    public String getNombre_usu() {
        return nombre_usu;
    }

    public void setNombre_usu(String nombre_usu) {
        this.nombre_usu = nombre_usu;
    }

    public String getApellido_usu() {
        return apellido_usu;
    }

    public void setApellido_usu(String apellido_usu) {
        this.apellido_usu = apellido_usu;
    }

    public String getFechaNacimiento_usu() {
        return fechaNacimiento_usu;
    }

    public void setFechaNacimiento_usu(String fechaNacimiento_usu) {
        this.fechaNacimiento_usu = fechaNacimiento_usu;
    }

    public String getSexo_usu() {
        return sexo_usu;
    }

    public void setSexo_usu(String sexo_usu) {
        this.sexo_usu = sexo_usu;
    }

    public String getTipoSangre_usu() {
        return tipoSangre_usu;
    }

    public void setTipoSangre_usu(String tipoSangre_usu) {
        this.tipoSangre_usu = tipoSangre_usu;
    }

    public String getCorreo_usu() {
        return correo_usu;
    }

    public void setCorreo_usu(String correo_usu) {
        this.correo_usu = correo_usu;
    }

    public String getCelular_usu() {
        return celular_usu;
    }

    public void setCelular_usu(String celular_usu) {
        this.celular_usu = celular_usu;
    }

    public String getCiudad_usu() {
        return ciudad_usu;
    }

    public void setCiudad_usu(String ciudad_usu) {
        this.ciudad_usu = ciudad_usu;
    }

    public String getDireccion_usu() {
        return direccion_usu;
    }

    public void setDireccion_usu(String direccion_usu) {
        this.direccion_usu = direccion_usu;
    }

    public String getContraseña_usu() {
        return contraseña_usu;
    }

    public void setContraseña_usu(String contraseña_usu) {
        this.contraseña_usu = contraseña_usu;
    }

    @Override
    public String toString() {
        return "Usuario{" + "cedula_usu=" + cedula_usu + ", nombre_usu=" + nombre_usu + ", apellido_usu=" + apellido_usu + ", fechaNacimiento_usu=" + fechaNacimiento_usu + ", sexo_usu=" + sexo_usu + ", tipoSangre_usu=" + tipoSangre_usu + ", correo_usu=" + correo_usu + ", celular_usu=" + celular_usu + ", ciudad_usu=" + ciudad_usu + ", direccion_usu=" + direccion_usu + ", contrase\u00f1a_usu=" + contraseña_usu + '}';
    }
    
}
