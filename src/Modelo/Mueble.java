package Modelo;

public class Mueble extends TipoVendible {

    private int id_mueb;
    private String material_mu;
    private double peso_mue;
    private int id_vendible_mue;

    public Mueble() {
        super();
    }

    public Mueble(int id_mueb, String material_mu, double peso_mue, int id_vendible_mue, int id_vendible, double precio, String tamaño, String tipo, int id_pro_ven, int id_pro, String tipo_pro, boolean disponibilidad_pro, String nombre_pro, byte[] imagen_pro) {
        super(id_vendible, precio, tamaño, tipo, id_pro_ven, id_pro, tipo_pro, disponibilidad_pro, nombre_pro, imagen_pro);
        this.id_mueb = id_mueb;
        this.material_mu = material_mu;
        this.peso_mue = peso_mue;
        this.id_vendible_mue = id_vendible_mue;
    }

    public int getId_mueb() {
        return id_mueb;
    }

    public void setId_mueb(int id_mueb) {
        this.id_mueb = id_mueb;
    }

    public String getMaterial_mu() {
        return material_mu;
    }

    public void setMaterial_mu(String material_mu) {
        this.material_mu = material_mu;
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
        return "Mueble{" + "id_mueb=" + id_mueb + ", material_mu=" + material_mu + ", peso_mue=" + peso_mue + ", id_vendible_mue=" + id_vendible_mue + '}';
    }

}
