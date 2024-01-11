package Modelo;

public class Lugar {

    private int id_lug;
    private String nombre_lug;
    private String direccion_lug;

    public Lugar() {
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
        return "Lugar{" + "id_lug=" + id_lug + ", nombre_lug=" + nombre_lug + ", direccion_lug=" + direccion_lug + '}';
    }

}
