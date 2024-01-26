package Modelo;

public class LugarAfectado extends Lugar {

    private int id_lugarAf;
    private String situacion_luaf;
    private String estado_luaf;

    public LugarAfectado(int id_lugarAf, String situacion_luaf, String estado_luaf, int id_lug, String nombre_lug, String direccion_lug, int id_ciudad) {
        super(id_lug, nombre_lug, direccion_lug, id_ciudad);
        this.id_lugarAf = id_lugarAf;
        this.situacion_luaf = situacion_luaf;
        this.estado_luaf = estado_luaf;
    }
   
    
    public LugarAfectado() {
        super();
    }

    public int getId_lugarAf() {
        return id_lugarAf;
    }

    public void setId_lugarAf(int id_lugarAf) {
        this.id_lugarAf = id_lugarAf;
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

    @Override
    public String toString() {
        return super.toString()+ "LugarAfectado{" + "id_lugarAf=" + id_lugarAf + ", situacion_luaf=" + situacion_luaf + ", estado_luaf=" + estado_luaf + '}';
    }
     
  
}
