package Modelo;

import java.util.Date;

public class Medicamentos extends TipoDonable {

    private int id_med;
    private String formaFarmaceutica_med;
    private int id_donable_med;

    public Medicamentos() {
        super();
    }

    public Medicamentos(int id_med, String formaFarmaceutica_med, int id_donable_med) {
        this.id_med = id_med;
        this.formaFarmaceutica_med = formaFarmaceutica_med;
        this.id_donable_med = id_donable_med;
    }

    public Medicamentos(int id_med, String formaFarmaceutica_med, int id_donable_med, int id_donable, String nombre_dona, Date fechaElaboracion, Date fechaVencimiento, int id_pro_dona, int id_producto, String tipo_pro, byte[] imagen_pro) {
        super(id_donable, nombre_dona, fechaElaboracion, fechaVencimiento, id_pro_dona, id_producto, tipo_pro, imagen_pro);
        this.id_med = id_med;
        this.formaFarmaceutica_med = formaFarmaceutica_med;
        this.id_donable_med = id_donable_med;
    }

    public int getId_med() {
        return id_med;
    }

    public void setId_med(int id_med) {
        this.id_med = id_med;
    }

    public String getFormaFarmaceutica_med() {
        return formaFarmaceutica_med;
    }

    public void setFormaFarmaceutica_med(String formaFarmaceutica_med) {
        this.formaFarmaceutica_med = formaFarmaceutica_med;
    }

    public int getId_donable_med() {
        return id_donable_med;
    }

    public void setId_donable_med(int id_donable_med) {
        this.id_donable_med = id_donable_med;
    }

}
