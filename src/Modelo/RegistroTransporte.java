package Modelo;

import java.util.Date;

public class RegistroTransporte {

    private int id_reg_trans;
    private Date Fecha_salida;
    private Date fecha_llegada;
    private int id_cam_retr;
    private int id_lugar;
    private int id_pro_retr;

    public RegistroTransporte() {
    }

    public RegistroTransporte(int id_reg_trans, Date Fecha_salida, Date fecha_llegada, int id_cam_retr, int id_lugar, int id_pro_retr) {
        this.id_reg_trans = id_reg_trans;
        this.Fecha_salida = Fecha_salida;
        this.fecha_llegada = fecha_llegada;
        this.id_cam_retr = id_cam_retr;
        this.id_lugar = id_lugar;
        this.id_pro_retr = id_pro_retr;
    }

    public int getId_reg_trans() {
        return id_reg_trans;
    }

    public void setId_reg_trans(int id_reg_trans) {
        this.id_reg_trans = id_reg_trans;
    }

    public Date getFecha_salida() {
        return Fecha_salida;
    }

    public void setFecha_salida(Date Fecha_salida) {
        this.Fecha_salida = Fecha_salida;
    }

    public Date getFecha_llegada() {
        return fecha_llegada;
    }

    public void setFecha_llegada(Date fecha_llegada) {
        this.fecha_llegada = fecha_llegada;
    }

    public int getId_cam_retr() {
        return id_cam_retr;
    }

    public void setId_cam_retr(int id_cam_retr) {
        this.id_cam_retr = id_cam_retr;
    }

    public int getId_lugar() {
        return id_lugar;
    }

    public void setId_lugar(int id_lugar) {
        this.id_lugar = id_lugar;
    }

    

    public int getId_pro_retr() {
        return id_pro_retr;
    }

    public void setId_pro_retr(int id_pro_retr) {
        this.id_pro_retr = id_pro_retr;
    }

    @Override
    public String toString() {
        return "RegistroTransporte{" + "id_reg_trans=" + id_reg_trans + ", Fecha_salida=" + Fecha_salida + ", fecha_llegada=" + fecha_llegada + ", id_cam_retr=" + id_cam_retr + ", id_lugar=" + id_lugar + ", id_pro_retr=" + id_pro_retr + '}';
    }

   
}
