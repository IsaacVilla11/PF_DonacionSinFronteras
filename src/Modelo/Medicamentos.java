package Modelo;

import java.util.Date;

public class Medicamentos extends TipoDonable {

    private int id_med;
    private String formaFarmaceutica_med;
    private String docificacion_med;
    private int id_donable_med;

    public Medicamentos() {
        super();
    }

    public Medicamentos(int id_med, String formaFarmaceutica_med, String docificacion_med, int id_donable_med) {
        this.id_med = id_med;
        this.formaFarmaceutica_med = formaFarmaceutica_med;
        this.docificacion_med = docificacion_med;
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

    public String getDocificacion_med() {
        return docificacion_med;
    }

    public void setDocificacion_med(String docificacion_med) {
        this.docificacion_med = docificacion_med;
    }

    public int getId_donable_med() {
        return id_donable_med;
    }

    public void setId_donable_med(int id_donable_med) {
        this.id_donable_med = id_donable_med;
    }

    @Override
    public String toString() {
        return "Medicamentos{" + "id_med=" + id_med + ", formaFarmaceutica_med=" + formaFarmaceutica_med + ", docificacion_med=" + docificacion_med + ", id_donable_med=" + id_donable_med + '}';
    }

}
