package Modelo;

import java.util.Date;

public class Comprador extends Usuario {

    private int id_comprador;
    private String metodoPago_com;
    private String estadoCivil_com;
    private int id_persona_com;

    public Comprador() {
        super();
    }

    public Comprador(int id_comprador, String metodoPago_com, String estadoCivil_com, int id_persona_com, int id_persona, String cedula_usu, String nombre_usu, String apellido_usu, String fechaNacimiento_usu, String sexo_usu, String tipoSangre_usu, String correo_usu, String celular_usu, String ciudad_usu, String direccion_usu, String contraseña_usu) {
        super(id_persona, cedula_usu, nombre_usu, apellido_usu, fechaNacimiento_usu, sexo_usu, tipoSangre_usu, correo_usu, celular_usu, ciudad_usu, direccion_usu, contraseña_usu);
        this.id_comprador = id_comprador;
        this.metodoPago_com = metodoPago_com;
        this.estadoCivil_com = estadoCivil_com;
        this.id_persona_com = id_persona_com;
    }


    public int getId_comprador() {
        return id_comprador;
    }

    public void setId_comprador(int id_comprador) {
        this.id_comprador = id_comprador;
    }


    public String getMetodoPago_com() {
        return metodoPago_com;
    }

    public void setMetodoPago_com(String metodoPago_com) {
        this.metodoPago_com = metodoPago_com;
    }

    public String getEstadoCivil_com() {
        return estadoCivil_com;
    }

    public void setEstadoCivil_com(String estadoCivil_com) {
        this.estadoCivil_com = estadoCivil_com;
    }

    
    public int getId_persona_com() {
        return id_persona_com;
    }

    public void setId_persona_com(int id_persona_com) {
        this.id_persona_com = id_persona_com;
    }

    @Override
    public String toString() {
        return super.toString()+ "Comprador{" + "id_comprador=" + id_comprador + ", metodoPago_com=" + metodoPago_com + ", estadoCivil_com=" + estadoCivil_com + ", id_persona_com=" + id_persona_com + '}';
    }

}
