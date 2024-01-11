package Modelo;

import java.util.Date;

public class Donacion {

    private int id_donacion;
    private int cantidad_don;
    private Date fechaDonacion;
    private int id_pro_don;
    private int id_donante_don;

    public Donacion() {
    }

    public Donacion(int id_donacion, int cantidad_don, Date fechaDonacion, int id_pro_don, int id_donante_don) {
        this.id_donacion = id_donacion;
        this.cantidad_don = cantidad_don;
        this.fechaDonacion = fechaDonacion;
        this.id_pro_don = id_pro_don;
        this.id_donante_don = id_donante_don;
    }

    public int getId_donacion() {
        return id_donacion;
    }

    public void setId_donacion(int id_donacion) {
        this.id_donacion = id_donacion;
    }

    public int getCantidad_don() {
        return cantidad_don;
    }

    public void setCantidad_don(int cantidad_don) {
        this.cantidad_don = cantidad_don;
    }

    public Date getFechaDonacion() {
        return fechaDonacion;
    }

    public void setFechaDonacion(Date fechaDonacion) {
        this.fechaDonacion = fechaDonacion;
    }

    public int getId_pro_don() {
        return id_pro_don;
    }

    public void setId_pro_don(int id_pro_don) {
        this.id_pro_don = id_pro_don;
    }

    public int getId_donante_don() {
        return id_donante_don;
    }

    public void setId_donante_don(int id_donante_don) {
        this.id_donante_don = id_donante_don;
    }

    @Override
    public String toString() {
        return "Donacion{" + "id_donacion=" + id_donacion + ", cantidad_don=" + cantidad_don + ", fechaDonacion=" + fechaDonacion + ", id_pro_don=" + id_pro_don + ", id_donante_don=" + id_donante_don + '}';
    }

}
