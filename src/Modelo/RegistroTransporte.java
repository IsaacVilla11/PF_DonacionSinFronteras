package Modelo;

import java.util.Date;

public class RegistroTransporte extends Camion{

    private int id_reg_trans;
    private Date Fecha_salida;
    private Date fecha_llegada;
    private int id_cam_retr;
    private int id_lugar;
    private int id_donacion;
private Lugar lugar;
        

    public RegistroTransporte() {
    }

    public RegistroTransporte(int id_reg_trans, Date Fecha_salida, Date fecha_llegada, int id_cam_retr, int id_lugar, int id_donacion) {
        this.id_reg_trans = id_reg_trans;
        this.Fecha_salida = Fecha_salida;
        this.fecha_llegada = fecha_llegada;
        this.id_cam_retr = id_cam_retr;
        this.id_lugar = id_lugar;
        this.id_donacion = id_donacion;
    }

    public RegistroTransporte(int id_reg_trans, Date Fecha_salida, Date fecha_llegada, int id_cam_retr, int id_lugar, int id_donacion, int id_cam, String marca_cam, String color_cam, String modelo_cam, int peso_max_cam, int id_conductor_cam) {
        super(id_cam, marca_cam, color_cam, modelo_cam, peso_max_cam, id_conductor_cam);
        this.id_reg_trans = id_reg_trans;
        this.Fecha_salida = Fecha_salida;
        this.fecha_llegada = fecha_llegada;
        this.id_cam_retr = id_cam_retr;
        this.id_lugar = id_lugar;
        this.id_donacion = id_donacion;
    }

    public RegistroTransporte(int id_reg_trans, Date Fecha_salida, Date fecha_llegada, int id_cam_retr, int id_lugar, int id_donacion, int id_cam, String marca_cam, String color_cam, String modelo_cam, int peso_max_cam, int id_conductor_cam, int id_conductor, String jornada_con, String tipoLicencia_con, int id_persona_con, int id_persona, String cedula_usu, String nombre_usu, String apellido_usu, String fechaNacimiento_usu, String sexo_usu, String tipoSangre_usu, String correo_usu, String celular_usu, String ciudad_usu, String direccion_usu, String contraseña_usu) {
        super(id_cam, marca_cam, color_cam, modelo_cam, peso_max_cam, id_conductor_cam, id_conductor, jornada_con, tipoLicencia_con, id_persona_con, id_persona, cedula_usu, nombre_usu, apellido_usu, fechaNacimiento_usu, sexo_usu, tipoSangre_usu, correo_usu, celular_usu, ciudad_usu, direccion_usu, contraseña_usu);
        this.id_reg_trans = id_reg_trans;
        this.Fecha_salida = Fecha_salida;
        this.fecha_llegada = fecha_llegada;
        this.id_cam_retr = id_cam_retr;
        this.id_lugar = id_lugar;
        this.id_donacion = id_donacion;
    }

    public int getId_reg_trans() {
        return id_reg_trans;
    }

    public Date getFecha_salida() {
        return Fecha_salida;
    }

    public Date getFecha_llegada() {
        return fecha_llegada;
    }

    public int getId_cam_retr() {
        return id_cam_retr;
    }

    public int getId_lugar() {
        return id_lugar;
    }

    public int getId_donacion() {
        return id_donacion;
    }

    public void setId_reg_trans(int id_reg_trans) {
        this.id_reg_trans = id_reg_trans;
    }

    public void setFecha_salida(Date Fecha_salida) {
        this.Fecha_salida = Fecha_salida;
    }

    public void setFecha_llegada(Date fecha_llegada) {
        this.fecha_llegada = fecha_llegada;
    }

    public void setId_cam_retr(int id_cam_retr) {
        this.id_cam_retr = id_cam_retr;
    }

    public void setId_lugar(int id_lugar) {
        this.id_lugar = id_lugar;
    }

    public void setId_donacion(int id_donacion) {
        this.id_donacion = id_donacion;
    }

    
    
        public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }
    
    
    @Override
    public String toString() {
        return "RegistroTransporte{" + "id_reg_trans=" + id_reg_trans + ", Fecha_salida=" + Fecha_salida + ", fecha_llegada=" + fecha_llegada + ", id_cam_retr=" + id_cam_retr + ", id_lugar=" + id_lugar + ", id_donacion=" + id_donacion + '}';
    }
    

   
}
