package Modelo;

import java.util.Date;

public class RegistroConductor {

    private int id_reco;
    private Date fecha_reg;
    private int id_adm_reco;
    private int id_conductor_reco;

    public RegistroConductor() {
    }

    public RegistroConductor(int id_reco, Date fecha_reg, int id_adm_reco, int id_conductor_reco) {
        this.id_reco = id_reco;
        this.fecha_reg = fecha_reg;
        this.id_adm_reco = id_adm_reco;
        this.id_conductor_reco = id_conductor_reco;
    }

    public int getId_reco() {
        return id_reco;
    }

    public void setId_reco(int id_reco) {
        this.id_reco = id_reco;
    }

    public Date getFecha_reg() {
        return fecha_reg;
    }

    public void setFecha_reg(Date fecha_reg) {
        this.fecha_reg = fecha_reg;
    }

    public int getId_adm_reco() {
        return id_adm_reco;
    }

    public void setId_adm_reco(int id_adm_reco) {
        this.id_adm_reco = id_adm_reco;
    }

    public int getId_conductor_reco() {
        return id_conductor_reco;
    }

    public void setId_conductor_reco(int id_conductor_reco) {
        this.id_conductor_reco = id_conductor_reco;
    }

    @Override
    public String toString() {
        return "RegistroConductor{" + "id_reco=" + id_reco + ", fecha_reg=" + fecha_reg + ", id_adm_reco=" + id_adm_reco + ", id_conductor_reco=" + id_conductor_reco + '}';
    }

}
