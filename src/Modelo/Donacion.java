package Modelo;

import java.security.Timestamp;
import java.util.Date;

public class Donacion {

    private int id_donacion;
    private int cantidad_pro;
    private Date fechaDonacion;
    private int id_pro_don;
    private int id_donante_don;

    public Donacion(int id_donacion, int cantidad_pro, Date fechaDonacion, int id_pro_don, int id_donante_don) {
        this.id_donacion = id_donacion;
        this.cantidad_pro = cantidad_pro;
        this.fechaDonacion = fechaDonacion;
        this.id_pro_don = id_pro_don;
        this.id_donante_don = id_donante_don;
    }

    public Donacion() {
    }

    public int getId_donacion() {
        return id_donacion;
    }

    public void setId_donacion(int id_donacion) {
        this.id_donacion = id_donacion;
    }

    public int getCantidad_pro() {
        return cantidad_pro;
    }

    public void setCantidad_pro(int cantidad_pro) {
        this.cantidad_pro = cantidad_pro;
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
        return "Donacion{" + "id_donacion=" + id_donacion + ", cantidad_pro=" + cantidad_pro + ", fechaDonacion=" + fechaDonacion + ", id_pro_don=" + id_pro_don + ", id_donante_don=" + id_donante_don + '}';
    }

   

   

}