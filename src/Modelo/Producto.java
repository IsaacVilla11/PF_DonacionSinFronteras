package Modelo;

public class Producto {

    private int id_producto;
    private String tipo_pro;
    private boolean disponibilidad_pro;
    private String nombre_pro;
    private byte[] imagen_pro;

    public Producto() {
    }

    public Producto(int id_producto, String tipo_pro, boolean disponibilidad_pro, String nombre_pro, byte[] imagen_pro) {
        this.id_producto = id_producto;
        this.tipo_pro = tipo_pro;
        this.disponibilidad_pro = disponibilidad_pro;
        this.nombre_pro = nombre_pro;
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

    public boolean isDisponibilidad_pro() {
        return disponibilidad_pro;
    }

    public void setDisponibilidad_pro(boolean disponibilidad_pro) {
        this.disponibilidad_pro = disponibilidad_pro;
    }

    public String getNombre_pro() {
        return nombre_pro;
    }

    public void setNombre_pro(String nombre_pro) {
        this.nombre_pro = nombre_pro;
    }

    public byte[] getImagen_pro() {
        return imagen_pro;
    }

    public void setImagen_pro(byte[] imagen_pro) {
        this.imagen_pro = imagen_pro;
    }

    @Override
    public String toString() {
        return "Producto{" + "id_producto=" + id_producto + ", tipo_pro=" + tipo_pro + ", disponibilidad_pro=" + disponibilidad_pro + ", nombre_pro=" + nombre_pro + ", imagen_pro=" + imagen_pro + '}';
    }


}
