package Modelo;

public class CentroAcopio {

    private String ruc_ca;
    private int capacidad;
    private int id_lug_ca;

    public CentroAcopio() {
    }

    public CentroAcopio(String ruc_ca, int capacidad, int id_lug_ca) {
        this.ruc_ca = ruc_ca;
        this.capacidad = capacidad;
        this.id_lug_ca = id_lug_ca;
    }

    public String getRuc_ca() {
        return ruc_ca;
    }

    public void setRuc_ca(String ruc_ca) {
        this.ruc_ca = ruc_ca;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getId_lug_ca() {
        return id_lug_ca;
    }

    public void setId_lug_ca(int id_lug_ca) {
        this.id_lug_ca = id_lug_ca;
    }

    @Override
    public String toString() {
        return "CentroAcopio{" + "ruc_ca=" + ruc_ca + ", capacidad=" + capacidad + ", id_lug_ca=" + id_lug_ca + '}';
    }

}
