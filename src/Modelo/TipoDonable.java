package Modelo;

import java.util.Date;

public class TipoDonable extends Producto {

    private int id_donable;
    private int cantidad_dona;
    private Date fechaVencimiento;
    private int id_pro_dona;

    public TipoDonable() {
        super();
    }

    public TipoDonable(int id_donable, int cantidad_dona, Date fechaVencimiento, int id_pro_dona, int id_pro, String tipo_pro, boolean disponibilidad_pro, String nombre_pro, byte[] imagen_pro) {
        super(id_pro, tipo_pro, disponibilidad_pro, nombre_pro, imagen_pro);
        this.id_donable = id_donable;
        this.cantidad_dona = cantidad_dona;
        this.fechaVencimiento = fechaVencimiento;
        this.id_pro_dona = id_pro_dona;
    }

    public int getId_donable() {
        return id_donable;
    }

    public void setId_donable(int id_donable) {
        this.id_donable = id_donable;
    }

    public int getCantidad_dona() {
        return cantidad_dona;
    }

    public void setCantidad_dona(int cantidad_dona) {
        this.cantidad_dona = cantidad_dona;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getId_pro_dona() {
        return id_pro_dona;
    }

    public void setId_pro_dona(int id_pro_dona) {
        this.id_pro_dona = id_pro_dona;
    }

    @Override
    public String toString() {
        return "TipoDonable{" + "id_donable=" + id_donable + ", cantidad_dona=" + cantidad_dona + ", fechaVencimiento=" + fechaVencimiento + ", id_pro_dona=" + id_pro_dona + '}';
    }

}
