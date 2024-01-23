package Modelo;

public class Ropa extends TipoVendible {

    private int id_rop;
    private String marca_rop;
    private String talla_rop;
    private String color_rop;
    private String tipo_rop;
    private int id_vendible_rop;

    public Ropa() {
        super();
    }

    public Ropa(int id_rop, String marca_rop, String talla_rop, String color_rop, String tipo_rop, int id_vendible_rop, int id_vendible, double precio, String tipo, int id_pro_ven, int id_pro, String tipo_pro, boolean disponibilidad_pro, String nombre_pro, byte[] imagen_pro) {
        super(id_vendible, precio, tipo, id_pro_ven, id_pro, tipo_pro, disponibilidad_pro, nombre_pro, imagen_pro);
        this.id_rop = id_rop;
        this.marca_rop = marca_rop;
        this.talla_rop = talla_rop;
        this.color_rop = color_rop;
        this.tipo_rop = tipo_rop;
        this.id_vendible_rop = id_vendible_rop;
    }

    public int getId_rop() {
        return id_rop;
    }

    public void setId_rop(int id_rop) {
        this.id_rop = id_rop;
    }

    public String getMarca_rop() {
        return marca_rop;
    }

    public void setMarca_rop(String marca_rop) {
        this.marca_rop = marca_rop;
    }

    public String getTalla_rop() {
        return talla_rop;
    }

    public void setTalla_rop(String talla_rop) {
        this.talla_rop = talla_rop;
    }

    public String getColor_rop() {
        return color_rop;
    }

    public void setColor_rop(String color_rop) {
        this.color_rop = color_rop;
    }

    public String getTipo_rop() {
        return tipo_rop;
    }

    public void setTipo_rop(String tipo_rop) {
        this.tipo_rop = tipo_rop;
    }

    public int getId_vendible_rop() {
        return id_vendible_rop;
    }

    public void setId_vendible_rop(int id_vendible_rop) {
        this.id_vendible_rop = id_vendible_rop;
    }

}
