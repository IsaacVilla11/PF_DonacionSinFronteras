package Modelo;

import java.util.Date;

public class EncabezadoFactura {

    private int id_encabezadoFact;
    private Date fecha_fact;
    private double total;
    private int id_comprador_fact;

    public EncabezadoFactura() {
    }

    public EncabezadoFactura(int id_encabezadoFact, Date fecha_fact, double total, int id_comprador_fact) {
        this.id_encabezadoFact = id_encabezadoFact;
        this.fecha_fact = fecha_fact;
        this.total = total;
        this.id_comprador_fact = id_comprador_fact;
    }

    public int getId_encabezadoFact() {
        return id_encabezadoFact;
    }

    public void setId_encabezadoFact(int id_encabezadoFact) {
        this.id_encabezadoFact = id_encabezadoFact;
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
        return "EncabezadoFactura{" + "id_encabezadoFact=" + id_encabezadoFact + ", fecha_fact=" + fecha_fact + ", total=" + total + ", id_comprador_fact=" + id_comprador_fact + '}';
    }

   

}
