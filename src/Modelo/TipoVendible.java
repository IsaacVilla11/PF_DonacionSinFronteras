package Modelo;

public class TipoVendible extends Producto {

    private int id_vendible;
    private double precio;
    private String tamaño;
    private String tipo;
    private int id_pro_ven;

    public TipoVendible() {
        super();
    }

    public TipoVendible(int id_vendible, double precio, String tamaño, String tipo, int id_pro_ven, int id_pro, String tipo_pro, boolean disponibilidad_pro, String nombre_pro, byte[] imagen_pro) {
        super(id_pro, tipo_pro, disponibilidad_pro, nombre_pro, imagen_pro);
        this.id_vendible = id_vendible;
        this.precio = precio;
        this.tamaño = tamaño;
        this.tipo = tipo;
        this.id_pro_ven = id_pro_ven;
    }

    public int getId_vendible() {
        return id_vendible;
    }

    public void setId_vendible(int id_vendible) {
        this.id_vendible = id_vendible;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId_pro_ven() {
        return id_pro_ven;
    }

    public void setId_pro_ven(int id_pro_ven) {
        this.id_pro_ven = id_pro_ven;
    }

    @Override
    public String toString() {
        return "TipoVendible{" + "id_vendible=" + id_vendible + ", precio=" + precio + ", tama\u00f1o=" + tamaño + ", tipo=" + tipo + ", id_pro_ven=" + id_pro_ven + '}';
    }

}
