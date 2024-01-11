package Modelo;

import java.util.Date;

public class Solicitud {

    private int id_soli;
    private String razon_soli;
    private Date fecha_soli;
    private int id_donacion_soli;
    private int id_solicitante_soli;

    public Solicitud() {
    }

    public Solicitud(int id_soli, String razon_soli, Date fecha_soli, int id_donacion_soli, int id_solicitante_soli) {
        this.id_soli = id_soli;
        this.razon_soli = razon_soli;
        this.fecha_soli = fecha_soli;
        this.id_donacion_soli = id_donacion_soli;
        this.id_solicitante_soli = id_solicitante_soli;
    }

    public int getId_soli() {
        return id_soli;
    }

    public void setId_soli(int id_soli) {
        this.id_soli = id_soli;
    }

    public String getRazon_soli() {
        return razon_soli;
    }

    public void setRazon_soli(String razon_soli) {
        this.razon_soli = razon_soli;
    }

    public Date getFecha_soli() {
        return fecha_soli;
    }

    public void setFecha_soli(Date fecha_soli) {
        this.fecha_soli = fecha_soli;
    }

    public int getId_solicitante_soli() {
        return id_solicitante_soli;
    }

    public void setId_solicitante_soli(int id_solicitante_soli) {
        this.id_solicitante_soli = id_solicitante_soli;
    }

    public int getId_donacion_soli() {
        return id_donacion_soli;
    }

    public void setId_donacion_soli(int id_donacion_soli) {
        this.id_donacion_soli = id_donacion_soli;
    }

    @Override
    public String toString() {
        return "Solicitud{" + "id_soli=" + id_soli + ", razon_soli=" + razon_soli + ", fecha_soli=" + fecha_soli + ", id_solicitante_soli=" + id_solicitante_soli + '}';
    }

}
