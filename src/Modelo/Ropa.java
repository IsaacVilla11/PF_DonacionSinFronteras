package Modelo;

public class Ropa extends TipoVendible {

    private int id_rop;
    private String talla_rop;
    private int id_vendible_rop;

    public Ropa() {
        super();
    }

    public Ropa(int id_rop, String talla_rop, int id_vendible_rop) {
        this.id_rop = id_rop;
        this.talla_rop = talla_rop;
        this.id_vendible_rop = id_vendible_rop;
    }

    public Ropa(int id_rop, String talla_rop, int id_vendible_rop, int id_vendible, double precio, String tipo, String estado, int id_pro_ven, int id_producto, String tipo_pro, byte[] imagen_pro) {
        super(id_vendible, precio, tipo, estado, id_pro_ven, id_producto, tipo_pro, imagen_pro);
        this.id_rop = id_rop;
        this.talla_rop = talla_rop;
        this.id_vendible_rop = id_vendible_rop;
    }

    public int getId_rop() {
        return id_rop;
    }

    public void setId_rop(int id_rop) {
        this.id_rop = id_rop;
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

}
