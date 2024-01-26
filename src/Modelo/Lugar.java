package Modelo;

public class Lugar {

    private int id_lug;
    private String nombre_lug;
    private String direccion_lug;
    private int id_ciudad;

    public Lugar(int id_lug, String nombre_lug, String direccion_lug, int id_ciudad) {
        this.id_lug = id_lug;
        this.nombre_lug = nombre_lug;
        this.direccion_lug = direccion_lug;
        this.id_ciudad = id_ciudad;
    }

    public Lugar() {
        super();
    }

    public int getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(int id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public int getId_lug() {
        return id_lug;
    }

    public void setId_lug(int id_lug) {
        this.id_lug = id_lug;
    }

    public String getNombre_lug() {
        return nombre_lug;
    }

    public void setNombre_lug(String nombre_lug) {
        this.nombre_lug = nombre_lug;
    }

    public String getDireccion_lug() {
        return direccion_lug;
    }

    public void setDireccion_lug(String direccion_lug) {
        this.direccion_lug = direccion_lug;
    }

    @Override
    public String toString() {
        return "Lugar{" + "id_lug=" + id_lug + ", nombre_lug=" + nombre_lug + ", direccion_lug=" + direccion_lug + ", id_ciudad=" + id_ciudad + '}';
    }

   

}
