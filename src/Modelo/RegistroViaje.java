package Modelo;

import java.util.Date;

public class RegistroViaje {

    private int id_viaje;
    private Date fechaFin_via;
    private int id_cam_via;
    private int id_lug_via;

    public RegistroViaje() {
    }

    public RegistroViaje(int id_viaje, Date fechaFin_via, int id_cam_via, int id_lug_via) {
        this.id_viaje = id_viaje;
        this.fechaFin_via = fechaFin_via;
        this.id_cam_via = id_cam_via;
        this.id_lug_via = id_lug_via;
    }

    public int getId_viaje() {
        return id_viaje;
    }

    public void setId_viaje(int id_viaje) {
        this.id_viaje = id_viaje;
    }

    public Date getFechaFin_via() {
        return fechaFin_via;
    }

    public void setFechaFin_via(Date fechaFin_via) {
        this.fechaFin_via = fechaFin_via;
    }

    public int getId_cam_via() {
        return id_cam_via;
    }

    public void setId_cam_via(int id_cam_via) {
        this.id_cam_via = id_cam_via;
    }

    public int getId_lug_via() {
        return id_lug_via;
    }

    public void setId_lug_via(int id_lug_via) {
        this.id_lug_via = id_lug_via;
    }

    @Override
    public String toString() {
        return "RegistroViaje{" + "id_viaje=" + id_viaje + ", fechaFin_via=" + fechaFin_via + ", id_cam_via=" + id_cam_via + ", id_lug_via=" + id_lug_via + '}';
    }

}
