package Modelo;

import java.util.Date;

public class AprobacionSolicitud {

    private int id_aprobacionSoli;
    private Date fechaAprobacion;
    private boolean aprueba;
    private int id_adm_apso;
    private int id_soli_apso;

    public AprobacionSolicitud() {
    }

    public AprobacionSolicitud(int id_aprobacionSoli, Date fechaAprobacion, boolean aprueba, int id_adm_apso, int id_soli_apso) {
        this.id_aprobacionSoli = id_aprobacionSoli;
        this.fechaAprobacion = fechaAprobacion;
        this.aprueba = aprueba;
        this.id_adm_apso = id_adm_apso;
        this.id_soli_apso = id_soli_apso;
    }

    public int getId_aprobacionSoli() {
        return id_aprobacionSoli;
    }

    public void setId_aprobacionSoli(int id_aprobacionSoli) {
        this.id_aprobacionSoli = id_aprobacionSoli;
    }

    public Date getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(Date fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    public boolean isAprueba() {
        return aprueba;
    }

    public void setAprueba(boolean aprueba) {
        this.aprueba = aprueba;
    }

    public int getId_adm_apso() {
        return id_adm_apso;
    }

    public void setId_adm_apso(int id_adm_apso) {
        this.id_adm_apso = id_adm_apso;
    }

    public int getId_soli_apso() {
        return id_soli_apso;
    }

    public void setId_soli_apso(int id_soli_apso) {
        this.id_soli_apso = id_soli_apso;
    }

    @Override
    public String toString() {
        return "AprobacionSolicitud{" + "id_aprobacionSoli=" + id_aprobacionSoli + ", fechaAprobacion=" + fechaAprobacion + ", aprueba=" + aprueba + ", id_adm_apso=" + id_adm_apso + ", id_soli_apso=" + id_soli_apso + '}';
    }

}
