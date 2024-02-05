package Modelo;

import java.util.Date;

public class TipoDonable extends Producto {

    private int id_donable;
    private String nombre_dona;
    private Date fechaElaboracion;
    private Date fechaVencimiento;
    private int id_pro_dona;

    public TipoDonable() {
        super();
    }

    public TipoDonable(int id_donable, String nombre_dona, Date fechaElaboracion, Date fechaVencimiento, int id_pro_dona, int id_producto, String tipo_pro, byte[] imagen_pro) {
        super(id_producto, tipo_pro, imagen_pro);
        this.id_donable = id_donable;
        this.nombre_dona = nombre_dona;
        this.fechaElaboracion = fechaElaboracion;
        this.fechaVencimiento = fechaVencimiento;
        this.id_pro_dona = id_pro_dona;
    }

    public TipoDonable(int id_donable, String nombre_dona, Date fechaElaboracion, Date fechaVencimiento, int id_pro_dona) {
        this.id_donable = id_donable;
        this.nombre_dona = nombre_dona;
        this.fechaElaboracion = fechaElaboracion;
        this.fechaVencimiento = fechaVencimiento;
        this.id_pro_dona = id_pro_dona;
    }

    public int getId_donable() {
        return id_donable;
    }

    public void setId_donable(int id_donable) {
        this.id_donable = id_donable;
    }

    public String getNombre_dona() {
        return nombre_dona;
    }

    public void setNombre_dona(String nombre_dona) {
        this.nombre_dona = nombre_dona;
    }

    public Date getFechaElaboracion() {
        return fechaElaboracion;
    }

    public void setFechaElaboracion(Date fechaElaboracion) {
        this.fechaElaboracion = fechaElaboracion;
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

}
