package Modelo;

import java.util.Date;

public class Registra {

    private int id_reg;
    private Date fecha_reg;
    private int id_adm_reg;
    private int id_donacion_reg;

    public Registra() {
    }

    public Registra(int id_reg, Date fecha_reg, int id_adm_reg, int id_donacion_reg) {
        this.id_reg = id_reg;
        this.fecha_reg = fecha_reg;
        this.id_adm_reg = id_adm_reg;
        this.id_donacion_reg = id_donacion_reg;
    }

    public int getId_reg() {
        return id_reg;
    }

    public void setId_reg(int id_reg) {
        this.id_reg = id_reg;
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
        return "Registra{" + "id_reg=" + id_reg + ", fecha_reg=" + fecha_reg + ", id_adm_reg=" + id_adm_reg + ", id_donacion_reg=" + id_donacion_reg + '}';
    }

}
