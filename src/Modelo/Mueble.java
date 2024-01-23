package Modelo;

public class Mueble extends TipoVendible {

    private int id_mueb;
    private String material_mue;
    private String tamaño_mue;
    private double peso_mue;
    private int id_vendible_mue;

    public Mueble() {
        super();
    }

    public Mueble(int id_mueb, String material_mue, String tamaño_mue, double peso_mue, int id_vendible_mue, int id_vendible, double precio, String tipo, int id_pro_ven, int id_pro, String tipo_pro, boolean disponibilidad_pro, String nombre_pro, byte[] imagen_pro) {
        super(id_vendible, precio, tipo, id_pro_ven, id_pro, tipo_pro, disponibilidad_pro, nombre_pro, imagen_pro);
        this.id_mueb = id_mueb;
        this.material_mue = material_mue;
        this.tamaño_mue = tamaño_mue;
        this.peso_mue = peso_mue;
        this.id_vendible_mue = id_vendible_mue;
    }

    public int getId_mueb() {
        return id_mueb;
    }

    public void setId_mueb(int id_mueb) {
        this.id_mueb = id_mueb;
    }

    public String getMaterial_mue() {
        return material_mue;
    }

    public void setMaterial_mue(String material_mue) {
        this.material_mue = material_mue;
    }

    public String getTamaño_mue() {
        return tamaño_mue;
    }

    public void setTamaño_mue(String tamaño_mue) {
        this.tamaño_mue = tamaño_mue;
    }

    public double getPeso_mue() {
        return peso_mue;
    }

    public void setPeso_mue(double peso_mue) {
        this.peso_mue = peso_mue;
    }

    public int getId_vendible_mue() {
        return id_vendible_mue;
    }

    public void setId_vendible_mue(int id_vendible_mue) {
        this.id_vendible_mue = id_vendible_mue;
    }

    @Override
    public String toString() {
        return "Mueble{" + "id_mueb=" + id_mueb + ", material_mue=" + material_mue + ", tama\u00f1o_mue=" + tamaño_mue + ", peso_mue=" + peso_mue + ", id_vendible_mue=" + id_vendible_mue + '}';
    }

}
