package Modelo;

import java.util.Date;

public class RegistroDonacion {

    private int id_regDon;
    private Date fecha_reg;
    private int id_adm_reg;
    private int id_donacion_reg;

    public RegistroDonacion() {
    }

    public RegistroDonacion(int id_regDon, Date fecha_reg, int id_adm_reg, int id_donacion_reg) {
        this.id_regDon = id_regDon;
        this.fecha_reg = fecha_reg;
        this.id_adm_reg = id_adm_reg;
        this.id_donacion_reg = id_donacion_reg;
    }

    public int getId_regDon() {
        return id_regDon;
    }

    public void setId_regDon(int id_regDon) {
        this.id_regDon = id_regDon;
    }

    public Date getFecha_reg() {
        return fecha_reg;
    }

    public void setFecha_reg(Date fecha_reg) {
        this.fecha_reg = fecha_reg;
    }

    public int getId_adm_reg() {
        return id_adm_reg;
    }

    public void setId_adm_reg(int id_adm_reg) {
        this.id_adm_reg = id_adm_reg;
    }

    public int getId_donacion_reg() {
        return id_donacion_reg;
    }

    public void setId_donacion_reg(int id_donacion_reg) {
        this.id_donacion_reg = id_donacion_reg;
    }

    @Override
    public String toString() {
        return "RegistroDonacion{" + "id_regDon=" + id_regDon + ", fecha_reg=" + fecha_reg + ", id_adm_reg=" + id_adm_reg + ", id_donacion_reg=" + id_donacion_reg + '}';
    }

    
}
