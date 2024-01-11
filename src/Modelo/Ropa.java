package Modelo;

public class Ropa extends TipoVendible {

    private int id_rop;
    private String marca_rop;
    private String talla_rop;
    private int id_vendible_rop;

    public Ropa() {
        super();
    }

    public Ropa(int id_rop, String marca_rop, String talla_rop, int id_vendible_rop, int id_vendible, double precio, String tamaño, String tipo, int id_pro_ven, int id_pro, String tipo_pro, boolean disponibilidad_pro, String nombre_pro, byte[] imagen_pro) {
        super(id_vendible, precio, tamaño, tipo, id_pro_ven, id_pro, tipo_pro, disponibilidad_pro, nombre_pro, imagen_pro);
        this.id_rop = id_rop;
        this.marca_rop = marca_rop;
        this.talla_rop = talla_rop;
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

    public int getId_vendible_rop() {
        return id_vendible_rop;
    }

    public void setId_vendible_rop(int id_vendible_rop) {
        this.id_vendible_rop = id_vendible_rop;
    }

    @Override
    public String toString() {
        return "Ropa{" + "id_rop=" + id_rop + ", marca_rop=" + marca_rop + ", talla_rop=" + talla_rop + ", id_vendible_rop=" + id_vendible_rop + '}';
    }

}
