package Modelo;

public class LugarAfectado {

    private int id_luaf;
    private String situacion_luaf;
    private String estado_luaf;
    private int id_lug_luaf;

    public LugarAfectado() {
    }

    public LugarAfectado(int id_luaf, String situacion_luaf, String estado_luaf, int id_lug_luaf) {
        this.id_luaf = id_luaf;
        this.situacion_luaf = situacion_luaf;
        this.estado_luaf = estado_luaf;
        this.id_lug_luaf = id_lug_luaf;
    }

    public int getId_luaf() {
        return id_luaf;
    }

    public void setId_luaf(int id_luaf) {
        this.id_luaf = id_luaf;
    }

    public String getSituacion_luaf() {
        return situacion_luaf;
    }

    public void setSituacion_luaf(String situacion_luaf) {
        this.situacion_luaf = situacion_luaf;
    }

    public String getEstado_luaf() {
        return estado_luaf;
    }

    public void setEstado_luaf(String estado_luaf) {
        this.estado_luaf = estado_luaf;
    }

    public int getId_lug_luaf() {
        return id_lug_luaf;
    }

    public void setId_lug_luaf(int id_lug_luaf) {
        this.id_lug_luaf = id_lug_luaf;
    }

    @Override
    public String toString() {
        return "LugarAfectado{" + "id_luaf=" + id_luaf + ", situacion_luaf=" + situacion_luaf + ", estado_luaf=" + estado_luaf + ", id_lug_luaf=" + id_lug_luaf + '}';
    }

}
