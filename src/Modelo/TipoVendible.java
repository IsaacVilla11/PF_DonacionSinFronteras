package Modelo;

public class TipoVendible extends Producto {

    private int id_vendible;
    private double precio;
    private String tipo;
    private String estado;
    private int id_pro_ven;

    public TipoVendible() {
        super();
    }

    public TipoVendible(int id_vendible, double precio, String tipo, String estado, int id_pro_ven, int id_producto, String tipo_pro, byte[] imagen_pro) {
        super(id_producto, tipo_pro, imagen_pro);
        this.id_vendible = id_vendible;
        this.precio = precio;
        this.tipo = tipo;
        this.estado = estado;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
