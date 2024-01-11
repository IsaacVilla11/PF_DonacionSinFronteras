package Modelo;

import java.util.Date;

public class RegistroTransporte {

    private int id_reg_trans;
    private Date fechaInicio_trans;
    private int id_cam_retr;
    private int id_pro_retr;

    public RegistroTransporte() {
    }

    public RegistroTransporte(int id_reg_trans, Date fechaInicio_trans, int id_cam_retr, int id_pro_retr) {
        this.id_reg_trans = id_reg_trans;
        this.fechaInicio_trans = fechaInicio_trans;
        this.id_cam_retr = id_cam_retr;
        this.id_pro_retr = id_pro_retr;
    }

    public int getId_reg_trans() {
        return id_reg_trans;
    }

    public void setId_reg_trans(int id_reg_trans) {
        this.id_reg_trans = id_reg_trans;
    }

    public Date getFechaInicio_trans() {
        return fechaInicio_trans;
    }

    public void setFechaInicio_trans(Date fechaInicio_trans) {
        this.fechaInicio_trans = fechaInicio_trans;
    }

    public int getId_cam_retr() {
        return id_cam_retr;
    }

    public void setId_cam_retr(int id_cam_retr) {
        this.id_cam_retr = id_cam_retr;
    }

    public int getId_pro_retr() {
        return id_pro_retr;
    }

    public void setId_pro_retr(int id_pro_retr) {
        this.id_pro_retr = id_pro_retr;
    }

    @Override
    public String toString() {
        return "RegistroTransporte{" + "id_reg_trans=" + id_reg_trans + ", fechaInicio_trans=" + fechaInicio_trans + ", id_cam_retr=" + id_cam_retr + ", id_pro_retr=" + id_pro_retr + '}';
    }

}
