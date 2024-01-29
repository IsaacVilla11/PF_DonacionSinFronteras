package Modelo;

public class Producto {

    private int id_producto;
    private String tipo_pro;
    private byte[] imagen_pro;

    public Producto() {
    }

    public Producto(int id_producto, String tipo_pro, byte[] imagen_pro) {
        this.id_producto = id_producto;
        this.tipo_pro = tipo_pro;
        this.imagen_pro = imagen_pro;
    }

    public Producto(String tipo_pro, byte[] imagen_pro) {
        this.tipo_pro = tipo_pro;
        this.imagen_pro = imagen_pro;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getTipo_pro() {
        return tipo_pro;
    }

    public void setTipo_pro(String tipo_pro) {
        this.tipo_pro = tipo_pro;
    }

    public byte[] getImagen_pro() {
        return imagen_pro;
    }

    public void setImagen_pro(byte[] imagen_pro) {
        this.imagen_pro = imagen_pro;
    }

}
