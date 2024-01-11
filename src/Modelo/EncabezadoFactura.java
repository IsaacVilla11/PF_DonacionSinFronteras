package Modelo;

import java.util.Date;

public class EncabezadoFactura {

    private int id_encabezado;
    private Date fecha_fact;
    private double total;
    private int id_comprador_fact;

    public EncabezadoFactura() {
    }

    public EncabezadoFactura(int id_encabezado, Date fecha_fact, double total, int id_comprador_fact) {
        this.id_encabezado = id_encabezado;
        this.fecha_fact = fecha_fact;
        this.total = total;
        this.id_comprador_fact = id_comprador_fact;
    }

    public int getId_encabezado() {
        return id_encabezado;
    }

    public void setId_encabezado(int id_encabezado) {
        this.id_encabezado = id_encabezado;
    }

    public Date getFecha_fact() {
        return fecha_fact;
    }

    public void setFecha_fact(Date fecha_fact) {
        this.fecha_fact = fecha_fact;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getId_comprador_fact() {
        return id_comprador_fact;
    }

    public void setId_comprador_fact(int id_comprador_fact) {
        this.id_comprador_fact = id_comprador_fact;
    }

    @Override
    public String toString() {
        return "EncabezadoFactura{" + "id_encabezado=" + id_encabezado + ", fecha_fact=" + fecha_fact + ", total=" + total + ", id_comprador_fact=" + id_comprador_fact + '}';
    }

}
