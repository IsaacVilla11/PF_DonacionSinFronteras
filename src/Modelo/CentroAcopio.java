package Modelo;

public class CentroAcopio  extends Lugar{

 
    private int ruc_ca;
    private int capacidad_ca;

    public CentroAcopio(int ruc_ca, int capacidad_ca, int id_lug, String nombre_lug, String direccion_lug, int id_ciudad) {
        super(id_lug, nombre_lug, direccion_lug, id_ciudad);
        this.ruc_ca = ruc_ca;
        this.capacidad_ca = capacidad_ca;
    }

    public CentroAcopio() {
        super();
    }

    public int getRuc_ca() {
        return ruc_ca;
    }

    public void setRuc_ca(int ruc_ca) {
        this.ruc_ca = ruc_ca;
    }

    public int getCapacidad_ca() {
        return capacidad_ca;
    }

    public void setCapacidad_ca(int capacidad_ca) {
        this.capacidad_ca = capacidad_ca;
    }

    @Override
    public String toString() {
        return super.toString()+"CentroAcopio{" + "ruc_ca=" + ruc_ca + ", capacidad_ca=" + capacidad_ca + '}';
    }
    
    
    
    


   

}
