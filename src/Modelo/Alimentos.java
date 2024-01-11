package Modelo;

import java.util.Date;

public class Alimentos extends TipoDonable {

    private int id_ali;
    private String tipo_ali;
    private int id_donable_ali;

    public Alimentos() {
    }

    public Alimentos(int id_ali, String tipo_ali, int id_donable_ali, int id_donable, int cantidad_dona, Date fechaVencimiento, int id_pro_dona, int id_pro, String tipo_pro, boolean disponibilidad_pro, String nombre_pro, byte[] imagen_pro) {
        super(id_donable, cantidad_dona, fechaVencimiento, id_pro_dona, id_pro, tipo_pro, disponibilidad_pro, nombre_pro, imagen_pro);
        this.id_ali = id_ali;
        this.tipo_ali = tipo_ali;
        this.id_donable_ali = id_donable_ali;
    }

    public int getId_ali() {
        return id_ali;
    }

    public void setId_ali(int id_ali) {
        this.id_ali = id_ali;
    }

    public String getTipo_ali() {
        return tipo_ali;
    }

    public void setTipo_ali(String tipo_ali) {
        this.tipo_ali = tipo_ali;
    }

    public int getId_donable_ali() {
        return id_donable_ali;
    }

    public void setId_donable_ali(int id_donable_ali) {
        this.id_donable_ali = id_donable_ali;
    }

    @Override
    public String toString() {
        return "Alimentos{" + "id_ali=" + id_ali + ", tipo_ali=" + tipo_ali + ", id_donable_ali=" + id_donable_ali + '}';
    }

}
